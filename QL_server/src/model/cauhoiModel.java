/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class cauhoiModel {
    private String macauhoi;
    private String noidung;
    private String madethi;
    private String anh;
    private String nguoisua;
    private Timestamp ngaysua;
    private List<dapanModel> dapanlist;
    private String madoanvan;

    public cauhoiModel() {
    dapanlist = new ArrayList<>();
    
    }

    public String getMadoanvan() {
        return madoanvan;
    }

    public void setMadoanvan(String madoanvan) {
        this.madoanvan = madoanvan;
    }
    
    

    public String getMacauhoi() {
        return macauhoi;
    }

    public void setMacauhoi(String macauhoi) {
        this.macauhoi = macauhoi;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getMadethi() {
        return madethi;
    }

    public void setMadethi(String madethi) {
        this.madethi = madethi;
    }

    public String getNguoisua() {
        return nguoisua;
    }

    public void setNguoisua(String nguoisua) {
        this.nguoisua = nguoisua;
    }

    public Timestamp getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(Timestamp ngaysua) {
        this.ngaysua = ngaysua;
    }

    public List<dapanModel> getDapanlist() {
        return dapanlist;
    }

    public void setDapanlist(List<dapanModel> dapanlist) {
        this.dapanlist = dapanlist;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    
}
