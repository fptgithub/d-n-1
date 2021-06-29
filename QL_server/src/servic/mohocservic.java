/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.monhocDAO;
import java.util.List;
import model.monhocModel;

/**
 *
 * @author Admin
 */
public class mohocservic {
    private monhocDAO monhocdao;

    public mohocservic() {
    monhocdao = new monhocDAO();
    }
    
    public List<monhocModel> select(){
    return monhocdao.select();
    }
    
}
