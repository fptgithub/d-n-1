/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.DapAnModel;
import util.JDBC;


/**
 *
 * @author Admin
 */
public class DapAnDAO extends JDBC{

    
    
    public void insert(DapAnModel dapan){
        String sql = "insert into dapan(macauhoi,madapan,noidung,trangthai,loaidapan) values(?,?,?,?,?)";
        try {
            excuteupdate(sql, dapan.getMacauhoi(),dapan.getMadapan(),dapan.getNoidung(),dapan.getTrangthai(),dapan.getLoaidapan());
        } catch (Exception e) {
            System.out.println("đáp án fail");
        }
    }
}
