/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DeThiModel;
import SerVic.DeThiServic;
import Util.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DeThiDAO extends JDBC{
    public List<DeThiModel> selectDeThi(String mamonhoc){
    List<DeThiModel> listdethi = new ArrayList<>();
    String sql = "select * from DUAN1_THITHPT_2.dethi join DUAN1_THITHPT_2.monhoc on dethi.mamonhoc = monhoc.mamonhoc where monhoc.mamonhoc = ?";
        ResultSet rs = selectByParam(sql,mamonhoc);
        try {
            while (rs.next()) {
                DeThiModel dethi = new DeThiModel();
                dethi.setMadethi(rs.getString("madethi"));
                dethi.setMamonhoc(rs.getString("mamonhoc"));
                dethi.setTendethi(rs.getString("tendethi"));
                dethi.setThoigianthi(rs.getInt("THOIGIANTHI"));
                dethi.setTongsocau(rs.getInt("TONGSOCAU"));
                dethi.setMotangan(rs.getString("motangan"));
                listdethi.add(dethi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DeThiServic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listdethi.isEmpty()?null:listdethi;
    }
}
