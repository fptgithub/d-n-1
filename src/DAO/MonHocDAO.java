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
import model.MonHocModel;
import util.JDBC;

/**
 *
 * @author Admin
 */
public class MonHocDAO extends JDBC{
    public List<MonHocModel> selectMonHoc(){
        List<MonHocModel> listmonhoc = new ArrayList<>();
        String sql = "select * from monhoc";
        ResultSet rs = select(sql);
        try {
            while(rs.next()){
                MonHocModel monhoc = new MonHocModel();
                monhoc.setMamonhoc(rs.getString("mamonhoc"));
                monhoc.setTenmonhoc(rs.getString("tenmonhoc"));
                listmonhoc.add(monhoc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listmonhoc.isEmpty()?null:listmonhoc;
    }
}
