/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Thimodel;
import servic.AccountServic;
import servic.ThiServic;
import util.RequestPackageObject;
import util.Formatter;

/**
 *
 * @author Admin
 */
public class socketThread implements Runnable {

    private Socket client;

    public socketThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        DataInputStream read = null;
        try {
            read = new DataInputStream(client.getInputStream());
            System.out.println("get input ok");
            String line = read.readUTF();
            System.out.println(line);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(line);
            RequestPackageObject rq = Formatter.GSON.fromJson(element, RequestPackageObject.class);
            System.out.println("rq status: " + rq.getStatus());
            System.out.println("rq data: " + rq.getData());
            System.out.println("");
            switch (rq.getStatus()) {
                case "DANGNHAP":
                    new Thread(new dangNhap(rq.getData(), client)).start();
                    break;
                case "DANGKY":
                    new Thread(new dangky(client, rq.getData())).start();
                    break;
                case "LOGOUT":
                    dangNhap.logout(rq.getData());
                    break;
                case "QUENMK":
                    new Thread(new quenMatkhau(client, rq.getData())).start();
                    break;
                case "DOIMK":
                    new AccountServic().DoiMatKhau(rq.getData().split(";")[0], rq.getData().split(";")[1]);
                    break;
                case "GETDATA":
                    new Thread(new selectData(client, rq)).start();
                    break;
                case "THITHU":
                    new ThiServic().insert(Formatter.GSON.fromJson(new JsonParser().parse(rq.getData()), Thimodel.class));
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(socketThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//            if (read != null) {
//                try {
//                    read.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(socketThread.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }

    }

}
