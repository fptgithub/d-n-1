/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormatDom.headerDOM;

import DAO.MonHocDAO;
import Model.MonHocModel;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MonHocDOM {
    private MonHocDAO monHocDAO;
    private List<MonHocModel> listmonhoc;

    public MonHocDOM() {
    monHocDAO = new MonHocDAO();
    listmonhoc = monHocDAO.selectMonHoc();
    }
    
    public String monhocdom(){
    StringBuilder bd = new StringBuilder();
    bd.append("<header id=\"header\" class=\"\">\n" +
"      <ul>");
    for(MonHocModel monhoc:listmonhoc){
    bd.append("<li><button onclick=\"changemonhoc(this)\" class=\"btn_header\" data-mamonhoc=\""+monhoc.getMamonhoc()+"\" type=\"\">"+monhoc.getTenmonhoc().toUpperCase()+"</button></li>\n");
    }
    bd.append("</ul>\n" +
"    </header><div id = \"reload\">");
    return bd.toString();
    }

    public MonHocDAO getMonHocDAO() {
        return monHocDAO;
    }

    public void setMonHocDAO(MonHocDAO monHocDAO) {
        this.monHocDAO = monHocDAO;
    }

    public List<MonHocModel> getListmonhoc() {
        return listmonhoc;
    }

    public void setListmonhoc(List<MonHocModel> listmonhoc) {
        this.listmonhoc = listmonhoc;
    }
    
    
}
