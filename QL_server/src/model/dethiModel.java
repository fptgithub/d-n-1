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
public class dethiModel {
    private String madethi;
    private String tendethi;
    private String mamonhoc;
    private Timestamp ngaytao;
    private String nguoitao;
    private String nguoisua;
    private Timestamp ngaysua;
    private String motangan;

    public String getMadethi() {
        return madethi;
    }

    public String getMotangan() {
        return motangan;
    }

    public void setMotangan(String motangan) {
        this.motangan = motangan;
    }

    public void setMadethi(String madethi) {
        this.madethi = madethi;
    }

    

    public String getTendethi() {
        return tendethi;
    }

    public void setTendethi(String tendethi) {
        this.tendethi = tendethi;
    }

    public String getMamonhoc() {
        return mamonhoc;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }

    public Timestamp getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Timestamp ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNguoitao() {
        return nguoitao;
    }

    public void setNguoitao(String nguoitao) {
        this.nguoitao = nguoitao;
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
    
    
}
