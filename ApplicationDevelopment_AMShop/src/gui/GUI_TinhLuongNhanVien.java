package gui;

import dao.DAO_NhanVien;
import data.FormatDouble;
import entity.NhanVien;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.Duration;

public class GUI_TinhLuongNhanVien extends javax.swing.JPanel {
    
    private static GUI_TinhLuongNhanVien instance = new GUI_TinhLuongNhanVien();
    
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    public static GUI_TinhLuongNhanVien getInstance() {
        return instance;
    }
    
    public static GUI_TinhLuongNhanVien newInstance() {
        instance = new GUI_TinhLuongNhanVien();
        return instance;
    }
    
    public GUI_TinhLuongNhanVien() {
        initComponents();
        tblLuong.fixTable(scrLuong);
        
    }
    
    private void tinhLuongNhanVien(){
        int nam;
        int thang;
        try{
            nam = Integer.parseInt(txtNam.getText());
            thang = Integer.parseInt(txtThang.getText());
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Năm và Tháng hợp lệ");
            return;
        }
        ResultSet rs = DAO_NhanVien.tinhLuongNhanVien(nam, thang);
        try {
            DefaultTableModel model = (DefaultTableModel) tblLuong.getModel();
            model.getDataVector().removeAllElements();
            tblLuong.revalidate();
            tblLuong.repaint();
            while(rs.next()){
                String maNhanVien = rs.getString(1);
                NhanVien nhanVien = DAO_NhanVien.getNhanVienTheoMaNhanVien(maNhanVien);
                
                int thoiGianLam = rs.getInt(2);
                Duration duration = Duration.ofSeconds(thoiGianLam);
                long gio = duration.toHours();
                long phut = duration.toMinutesPart();
                long giay = duration.toSecondsPart();
                
                double thoiGianLamViec = gio + phut/60 + giay/3600;
                
                model.addRow(new Object[]{
                    maNhanVien,
                    nhanVien.getHoTen(),
                    nhanVien.getChucVu(),
                    nhanVien.getLuong(),
                    thoiGianLamViec,
                    FormatDouble.toMoney(nhanVien.getLuong() * thoiGianLamViec)
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        if(tblLuong.getModel().getRowCount() == 0)
            JOptionPane.showMessageDialog(null, "Không có dữ liệu");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHoaDon = new javax.swing.JPanel();
        scrLuong = new javax.swing.JScrollPane();
        tblLuong = new extended_JComponent.JTable_LightMode();
        pnlThongKe = new javax.swing.JPanel();
        lblNam = new javax.swing.JLabel();
        lblThang = new javax.swing.JLabel();
        txtNam = new extended_JComponent.JTextField_AllRound();
        txtThang = new extended_JComponent.JTextField_AllRound();
        btnTinhLuong = new extended_JComponent.JButton_AllRound();

        setBackground(new java.awt.Color(68, 136, 255));
        setLayout(new java.awt.BorderLayout());

        pnlHoaDon.setOpaque(false);
        pnlHoaDon.setPreferredSize(new java.awt.Dimension(600, 700));
        pnlHoaDon.setLayout(new java.awt.BorderLayout());

        scrLuong.setBackground(new java.awt.Color(68, 136, 255));
        scrLuong.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lương Nhân Viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        tblLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ", "Mức Lương", "Tổng Giờ Làm", "Lương Tháng"
            }
        ));
        scrLuong.setViewportView(tblLuong);

        pnlHoaDon.add(scrLuong, java.awt.BorderLayout.CENTER);

        add(pnlHoaDon, java.awt.BorderLayout.CENTER);

        pnlThongKe.setBackground(new java.awt.Color(68, 136, 255));
        pnlThongKe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tính Lương Tháng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlThongKe.setPreferredSize(new java.awt.Dimension(300, 100));

        lblNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNam.setForeground(new java.awt.Color(255, 255, 255));
        lblNam.setText("Năm");

        lblThang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblThang.setForeground(new java.awt.Color(255, 255, 255));
        lblThang.setText("Tháng");

        txtNam.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtThang.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnTinhLuong.setText("Tính Lương");
        btnTinhLuong.setBorderRadius(30);
        btnTinhLuong.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTinhLuong.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTinhLuong.setColorClick(new java.awt.Color(119, 204, 255));
        btnTinhLuong.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(btnTinhLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnTinhLuong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblThang)
                        .addComponent(lblNam)
                        .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        add(pnlThongKe, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhLuongActionPerformed
        // TODO add your handling code here:
        tinhLuongNhanVien();
    }//GEN-LAST:event_btnTinhLuongActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnTinhLuong;
    private javax.swing.JLabel lblNam;
    private javax.swing.JLabel lblThang;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JScrollPane scrLuong;
    private extended_JComponent.JTable_LightMode tblLuong;
    private extended_JComponent.JTextField_AllRound txtNam;
    private extended_JComponent.JTextField_AllRound txtThang;
    // End of variables declaration//GEN-END:variables

}
