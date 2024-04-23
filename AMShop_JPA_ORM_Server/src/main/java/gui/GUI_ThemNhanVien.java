package gui;

import java.util.ArrayList;

import entity.NhanVien;

public class GUI_ThemNhanVien extends javax.swing.JPanel {
    
    private static GUI_ThemNhanVien instance = new GUI_ThemNhanVien();

    public static GUI_ThemNhanVien getInstance() {
        return instance;
    }
    
    public static GUI_ThemNhanVien newInstance() {
        instance = new GUI_ThemNhanVien();
        return instance;
    }

    public GUI_ThemNhanVien() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
    }
    
    private void updateTable(ArrayList<NhanVien> list){
    }
    
    private void themNhanVien(){
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTable = new javax.swing.JPanel();
        scrTable = new javax.swing.JScrollPane();
        tblTable = new extended_component.JTable_LightMode();
        pnlCenter = new javax.swing.JPanel();
        pnlDangNhap = new javax.swing.JPanel();
        lblTenDangNhap = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        txtTenDangNhap = new extended_component.JTextField_AllRound();
        txtMauKhau = new extended_component.JPasswordField_AllRound();
        pnlNhanVien = new javax.swing.JPanel();
        txtMaNhanVien = new extended_component.JTextField_AllRound();
        txtHoTen = new extended_component.JTextField_AllRound();
        txtCCCD = new extended_component.JTextField_AllRound();
        txtSoDienThoai = new extended_component.JTextField_AllRound();
        txtNgaySinh = new extended_component.JTextField_AllRound();
        txtLuong = new extended_component.JTextField_AllRound();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        cmbChucVu = new javax.swing.JComboBox<>();
        txtDiaChi = new extended_component.JTextField_AllRound();
        btnThem = new extended_component.JButton_AllRound();
        btnLamMoi = new extended_component.JButton_AllRound();

        setLayout(new java.awt.BorderLayout());

        pnlTable.setPreferredSize(new java.awt.Dimension(1066, 350));
        pnlTable.setLayout(new java.awt.BorderLayout());

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Căn Cước Công Dân", "Số Điện Thoại", "Ngày Sinh", "Giới Tính", "Chức Vụ"
            }
        ));
        scrTable.setViewportView(tblTable);
        if (tblTable.getColumnModel().getColumnCount() > 0) {
            tblTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        pnlTable.add(scrTable, java.awt.BorderLayout.CENTER);

        add(pnlTable, java.awt.BorderLayout.NORTH);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlDangNhap.setBackground(new java.awt.Color(68, 136, 255));
        pnlDangNhap.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Đăng Nhập", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDangNhap.setPreferredSize(new java.awt.Dimension(400, 350));

        lblTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lblTenDangNhap.setText("Tên Đăng Nhập");

        lblMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblMatKhau.setText("Mật Khẩu");

        txtTenDangNhap.setEditable(false);
        txtTenDangNhap.setBackground(new java.awt.Color(224, 224, 224));

        javax.swing.GroupLayout pnlDangNhapLayout = new javax.swing.GroupLayout(pnlDangNhap);
        pnlDangNhap.setLayout(pnlDangNhapLayout);
        pnlDangNhapLayout.setHorizontalGroup(
            pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangNhapLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMauKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnlDangNhapLayout.setVerticalGroup(
            pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangNhapLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMauKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        pnlCenter.add(pnlDangNhap, java.awt.BorderLayout.WEST);

        pnlNhanVien.setBackground(new java.awt.Color(68, 136, 255));
        pnlNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Nhân Viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaNhanVien.setEditable(false);
        txtMaNhanVien.setBackground(new java.awt.Color(224, 224, 224));

        txtHoTen.setText("Họ Tên");
        txtHoTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoTenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoTenFocusLost(evt);
            }
        });

        txtCCCD.setText("Căn Cước Công Dân");
        txtCCCD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCCCDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCCCDFocusLost(evt);
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

        txtNgaySinh.setText("Ngày Sinh (DD/MM/YYYY)");
        txtNgaySinh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNgaySinhFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNgaySinhFocusLost(evt);
            }
        });

        txtLuong.setText("Mức Lương / Giờ");
        txtLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLuongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLuongFocusLost(evt);
            }
        });

        cmbGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giới Tính", "Nam", "Nữ" }));

        cmbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chức Vụ" }));

        txtDiaChi.setText("Địa Chỉ");
        txtDiaChi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusLost(evt);
            }
        });

        btnThem.setText("Thêm Nhân Viên");
        btnThem.setBorderRadius(20);
        btnThem.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThem.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThem.setColorClick(new java.awt.Color(119, 204, 255));
        btnThem.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(cmbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pnlCenter.add(pnlNhanVien, java.awt.BorderLayout.CENTER);

        add(pnlCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenFocusGained

    private void txtHoTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenFocusLost

    private void txtCCCDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCCCDFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDFocusGained

    private void txtCCCDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCCCDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDFocusLost

    private void txtSoDienThoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiFocusGained

    private void txtSoDienThoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiFocusLost

    private void txtNgaySinhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgaySinhFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhFocusGained

    private void txtNgaySinhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgaySinhFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhFocusLost

    private void txtLuongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLuongFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongFocusGained

    private void txtLuongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLuongFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLuongFocusLost

    private void txtDiaChiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiFocusGained

    private void txtDiaChiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiFocusLost

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_component.JButton_AllRound btnLamMoi;
    private extended_component.JButton_AllRound btnThem;
    private javax.swing.JComboBox<String> cmbChucVu;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblTenDangNhap;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlDangNhap;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JScrollPane scrTable;
    private extended_component.JTable_LightMode tblTable;
    private extended_component.JTextField_AllRound txtCCCD;
    private extended_component.JTextField_AllRound txtDiaChi;
    private extended_component.JTextField_AllRound txtHoTen;
    private extended_component.JTextField_AllRound txtLuong;
    private extended_component.JTextField_AllRound txtMaNhanVien;
    private extended_component.JPasswordField_AllRound txtMauKhau;
    private extended_component.JTextField_AllRound txtNgaySinh;
    private extended_component.JTextField_AllRound txtSoDienThoai;
    private extended_component.JTextField_AllRound txtTenDangNhap;
    // End of variables declaration//GEN-END:variables

}
