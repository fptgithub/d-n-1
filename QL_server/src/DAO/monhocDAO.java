/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import help.JDBCHelp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.monhocModel;

/**
 *
 * @author Admin
 */
public class monhocDAO extends JDBCHelp{
    public List<monhocModel> select(){
        List<monhocModel> listmonhoc = new ArrayList<>();
        String sql = "select * from monhoc";
        ResultSet rs = select(sql);
        if(rs!=null){
            monhocModel monhocmodel = null;
            try {
                while(rs.next()){
                    monhocmodel = new monhocModel(rs.getString("MAMONHOC"), rs.getString("TENMONHOC"));
                    listmonhoc.add(monhocmodel);
                }
            } catch (SQLException ex) {
                Logger.getLogger(monhocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listmonhoc.isEmpty()?null:listmonhoc;
    }
}
