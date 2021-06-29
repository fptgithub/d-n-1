/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.CauHoiDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.CauHoiModel;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Admin
 */
public class CauHoiServic {
    private CauHoiDAO cauHoiDAO;
    public static Map<Integer,ObjectIsCauhoi> map;

    public CauHoiServic() {
    cauHoiDAO = new CauHoiDAO();
    map = new HashMap<>();
    }
    
    public List<CauHoiModel> select(String madethi){
    return cauHoiDAO.selectCauHoi(madethi);
    }
    
   public void insert(CauHoiModel cauhoi) {
        cauHoiDAO.insert(cauhoi);
    }

    public void setcauhoiservic(List<CauHoiModel> listcauhoiList, Elements els, String madethi, dapanservic dapan) {
        int i = 1;
        els.select("script").remove();
        for (Element element : els) {
                CauHoiModel cauhoi = new CauHoiModel();
                cauhoi.setMacauhoi(madethi + "_CH_" + i);
                setnoidung(element, cauhoi);
                cauhoi.setMadethi(madethi);
                setimage(element, cauhoi);
                i++;
                listcauhoiList.add(cauhoi);
                dapan.setdapanservic(cauhoi.getListDapAn(), element, cauhoi.getMacauhoi());
            }
    }
    
    public int setcauhoiservicmonTiengAnh(List<CauHoiModel> listcauhoiList, Element els, String madethi, dapanservic dapan,Integer i,String doanvan) {
        els.select("script").remove();
        int stt = i;
        Elements els1 = els.select(".game-code-view-main-view-panel.mainPanelAutoIndexLine .game-code-view-main-view-panel .gameViewPanel");
        for (Element element : els1) {
                CauHoiModel cauhoi = new CauHoiModel();
                cauhoi.setMacauhoi(madethi + "_CH_" + stt);
                setnoidung(element, cauhoi);
                cauhoi.setMadethi(madethi);
                cauhoi.setDoanvan(doanvan);
                setimage(element, cauhoi);
                listcauhoiList.add(cauhoi);
                dapan.setdapanservic(cauhoi.getListDapAn(), element, cauhoi.getMacauhoi());
                stt++;
            }
        return stt;
    }

    public void setnoidung(Element element, CauHoiModel cauhoi) {
        Element el = element.selectFirst(".card-game-content");
        if(el.html().contains("</b>")){
        el.select("b").remove();
        }
        cauhoi.setNoidung(el.html());
    }

    public void setimage(Element element, CauHoiModel cauhoi) {
        Element el = element.selectFirst(".card-game-content");
        if (el.html().contains("<img src")) {
            cauhoi.setImage(el.select("img").toString());
        } else {
            cauhoi.setImage("");
        }
    }

}
