/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerVic;

import DAO.DeThiDAO;
import Model.CauHoiModel;
import Model.DeThiModel;
import Socket.requestSocket;
import Util.Formatter;
import Util.RepoundPackageObject;
import Util.RequestPackageObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DeThiServic {

    private requestSocket request;

    public DeThiServic() {
    }

    public List<DeThiModel> select(String mamonhoc) {
        RequestPackageObject rq = new RequestPackageObject();
        request = new requestSocket();
        rq.setData(RequestPackageObject.GETDETHI + ";" + mamonhoc);
        rq.setStatus(RequestPackageObject.GETDATA);
        request.write(Formatter.GSON.toJson(rq));
        RepoundPackageObject rp = request.read();
        if (rp.getData().equalsIgnoreCase("null")) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(rp.getData());
        DeThiModel[] dethiArray = Formatter.GSON.fromJson(element, DeThiModel[].class);

        return Arrays.asList(dethiArray);
    }
}
