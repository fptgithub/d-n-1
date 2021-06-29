/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.dethiDAO;
import model.dethiModel;
import org.jsoup.nodes.Document;

/**
 *
 * @author Admin
 */
public class dethiservic {

    private dethiDAO dethidao;
    
    public boolean checkmadethi(String madethi){
    return  dethidao.checkmadethi(madethi);
    }
    
    public dethiservic() {
        dethidao = new dethiDAO();
    }

    public void settendethi(dethiModel dethi, Document doc) {
        dethi.setTendethi(doc.select("#path-panel .content .active").text());
    }

    public void insert(dethiModel dethi) {
        dethidao.insertdethi(dethi);
    }
}
