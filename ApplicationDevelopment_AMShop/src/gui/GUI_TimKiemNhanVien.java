package gui;

import dao.DAO_NhanVien;
import data.UtilityJTextField;
import entity.NhanVien;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_TimKiemNhanVien extends javax.swing.JPanel {
    
    private static GUI_TimKiemNhanVien instance = new GUI_TimKiemNhanVien();

    public static GUI_TimKiemNhanVien getInstance() {
        return instance;
    }
    
    public static GUI_TimKiemNhanVien newInstance() {
        instance = new GUI_TimKiemNhanVien();
        return instance;
    }

    public GUI_TimKiemNhanVien() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
        updateTable(DAO_NhanVien.getAllNhanVien());
        UtilityJTextField.addPlaceHolderStyle(txtMaNhanVien);
        tblTable.fixTable(scrTable);
    }
    
    private void updateTable(ArrayList<NhanVien> list){
        DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
        model.getDataVector().removeAllElements();
        tblTable.revalidate();
        tblTable.repaint();
        for(NhanVien thisNhanVien : list){
            model.addRow(new Object[]{
                thisNhanVien.getMaNhanVien(),
                thisNhanVien.getHoTen(),
                thisNhanVien.getSoDienThoai(),
                thisNhanVien.getCanCuocCongDan(),
                thisNhanVien.getChucVu()
            });
        }
    }
    
    private void timKiemTheoMaNhanVien(){
        String maNhanVien = txtMaNhanVien.getText();
        
        ArrayList<NhanVien> list = DAO_NhanVien.getAllNhanVien();
        ArrayList<NhanVien> listRemove = new ArrayList<>();
        
        if(!maNhanVien.equals("")){
            for(NhanVien thisNhanVien : list){
                if(!thisNhanVien.getMaNhanVien().equals(maNhanVien))
                    listRemove.add(thisNhanVien);
            }
        }
        
        list.removeAll(listRemove);
        updateTable(list);
    }

    private void xemChiTietNhanVien(){
        int i = tblTable.getSelectedRow();
        if(i < 0){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Nhân Viên.");
            return;
        }
        String maNhanVien = tblTable.getValueAt(i, 0).toString();
        
        GUI_Main.getInstance().showPanel(GUI_ChiTietNhanVien.newInstance());
        GUI_ChiTietNhanVien.getInstance().showChiTietNhanVien(maNhanVien);
        GUI_ChiTietNhanVien.getInstance().setPnlBefore(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTimKiem = new javax.swing.JPanel();
        txtMaNhanVien = new extended_JComponent.JTextField_AllRound();
        btnTimKiem = new extended_JComponent.JButton_AllRound();
        btnLamMoi = new extended_JComponent.JButton_AllRound();
        btnChiTiet = new extended_JComponent.JButton_AllRound();
        pnlTable = new javax.swing.JPanel();
        scrTable = new javax.swing.JScrollPane();
        tblTable = new extended_JComponent.JTable_LightMode();

        setLayout(new java.awt.BorderLayout());

        pnlTimKiem.setBackground(new java.awt.Color(68, 136, 255));
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiem.setPreferredSize(new java.awt.Dimension(300, 700));

        txtMaNhanVien.setText("Mã Nhân Viên");
        txtMaNhanVien.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaNhanVienFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaNhanVienFocusLost(evt);
            }
        });

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setBorderRadius(30);
        btnTimKiem.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTimKiem.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTimKiem.setColorClick(new java.awt.Color(119, 204, 255));
        btnTimKiem.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setBorderRadius(30);
        btnLamMoi.setColorBackground(new java.awt.Color(170, 238, 255));
        btnLamMoi.setColorBorder(new java.awt.Color(255, 255, 255));
        btnLamMoi.setColorClick(new java.awt.Color(119, 204, 255));
        btnLamMoi.setColorEnter(new java.awt.Color(119, 238, 255));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnChiTiet.setText("Xem Chi Tiết Nhân Viên");
        btnChiTiet.setBorderRadius(30);
        btnChiTiet.setColorBackground(new java.awt.Color(170, 238, 255));
        btnChiTiet.setColorBorder(new java.awt.Color(255, 255, 255));
        btnChiTiet.setColorClick(new java.awt.Color(119, 204, 255));
        btnChiTiet.setColorEnter(new java.awt.Color(119, 238, 255));
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 482, Short.MAX_VALUE))
        );

        add(pnlTimKiem, java.awt.BorderLayout.EAST);

        pnlTable.setLayout(new java.awt.BorderLayout());

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Căn Cước Công Dân", "Chức Vụ"
            }
        ));
        scrTable.setViewportView(tblTable);

        pnlTable.add(scrTable, java.awt.BorderLayout.CENTER);

        add(pnlTable, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        timKiemTheoMaNhanVien();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        GUI_Main.getInstance().showPanel(newInstance());
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        xemChiTietNhanVien();
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void txtMaNhanVienFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNhanVienFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtMaNhanVien, "Mã Nhân Viên");
    }//GEN-LAST:event_txtMaNhanVienFocusGained

    private void txtMaNhanVienFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNhanVienFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtMaNhanVien, "Mã Nhân Viên");
    }//GEN-LAST:event_txtMaNhanVienFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnChiTiet;
    private extended_JComponent.JButton_AllRound btnLamMoi;
    private extended_JComponent.JButton_AllRound btnTimKiem;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JScrollPane scrTable;
    private extended_JComponent.JTable_LightMode tblTable;
    private extended_JComponent.JTextField_AllRound txtMaNhanVien;
    // End of variables declaration//GEN-END:variables

}
