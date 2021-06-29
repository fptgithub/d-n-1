/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerVic;

import Model.CauHoiModel;
import Model.MonHocModel;
import Socket.requestSocket;
import Util.Formatter;
import Util.RepoundPackageObject;
import Util.RequestPackageObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class CauHoiServic {

    private requestSocket request;
    public static Map<Integer, ObjectIsCauhoi> map;

    public CauHoiServic() {
        request = new requestSocket();
        map = new HashMap<>();
    }

    public List<CauHoiModel> select(String madethi) {
        RequestPackageObject rq = new RequestPackageObject();
        rq.setData(RequestPackageObject.GETCAUHOI+";"+madethi);
        rq.setStatus(RequestPackageObject.GETDATA);
        request.write(Formatter.GSON.toJson(rq));
        RepoundPackageObject rp = request.readDataLong();
        if (rp.getData().equalsIgnoreCase("null")) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(rp.getData());
        CauHoiModel[] CauHoiArray = Formatter.GSON.fromJson(element, CauHoiModel[].class);
        return Arrays.asList(CauHoiArray);
    }

    public void finish() {

    }

    public static void main(String[] args) {
        List<ObjectIsCauhoi> list = new ArrayList<>();
        list.add(new ObjectIsCauhoi("a", "A"));
        list.add(new ObjectIsCauhoi("b", "B"));
        list.add(new ObjectIsCauhoi("c", "C"));
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        ObjectIsCauhoi[] obj = gson.fromJson(element, ObjectIsCauhoi[].class);
        List<ObjectIsCauhoi> list2 = Arrays.asList(obj);
        System.out.println(list2.get(0).getDapandung());
    }
}
