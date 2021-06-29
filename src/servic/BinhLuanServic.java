/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.BinhLuanDAO;
import java.util.List;
import model.BinhLuanModel;

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
