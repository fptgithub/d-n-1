/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.TaiKhoanDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;
import model.TaiKhoanModel;
import util.EmailUtil;
import util.MessageConfig;
import util.cookieNguoiDung;

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

    public boolean signUpAccount(TaiKhoanModel taikhoan) {
        if (taiKhoanDAO.selectFindOne(taikhoan.getTaikhoan()) != null) {
            return false;
        }
        return taiKhoanDAO.insertTaiKhoan(taikhoan);
    }

    public boolean loginadmin(String taikhoanGmail, JComponent component, String pass) {
        TaiKhoanModel taiKhoanModel = selectFindOneServic(taikhoanGmail);
        if (taiKhoanModel != null) {
            if (taiKhoanModel.getVaitro().equals("admin")) {
                if (taiKhoanModel.getMatkhau().equals(pass)) {
                    cookieNguoiDung.login(taiKhoanModel);
                    MessageConfig.messageText("đăng nhập thành công", component);
                    return true;
                } else {
                    MessageConfig.messageText("mật khẩu không đúng", component);
                    return false;
                }
            }
            MessageConfig.messageText("tài khoản không có quyền truy cập", component);
            return false;
        } else {
            MessageConfig.messageText("Tài khoản không tồn tại", component);
            return false;
        }
    }

    public String guimaxacnhan(String Email) {
        String maxacnhan = String.valueOf((int) ((Math.random() * 89999) + 10000));
        if (taiKhoanDAO.selectFindOne(Email) == null) {
            return null;
        }
        new Thread(new EmailUtil("Mã Xác Nhận", maxacnhan, Email)).start();
        return maxacnhan;
    }

    public boolean DoiMatKhau(String taikhoan, String pass) {
        return taiKhoanDAO.updatepassworld(pass, taikhoan);
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
