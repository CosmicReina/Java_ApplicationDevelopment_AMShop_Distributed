package gui_old;


import data.FormatLocalDate;
import data.FormatLocalTime;
import entity.LichLamViec;
import entity.NhanVien;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

public class GUI_LichLamViec extends javax.swing.JPanel {
    
    private static GUI_LichLamViec instance = new GUI_LichLamViec();

    public static GUI_LichLamViec getInstance() {
        return instance;
    }
    
    public static GUI_LichLamViec newInstance() {
        instance = new GUI_LichLamViec();
        return instance;
    }
    
    public GUI_LichLamViec() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
        
    }

    private void showTableListLichLamViec(ArrayList<LichLamViec> list){
        
    }    

    private void showTableListNhanVien(ArrayList<NhanVien> list){
        
    }    

    private void showTableListNhanVienTrongCa(String maLichLamViec){
        
    }    
    
    private void themLichLamViec(){
        
    }

    private void updateDanhSachNhanVien(){
        
    }
    
    private void themNhanVienVaoLich(){
        
    }
    
    private void xoaNhanVienKhoiLich(){
        
    }
    
    private void updateSauCapNhat(String maLichLamViec){
        
    }
    
    private void chamCongVaoCa(){
        
    }
    
    private void chamCongRaCa(){
        
    }
    
    private void timKiem(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLichLamViec = new javax.swing.JPanel();
        pnlDanhSachLichVaNhanVien = new javax.swing.JPanel();
        pnlDanhSachLichLamViec = new javax.swing.JPanel();
        scrDanhSachLichLamViec = new javax.swing.JScrollPane();
        tblDanhSachLichLamViec = new extended_component.JTable_LightMode();
        pnlDanhSachNhanVienTrongCa = new javax.swing.JPanel();
        scrDanhSachNhanVienTrongCa = new javax.swing.JScrollPane();
        tblDanhSachNhanVienTrongCa = new extended_component.JTable_LightMode();
        pnlCapNhatLichLamViec = new javax.swing.JPanel();
        pnlCapNhatCaLam = new javax.swing.JPanel();
        lblNgayLamViec = new javax.swing.JLabel();
        lblCaLamViec = new javax.swing.JLabel();
        cmbCaLamViec = new javax.swing.JComboBox<>();
        txtNgayLamViec = new extended_component.JTextField_AllRound();
        btnThem = new extended_component.JButton_AllRound();
        btnTimKiem = new extended_component.JButton_AllRound();
        btnLamMoi = new extended_component.JButton_AllRound();
        pnlDanhSachNhanVien = new javax.swing.JPanel();
        scrDanhSachNhanVien = new javax.swing.JScrollPane();
        tblDanhSachNhanVien = new extended_component.JTable_LightMode();
        pnlChamCong = new javax.swing.JPanel();
        pnlChamCongCaLam = new javax.swing.JPanel();
        btnChamCongVao = new extended_component.JButton_AllRound();
        btnChamCongRa = new extended_component.JButton_AllRound();
        pnlTimKiemNhanVien = new javax.swing.JPanel();
        btnThemNhanVien = new extended_component.JButton_AllRound();
        btnXoaNhanVien = new extended_component.JButton_AllRound();

        setLayout(new java.awt.BorderLayout());

        pnlLichLamViec.setPreferredSize(new java.awt.Dimension(900, 700));
        pnlLichLamViec.setLayout(new java.awt.BorderLayout());

        pnlDanhSachLichVaNhanVien.setPreferredSize(new java.awt.Dimension(900, 350));
        pnlDanhSachLichVaNhanVien.setLayout(new java.awt.BorderLayout());

        pnlDanhSachLichLamViec.setBackground(new java.awt.Color(79, 137, 255));
        pnlDanhSachLichLamViec.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Lịch Làm Việc", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDanhSachLichLamViec.setPreferredSize(new java.awt.Dimension(500, 350));
        pnlDanhSachLichLamViec.setLayout(new java.awt.BorderLayout());

        tblDanhSachLichLamViec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Lịch Làm", "Tên Ca Làm", "Ngày Làm Việc"
            }
        ));
        tblDanhSachLichLamViec.setRowHeight(20);
        tblDanhSachLichLamViec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachLichLamViecMouseClicked(evt);
            }
        });
        scrDanhSachLichLamViec.setViewportView(tblDanhSachLichLamViec);

        pnlDanhSachLichLamViec.add(scrDanhSachLichLamViec, java.awt.BorderLayout.CENTER);

        pnlDanhSachLichVaNhanVien.add(pnlDanhSachLichLamViec, java.awt.BorderLayout.WEST);

        pnlDanhSachNhanVienTrongCa.setBackground(new java.awt.Color(79, 137, 255));
        pnlDanhSachNhanVienTrongCa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Nhân Viên Trong Ca", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDanhSachNhanVienTrongCa.setPreferredSize(new java.awt.Dimension(400, 350));
        pnlDanhSachNhanVienTrongCa.setLayout(new java.awt.BorderLayout());

        tblDanhSachNhanVienTrongCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "T.Gian Vào Ca", "T.Gian Ra Ca"
            }
        ));
        scrDanhSachNhanVienTrongCa.setViewportView(tblDanhSachNhanVienTrongCa);

        pnlDanhSachNhanVienTrongCa.add(scrDanhSachNhanVienTrongCa, java.awt.BorderLayout.CENTER);

        pnlDanhSachLichVaNhanVien.add(pnlDanhSachNhanVienTrongCa, java.awt.BorderLayout.CENTER);

        pnlLichLamViec.add(pnlDanhSachLichVaNhanVien, java.awt.BorderLayout.NORTH);

        pnlCapNhatLichLamViec.setPreferredSize(new java.awt.Dimension(900, 350));
        pnlCapNhatLichLamViec.setLayout(new java.awt.BorderLayout());

        pnlCapNhatCaLam.setBackground(new java.awt.Color(79, 137, 255));
        pnlCapNhatCaLam.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thêm Lịch Làm Việc", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlCapNhatCaLam.setPreferredSize(new java.awt.Dimension(500, 350));

        lblNgayLamViec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgayLamViec.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayLamViec.setText("Ngày Làm Việc");

        lblCaLamViec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCaLamViec.setForeground(new java.awt.Color(255, 255, 255));
        lblCaLamViec.setText("Ca Làm Việc");

        cmbCaLamViec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCaLamViec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ca Làm Việc" }));

        txtNgayLamViec.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnThem.setText("Thêm Lịch");
        btnThem.setBorderRadius(30);
        btnThem.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThem.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThem.setColorClick(new java.awt.Color(119, 204, 255));
        btnThem.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
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

        javax.swing.GroupLayout pnlCapNhatCaLamLayout = new javax.swing.GroupLayout(pnlCapNhatCaLam);
        pnlCapNhatCaLam.setLayout(pnlCapNhatCaLamLayout);
        pnlCapNhatCaLamLayout.setHorizontalGroup(
            pnlCapNhatCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatCaLamLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlCapNhatCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCapNhatCaLamLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNgayLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(lblCaLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(pnlCapNhatCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbCaLamViec, 0, 200, Short.MAX_VALUE)
                            .addComponent(txtNgayLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        pnlCapNhatCaLamLayout.setVerticalGroup(
            pnlCapNhatCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatCaLamLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlCapNhatCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNgayLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCapNhatCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCaLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cmbCaLamViec, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlCapNhatLichLamViec.add(pnlCapNhatCaLam, java.awt.BorderLayout.WEST);

        pnlDanhSachNhanVien.setBackground(new java.awt.Color(79, 137, 255));
        pnlDanhSachNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Nhân Viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlDanhSachNhanVien.setPreferredSize(new java.awt.Dimension(400, 350));
        pnlDanhSachNhanVien.setLayout(new java.awt.BorderLayout());

        tblDanhSachNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên"
            }
        ));
        scrDanhSachNhanVien.setViewportView(tblDanhSachNhanVien);

        pnlDanhSachNhanVien.add(scrDanhSachNhanVien, java.awt.BorderLayout.CENTER);

        pnlCapNhatLichLamViec.add(pnlDanhSachNhanVien, java.awt.BorderLayout.CENTER);

        pnlLichLamViec.add(pnlCapNhatLichLamViec, java.awt.BorderLayout.CENTER);

        add(pnlLichLamViec, java.awt.BorderLayout.WEST);

        pnlChamCong.setLayout(new java.awt.BorderLayout());

        pnlChamCongCaLam.setBackground(new java.awt.Color(79, 137, 255));
        pnlChamCongCaLam.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chấm Công", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlChamCongCaLam.setPreferredSize(new java.awt.Dimension(266, 350));

        btnChamCongVao.setText("Chấm Công Vào Ca");
        btnChamCongVao.setBorderRadius(50);
        btnChamCongVao.setColorBackground(new java.awt.Color(170, 238, 255));
        btnChamCongVao.setColorBorder(new java.awt.Color(255, 255, 255));
        btnChamCongVao.setColorClick(new java.awt.Color(119, 204, 255));
        btnChamCongVao.setColorEnter(new java.awt.Color(119, 238, 255));
        btnChamCongVao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChamCongVao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamCongVaoActionPerformed(evt);
            }
        });

        btnChamCongRa.setText("Chấm Công Ra Ca");
        btnChamCongRa.setBorderRadius(50);
        btnChamCongRa.setColorBackground(new java.awt.Color(170, 238, 255));
        btnChamCongRa.setColorBorder(new java.awt.Color(255, 255, 255));
        btnChamCongRa.setColorClick(new java.awt.Color(119, 204, 255));
        btnChamCongRa.setColorEnter(new java.awt.Color(119, 238, 255));
        btnChamCongRa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChamCongRa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamCongRaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChamCongCaLamLayout = new javax.swing.GroupLayout(pnlChamCongCaLam);
        pnlChamCongCaLam.setLayout(pnlChamCongCaLamLayout);
        pnlChamCongCaLamLayout.setHorizontalGroup(
            pnlChamCongCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChamCongCaLamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChamCongCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChamCongVao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChamCongRa, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlChamCongCaLamLayout.setVerticalGroup(
            pnlChamCongCaLamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChamCongCaLamLayout.createSequentialGroup()
                .addComponent(btnChamCongVao, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnChamCongRa, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlChamCong.add(pnlChamCongCaLam, java.awt.BorderLayout.NORTH);

        pnlTimKiemNhanVien.setBackground(new java.awt.Color(79, 137, 255));
        pnlTimKiemNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chỉnh Sửa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiemNhanVien.setPreferredSize(new java.awt.Dimension(266, 350));

        btnThemNhanVien.setText("Thêm Nhân Viên Vào Ca");
        btnThemNhanVien.setBorderRadius(50);
        btnThemNhanVien.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThemNhanVien.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThemNhanVien.setColorClick(new java.awt.Color(119, 204, 255));
        btnThemNhanVien.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThemNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        btnXoaNhanVien.setText("Xóa Nhân Viên Khỏi Ca");
        btnXoaNhanVien.setBorderRadius(50);
        btnXoaNhanVien.setColorBackground(new java.awt.Color(170, 238, 255));
        btnXoaNhanVien.setColorBorder(new java.awt.Color(255, 255, 255));
        btnXoaNhanVien.setColorClick(new java.awt.Color(119, 204, 255));
        btnXoaNhanVien.setColorEnter(new java.awt.Color(119, 238, 255));
        btnXoaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKiemNhanVienLayout = new javax.swing.GroupLayout(pnlTimKiemNhanVien);
        pnlTimKiemNhanVien.setLayout(pnlTimKiemNhanVienLayout);
        pnlTimKiemNhanVienLayout.setHorizontalGroup(
            pnlTimKiemNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiemNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTimKiemNhanVienLayout.setVerticalGroup(
            pnlTimKiemNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemNhanVienLayout.createSequentialGroup()
                .addComponent(btnThemNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlChamCong.add(pnlTimKiemNhanVien, java.awt.BorderLayout.CENTER);

        add(pnlChamCong, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnChamCongVaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCongVaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChamCongVaoActionPerformed

    private void btnChamCongRaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCongRaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChamCongRaActionPerformed

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void btnXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaNhanVienActionPerformed

    private void tblDanhSachLichLamViecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachLichLamViecMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachLichLamViecMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLamMoiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_component.JButton_AllRound btnChamCongRa;
    private extended_component.JButton_AllRound btnChamCongVao;
    private extended_component.JButton_AllRound btnLamMoi;
    private extended_component.JButton_AllRound btnThem;
    private extended_component.JButton_AllRound btnThemNhanVien;
    private extended_component.JButton_AllRound btnTimKiem;
    private extended_component.JButton_AllRound btnXoaNhanVien;
    private javax.swing.JComboBox<String> cmbCaLamViec;
    private javax.swing.JLabel lblCaLamViec;
    private javax.swing.JLabel lblNgayLamViec;
    private javax.swing.JPanel pnlCapNhatCaLam;
    private javax.swing.JPanel pnlCapNhatLichLamViec;
    private javax.swing.JPanel pnlChamCong;
    private javax.swing.JPanel pnlChamCongCaLam;
    private javax.swing.JPanel pnlDanhSachLichLamViec;
    private javax.swing.JPanel pnlDanhSachLichVaNhanVien;
    private javax.swing.JPanel pnlDanhSachNhanVien;
    private javax.swing.JPanel pnlDanhSachNhanVienTrongCa;
    private javax.swing.JPanel pnlLichLamViec;
    private javax.swing.JPanel pnlTimKiemNhanVien;
    private javax.swing.JScrollPane scrDanhSachLichLamViec;
    private javax.swing.JScrollPane scrDanhSachNhanVien;
    private javax.swing.JScrollPane scrDanhSachNhanVienTrongCa;
    private extended_component.JTable_LightMode tblDanhSachLichLamViec;
    private extended_component.JTable_LightMode tblDanhSachNhanVien;
    private extended_component.JTable_LightMode tblDanhSachNhanVienTrongCa;
    private extended_component.JTextField_AllRound txtNgayLamViec;
    // End of variables declaration//GEN-END:variables

}
