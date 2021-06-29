/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class dapanModel {
    private String madapan;
    private String macauhoi;
    private String NoiDung;
    private String TrangThai;
    private Timestamp ngaysua;
    private String nguoisua;
    private String loaidapan;
    
    public dapanModel() {
    }

    public String getMadapan() {
        return madapan;
    }

    public void setMadapan(String madapan) {
        this.madapan = madapan;
    }

    public String getMacauhoi() {
        return macauhoi;
    }

    public void setMacauhoi(String macauhoi) {
        this.macauhoi = macauhoi;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Timestamp getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(Timestamp ngaysua) {
        this.ngaysua = ngaysua;
    }

    public String getNguoisua() {
        return nguoisua;
    }

    public void setNguoisua(String nguoisua) {
        this.nguoisua = nguoisua;
    }

    public String getLoaidapan() {
        return loaidapan;
    }

    public void setLoaidapan(String loaidapan) {
        this.loaidapan = loaidapan;
    }

    
}
