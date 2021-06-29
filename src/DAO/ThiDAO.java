/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Thimodel;
import util.JDBC;

/**
 *
 * @author Admin
 */
public class ThiDAO extends JDBC {

    public void insertThi(Thimodel thi) {
        String sql = "insert into thithu(taikhoan,madethi,socaudung,socausai,socaukhongtraloi,thoidiemthi) values(?,?,?,?,?,?)";
        try {
            excuteupdate(sql, thi.getTaikhoan(),thi.getMadethi(),thi.getSocaudung(),thi.getSocausai(),thi.getKhongtraloi(),thi.getThoidiemthi());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
