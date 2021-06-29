/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.DapAnDAO;
import java.util.List;
import model.DapAnModel;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class dapanservic {
    private DapAnDAO dapandao;

    public dapanservic() {
    dapandao = new DapAnDAO();
    }

    public void insert(DapAnModel dapan){
    dapandao.insert(dapan);
    }
    
    public void setdapanservic(List<DapAnModel> listdapan, Element el, String macauhoi) {
        Elements els = el.select(".ks-checkBox");
        int i = 1;
        for (Element element : els) {
            DapAnModel dapan = new DapAnModel();
            dapan.setMacauhoi(macauhoi);
            dapan.setMadapan(macauhoi + "_DA_" + i);
            setnoidung(element, dapan);
            settrangthai(element, dapan);
            setloaidapan(i, dapan);
            listdapan.add(dapan);
            i++;
        }
    }

    public void setnoidung(Element element, DapAnModel dapan) {
        Element element1 = element.selectFirst(".gwt-HTML");
        if (element1.toString().contains("<span class\"MathJax_SVG\"")) {
            dapan.setNoidung(element1.selectFirst(".MathJax_SVG").toString());
        } else {
            dapan.setNoidung(element1.toString());
        }
    }

    public void settrangthai(Element element, DapAnModel dapan) {
        if(element.is(".cardAnswer-correct")){
        dapan.setTrangthai("TRUE");
        }else{
        dapan.setTrangthai("FALSE");
        }
    }

    public void setloaidapan(int i, DapAnModel dapan) {
        switch (i) {
            case 1:
                dapan.setLoaidapan("A");
                break;
            case 2:
                dapan.setLoaidapan("B");
                break;
            case 3:
                dapan.setLoaidapan("C");
                break;
            case 4:
                dapan.setLoaidapan("D");
                break;
        }
    }
}
