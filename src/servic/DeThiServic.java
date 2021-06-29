/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.DeThiDAO;
import java.util.List;
import model.DeThiModel;
import org.jsoup.nodes.Document;

/**
 *
 * @author Admin
 */
public class DeThiServic {

    private DeThiDAO deThiDAO;

    public DeThiServic() {
        deThiDAO = new DeThiDAO();
    }

    public List<DeThiModel> select(String mamonhoc) {
        return deThiDAO.selectDeThi(mamonhoc);
    }

    public void settendethi(DeThiModel dethi, Document doc) {
        dethi.setTendethi(doc.select("#path-panel .content .active").text());
    }

    public boolean checkmadethi(String madethi) {
        return deThiDAO.checkmadethi(madethi);
    }

    public void insert(DeThiModel dethi) {
        deThiDAO.insertdethi(dethi);
    }
    public boolean delete(String madethi){
    return deThiDAO.deletedethi(madethi);
    }
}
