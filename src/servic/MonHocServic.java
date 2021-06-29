/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.MonHocDAO;
import java.util.List;
import model.MonHocModel;

/**
 *
 * @author Admin
 */
public class MonHocServic {
    private MonHocDAO monHocDAO;

    public MonHocServic() {
    monHocDAO = new MonHocDAO();
    }
    
    public List<MonHocModel> select(){
    return monHocDAO.selectMonHoc();
    }
}
