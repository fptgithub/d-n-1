/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.TaiKhoanModel;

/**
 *
 * @author Admin
 */
public class cookieNguoiDung {
    public static TaiKhoanModel NGUOIDUNG = null;
    public static String MAXACNHAN = null; 
    
    public static void logOut(){
    NGUOIDUNG = null;
    }
    
    public static void login(TaiKhoanModel taikhoan){
    NGUOIDUNG = taikhoan;
    }
    
    public static boolean isNguoiDung(){
    return NGUOIDUNG==null?false:true;
    }
    
    
}
