/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import help.JDBCHelp;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dethiModel;

/**
 *
 * @author Admin
 */
public class dethiDAO extends JDBCHelp{
    public void insertdethi(dethiModel dethi){
        String sql = "insert into dethi(madethi,tendethi,mamonhoc,ngaythem,nguoithem,motangan) values(?,?,?,?,?,?)";
        try {
            excuteupdate(sql, dethi.getMadethi(),dethi.getTendethi(),dethi.getMamonhoc(),dethi.getNgaytao(),dethi.getNguoitao(),dethi.getMotangan());
        } catch (Exception e) {
        }
    }
    public boolean checkmadethi(String madethi){
        String sql = "select * from dethi where madethi = ?";
        try { 
            return selectcheck(sql, madethi);
        } catch (SQLException ex) {
            Logger.getLogger(dethiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
