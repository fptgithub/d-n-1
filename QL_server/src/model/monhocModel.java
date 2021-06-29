/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class monhocModel {

    private String MaMonHoc;
    private String TenMonHoc;

    public monhocModel() {

    }

    public monhocModel(String MaMonHoc, String TenMonHoc) {
        this.MaMonHoc = MaMonHoc;
        this.TenMonHoc = TenMonHoc;

    }

    public String getMaMonHoc() {
        return MaMonHoc;
    }

    public void setMaMonHoc(String MaMonHoc) {
        this.MaMonHoc = MaMonHoc;
    }

    public String getTenMonHoc() {
        return TenMonHoc;
    }

    public void setTenMonHoc(String TenMonHoc) {
        this.TenMonHoc = TenMonHoc;
    }

    @Override
    public String toString() {
        return TenMonHoc;
    }

}
