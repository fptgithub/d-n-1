/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import help.JDBCHelp;
import model.doanvan_tienganhModel;

/**
 *
 * @author Admin
 */
public class doanvanDAO extends JDBCHelp{
    public void insert(doanvan_tienganhModel doanvan){
    String sql = "insert into doanvan_tienganh(madethi,madoanvan,noidung) values(?,?,?)";
        try {
            excuteupdate(sql, doanvan.getMadethi(),doanvan.getMadoanvan(),doanvan.getNoidung());
        } catch (Exception e) {
        }
    }
}
