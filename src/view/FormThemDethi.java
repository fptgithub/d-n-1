/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.MonHocDAO;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CauHoiModel;
import model.DapAnModel;
import model.DeThiModel;
import model.MonHocModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import servic.CauHoiServic;
import servic.DeThiServic;
import servic.dapanservic;
import util.JDBC;
import util.readFile;

/**
 *
 * @author Admin
 */
public class FormThemDethi extends javax.swing.JDialog {

    private DeThiServic dethiservic;
    private CauHoiServic cauhoiservic;
    private dapanservic dapanservic;
    private MonHocDAO monhocdao;
    private String monhoc;
    private DeThiModel dethi;
    private List<CauHoiModel> listcauhoi;

    /**
     * Creates new form FormThemDethi
     */
    public FormThemDethi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void init() {
        try {
            JDBC.con = JDBC.getconnect();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dethiservic = new DeThiServic();
        cauhoiservic = new CauHoiServic();
        dapanservic = new dapanservic();

        monhocdao = new MonHocDAO();
        listcauhoi = new ArrayList<>();
        loadcombo();
        monhoc = ((MonHocModel) cbomonhoc.getSelectedItem()).getMamonhoc();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnchonfile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblfilename = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbomonhoc = new javax.swing.JComboBox<>();
        tamotangan = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        btnthoat = new javax.swing.JButton();
        txtdethi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnthem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnchonfile.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        btnchonfile.setText("Chọn File");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("File Name");

        lblfilename.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã Đề Thi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Môn Học");

        cbomonhoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbomonhoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbomonhocItemStateChanged(evt);
            }
        });

        ta.setColumns(20);
        ta.setRows(5);
        ta.setBorder(javax.swing.BorderFactory.createTitledBorder("Mô Tả Ngắn"));
        tamotangan.setViewportView(ta);

        btnthoat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        txtdethi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblfilename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtdethi))
                                    .addComponent(btnchonfile, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cbomonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(tamotangan, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(btnthem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnthoat)
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdethi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(btnchonfile, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbomonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(tamotangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblfilename, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnthoat))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        if (checkMaDeThi()) {
            setdethi();
            insert();
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void cbomonhocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbomonhocItemStateChanged
        // TODO add your handling code here:
        monhoc = ((MonHocModel) cbomonhoc.getSelectedItem()).getMamonhoc();
    }//GEN-LAST:event_cbomonhocItemStateChanged

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnthoatActionPerformed

    public void setdethi() {
        dethi = new DeThiModel();
        dethi.setMadethi(txtdethi.getText());
        dethi.setMamonhoc(monhoc);
        dethi.setNgaytao(new Timestamp(new java.util.Date().getTime()));
        dethi.setNguoitao("damvuong0987@gmail.com");
        dethi.setMotangan(ta.getText());
    }

    public void insert() {
        Document doc = getdocument();
        if (doc != null) {
            dethiservic.settendethi(dethi, doc);
            Integer stt = 1;
            if (doc.select(".question-item-main-panel").size() < 40) {
                Elements els = doc.select(".question-item-main-panel");
                int i = 1;
                for (Element el : els) {
                    Element el1 = el.selectFirst(".card-game-content");
                    if (el1.select("card-game-content").toString().contains("</b>")) {
                        el1.select("b").remove();
                    }
                    String doanvan = el1.html();
                    stt = cauhoiservic.setcauhoiservicmonTiengAnh(listcauhoi, el, dethi.getMadethi(), dapanservic, stt, doanvan
                    );
                    i++;
                }
            } else {
                Elements els = doc.select(".question-item-main-panel");
                cauhoiservic.setcauhoiservic(listcauhoi, els, dethi.getMadethi(), dapanservic);
            }
            dethiservic.insert(dethi);
            for (CauHoiModel cauhoi : listcauhoi) {
                cauhoiservic.insert(cauhoi);
                for (DapAnModel dapan : cauhoi.getListDapAn()) {
                    dapanservic.insert(dapan);
                }
            }
            listcauhoi.removeAll(listcauhoi);
            JOptionPane.showMessageDialog(rootPane, "success");
        }
    }

    public boolean checkMaDeThiFromDataBase() {
        if (dethiservic.checkmadethi(txtdethi.getText())) {
            return true;
        }
        JOptionPane.showMessageDialog(this, "mã đề thi đã tồn tại");
        return false;
    }

    public boolean checkMaDeThi() {
        String a = txtdethi.getText();
        if (txtdethi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "không được để trống mã đề thi");
            return false;
        }
        return checkMaDeThiFromDataBase();
    }

    public void loadcombo() {
        List<MonHocModel> list = monhocdao.selectMonHoc();
        cbomonhoc.removeAllItems();
        for (MonHocModel monhoc : list) {
            cbomonhoc.addItem(monhoc);
        }
    }

    public Document getdocument() {
        return Jsoup.parse(readFile.readFiletoString());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormThemDethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThemDethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThemDethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThemDethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormThemDethi dialog = new FormThemDethi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnchonfile;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthoat;
    private javax.swing.JComboBox<MonHocModel> cbomonhoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblfilename;
    private javax.swing.JTextArea ta;
    private javax.swing.JScrollPane tamotangan;
    private javax.swing.JTextField txtdethi;
    // End of variables declaration//GEN-END:variables
}
