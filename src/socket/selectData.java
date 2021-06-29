/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import servic.CauHoiServic;
import servic.DeThiServic;
import servic.MonHocServic;
import util.Formatter;
import util.RepoundPackageObject;
import util.RequestPackageObject;

/**
 *
 * @author Admin
 */
public class selectData implements Runnable {
    
    private CauHoiServic cauHoiServic;
    private DeThiServic deThiServic;
    private MonHocServic monHocServic;
    Socket client;
    RequestPackageObject rq;
    
    public selectData(Socket client, RequestPackageObject rq) {
        cauHoiServic = new CauHoiServic();
        deThiServic = new DeThiServic();
        monHocServic = new MonHocServic();
        this.client = client;
        this.rq = rq;
    }
    
    @Override
    public void run() {
        DataOutputStream out = null;
        RepoundPackageObject rp = new RepoundPackageObject();
        rp.setStatus(RepoundPackageObject.TRUE);
        try {
            out = new DataOutputStream(client.getOutputStream());
            switch (rq.getData().split(";")[0]) {
                case "CAUHOI":
                    rp.setData(Formatter.GSON.toJson(cauHoiServic.select(rq.getData().split(";")[1])));
                    break;
                case "MONHOC":
                    rp.setData(Formatter.GSON.toJson(monHocServic.select()));
                    break;
                case "DETHI":
                    System.out.println(rq.getData().split(";")[1]);
                    rp.setData(Formatter.GSON.toJson(deThiServic.select(rq.getData().split(";")[1])));
                    break;
            }
            if (rq.getData().split(";")[0].equals("CAUHOI")) {
                String[] data = Formatter.GSON.toJson(rp).split(":");
                int i = 0;
                while (i < data.length) {
                    if (i < data.length - 1) {
                        out.writeUTF(data[i] + ":");
                    } else {
                        out.writeUTF(data[i]);
                    }
                    i++;
                }
                out.writeUTF("end");
                out.flush();
            } else {
                out.writeUTF(Formatter.GSON.toJson(rp));
                out.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(selectData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(selectData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}
