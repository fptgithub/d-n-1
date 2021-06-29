/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
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
public class dangNhap implements Runnable {

    public static List<String> listUserOnline = new ArrayList<>();
    private AccountServic accountServic;
    private String taikhoan;
    private Socket client;

    public dangNhap(String taikhoan, Socket client) {
        accountServic = new AccountServic();
        this.client = client;
        this.taikhoan = taikhoan;
    }
    
    public static void logout(String taikhoan){
    listUserOnline.remove(taikhoan);
    }
    
    @Override
    public void run() {
        DataOutputStream write = null;
        try {
            write = new DataOutputStream(client.getOutputStream());
            RepoundPackageObject rp = new RepoundPackageObject();
            checkUserOnline(rp);
            String repound = Formatter.GSON.toJson(rp);
            System.out.println(repound);
            write.writeUTF(repound);
            write.flush();
        } catch (IOException ex) {
            Logger.getLogger(dangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (write != null) {
                try {
                    write.close();
                } catch (IOException ex) {
                    Logger.getLogger(dangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    void checkUserOnline(RepoundPackageObject rp) {
        if (listUserOnline.size() >= 1) {
            for (int i = 0; i < listUserOnline.size(); i++) {
                if (taikhoan.equals(listUserOnline.get(i))) {
                    rp.setMessage("tài khoản đang hoạt động");
                    rp.setStatus(RepoundPackageObject.FALSE);
                } else {
                    TaiKhoanModel taikhoan = accountServic.selectFindOneServic(this.taikhoan);
                    if (taikhoan != null) {
                        rp.setStatus(RepoundPackageObject.TRUE);
                        rp.setData(Formatter.GSON.toJson(taikhoan));
                        listUserOnline.add(taikhoan.getTaikhoan());
                    } else {
                        rp.setMessage("Tài Khoản Không Đúng");
                        rp.setStatus(RepoundPackageObject.FALSE);
                    }
                }
            }
        } else {
            TaiKhoanModel taikhoan = accountServic.selectFindOneServic(this.taikhoan);
            if (taikhoan != null) {
                rp.setStatus(RepoundPackageObject.TRUE);
                rp.setData(Formatter.GSON.toJson(taikhoan));
                listUserOnline.add(taikhoan.getTaikhoan());
            } else {
                rp.setMessage("Tài Khoản Không Đúng");
                rp.setStatus(RepoundPackageObject.FALSE);
            }
        }
    }

}
