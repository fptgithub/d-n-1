/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.BinhLuanModel;
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
public class BinhLuanDAO extends JDBC{
    public List<BinhLuanModel> selectbinhluan(){
    List<BinhLuanModel> listbinhluan = new ArrayList<>();
    String sql = "select * from binhluan";
        ResultSet rs = select(sql);
        try {
            while (rs.next()) {
                BinhLuanModel binhluan = new BinhLuanModel();
                binhluan.setMadethi(rs.getString("madethi"));
                binhluan.setNgaythem(rs.getTimestamp("ngaythem"));
                binhluan.setNoidung(rs.getString("noidung"));
                binhluan.setTaikhoan(rs.getString("taikhoan"));
                listbinhluan.add(binhluan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BinhLuanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listbinhluan.isEmpty()?null:listbinhluan;
    }
}
