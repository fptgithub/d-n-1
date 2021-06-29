/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JComponent;

import Model.CauHoiModel;
import SerVic.ObjectIsCauhoi;
import java.awt.Color;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class anwserside extends JPanel {

    public static ButtonGroup group;
    anwserRdoButton none;
    anwserRdoButton AnwserA;
    anwserRdoButton AnwserB;
    anwserRdoButton AnwserC;
    anwserRdoButton AnwserD;

    public anwserside(Map<Integer, ObjectIsCauhoi> mapQuesAnwser,List<CauHoiModel> listcauhoi) {
        setBackground(Color.white);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        group = new ButtonGroup();
        none = new anwserRdoButton("none", mapQuesAnwser,listcauhoi);
        none.setVisible(false);
        none.setSelected(true);
        group.add(none);
        AnwserA = new anwserRdoButton("A", mapQuesAnwser,listcauhoi);
        AnwserB = new anwserRdoButton("B", mapQuesAnwser,listcauhoi);
        AnwserC = new anwserRdoButton("C", mapQuesAnwser,listcauhoi);
        AnwserD = new anwserRdoButton("D", mapQuesAnwser,listcauhoi);
        group.add(AnwserA);
        group.add(AnwserB);
        group.add(AnwserC);
        group.add(AnwserD);
        add(none);
        add(AnwserA);
        add(AnwserB);
        add(AnwserC);
        add(AnwserD);
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public void setGroup(ButtonGroup group) {
        this.group = group;
    }

    
}
