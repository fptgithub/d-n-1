/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JComponent;

import FxForm.FxWebview;
import Model.CauHoiModel;
import SerVic.ObjectIsCauhoi;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Map;
import javafx.scene.web.WebEngine;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ExamRdoButton extends JPanel {
    
    private final String questionName = "Question-";
    public static ButtonGroup btgroup;
    
    public ExamRdoButton(Map<Integer,ObjectIsCauhoi> map,List<CauHoiModel> list, int size,FxWebview fxw) {
        setBackground(Color.white);
        btgroup = new ButtonGroup();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        QuestionRdoButton rd1 = null;
        for (int i = 0; i < size; i++) {
            QuestionRdoButton rd = new QuestionRdoButton( questionName + (i+1),i,fxw);
            if (i == 0) {
                rd1 = rd;
            }
            rd.setStt(i);
            btgroup.add(rd);
            add(rd);
        }
        rd1.setSelected(true);
    }

    public ButtonGroup getBtgroup() {
        return btgroup;
    }

    public void setBtgroup(ButtonGroup btgroup) {
        this.btgroup = btgroup;
    }
    
}
