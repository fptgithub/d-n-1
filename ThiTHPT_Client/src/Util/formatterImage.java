/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class formatterImage {
    public static ImageIcon fiximage(String image){
    ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(130, 95, Image.SCALE_DEFAULT));
    return imageIcon;
    }
}
