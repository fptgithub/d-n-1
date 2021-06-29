/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.dapanModel;
import help.JDBCHelp;
import static ql_server.QL_server.main;

/**
 *
 * @author Admin
 */
public class DapAnDAO extends JDBCHelp{

    
    
    public void insert(dapanModel dapan){
        String sql = "insert into dapan(macauhoi,madapan,noidung,trangthai,loaidapan) values(?,?,?,?,?)";
        try {
            excuteupdate(sql, dapan.getMacauhoi(),dapan.getMadapan(),dapan.getNoiDung(),dapan.getTrangThai(),dapan.getLoaidapan());
        } catch (Exception e) {
            System.out.println("đáp án fail");
        }
    }
}
