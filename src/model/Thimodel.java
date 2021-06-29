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
public class Thimodel {

    private Timestamp thoidiemthi = new Timestamp(new Date().getTime());
    private String taikhoan;
    private String madethi;
    private int socaudung;
    private int socausai;
    private int khongtraloi;

    public Timestamp getThoidiemthi() {
        return thoidiemthi;
    }

    public void setThoidiemthi(Timestamp thoidiemthi) {
        this.thoidiemthi = thoidiemthi;
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

    public int getSocaudung() {
        return socaudung;
    }

    public void setSocaudung(int socaudung) {
        this.socaudung = socaudung;
    }

    public int getSocausai() {
        return socausai;
    }

    public void setSocausai(int socausai) {
        this.socausai = socausai;
    }

    public int getKhongtraloi() {
        return khongtraloi;
    }

    public void setKhongtraloi(int khongtraloi) {
        this.khongtraloi = khongtraloi;
    }

}
