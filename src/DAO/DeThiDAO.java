/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DeThiModel;
import servic.DeThiServic;
import util.JDBC;

/**
 *
 * @author Admin
 */
public class DeThiDAO extends JDBC {

    public List<DeThiModel> selectDeThi(String mamonhoc) {
        List<DeThiModel> listdethi = new ArrayList<>();
        String sql = "select * from DUAN1_THITHPT_2.dethi join DUAN1_THITHPT_2.monhoc on dethi.mamonhoc = monhoc.mamonhoc where monhoc.mamonhoc = ?";
        ResultSet rs = selectByParam(sql, mamonhoc);
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
        return listdethi.isEmpty() ? null : listdethi;
    }

    public void insertdethi(DeThiModel dethi) {
        String sql = "insert into dethi(madethi,tendethi,mamonhoc,ngaythem,nguoithem,motangan) values(?,?,?,?,?,?)";
        try {
            excuteupdate(sql, dethi.getMadethi(), dethi.getTendethi(), dethi.getMamonhoc(), dethi.getNgaytao(), dethi.getNguoitao(), dethi.getMotangan());
        } catch (Exception e) {
        }
    }

    public boolean checkmadethi(String madethi) {
        String sql = "select * from dethi where madethi = ?";
        try {
            return selectcheck(sql, madethi);
        } catch (SQLException ex) {
            Logger.getLogger(DeThiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deletedethi(String madethi) {
        String sql = "delete from dethi where madethi = ?";
        return delete(sql, madethi);
    }
}
