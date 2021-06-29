/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JComponent;

import FormatDom.CauHoiDom;
import FxForm.FxWebview;
import Model.CauHoiModel;
import Model.DapAnModel;
import SerVic.CauHoiServic;
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
import view.formthi.FormthiPnTop;

/**
 *
 * @author Admin
 */
public class QuestionRdoButton extends JRadioButton {

    private int Stt;

    public QuestionRdoButton(String title, int actioncommand, FxWebview fxw) {
        setText(title);
        setActionCommand(String.valueOf(actioncommand));
        setFont(new Font("TimesRoman", Font.BOLD, 18));
        setForeground(Color.gray);
        setMargin(new Insets(5, 50, 10, RIGHT));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormThi.STT = getStt();
                FormthiPnTop.lblindex.setText("Câu Số : "+(getStt()+1)+"/"+FormThi.listCauHoi.size());
                if (!FormThi.STATEFINISH) {
                    String anwserRdo = CauHoiServic.map.get(getStt()) == null ? null : CauHoiServic.map.get(getStt()).getNguoidungchon();
                    if (anwserRdo == null) {
                        for (Enumeration<AbstractButton> buttons = anwserside.group.getElements(); buttons.hasMoreElements();) {
                            AbstractButton button = buttons.nextElement();
                            if (button.getActionCommand().equals("none")) {
                                button.setSelected(true);
                            }
                        }
                    } else {
                        for (Enumeration<AbstractButton> buttons = anwserside.group.getElements(); buttons.hasMoreElements();) {
                            AbstractButton button = buttons.nextElement();
                            if (button.getActionCommand().equals(anwserRdo)) {
                                button.setSelected(true);
                            }
                        }
                    }
                } else {
                    ObjectIsCauhoi obj = CauHoiServic.map.get(FormThi.STT);
                    if (obj != null) {
                        for (Enumeration<AbstractButton> buttons = anwserside.group.getElements(); buttons.hasMoreElements();) {
                            AbstractButton button = buttons.nextElement();
                            button.setForeground(Color.black);
                            if (button.getActionCommand().equals(obj.getNguoidungchon())) {
                                button.setForeground(Color.red);
                            }
                            if (button.getActionCommand().equals(obj.getDapandung())) {
                                button.setForeground(Color.GREEN);
                                button.setSelected(true);
                            }
                        }
                    } else {
                        for (Enumeration<AbstractButton> buttons = anwserside.group.getElements(); buttons.hasMoreElements();) {
                            AbstractButton button = buttons.nextElement();
                            button.setForeground(Color.black);
                            String dapandung = null;
                            for (DapAnModel da : FormThi.listCauHoi.get(getStt()).getListDapAn()) {
                                if (da.getTrangthai().equals("TRUE")) {
                                    dapandung = da.getLoaidapan();
                                }
                            }
                            if (button.getActionCommand().equals(dapandung)) {
                                button.setForeground(Color.pink);
                                button.setSelected(true);
                            }
                        }
                    }
                }

                fxw.loadConent(CauHoiDom.formatterCauHoiDom(FormThi.listCauHoi.get(getStt())));
            }
        });
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public void getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                if (!button.getActionCommand().equals("none")) {

                }
            }
        }
    }

}
