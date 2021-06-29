/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerVic;

import Model.MonHocModel;
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
public class MonHocServic {

    private requestSocket request;

    public MonHocServic() {
        request = new requestSocket();
    }

    public List<MonHocModel> select() {
        RequestPackageObject rq = new RequestPackageObject();
        rq.setData(RequestPackageObject.GETMONHOC);
        rq.setStatus(RequestPackageObject.GETDATA);
        request.write(Formatter.GSON.toJson(rq));
        RepoundPackageObject rp = request.read();
        if (rp.getData().equalsIgnoreCase("null")) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(rp.getData());
        MonHocModel[] monhocArray = Formatter.GSON.fromJson(element, MonHocModel[].class);
        return Arrays.asList(monhocArray);
    }
}
