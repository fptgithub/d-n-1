/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TaiKhoanModel;
import servic.AccountServic;
import util.RepoundPackageObject;
import util.Formatter;

/**
 *
 * @author Admin
 */
public class dangky implements Runnable {

    private Socket client;
    private AccountServic accountServic;
    private String json;

    public dangky(Socket client, String json) {
        this.client = client;
        accountServic = new AccountServic();
        this.json = json;
    }

    @Override
    public void run() {
        DataOutputStream write = null;
        try {
            JsonParser parser = new JsonParser();
            RepoundPackageObject rp = new RepoundPackageObject();
            JsonElement element = parser.parse(json);
            System.out.println(Formatter.GSON.fromJson(element, TaiKhoanModel.class));
            if (accountServic.signUpAccount(Formatter.GSON.fromJson(element, TaiKhoanModel.class))) {
                rp.setStatus(RepoundPackageObject.TRUE);
            } else {
                rp.setStatus(RepoundPackageObject.FALSE);
                rp.setMessage("Tài Khoản Đã Tồn Tại");
            }
            write = new DataOutputStream(client.getOutputStream());
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
