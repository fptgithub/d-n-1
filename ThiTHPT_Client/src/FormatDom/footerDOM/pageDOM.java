/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormatDom.footerDOM;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Admin
 */
public class pageDOM {

    public String pagedom(int size) {
        double end = Math.ceil((double)size / 4);
        StringBuilder bd = new StringBuilder();
        bd.append("<div class=\"footer\">\n"
                + "      <ul>\n"
        );
        for (int i = 1; i <= end; i++) {
            bd.append("<li onclick=\"changePage(this)\" class=\"page\">"+i+"</li>\n");
        }
        bd.append("</ul>\n"
                + "</div>");
        return bd.toString();
    }
}
