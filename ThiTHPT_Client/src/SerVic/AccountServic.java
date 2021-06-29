/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerVic;

import DAO.TaiKhoanDAO;
import Model.TaiKhoanModel;
import Socket.requestSocket;
import Util.EmailUtil;
import Util.MessageConfig;
import Util.RegexPattern;
import Util.RepoundPackageObject;
import Util.RequestPackageObject;
import Util.cookieNguoiDung;
import Util.Formatter;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class AccountServic {

    private TaiKhoanDAO taiKhoanDAO;
    public Thread timeOutMaXacNhan;
    public boolean isrunning = true;

    public AccountServic() {
        taiKhoanDAO = new TaiKhoanDAO();
    }

    public static void logout() {
        requestSocket logout = new requestSocket();
        RequestPackageObject rq = new RequestPackageObject();
        rq.setStatus(RequestPackageObject.LOGOUT);
        rq.setData(cookieNguoiDung.NGUOIDUNG.getTaikhoan());
        logout.write(Formatter.GSON.toJson(rq));
    }

    public boolean login(String taikhoanGmail, char[] matkhau, JComponent component) {
        if (taikhoanGmail.equals("") || String.valueOf(matkhau).equals("")) {
            MessageConfig.messageText("Không Được Để Trống Dữ Liệu", component);
            return false;
        } else {
            if (RegexPattern.checkgmail(taikhoanGmail)) {
                MessageConfig.messageText("tài khoản không đúng định dạng", component);
                return false;
            }
            requestSocket socket = new requestSocket();
            RequestPackageObject rq = new RequestPackageObject();
            rq.setStatus(RequestPackageObject.DANGNHAP);
            rq.setData(taikhoanGmail);
            socket.write(Formatter.GSON.toJson(rq));
            RepoundPackageObject rp = socket.read();
            if (rp.getStatus().equals("TRUE")) {
                JsonParser parser = new JsonParser();
                JsonElement element = parser.parse(rp.getData());
                TaiKhoanModel taikhoan = Formatter.GSON.fromJson(element, TaiKhoanModel.class);
                if (taikhoan.getMatkhau().equals(String.valueOf(matkhau))) {
                    cookieNguoiDung.login(taikhoan);
                    return true;
                } else {
                    MessageConfig.messageText("Mật Khẩu Không Đúng", component);
                    return false;
                }
            } else {
                MessageConfig.messageText(rp.getMessage(), component);
                return false;
            }
        }
    }

    public boolean signup(TaiKhoanModel taiKhoanModel, JComponent component, char[] pass2) {
        if (taiKhoanModel.getTen().equals("") || taiKhoanModel.getTaikhoan().equals("") || taiKhoanModel.getMatkhau().equals("")) {
            MessageConfig.messageText("Không Được Để Trống Dữ Liệu", component);
            return false;
        }
        if (!RegexPattern.checkgmail(taiKhoanModel.getTaikhoan())) {
            MessageConfig.messageText("Tài Khoản Không Đúng Định Dạng", component);
            return false;
        }
        if (taiKhoanModel.getMatkhau().length() < 6) {
            MessageConfig.messageText("Mật Khẩu Dài Hơn 6 Ký Tự", component);
            return false;
        }
        if (!taiKhoanModel.getMatkhau().equals(String.valueOf(pass2))) {
            MessageConfig.messageText("Mật Khẩu Không Trùng Khớp", component);
            return false;
        }
        requestSocket signup = new requestSocket();
        RequestPackageObject rq = new RequestPackageObject();
        rq.setStatus(RequestPackageObject.DANGKY);
        rq.setData(Formatter.GSON.toJson(taiKhoanModel));
        signup.write(Formatter.GSON.toJson(rq));
        RepoundPackageObject rp = signup.read();
        if (rp.getStatus().equals("TRUE")) {
            return true;
        } else {
            MessageConfig.messageText(rp.getMessage(), component);
            return false;
        }
    }

    public boolean guimaxacnhan(String Email, JComponent component) {
        requestSocket sendEmail = new requestSocket();
        RequestPackageObject rq = new RequestPackageObject();
        rq.setStatus(RequestPackageObject.QUENMK);
        rq.setData(Email);
        sendEmail.write(Formatter.GSON.toJson(rq));
        RepoundPackageObject rp = sendEmail.read();
        if (rp.getStatus().equals("FALSE")) {
            MessageConfig.messageText(rp.getMessage(), component);
            return false;
        } else {
            cookieNguoiDung.MAXACNHAN = rp.getData();
            return true;
        }
    }

    public void DoiMatKhau(String taikhoan, String pass) {
        requestSocket doimatkhau = new requestSocket();
        RequestPackageObject rq = new RequestPackageObject();
        rq.setStatus(RequestPackageObject.DOIMK);
        rq.setData(taikhoan + ";" + pass);
        doimatkhau.write(Formatter.GSON.toJson(rq));
    }

    public TaiKhoanModel selectFindOneServic(String gmail) {
        return taiKhoanDAO.selectFindOne(gmail);
    }

    public void stopTimeOut() {
        isrunning = false;
    }

    public void TimeOut(JLabel lbl) {
        timeOutMaXacNhan = new Thread(new Runnable() {
            int i = 60;

            @Override
            public void run() {
                if (!isrunning) {
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AccountServic.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    isrunning = true;
                }
                while (i >= 1) {
                    if (!isrunning) {
                        break;
                    }
                    if (i >= 1) {
                        try {
                            lbl.setText(i + " Giây");
                            i--;
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AccountServic.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (isrunning) {
                    lbl.setText("Hết Giờ, Mã Xác Nhận Không Còn Hiệu Lực");
                    cookieNguoiDung.MAXACNHAN = null;
                }
            }
        });
        timeOutMaXacNhan.start();
    }
}
