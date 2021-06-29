/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CauHoiModel {
    private String macauhoi;
    private String madethi;
    private String noidung;
    private String image;
    private String doanvan;
    private List<DapAnModel> listDapAn;

    public CauHoiModel() {
    listDapAn = new ArrayList<>();
    }

    public String getDoanvan() {
        return doanvan;
    }

    public void setDoanvan(String doanvan) {
        this.doanvan = doanvan;
    }
    
    

    public String getMacauhoi() {
        return macauhoi;
    }

    public void setMacauhoi(String macauhoi) {
        this.macauhoi = macauhoi;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<DapAnModel> getListDapAn() {
        return listDapAn;
    }

    public void setListDapAn(List<DapAnModel> listDapAn) {
        this.listDapAn = listDapAn;
    }
    
    
}
