/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerVic;

import DAO.ThiDAO;
import Model.Thimodel;
import Socket.requestSocket;
import Util.Formatter;
import Util.RequestPackageObject;

/**
 *
 * @author Admin
 */
public class ThiServic {
    private ThiDAO thiDAO;

    
    public ThiServic() {
    thiDAO = new ThiDAO();
    }
    
    public void insert(Thimodel thi){
        requestSocket request = new requestSocket();
        RequestPackageObject rq = new RequestPackageObject();
        rq.setData(Formatter.GSON.toJson(thi));
        rq.setStatus(RequestPackageObject.THITHU);
        request.write(Formatter.GSON.toJson(rq));
    }
    
}
