/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Admin
 */
public class RequestPackageObject {

    public static String DANGNHAP = "DANGNHAP";
    public static String DANGKY = "DANGKY";
    public static String LOGOUT = "LOGOUT";
    public static String QUENMK = "QUENMK";
    public static String DOIMK = "DOIMK";
    public static String GETDATA = "GETDATA";
    public static String GETCAUHOI = "CAUHOI";
    public static String GETMONHOC = "MONHOC";
    public static String GETDETHI = "DETHI";
    public static String THITHU = "THITHU";
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
