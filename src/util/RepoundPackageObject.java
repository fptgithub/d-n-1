/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Admin
 */
public class RepoundPackageObject {
    public static String TRUE = "TRUE";
    public static String FALSE = "FALSE";
    
    private String status;
    private String message;
    private String data;

    public static String getTRUE() {
        return TRUE;
    }

    public static void setTRUE(String TRUE) {
        RepoundPackageObject.TRUE = TRUE;
    }

    public static String getFALSE() {
        return FALSE;
    }

    public static void setFALSE(String FALSE) {
        RepoundPackageObject.FALSE = FALSE;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
}
