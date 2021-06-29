/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.doanvanDAO;
import java.util.List;
import model.doanvan_tienganhModel;
import org.jsoup.nodes.Element;

/**
 *
 * @author Admin
 */
public class daonvanservic {
    private doanvanDAO daonvandao;

    public daonvanservic() {
    daonvandao = new doanvanDAO();
    }
    
    
    public void insert(doanvan_tienganhModel doanvan){
    daonvandao.insert(doanvan);
    }
    
    public void setdoanvanservic(List<doanvan_tienganhModel> listdoanvan,Element el,String madethi,int i){
        doanvan_tienganhModel doanvan = new doanvan_tienganhModel();
        doanvan.setMadethi(madethi);
        doanvan.setMadoanvan(madethi+"_DV"+i);
        setnoidung(el, doanvan);
        listdoanvan.add(doanvan);
    }
    
    public void setnoidung(Element el,doanvan_tienganhModel doanvan){
        Element el1 = el.selectFirst(".card-game-content");
        if(el1.select("card-game-content").toString().contains("</b>")){
        el1.select("b").remove();
        }
    doanvan.setNoidung(el1.html());
    }
}
