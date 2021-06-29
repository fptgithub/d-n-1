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
import servic.AccountServic;
import util.Formatter;
import util.RepoundPackageObject;

/**
 *
 * @author Admin
 */
public class quenMatkhau implements Runnable {
    
    Socket client;
    private AccountServic accountServic;
    private String gmail;
    
    public quenMatkhau(Socket client, String gmail) {
        this.client = client;
        accountServic = new AccountServic();
        this.gmail = gmail;
    }
    
    @Override
    public void run() {
        DataOutputStream write = null;
        try {
            write = new DataOutputStream(client.getOutputStream());
            RepoundPackageObject rp = new RepoundPackageObject();
            String maxacnhan = accountServic.guimaxacnhan(gmail);
            if (maxacnhan != null) {
                rp.setStatus("TRUE");
                rp.setData(maxacnhan);
            } else {
                rp.setStatus(RepoundPackageObject.FALSE);
                rp.setMessage("Tài Khoản Không Có Trong Hệ Thống");
            }
            String repound = Formatter.GSON.toJson(rp);
            write.writeUTF(repound);
            write.flush();
        } catch (IOException ex) {
            Logger.getLogger(dangNhap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (write != null) {
                try {
                    write.close();
                } catch (IOException ex) {
                    Logger.getLogger(dangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
}
