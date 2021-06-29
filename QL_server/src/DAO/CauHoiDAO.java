/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.cauhoiModel;
import help.JDBCHelp;
import static ql_server.QL_server.main;

/**
 *
 * @author Admin
 */
public class CauHoiDAO extends JDBCHelp{

   
    
    public boolean selectfindOne(String macauhoi){
        String sql = "select * from cauhoi where macauhoi = ?";
        try {
            return selectcheck(sql, macauhoi);
        } catch (Exception e) {
            return false;
        }
    }
    
    public void insert(cauhoiModel cauhoi){
    String sql="insert into cauhoi(macauhoi,noidung,image,madethi,madoanvan) values(?,?,?,?,?)";
        try {
            excuteupdate(sql, cauhoi.getMacauhoi(),cauhoi.getNoidung(),cauhoi.getAnh(),cauhoi.getMadethi(),cauhoi.getMadoanvan());
        } catch (Exception e) {
            System.out.println("câu hỏi fail");
        }
    }
}
