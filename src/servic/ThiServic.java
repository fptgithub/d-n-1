/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servic;

import DAO.ThiDAO;
import model.Thimodel;

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
    thiDAO.insertThi(thi);
    }
    
}
