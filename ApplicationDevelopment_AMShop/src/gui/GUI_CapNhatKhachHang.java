package gui;

import dao.DAO_KhachHang;
import data.UtilityJTextField;
import entity.KhachHang;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_CapNhatKhachHang extends javax.swing.JPanel {
    
    private static GUI_CapNhatKhachHang instance = new GUI_CapNhatKhachHang();

    public static GUI_CapNhatKhachHang getInstance() {
        return instance;
    }
    
    public static GUI_CapNhatKhachHang newInstance() {
        instance = new GUI_CapNhatKhachHang();
        return instance;
    }

    public GUI_CapNhatKhachHang() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
        updateTable(DAO_KhachHang.getAllKhachHang());
        
        UtilityJTextField.addPlaceHolderStyle(txtSoDienThoaiTimKiem);
        UtilityJTextField.addPlaceHolderStyle(txtMaKhachHang);
        UtilityJTextField.addPlaceHolderStyle(txtHoTen);
        UtilityJTextField.addPlaceHolderStyle(txtSoDienThoai);
        UtilityJTextField.addPlaceHolderStyle(txtDiaChi);
        
        tblTable.fixTable(scrTable);
    }
    
    private void updateTable(ArrayList<KhachHang> list){
        DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
        model.getDataVector().removeAllElements();
        tblTable.revalidate();
        tblTable.repaint();
        for(KhachHang thisKhachHang : list){
            model.addRow(new Object[]{
                thisKhachHang.getMaKhachHang(),
                thisKhachHang.getHoTen(),
                thisKhachHang.getSoDienThoai(),
                thisKhachHang.getDiaChi(),
                thisKhachHang.getNhomKhachHang()
            });
        }
    }
    
    private void timKiemTheoSoDienThoai(){
        String soDienThoai = txtSoDienThoaiTimKiem.getText();
        
        ArrayList<KhachHang> list = DAO_KhachHang.getAllKhachHang();
        ArrayList<KhachHang> listRemove = new ArrayList<>();
        
        if(!soDienThoai.equals("")){
            for(KhachHang thisKhachHang : list){
                if(!thisKhachHang.getSoDienThoai().equals(soDienThoai))
                    listRemove.add(thisKhachHang);
            }
        }
        
        list.removeAll(listRemove);
        updateTable(list);
    }
    
    private void capNhatKhachHang(){
        String maKhachHang = txtMaKhachHang.getText();
        if(maKhachHang.equals("Mã Khách Hàng")){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Khách Hàng để cập nhật.");
            return;
        }
        String error = "";
        
        KhachHang khachHangCapNhat = DAO_KhachHang.getKhachHangTheoMaKhachHang(maKhachHang);
        
        String hoTen = txtHoTen.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();
        
        if(hoTen.equals("Họ Tên")) //Kiểm tra rỗng
            error += "\n- Vui lòng nhập Họ Tên.";
        else
            if(!hoTen.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")) //Kiểm tra Biểu thức chính quy
                error += "\n- Vui lòng nhập Họ Tên hợp lệ.";
        
        if(soDienThoai.equals("Số Điện Thoại")) // Kiểm tra rỗng
            error += "\n- Vui lòng nhập Số Điện Thoại.";
        else
            if(!soDienThoai.matches("0{1}[0-9]{9}")) // Kiểm tra biểu thức chính quy
                error += "\n- Vui lòng nhập Số Điện Thoại hợp lệ.";
            else
                if(!khachHangCapNhat.getSoDienThoai().equals(soDienThoai))
                    if(DAO_KhachHang.getKhachHangTheoSoDienThoai(soDienThoai) != null) // Kiểm tra đã tồn tại
                        error += "\n- Số Điện Thoại đã tồn tại";
        
        if(diaChi.equals("Địa Chỉ") || diaChi.isBlank())
            error += "\n- Vui lòng nhập Địa Chỉ";
        
        if(error.equals("")){
            khachHangCapNhat.setHoTen(hoTen);
            khachHangCapNhat.setSoDienThoai(soDienThoai);
            khachHangCapNhat.setDiaChi(diaChi);
            if(DAO_KhachHang.updateKhachHang(khachHangCapNhat) == true){
                JOptionPane.showMessageDialog(null, "Cập Nhật Khách Hàng thành công.");
                GUI_Main.getInstance().showPanel(newInstance());
            }
            else{
                JOptionPane.showMessageDialog(null, "Cập Nhật Khách Hàng thất bại.");
            }
        }
        else{
            String throwMessage = "Lỗi nhập liệu: " + error;
            JOptionPane.showMessageDialog(null, throwMessage);
        }
    }
    
    private void hienThiThongTinKhachHang(){
        int i = tblTable.getSelectedRow();
        if(i < 0) return;
        String maKhachHangHienThi = tblTable.getValueAt(i, 0).toString();
        KhachHang khachHang = DAO_KhachHang.getKhachHangTheoMaKhachHang(maKhachHangHienThi);
        
        txtMaKhachHang.setText(khachHang.getMaKhachHang());
        txtHoTen.setText(khachHang.getHoTen());
        txtSoDienThoai.setText(khachHang.getSoDienThoai());
        txtDiaChi.setText(khachHang.getDiaChi());
        
        UtilityJTextField.addPlaceHolderStyle(txtMaKhachHang);
        UtilityJTextField.addPlaceHolderStyle(txtHoTen);
        UtilityJTextField.addPlaceHolderStyle(txtSoDienThoai);
        UtilityJTextField.addPlaceHolderStyle(txtDiaChi);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTimKiem = new javax.swing.JPanel();
        txtSoDienThoaiTimKiem = new extended_JComponent.JTextField_AllRound();
        btnTimKiem = new extended_JComponent.JButton_AllRound();
        btnLamMoi = new extended_JComponent.JButton_AllRound();
        txtMaKhachHang = new extended_JComponent.JTextField_AllRound();
        txtHoTen = new extended_JComponent.JTextField_AllRound();
        txtSoDienThoai = new extended_JComponent.JTextField_AllRound();
        txtDiaChi = new extended_JComponent.JTextField_AllRound();
        btnCapNhat = new extended_JComponent.JButton_AllRound();
        pnlTable = new javax.swing.JPanel();
        scrTable = new javax.swing.JScrollPane();
        tblTable = new extended_JComponent.JTable_LightMode();

        setLayout(new java.awt.BorderLayout());

        pnlTimKiem.setBackground(new java.awt.Color(68, 136, 255));
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiem.setPreferredSize(new java.awt.Dimension(300, 700));

        txtSoDienThoaiTimKiem.setText("Số Điện Thoại");
        txtSoDienThoaiTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiTimKiemFocusLost(evt);
            }
        });

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setBorderRadius(20);
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
        btnLamMoi.setBorderRadius(20);
        btnLamMoi.setColorBackground(new java.awt.Color(170, 238, 255));
        btnLamMoi.setColorBorder(new java.awt.Color(255, 255, 255));
        btnLamMoi.setColorClick(new java.awt.Color(119, 204, 255));
        btnLamMoi.setColorEnter(new java.awt.Color(119, 238, 255));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        txtMaKhachHang.setEditable(false);
        txtMaKhachHang.setBackground(new java.awt.Color(224, 224, 224));
        txtMaKhachHang.setText("Mã Khách Hàng");

        txtHoTen.setText("Họ Tên");
        txtHoTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoTenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoTenFocusLost(evt);
            }
        });

        txtSoDienThoai.setText("Số Điện Thoại");
        txtSoDienThoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusLost(evt);
            }
        });

        txtDiaChi.setText("Địa Chỉ");
        txtDiaChi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusLost(evt);
            }
        });

        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.setBorderRadius(20);
        btnCapNhat.setColorBackground(new java.awt.Color(170, 238, 255));
        btnCapNhat.setColorBorder(new java.awt.Color(255, 255, 255));
        btnCapNhat.setColorClick(new java.awt.Color(119, 204, 255));
        btnCapNhat.setColorEnter(new java.awt.Color(119, 238, 255));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoDienThoaiTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSoDienThoaiTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 276, Short.MAX_VALUE))
        );

        add(pnlTimKiem, java.awt.BorderLayout.EAST);

        pnlTable.setLayout(new java.awt.BorderLayout());

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Họ Tên", "Số Điện Thoại", "Địa Chỉ", "Nhóm Khách Hàng"
            }
        ));
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        scrTable.setViewportView(tblTable);
        if (tblTable.getColumnModel().getColumnCount() > 0) {
            tblTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblTable.getColumnModel().getColumn(3).setPreferredWidth(300);
        }

        pnlTable.add(scrTable, java.awt.BorderLayout.CENTER);

        add(pnlTable, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoDienThoaiTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiTimKiemFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtSoDienThoaiTimKiem, "Số Điện Thoại");
    }//GEN-LAST:event_txtSoDienThoaiTimKiemFocusGained

    private void txtSoDienThoaiTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiTimKiemFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtSoDienThoaiTimKiem, "Số Điện Thoại");
    }//GEN-LAST:event_txtSoDienThoaiTimKiemFocusLost

    private void txtHoTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtHoTen, "Họ Tên");
    }//GEN-LAST:event_txtHoTenFocusGained

    private void txtHoTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtHoTen, "Họ Tên");
    }//GEN-LAST:event_txtHoTenFocusLost

    private void txtSoDienThoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtSoDienThoai, "Số Điện Thoại");
    }//GEN-LAST:event_txtSoDienThoaiFocusGained

    private void txtSoDienThoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtSoDienThoai, "Số Điện Thoại");
    }//GEN-LAST:event_txtSoDienThoaiFocusLost

    private void txtDiaChiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtDiaChi, "Địa Chỉ");
    }//GEN-LAST:event_txtDiaChiFocusGained

    private void txtDiaChiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtDiaChi, "Địa Chỉ");
    }//GEN-LAST:event_txtDiaChiFocusLost

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        timKiemTheoSoDienThoai();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        GUI_Main.getInstance().showPanel(newInstance());
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        capNhatKhachHang();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked
        // TODO add your handling code here:
        hienThiThongTinKhachHang();
    }//GEN-LAST:event_tblTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnCapNhat;
    private extended_JComponent.JButton_AllRound btnLamMoi;
    private extended_JComponent.JButton_AllRound btnTimKiem;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JScrollPane scrTable;
    private extended_JComponent.JTable_LightMode tblTable;
    private extended_JComponent.JTextField_AllRound txtDiaChi;
    private extended_JComponent.JTextField_AllRound txtHoTen;
    private extended_JComponent.JTextField_AllRound txtMaKhachHang;
    private extended_JComponent.JTextField_AllRound txtSoDienThoai;
    private extended_JComponent.JTextField_AllRound txtSoDienThoaiTimKiem;
    // End of variables declaration//GEN-END:variables

}
