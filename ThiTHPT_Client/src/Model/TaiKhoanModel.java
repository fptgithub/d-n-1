/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class TaiKhoanModel {

    private String taikhoan;
    private String ten;
    private String matkhau;
    private String gioitinh;
    private String vaitro = "user";

    public String getVaitro() {
        return vaitro;
    }

    public TaiKhoanModel() {
    }

    public TaiKhoanModel(String taikhoan, String ten, String matkhau, String gioitinh) {
        this.taikhoan = taikhoan;
        this.ten = ten;
        this.matkhau = matkhau;
        this.gioitinh = gioitinh;
    }
    
    
    
    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

}
