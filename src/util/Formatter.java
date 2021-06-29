/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;

/**
 *
 * @author Admin
 */
public class Formatter {
    public static Gson GSON = new Gson();
    
    public static String[] formatterRequest(String dulieuTho){
    String data[] = new String[2];
    data[0] = dulieuTho.split("body")[0].split(";")[1];
    data[1] = dulieuTho.split("body")[1].split(";")[1];
    return data;
    }
}
