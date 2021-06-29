/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TaiKhoanModel;
import Util.JDBC;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TaiKhoanDAO extends JDBC {

    public TaiKhoanModel selectFindOne(String gmail) {
        String sql = "select * from nguoidung where taikhoan = ?";
        ResultSet rs = selectByParam(sql, gmail);
        TaiKhoanModel taikhoan = null;
        try {
            while (rs.next()) {
                taikhoan = new TaiKhoanModel();
                taikhoan.setTaikhoan(rs.getString("taikhoan"));
                taikhoan.setMatkhau(rs.getString("matkhau"));
                taikhoan.setGioitinh(rs.getString("gioitinh"));
                taikhoan.setTen(rs.getString("ten"));
            }
            return taikhoan;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean insertTaiKhoan(TaiKhoanModel taikhoan) {
        String sql = "insert into nguoidung(taikhoan,matkhau,ten,gioitinh,mavaitro) values(?,?,?,?,?)";
        try {
            excuteupdate(sql, taikhoan.getTaikhoan(), taikhoan.getMatkhau(), taikhoan.getTen(),taikhoan.getGioitinh() , taikhoan.getVaitro());
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean updatepassworld(String matkhau,String taikhoan){
    String sql = "update nguoidung set matkhau = ? where taikhoan = ?";
        try {
            excuteupdate(sql, matkhau,taikhoan);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
