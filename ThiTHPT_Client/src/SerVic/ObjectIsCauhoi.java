/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerVic;

/**
 *
 * @author Admin
 */
public class ObjectIsCauhoi {
    private String nguoidungchon;
    private String dapandung;

    public String getNguoidungchon() {
        return nguoidungchon;
    }

    public ObjectIsCauhoi() {
    }

    
    
    public ObjectIsCauhoi(String nguoidungchon, String dapandung) {
        this.nguoidungchon = nguoidungchon;
        this.dapandung = dapandung;
    }
    
    

    public void setNguoidungchon(String nguoidungchon) {
        this.nguoidungchon = nguoidungchon;
    }

    public String getDapandung() {
        return dapandung;
    }

    public void setDapandung(String dapandung) {
        this.dapandung = dapandung;
    }

   
    
}
