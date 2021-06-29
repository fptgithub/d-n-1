/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormatDom.bodyDOM;

import Model.DeThiModel;
import Model.MonHocModel;
import SerVic.DeThiServic;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ItemDOM {

    private DeThiServic deThiServic;
    private List<DeThiModel> listdethi;

    public ItemDOM(String mamonhoc) {
        deThiServic = new DeThiServic();
        listdethi = deThiServic.select(mamonhoc);
    }

    public String itemdomBypage(int page) {
        if (listdethi != null) {
            StringBuilder bd = new StringBuilder();
            int begin = page * 4 - 4;
            int end = page * 4 - 1;
            for (int i = begin; i <= end; i++) {
                try {
                    bd.append(itemdom(listdethi.get(i)));
                } catch (Exception e) {
                    return bd.toString();
                }
            }
            return "<div id=\"content_side\" >" + bd.toString() + "</div>";
        }
        return "<h2>Chưa Có Đề Thi Nào</h2>";
    }

    public void reload(String mamonhoc) {
        System.out.println(deThiServic.select(mamonhoc));
        listdethi = deThiServic.select(mamonhoc);
    }

    public String itemdom(DeThiModel dethi) {
        String itemdom = "<div class=\"item\" >\n"
                + "          <div class=\"title\">\n"
                + "            <h2>" + dethi.getTendethi() + "</h2>\n"
                + "             <div>" + dethi.getMotangan() + "</div>"
                + "            <div class=\"item_content\">\n"
                + "              <p class=\"item_p\">Thời Gian Thi : <span>" + dethi.getThoigianthi() + " Phút</span></p>\n"
                + "              <p class=\"item_p\">Tổng Số Câu : <span>" + dethi.getTongsocau() + " Câu</span></p>\n"
                + "              <div class=\"item_btn\">\n"
                + "                <div class=\"thithu\">\n"
                + "                  <button type=\"\" onclick=\"openformthi(this)\" data-tendethi = \""+dethi.getTendethi()+"\" data-thoigian = \""+dethi.getThoigianthi()+"\"  data-dethi = " + dethi.getMadethi() + ">Thi Ngay</button>\n"
                + "                </div>\n"
                + "              </div>\n"
                + "            </div>\n"
                + "          </div>\n"
                + "        </div>";
        return itemdom;
    }

    public DeThiServic getDeThiServic() {
        return deThiServic;
    }

    public void setDeThiServic(DeThiServic deThiServic) {
        this.deThiServic = deThiServic;
    }

    public List<DeThiModel> getListdethi() {
        return listdethi;
    }

    public void setListdethi(List<DeThiModel> listdethi) {
        this.listdethi = listdethi;
    }

}
