/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DeThiModel;
import model.MonHocModel;
import servic.DeThiServic;
import servic.MonHocServic;
import util.JDBC;
import util.MessageConfig;

/**
 *
 * @author Admin
 */
public class FormSuaXoaDethi extends javax.swing.JDialog {

    /**
     * Creates new form FormSuaXoaDethi
     */
    List<DeThiModel> listdethi;
    List<MonHocModel> listmonhoc;
    int index = -1;
    MonHocServic monHocServic;
    DeThiServic deThiServic;
    DefaultTableModel tableModel;
    JFrame parent;

    public FormSuaXoaDethi(JFrame parent, boolean modal) {

        super(parent, modal);
        initComponents();
        try {
            JDBC.con = JDBC.getconnect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormSuaXoaDethi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormSuaXoaDethi.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.parent = parent;
        init();
    }

    void init() {
        monHocServic = new MonHocServic();
        deThiServic = new DeThiServic();
        txttendethi.setEditable(false);
        txtmota.setEditable(false);
        tableModel = (DefaultTableModel) tbldethi.getModel();
        listmonhoc = monHocServic.select();
        fillconboboxmonhoc();
        listdethi = deThiServic.select(((MonHocModel) cbomonhoc.getSelectedItem()).getMamonhoc());
        filltable();

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
        jLabel1 = new javax.swing.JLabel();
        cbomonhoc = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldethi = new javax.swing.JTable();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnthoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txttendethi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        lblthoigain = new javax.swing.JLabel();
        lbltongsocau = new javax.swing.JLabel();
        lblmadethi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Môn Học");

        cbomonhoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbomonhoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbomonhocItemStateChanged(evt);
            }
        });

        tbldethi.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        tbldethi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbldethi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Đề Thi", "Tên Đề Thi", "Mô Tả Ngắn", "Thời Gian Thi", "Tổng Số Câu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldethi.setGridColor(new java.awt.Color(255, 255, 255));
        tbldethi.setRowHeight(23);
        tbldethi.setRowMargin(3);
        tbldethi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbldethiMousePressed(evt);
            }
        });
        tbldethi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbldethiKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbldethi);
        if (tbldethi.getColumnModel().getColumnCount() > 0) {
            tbldethi.getColumnModel().getColumn(1).setPreferredWidth(333);
            tbldethi.getColumnModel().getColumn(2).setPreferredWidth(233);
        }

        btnsua.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnthoat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnthoat.setText("Thoát");
        btnthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthoatActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Mã Đề Thi");

        txttimkiem.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txttimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttimkiemKeyPressed(evt);
            }
        });

        btntimkiem.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btntimkiem.setText("Tìm Kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Tên Đề Thi");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Mô Tả Ngắn");

        txttendethi.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txtmota.setColumns(20);
        txtmota.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtmota.setLineWrap(true);
        txtmota.setRows(5);
        txtmota.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtmota);

        lblthoigain.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblthoigain.setText("Thời Gian :");

        lbltongsocau.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lbltongsocau.setText("Tổng Số Câu :");

        lblmadethi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblmadethi.setText("Mã Đề Thi :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1590, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnthoat)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addGap(34, 34, 34)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbomonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(130, 130, 130)
                                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txttimkiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btntimkiem)
                                .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(70, 70, 70)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(txttendethi, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblthoigain))
                                    .addGap(87, 87, 87))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblmadethi)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4)
                                    .addGap(15, 15, 15)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbltongsocau)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnthoat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblthoigain)
                    .addComponent(lbltongsocau))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntimkiem)
                            .addComponent(jLabel4)
                            .addComponent(lblmadethi))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbomonhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnsua)
                            .addComponent(btnxoa)
                            .addComponent(jLabel3)
                            .addComponent(txttendethi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
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

    private void btnthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnthoatActionPerformed

    private void cbomonhocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbomonhocItemStateChanged
        // TODO add your handling code here:
        listdethi = deThiServic.select(((MonHocModel) cbomonhoc.getSelectedItem()).getMamonhoc());
        filltable();
        if (tableModel.getRowCount() > 0) {
            tbldethi.setRowSelectionInterval(0, 0);
            setmodel(listdethi.get(0));
        }
    }//GEN-LAST:event_cbomonhocItemStateChanged

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        String[] madethilbl = lblmadethi.getText().split(":");
        if (madethilbl.length >= 2) {
            String madethi = madethilbl[1].trim();
            System.out.println(madethi);
            this.setVisible(false);
            new FormQlCauhoi(parent, this, madethi,txttendethi.getText(),txtmota.getText(), rootPaneCheckingEnabled).setVisible(true);
            return;
        }
        MessageConfig.messageText("Bạn Chưa Chọn Đề Thi", jPanel1);

    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        String[] madethilbl = lblmadethi.getText().split(":");
        if (madethilbl.length >= 2) {
            String madethi = madethilbl[1].trim();
            deThiServic.delete(madethi);
            setmodel(null);
            listdethi = deThiServic.select(((MonHocModel) cbomonhoc.getSelectedItem()).getMamonhoc());
            filltable();
            return;
        }
        MessageConfig.messageText("Bạn Chưa Chọn Đề Thi", jPanel1);
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        // TODO add your handling code here:
        finđethi();
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void txttimkiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkiemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            finđethi();
        }
    }//GEN-LAST:event_txttimkiemKeyPressed

    private void tbldethiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbldethiKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            if (index > 0 && index <= listdethi.size() - 1) {
                index--;
                setmodel(listdethi.get(index));
                index--;
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (index >= 0 && index < listdethi.size() - 1) {
                index++;
                setmodel(listdethi.get(index));
            }
        }
    }//GEN-LAST:event_tbldethiKeyPressed

    private void tbldethiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldethiMousePressed
        // TODO add your handling code here: 
        index = tbldethi.getSelectedRow();
        if (index >= 0 && index <= listdethi.size() - 1) {
            setmodel(listdethi.get(index));
        }
    }//GEN-LAST:event_tbldethiMousePressed

    void finđethi() {
        String madethi = txttimkiem.getText();
        if (madethi.equals("")) {
            MessageConfig.messageText("Không Được Để Trống Mã Đề Thi", jPanel1);
            return;
        }
        if (listdethi != null && !listdethi.isEmpty()) {
            int i = 0;
            for (DeThiModel dethi : listdethi) {
                if (dethi.getMadethi().equals(madethi)) {
                    tbldethi.setRowSelectionInterval(i, i);
                    setmodel(dethi);
                    return;
                }
                i++;
            }

        }
        MessageConfig.messageText("Không Tìm Thấy Đề Thi Này Tại Môn Học Này", jPanel1);

    }

    void setmodel(DeThiModel dethi) {
        if (dethi == null) {
            lblmadethi.setText(lblmadethi.getText().split(":")[0] + ": ");
            lblthoigain.setText(lblthoigain.getText().split(":")[0] + ": ");
            lbltongsocau.setText(lbltongsocau.getText().split(":")[0] + ": ");
            txttendethi.setText("");
            txtmota.setText("");
            return;
        }
        lblmadethi.setText(lblmadethi.getText().split(":")[0] + ": " + dethi.getMadethi());
        lblthoigain.setText(lblthoigain.getText().split(":")[0] + ": " + dethi.getThoigianthi());
        lbltongsocau.setText(lbltongsocau.getText().split(":")[0] + ": " + dethi.getTongsocau());
        txttendethi.setText(dethi.getTendethi());
        txtmota.setText(dethi.getMotangan());
    }

    void fillconboboxmonhoc() {
        if (listmonhoc != null && !listmonhoc.isEmpty()) {
            for (MonHocModel monhoc : listmonhoc) {
                cbomonhoc.addItem(monhoc);
            }
        }
    }

    void filltable() {
        tableModel.setRowCount(0);
        if (listdethi != null && !listdethi.isEmpty()) {
            for (DeThiModel dethi : listdethi) {
                tableModel.addRow(new Object[]{
                    dethi.getMadethi(),
                    dethi.getTendethi(),
                    dethi.getMotangan(),
                    dethi.getThoigianthi(),
                    dethi.getTongsocau()
                });
            }
        }
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
            java.util.logging.Logger.getLogger(FormSuaXoaDethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSuaXoaDethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSuaXoaDethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSuaXoaDethi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormSuaXoaDethi dialog = new FormSuaXoaDethi(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthoat;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<MonHocModel> cbomonhoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblmadethi;
    private javax.swing.JLabel lblthoigain;
    private javax.swing.JLabel lbltongsocau;
    private javax.swing.JTable tbldethi;
    private javax.swing.JTextArea txtmota;
    private javax.swing.JTextField txttendethi;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}