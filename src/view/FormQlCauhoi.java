/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.CauHoiModel;
import model.DapAnModel;
import servic.CauHoiServic;
import util.JDBC;
import util.MessageConfig;

/**
 *
 * @author Admin
 */
public class FormQlCauhoi extends javax.swing.JDialog {
    
    JFrame parent;
    FormSuaXoaDethi formSuaXoaDethi;
    String madethi;
    List<CauHoiModel> listcauhoi;
    CauHoiServic cauHoiServic;
    DefaultTableModel tablemodel;
    int index = -1;

    /**
     * Creates new form FormQlCauhoi
     */
    public FormQlCauhoi(java.awt.Frame parent, FormSuaXoaDethi form, String madethi, String tendethi, String motangan, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            JDBC.con = JDBC.getconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormSuaXoaDethi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormSuaXoaDethi.class.getName()).log(Level.SEVERE, null, ex);
        }
        formSuaXoaDethi = form;
        this.madethi = madethi;
        init();
        txttendethi.setText(tendethi);
        txtmota.setText(motangan);
    }
    
    void init() {
        tablemodel = (DefaultTableModel) tblcauhoi.getModel();
        cauHoiServic = new CauHoiServic();
        System.out.println(madethi);
        listcauhoi = cauHoiServic.select(madethi);
        filltable();
    }
    
    CauHoiModel getmodel() {
        CauHoiModel cauhoi = null;
        if (checknull()) {
            cauhoi = new CauHoiModel();
            cauhoi.setDoanvan(txtdoanvan.getText());
            cauhoi.setNoidung(txtnoidung.getText());
            cauhoi.setImage(txtanh.getText());
            List<DapAnModel> dapan = listcauhoi.get(index).getListDapAn();
            dapan.get(0).setNoidung(txtdapana.getText());
            dapan.get(1).setNoidung(txtdapanb.getText());
            dapan.get(2).setNoidung(txtdapanc.getText());
            dapan.get(3).setNoidung(txtdapand.getText());
            setdapandung(dapan);
            cauhoi.setListDapAn(dapan);
            cauhoi.setMacauhoi(listcauhoi.get(index).getMacauhoi());
            cauhoi.setMadethi(listcauhoi.get(index).getMadethi());
            cauhoi.setNguoisua("damvuong098@gmail.com");
        }
        return cauhoi;
    }
    
    void setdapandung(List<DapAnModel> listdapan) {
        for (DapAnModel dapan : listdapan) {
            if (dapan.getLoaidapan().equals(cbodapandung.getSelectedItem().toString())) {
                dapan.setTrangthai("TRUE");
            }else{
                dapan.setTrangthai("FALSE");
            }
        }
    }
    
    boolean checknull() {
        String noidung = txtnoidung.getText();
        String a = txtdapana.getText();
        String b = txtdapanb.getText();
        String c = txtdapanc.getText();
        String d = txtdapand.getText();
        String tende = txttendethi.getText();
        String mota = txtmota.getText();
        if (noidung.equals("")) {
            MessageConfig.messageText("Không Được Để Trống Nội Dung", rootPane);
            return false;
        }
        if (a.equals("") || b.equals("") || c.equals("") || d.equals("")) {
            MessageConfig.messageText("Không Được Để Trống Đáp Án", rootPane);
            return false;
        }
        if (tende.equals("")) {
            MessageConfig.messageText("Không Được Để Trống Tên Đề Thi", rootPane);
            return false;
        }
        if (mota.equals("")) {
            MessageConfig.messageText("Không Được Để Trống Mô Tả", rootPane);
            return false;
        }
        return true;
        
    }
    
    void filltable() {
        tablemodel.setRowCount(0);
        if (listcauhoi != null && !listcauhoi.isEmpty()) {
            for (CauHoiModel cauhoi : listcauhoi) {
                String dapandung = "";
                for (DapAnModel dapan : cauhoi.getListDapAn()) {
                    if (dapan.getTrangthai().equals("TRUE")) {
                        dapandung = dapan.getLoaidapan();
                    }
                }
                tablemodel.addRow(new Object[]{
                    cauhoi.getMacauhoi(),
                    cauhoi.getNoidung(),
                    cauhoi.getImage(),
                    cauhoi.getDoanvan(),
                    cauhoi.getListDapAn().get(0),
                    cauhoi.getListDapAn().get(1),
                    cauhoi.getListDapAn().get(2),
                    cauhoi.getListDapAn().get(3), dapandung}
                );
            }
        }
    }
    
    void setmodel(CauHoiModel cauhoi) {
        if (cauhoi != null) {
            txtanh.setText(cauhoi.getImage());
            txtdapana.setText(cauhoi.getListDapAn().get(0).getNoidung());
            txtdapanb.setText(cauhoi.getListDapAn().get(1).getNoidung());
            txtdapanc.setText(cauhoi.getListDapAn().get(2).getNoidung());
            txtdapand.setText(cauhoi.getListDapAn().get(3).getNoidung());
            txtdoanvan.setText(cauhoi.getDoanvan());
            txtnoidung.setText(cauhoi.getNoidung());
            for (DapAnModel dapan : cauhoi.getListDapAn()) {
                if (dapan.getTrangthai().equals("TRUE")) {
                    cbodapandung.setSelectedItem(dapan.getLoaidapan());
                }
            }
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcauhoi = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdapana = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtdapanc = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtdapanb = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtdapand = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtnoidung = new javax.swing.JTextArea();
        txtanh = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtdoanvan = new javax.swing.JTextArea();
        cbodapandung = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txttendethi = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblcauhoi.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        tblcauhoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblcauhoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Câu Hỏi", "Nội Dung", "Ảnh Minh Họa", "Đoạn Văn", "Đáp Án A", "Đáp Án B", "Đáp Án C", "Đáp Án D", "Đáp Án Đúng"
            }
        ));
        tblcauhoi.setGridColor(new java.awt.Color(255, 255, 255));
        tblcauhoi.setRowHeight(23);
        tblcauhoi.setRowMargin(3);
        tblcauhoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblcauhoiMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblcauhoi);

        txtdapana.setColumns(20);
        txtdapana.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        txtdapana.setLineWrap(true);
        txtdapana.setRows(5);
        txtdapana.setWrapStyleWord(true);
        txtdapana.setBorder(null);
        jScrollPane2.setViewportView(txtdapana);

        txtdapanc.setColumns(20);
        txtdapanc.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        txtdapanc.setLineWrap(true);
        txtdapanc.setRows(5);
        txtdapanc.setWrapStyleWord(true);
        txtdapanc.setBorder(null);
        jScrollPane3.setViewportView(txtdapanc);

        txtdapanb.setColumns(20);
        txtdapanb.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        txtdapanb.setLineWrap(true);
        txtdapanb.setRows(5);
        txtdapanb.setWrapStyleWord(true);
        txtdapanb.setBorder(null);
        jScrollPane4.setViewportView(txtdapanb);

        txtdapand.setColumns(20);
        txtdapand.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        txtdapand.setLineWrap(true);
        txtdapand.setRows(5);
        txtdapand.setWrapStyleWord(true);
        txtdapand.setBorder(null);
        jScrollPane5.setViewportView(txtdapand);

        txtnoidung.setColumns(20);
        txtnoidung.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        txtnoidung.setLineWrap(true);
        txtnoidung.setRows(5);
        txtnoidung.setWrapStyleWord(true);
        txtnoidung.setBorder(null);
        jScrollPane6.setViewportView(txtnoidung);

        txtanh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtdoanvan.setColumns(20);
        txtdoanvan.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        txtdoanvan.setLineWrap(true);
        txtdoanvan.setRows(5);
        txtdoanvan.setWrapStyleWord(true);
        txtdoanvan.setBorder(null);
        jScrollPane7.setViewportView(txtdoanvan);

        cbodapandung.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        cbodapandung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jLabel1.setText("Đáp Án Đúng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Ảnh Minh Họa");

        btnback.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnback.setText("Quay Lại");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(255, 255, 255));
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_refresh_200px_2.png"))); // NOI18N
        btnsua.setBorder(null);
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Tên Đề Thi");

        txttendethi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txtmota.setColumns(20);
        txtmota.setFont(new java.awt.Font("Monospaced", 0, 15)); // NOI18N
        txtmota.setLineWrap(true);
        txtmota.setRows(5);
        txtmota.setWrapStyleWord(true);
        txtmota.setBorder(null);
        jScrollPane8.setViewportView(txtmota);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Đáp Án A");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Đáp Án B");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Đáp Án C");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Đáp Án D");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Mô Tả Ngắn");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Nội Dung");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Đoạn Văn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnsua, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                                .addComponent(jScrollPane8))
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 74, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtanh, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txttendethi)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(319, 319, 319)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbodapandung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(356, 356, 356))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnback)
                                        .addGap(11, 11, 11))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                                        .addComponent(jScrollPane7))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnback)
                            .addComponent(txttendethi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbodapandung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane5)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        formSuaXoaDethi.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void tblcauhoiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcauhoiMousePressed
        // TODO add your handling code here:
        index = tblcauhoi.getSelectedRow();
        if (index >= 0 && index <= listcauhoi.size() - 1) {
            setmodel(listcauhoi.get(index));
        }
    }//GEN-LAST:event_tblcauhoiMousePressed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        if (index >= 0 && index <= listcauhoi.size() - 1) {
            CauHoiModel cauhoi = getmodel();
            listcauhoi.set(index, cauhoi);
            filltable();
        }
    }//GEN-LAST:event_btnsuaActionPerformed

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
            java.util.logging.Logger.getLogger(FormQlCauhoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQlCauhoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQlCauhoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                FormQlCauhoi dialog = new FormQlCauhoi(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnsua;
    private javax.swing.JComboBox<String> cbodapandung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable tblcauhoi;
    private javax.swing.JTextField txtanh;
    private javax.swing.JTextArea txtdapana;
    private javax.swing.JTextArea txtdapanb;
    private javax.swing.JTextArea txtdapanc;
    private javax.swing.JTextArea txtdapand;
    private javax.swing.JTextArea txtdoanvan;
    private javax.swing.JTextArea txtmota;
    private javax.swing.JTextArea txtnoidung;
    private javax.swing.JTextField txttendethi;
    // End of variables declaration//GEN-END:variables
}
