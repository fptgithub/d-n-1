/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.CauHoiDAO;
import help.downloadFile;
import java.util.List;
import model.cauhoiModel;
import model.dapanModel;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class cauhoiservic {

    private CauHoiDAO cauHoiDAO;

    public cauhoiservic() {
        cauHoiDAO = new CauHoiDAO();
    }

    public void insert(cauhoiModel cauhoi) {
        cauHoiDAO.insert(cauhoi);
    }

    public void setcauhoiservic(List<cauhoiModel> listcauhoiList, Elements els, String madethi, dapanservic dapan) {
        int i = 1;
        els.select("script").remove();
        for (Element element : els) {
                cauhoiModel cauhoi = new cauhoiModel();
                cauhoi.setMacauhoi(madethi + "_CH_" + i);
                setnoidung(element, cauhoi);
                cauhoi.setMadethi(madethi);
                setimage(element, cauhoi);
                i++;
                listcauhoiList.add(cauhoi);
                dapan.setdapanservic(cauhoi.getDapanlist(), element, cauhoi.getMacauhoi());
            }
    }
    
    public int setcauhoiservicmonTiengAnh(List<cauhoiModel> listcauhoiList, Element els, String madethi, dapanservic dapan,Integer i,String madoanvan) {
        els.select("script").remove();
        int stt = i;
        Elements els1 = els.select(".game-code-view-main-view-panel.mainPanelAutoIndexLine .game-code-view-main-view-panel .gameViewPanel");
        for (Element element : els1) {
                cauhoiModel cauhoi = new cauhoiModel();
                cauhoi.setMacauhoi(madethi + "_CH_" + stt);
                setnoidung(element, cauhoi);
                cauhoi.setMadethi(madethi);
                cauhoi.setMadoanvan(madoanvan);
                setimage(element, cauhoi);
                listcauhoiList.add(cauhoi);
                dapan.setdapanservic(cauhoi.getDapanlist(), element, cauhoi.getMacauhoi());
                stt++;
            }
        return stt;
    }

    public void setnoidung(Element element, cauhoiModel cauhoi) {
        Element el = element.selectFirst(".card-game-content");
        if(el.html().contains("</b>")){
        el.select("b").remove();
        }
        cauhoi.setNoidung(el.html());
    }

    public void setimage(Element element, cauhoiModel cauhoi) {
        Element el = element.selectFirst(".card-game-content");
        if (el.html().contains("<img src")) {
            cauhoi.setAnh(el.select("img").toString());
        } else {
            cauhoi.setAnh("");
        }
    }

}
