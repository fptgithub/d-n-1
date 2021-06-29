/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormatDom;

import FormatDom.bodyDOM.ItemDOM;
import FormatDom.footerDOM.pageDOM;
import FormatDom.headerDOM.MonHocDOM;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Admin
 */
public class DomIndex {

    private String header;
    private String body;
    private String footer;

    //ở đây sẽ gọi các dom khác để sử dụng trong lớp này
    //header dom,
    private MonHocDOM monHocDOM;
    private ItemDOM itemDOM;
    private pageDOM pagedom;

    public static String TENMONHOC;

    //truyền vào một list các tham số cho các dom con sử dụng
    // hearder ->list danh sách môn học
    // body ->list danh sách đề thi
    // footer ->thực hiện logic trong một lớp dom đc gọi
    public DomIndex(String mamonhoc) {
        header = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <meta charset=\"utf-8\" />\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
                + "    <title></title>\n"
                + "    <link rel=\"stylesheet\" href=\"\" />\n"
                + "    <link\n"
                + "      rel=\"stylesheet\"\n"
                + "      href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"\n"
                + "    />\n"
                + "<script\n"
                + "  src=\"https://code.jquery.com/jquery-3.5.1.js\"\n"
                + "  integrity=\"sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=\"\n"
                + "  crossorigin=\"anonymous\"></script>"
                + "    <style type=\"text/css\" media=\"screen\">\n"
                + "      body {\n"
                + "        width: 1200px;\n"
                + "        margin: auto;\n"
                + "        text-align: center;\n"
                + "        padding-top: 50px;\n"
                + "        padding-bottom: 200px;\n"
                + "      }\n"
                + "      .own_comment {\n"
                + "        color: red;\n"
                + "      }\n"
                + "      i {\n"
                + "        margin: 0px 10px 0px 10px;\n"
                + "      }\n"
                + "      button {\n"
                + "        background-color: #ffffff;\n"
                + "        color: #3ea9f5;\n"
                + "        padding: 6px 11px;\n"
                + "        font-size: 15px;\n"
                + "        border: 1px solid #3ea9f5;\n"
                + "        border-radius: 5px;\n"
                + "        outline: none;\n"
                + "      }\n"
                + ".btn_header:focus {\n"
                + "        background-color: #3ea9f5;\n"
                + "        color: #ffffff;\n"
                + "        padding: 6px 11px;\n"
                + "        font-size: 15px;\n"
                + "        border: 1px solid #ffffff;\n"
                + "        border-radius: 5px;\n"
                + "        outline: none;\n"
                + "      }\n"
                + "      .btn_header:hover {\n"
                + "        background-color: #3ea9f5;\n"
                + "        color: #ffffff;\n"
                + "        padding: 6px 11px;\n"
                + "        font-size: 15px;\n"
                + "        border: 1px solid #ffffff;\n"
                + "        border-radius: 5px;\n"
                + "        outline: none;\n"
                + "      }"
                + "      li {\n"
                + "        display: inline-block;\n"
                + "        padding: 10px 20px 10px 20px;\n"
                + "        margin: auto;\n"
                + "      }\n"
                + "      .content {\n"
                + "        display: grid;\n"
                + "        grid-template-columns: 1fr 300px;\n"
                + "        margin-top: 65px;\n"
                + "        margin-bottom: 65px;\n"
                + "      }\n"
                + "      .page {\n"
                + "        background-color: #ffffff;\n"
                + "        color: #3ea9f5;\n"
                + "        padding: 16px 21px;\n"
                + "        font-size: 15px;\n"
                + "        border-radius: 5px;\n"
                + "        border: 1px solid #3ea9f5;\n"
                + "        margin: 0 10px 0 10px;\n"
                + "      }\n"
                + "      .item {\n"
                + "        margin-bottom: 50px;\n"
                + "        margin-top: 50px;\n"
                + "        border-bottom: 1px solid #3ea9f5;\n"
                + "        padding-bottom: 40px;\n"
                + "      }\n"
                + "      .item_p,\n"
                + "      .comment_name {\n"
                + "        font-weight: bold;\n"
                + "      }\n"
                + "      span {\n"
                + "        font-weight: normal;\n"
                + "      }\n"
                + "      .item_content {\n"
                + "      }\n"
                + "      .comment_side {\n"
                + "        width: 300px;\n"
                + "      }\n"
                + "      .comment_content {\n"
                + "        margin-left: 25px;\n"
                + "      }\n"
                + "    </style>\n"
                + "  </head>\n"
                + "  <body>" + "<h2 id = \"tenmonhoc_title\">" + TENMONHOC + "</h2>";
        monHocDOM = new MonHocDOM();
        itemDOM = new ItemDOM(mamonhoc);
        pagedom = new pageDOM();

        body = setbody();

        footer = "</div>"
                + "<script type=\"text/javascript\">"
                + "function changePage(thispage){\n"
                + "	        		var numberPage = thispage.textContent;\n"
                + "	        	var content = window.dom.getItemDOM().itemdomBypage(numberPage) \n"
                + "	        	document.getElementById('content_side').innerHTML = content;\n"
                + "	        }\n"
                + "      \n"
                + "        \n"
                + "function changemonhoc(thispage){\n"
                + "	        		var mamonhoc = thispage.getAttribute(\"data-mamonhoc\");\n"
                + "document.getElementById(\"tenmonhoc_title\").innerHTML = thispage.textContent;"
                + "	         	var content = window.dom.reloadByMonhoc(mamonhoc);\n"
                + "	        	document.getElementById('reload').innerHTML = content;\n"
                + "	        }"
                + "function openformthi(thiselement){\n"
                + "      	var madethi = thiselement.getAttribute(\"data-dethi\");\n"
                + "var tenmonhoc = document.getElementById(\"tenmonhoc_title\").innerHTML;"
                + "var tendethi = thiselement.getAttribute(\"data-tendethi\");"
                + "var thoigian = thiselement.getAttribute(\"data-thoigian\");"
                + "      	window.chonde.openformthi(madethi,tenmonhoc,tendethi,thoigian);"
                + "      }"
                + "    </script>\n"
                + "  </body>\n"
                + "</html>";
    }

    public String reloadByMonhoc(String mamonhoc) {
        itemDOM.reload(mamonhoc);
        return setbodyConent() + setfooterBody();
    }

    public String setbody() {
        StringBuilder bd = new StringBuilder();
        bd.append(setheaderBody());
        bd.append(setbodyConent());
        bd.append(setfooterBody());
        return bd.toString();
    }

    public String setbodyConent() {
        return itemDOM.itemdomBypage(1);
    }

    public String setheaderBody() {
        return monHocDOM.monhocdom();
    }

    public String setfooterBody() {
        if (itemDOM.getListdethi() != null) {
            int size = itemDOM.getListdethi().size();
            if (size > 0) {
                return pagedom.pagedom(size);
            }
            return "";
        }
        return "";
    }

    public String getIndex() {
        //return page complete
        return this.header + this.body + this.footer;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public MonHocDOM getMonHocDOM() {
        return monHocDOM;
    }

    public void setMonHocDOM(MonHocDOM monHocDOM) {
        this.monHocDOM = monHocDOM;
    }

    public ItemDOM getItemDOM() {
        return itemDOM;
    }

    public void setItemDOM(ItemDOM itemDOM) {
        this.itemDOM = itemDOM;
    }

    public pageDOM getPagedom() {
        return pagedom;
    }

    public void setPagedom(pageDOM pagedom) {
        this.pagedom = pagedom;
    }

}
