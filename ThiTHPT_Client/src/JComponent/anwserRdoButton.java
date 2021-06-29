/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JComponent;

import Model.CauHoiModel;
import Model.DapAnModel;
import SerVic.ObjectIsCauhoi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import view.formthi.FormThi;

/**
 *
 * @author Admin
 */
public class anwserRdoButton extends JRadioButton {
    
    
    public anwserRdoButton(String tittle, Map<Integer, ObjectIsCauhoi> mapQuesAnwser, List<CauHoiModel> listcauhoi) {
        setText(tittle);
        setFont(new Font("TimesRoman", Font.BOLD, 36));
        setMargin(new Insets(25, 100, 25, 25));
        setActionCommand(tittle);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String anwser = e.getActionCommand();
                if (!anwser.equals("none")) {
                    ObjectIsCauhoi obj = new ObjectIsCauhoi();
                    obj.setNguoidungchon(anwser);
                    for (DapAnModel da : listcauhoi.get(FormThi.STT).getListDapAn()) {
                        if (da.getTrangthai().equals("TRUE")) {
                            obj.setDapandung(da.getLoaidapan());
                        }
                    }
                    mapQuesAnwser.put(FormThi.STT, obj);
                    //set màu cho button chọn câu hỏi
                    for (Enumeration<AbstractButton> buttons = ExamRdoButton.btgroup.getElements(); buttons.hasMoreElements();) {
                        AbstractButton abtn = buttons.nextElement();
                        if (abtn.isSelected()) {
                            abtn.setForeground(Color.GREEN);
                        }
                    }
                }
            }
        });
    }
    
}
