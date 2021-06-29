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
public class RegexPattern {
    public static String GMAILPATTERN = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    
    public static boolean checkgmail(String gmail){
    return gmail.matches(GMAILPATTERN);
    }
    
    
}
