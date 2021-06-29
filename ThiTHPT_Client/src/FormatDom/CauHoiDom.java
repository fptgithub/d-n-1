/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormatDom;

import Model.CauHoiModel;
import SerVic.CauHoiServic;
import Util.JDBC;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CauHoiDom {

    public static String formatterCauHoiDom(CauHoiModel cauhoi) {
        String cauhoiHTML = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "  <head>\n"
                + "    <meta charset=\"UTF-8\" />\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n"
                + "<script type=\"text/javascript\" src=\"https://hoctot.com/luyen-thi/resources/mathJax/MathJax.js?config=TeX-AMS-MML_SVG.js\"></script>"
                + "    <style>\n"
                + "      .dapan{\n"
                + "        margin-left : 65px;\n"
                + "        margin-top : 20px;\n"
                + "      }\n"
                + "      #cauhoi{\n"
                + "        margin-left : 30px;\n"
                + "        margin-top : 20px\n"
                + "      }\n"
                + "      #image{\n"
                + "        margin-left : 20px;\n"
                + "        margin-top : 20px;\n"
                + "      }\n"
                + "    </style>\n"
                + "    <title>Static Template</title>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    <div>\n"
                 + "      <div id=\"cauhoi\">" + cauhoi.getDoanvan()+"</div>\n"
                + "      <div id=\"cauhoi\">" + cauhoi.getNoidung() + "</div>\n"
                + "      <div id=\"image\">" + cauhoi.getImage() + "<div>\n"
                + "      <div class=\"dapan\"><b>A</b> . " + cauhoi.getListDapAn().get(0).getNoidung()+ "</div>\n"
                + "      <div class=\"dapan\"><b>B</b> . " + cauhoi.getListDapAn().get(1).getNoidung()+"</div>\n"
                + "      <div class=\"dapan\"><b>C</b> . " + cauhoi.getListDapAn().get(2).getNoidung()+"</div>\n"
                + "      <div class=\"dapan\"><b>D</b> . " + cauhoi.getListDapAn().get(3).getNoidung()+"</div>\n"
                + "    </div>\n"
                + "  </body>\n"
                + "</html>";
        return cauhoiHTML;
    }

    public static void main(String[] args) {
        try {
            JDBC.con = JDBC.getconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CauHoiDom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiDom.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(formatterCauHoiDom(new CauHoiServic().select("DT_01").get(44)));
        try {
            JDBC.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CauHoiDom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
