package gui;

import dao.DAO_QuanAo;
import data.InBaoCaoQuanAoDaHet;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class GUI_ThongKeQuanAoDaHet extends javax.swing.JPanel {
    
    private static GUI_ThongKeQuanAoDaHet instance = new GUI_ThongKeQuanAoDaHet();
    
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    public static GUI_ThongKeQuanAoDaHet getInstance() {
        return instance;
    }
    
    public static GUI_ThongKeQuanAoDaHet newInstance() {
        instance = new GUI_ThongKeQuanAoDaHet();
        return instance;
    }
    
    public GUI_ThongKeQuanAoDaHet() {
        initComponents();
        tblQuanAo.fixTable(scrQuanAo);
        
    }
    
    private void updateTable(){
        DefaultTableModel model = (DefaultTableModel) tblQuanAo.getModel();
        model.getDataVector().removeAllElements();
        tblQuanAo.revalidate();
        tblQuanAo.repaint();

        int tongQuanAo = 0;
        
        ResultSet rs = DAO_QuanAo.thongKeQuanAoDaHetHang();
        try {
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2)
                });
                tongQuanAo++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        txtTongSoQuanAo.setText(Integer.toString(tongQuanAo));
    }
    
    private void inBaoCaoThongKe(){
        try {
            if(tblQuanAo.getModel().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "Vui lòng Tạo Thống Kê trước.");
                return;
            }
            if(InBaoCaoQuanAoDaHet.createBaoCaoQuanAoDaHet(ngayBatDau, ngayKetThuc) == true){
                JOptionPane.showMessageDialog(null, "Tạo Báo Cáo Quần Áo đã hết thành công.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Tạo Báo Cáo Quần Áo đã hết thất bại.");
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHoaDon = new javax.swing.JPanel();
        scrQuanAo = new javax.swing.JScrollPane();
        tblQuanAo = new extended_JComponent.JTable_LightMode();
        pnlThongKe = new javax.swing.JPanel();
        lblTongSoQuanAo = new javax.swing.JLabel();
        txtTongSoQuanAo = new extended_JComponent.JTextField_AllRound();
        btnThongKe = new extended_JComponent.JButton_AllRound();
        btnInBaoCao = new extended_JComponent.JButton_AllRound();

        setBackground(new java.awt.Color(68, 136, 255));
        setLayout(new java.awt.BorderLayout());

        pnlHoaDon.setOpaque(false);
        pnlHoaDon.setPreferredSize(new java.awt.Dimension(600, 700));
        pnlHoaDon.setLayout(new java.awt.BorderLayout());

        scrQuanAo.setBackground(new java.awt.Color(68, 136, 255));
        scrQuanAo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Quần Áo Đã Hết", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        tblQuanAo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Quần Áo", "Tên Quần Áo"
            }
        ));
        scrQuanAo.setViewportView(tblQuanAo);
        if (tblQuanAo.getColumnModel().getColumnCount() > 0) {
            tblQuanAo.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        pnlHoaDon.add(scrQuanAo, java.awt.BorderLayout.CENTER);

        add(pnlHoaDon, java.awt.BorderLayout.CENTER);

        pnlThongKe.setBackground(new java.awt.Color(68, 136, 255));
        pnlThongKe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống Kê Quần Áo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlThongKe.setPreferredSize(new java.awt.Dimension(300, 700));

        lblTongSoQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongSoQuanAo.setForeground(new java.awt.Color(255, 255, 255));
        lblTongSoQuanAo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongSoQuanAo.setText("Tổng số quần áo đã hết");

        txtTongSoQuanAo.setEditable(false);
        txtTongSoQuanAo.setBackground(new java.awt.Color(224, 224, 224));
        txtTongSoQuanAo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnThongKe.setText("Thống Kê");
        btnThongKe.setBorderRadius(30);
        btnThongKe.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThongKe.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThongKe.setColorClick(new java.awt.Color(119, 204, 255));
        btnThongKe.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnInBaoCao.setText("In Báo Cáo");
        btnInBaoCao.setBorderRadius(30);
        btnInBaoCao.setColorBackground(new java.awt.Color(170, 238, 255));
        btnInBaoCao.setColorBorder(new java.awt.Color(255, 255, 255));
        btnInBaoCao.setColorClick(new java.awt.Color(119, 204, 255));
        btnInBaoCao.setColorEnter(new java.awt.Color(119, 238, 255));
        btnInBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBaoCaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTongSoQuanAo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInBaoCao, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTongSoQuanAo, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addComponent(lblTongSoQuanAo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongSoQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 491, Short.MAX_VALUE)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlThongKe, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
        updateTable();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnInBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBaoCaoActionPerformed
        // TODO add your handling code here:
        inBaoCaoThongKe();
    }//GEN-LAST:event_btnInBaoCaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnInBaoCao;
    private extended_JComponent.JButton_AllRound btnThongKe;
    private javax.swing.JLabel lblTongSoQuanAo;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JScrollPane scrQuanAo;
    private extended_JComponent.JTable_LightMode tblQuanAo;
    private extended_JComponent.JTextField_AllRound txtTongSoQuanAo;
    // End of variables declaration//GEN-END:variables

}
