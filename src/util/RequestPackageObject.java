/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    private String da
 */
package util;

/**
 *
 * @author Admin
 */
public class RequestPackageObject {
    public static String DANGNHAP = "DANGNHAP";
    
    private String status;
    private String data;

    public static String getDANGNHAP() {
        return DANGNHAP;
    }

    public static void setDANGNHAP(String DANGNHAP) {
        RequestPackageObject.DANGNHAP = DANGNHAP;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
