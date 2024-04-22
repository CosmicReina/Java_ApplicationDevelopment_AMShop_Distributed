package gui_old;


import data.FormatDouble;
import data.FormatLocalDateTime;
import entity.HoaDon;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_DanhSachHoaDon extends javax.swing.JPanel {
    
    private static GUI_DanhSachHoaDon instance = new GUI_DanhSachHoaDon();

    public static GUI_DanhSachHoaDon getInstance() {
        return instance;
    }
    
    public static GUI_DanhSachHoaDon newInstance() {
        instance = new GUI_DanhSachHoaDon();
        return instance;
    }
    
    public GUI_DanhSachHoaDon() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
    	
    }

    private void hienThiBang(ArrayList<HoaDon> list){
        
    }
    
    private void xemChiTietHoaDon(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTimKiem = new javax.swing.JPanel();
        btnXemChiTiet = new extended_component.JButton_AllRound();
        scrDanhSachHoaDon = new javax.swing.JScrollPane();
        tblDanhSachHoaDon = new extended_component.JTable_LightMode();

        setMinimumSize(new java.awt.Dimension(1166, 700));
        setPreferredSize(new java.awt.Dimension(1166, 700));
        setLayout(new java.awt.BorderLayout());

        pnlTimKiem.setBackground(new java.awt.Color(79, 137, 255));
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Xem Chi Tiết", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiem.setPreferredSize(new java.awt.Dimension(300, 100));

        btnXemChiTiet.setText("Xem Chi Tiết Hóa Đơn");
        btnXemChiTiet.setBorderRadius(30);
        btnXemChiTiet.setColorBackground(new java.awt.Color(170, 238, 255));
        btnXemChiTiet.setColorBorder(new java.awt.Color(255, 255, 255));
        btnXemChiTiet.setColorClick(new java.awt.Color(119, 204, 255));
        btnXemChiTiet.setColorEnter(new java.awt.Color(119, 238, 255));
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXemChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnlTimKiem, java.awt.BorderLayout.SOUTH);

        tblDanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Nhân Viên Lập Đơn", "Tên Khách Hàng", "Số Điện Thoại", "Ngày Lập Hóa Đơn", "Tổng Tiền"
            }
        ));
        scrDanhSachHoaDon.setViewportView(tblDanhSachHoaDon);

        add(scrDanhSachHoaDon, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_component.JButton_AllRound btnXemChiTiet;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JScrollPane scrDanhSachHoaDon;
    private extended_component.JTable_LightMode tblDanhSachHoaDon;
    // End of variables declaration//GEN-END:variables

}
