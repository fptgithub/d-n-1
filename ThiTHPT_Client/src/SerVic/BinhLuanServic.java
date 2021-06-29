/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerVic;

import DAO.BinhLuanDAO;
import Model.BinhLuanModel;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BinhLuanServic {
    private BinhLuanDAO binhLuanDAO;

    public BinhLuanServic() {
    binhLuanDAO = new BinhLuanDAO();
    }
    
    public List<BinhLuanModel> select(){
    return binhLuanDAO.selectbinhluan();
    }
}
