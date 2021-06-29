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
import model.CauHoiModel;
import model.DapAnModel;
import servic.CauHoiServic;
import util.JDBC;

/**
 *
 * @author Admin
 */
public class CauHoiDAO extends JDBC {

    public List<CauHoiModel> selectCauHoi(String madethi) {
        List<CauHoiModel> listcauhoi = new ArrayList<>();
        String sql = "select * from DUAN1_THITHPT_2.cauhoi where madethi = ?";
        // câu truy vấn lấy đáp án theo từng câu hỏi
        String sqldapan = "select * from DUAN1_THITHPT_2.dapan where macauhoi = ? order by loaidapan asc";
        ResultSet rs = selectByParam(sql, madethi);
        try {
            while (rs.next()) {
                CauHoiModel cauhoi = new CauHoiModel();
                cauhoi.setMacauhoi(rs.getString("macauhoi"));
                cauhoi.setMadethi(rs.getString("madethi"));
                cauhoi.setNoidung(rs.getString("noidung"));
                cauhoi.setImage(rs.getString("image"));
                cauhoi.setDoanvan(rs.getString("doanvan"));
                ResultSet rscauhoi = selectByParam(sqldapan, cauhoi.getMacauhoi());
                while (rscauhoi.next()) {
                    DapAnModel dapan = new DapAnModel();
                    dapan.setLoaidapan(rscauhoi.getString("loaidapan"));
                    dapan.setMacauhoi(rscauhoi.getString("MACAUHOI"));
                    dapan.setMadapan(rscauhoi.getString("MADAPAN"));
                    dapan.setNoidung(rscauhoi.getString("NOIDUNG"));
                    dapan.setTrangthai(rscauhoi.getString("TRANGTHAI"));
                    cauhoi.getListDapAn().add(dapan);
                }
                listcauhoi.add(cauhoi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiServic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listcauhoi.isEmpty() ? null : listcauhoi;
    }

    public boolean selectfindOne(String macauhoi) {
        String sql = "select * from cauhoi where macauhoi = ?";
        try {
            return selectcheck(sql, macauhoi);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean update(CauHoiModel cauhoi){
    String sql = "update ";
        try {
            return excuteupdate(sql, cauhoi);
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void insert(CauHoiModel cauhoi) {
        String sql = "insert into cauhoi(macauhoi,noidung,image,madethi,doanvan) values(?,?,?,?,?)";
        try {
            excuteupdate(sql, cauhoi.getMacauhoi(), cauhoi.getNoidung(), cauhoi.getImage(), cauhoi.getMadethi(), cauhoi.getDoanvan());
        } catch (Exception e) {
            System.out.println("câu hỏi fail");
        }
    }
}
