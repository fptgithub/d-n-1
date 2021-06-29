/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class BinhLuanModel {
    private String taikhoan;
    private String madethi;
    private String noidung;
    private Timestamp ngaythem;

    public BinhLuanModel() {
    ngaythem = new Timestamp(new Date().getTime());
    }
    
    
    
    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMadethi() {
        return madethi;
    }

    public void setMadethi(String madethi) {
        this.madethi = madethi;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Timestamp getNgaythem() {
        return ngaythem;
    }

    public void setNgaythem(Timestamp ngaythem) {
        this.ngaythem = ngaythem;
    }
    
    
}
