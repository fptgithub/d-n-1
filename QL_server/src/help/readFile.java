/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class readFile {

    public static String readFiletoString() {
        StringBuilder bd = new StringBuilder();
        try (FileInputStream in = new FileInputStream("C:\\Users\\Admin\\Desktop\\dialog.html"); BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));) {
            String inline = "";
            while ((inline = reader.readLine()) != null) {
                bd.append(inline + "\n");
            }
        } catch (Exception ex) {
            Logger.getLogger(readFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bd.toString();
    }
}
