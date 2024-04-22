package gui;

import connect.ConnectDB;
import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;
import javax.swing.JOptionPane;

public class GUI_DangNhap extends javax.swing.JFrame {
    
    private static GUI_DangNhap instance = new GUI_DangNhap();

    public static GUI_DangNhap getInstance() {
        return instance;
    }
    
    public static GUI_DangNhap newInstance() {
        instance = new GUI_DangNhap();
        return instance;
    }

    public GUI_DangNhap() {
        initComponents();
    }
    
    private void kiemTraDangNhap(){
        String tenDangNhap = txtTenDangNhap.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        if(tenDangNhap.isEmpty() || matKhau.isEmpty()){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin đăng nhập.");
            return;
        }
        boolean kiemTraDangNhap = DAO_TaiKhoan.kiemTraDangNhap(tenDangNhap, matKhau);
        if(!kiemTraDangNhap){
            JOptionPane.showMessageDialog(null, "Đăng nhập không thành công. Vui lòng kiểm tra lại thông tin tài khoản.");
            return;
        }
        JOptionPane.showMessageDialog(null, "Đăng nhập thành công.");
        DAO_NhanVien.nhanVienHienTai = DAO_NhanVien.getNhanVienTheoMaNhanVien(tenDangNhap);
        GUI_MainFrame.newInstance().setVisible(true);
        dispose();
    }
    
    private void moTraCuuChoKhachHang(){
        GUI_MainFrame.newInstance().setVisible(true);
        GUI_Main.getInstance().tatHetChucNang();
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDangNhap = new javax.swing.JPanel();
        lblDangNhap = new javax.swing.JLabel();
        lblTenDangNhap = new javax.swing.JLabel();
        lblMatKhau = new javax.swing.JLabel();
        txtTenDangNhap = new extended_JComponent.JTextField_AllRound();
        txtMatKhau = new extended_JComponent.JPasswordField_AllRound();
        btnDangNhap = new extended_JComponent.JButton_AllRound();
        btnThoat = new extended_JComponent.JButton_AllRound();
        btnTraCuuChoKhachHang = new extended_JComponent.JButton_AllRound();
        lblVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlDangNhap.setBackground(new java.awt.Color(102, 102, 102));
        pnlDangNhap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        lblDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lblDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDangNhap.setText("Đăng Nhập");

        lblTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lblTenDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenDangNhap.setText("Tên đăng nhập");

        lblMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMatKhau.setText("Mật khẩu");

        txtTenDangNhap.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtMatKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setBorderRadius(25);
        btnDangNhap.setColorBackground(new java.awt.Color(170, 238, 255));
        btnDangNhap.setColorBorder(new java.awt.Color(255, 255, 255));
        btnDangNhap.setColorClick(new java.awt.Color(119, 204, 255));
        btnDangNhap.setColorEnter(new java.awt.Color(119, 238, 255));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.setBorderRadius(25);
        btnThoat.setColorBackground(new java.awt.Color(255, 102, 102));
        btnThoat.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThoat.setColorClick(new java.awt.Color(255, 0, 0));
        btnThoat.setColorEnter(new java.awt.Color(255, 34, 102));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnTraCuuChoKhachHang.setText("Tra cứu dành cho khách hàng");
        btnTraCuuChoKhachHang.setBorderRadius(25);
        btnTraCuuChoKhachHang.setColorBackground(new java.awt.Color(255, 255, 204));
        btnTraCuuChoKhachHang.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTraCuuChoKhachHang.setColorClick(new java.awt.Color(255, 255, 0));
        btnTraCuuChoKhachHang.setColorEnter(new java.awt.Color(255, 255, 153));
        btnTraCuuChoKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuChoKhachHangActionPerformed(evt);
            }
        });

        lblVersion.setForeground(new java.awt.Color(255, 255, 255));
        lblVersion.setText("Version 1.0");

        javax.swing.GroupLayout pnlDangNhapLayout = new javax.swing.GroupLayout(pnlDangNhap);
        pnlDangNhap.setLayout(pnlDangNhapLayout);
        pnlDangNhapLayout.setHorizontalGroup(
            pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDangNhapLayout.createSequentialGroup()
                .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDangNhapLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDangNhapLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVersion))
                    .addGroup(pnlDangNhapLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 129, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDangNhapLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTraCuuChoKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDangNhapLayout.createSequentialGroup()
                        .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
        );
        pnlDangNhapLayout.setVerticalGroup(
            pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDangNhapLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(lblDangNhap)
                .addGap(70, 70, 70)
                .addComponent(lblTenDangNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblMatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(pnlDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnTraCuuChoKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(lblVersion)
                .addContainerGap())
        );

        getContentPane().add(pnlDangNhap, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        kiemTraDangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        ConnectDB.getInstance().disconnectDatabase();
        dispose();
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTraCuuChoKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuChoKhachHangActionPerformed
        // TODO add your handling code here:
        moTraCuuChoKhachHang();
    }//GEN-LAST:event_btnTraCuuChoKhachHangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnDangNhap;
    private extended_JComponent.JButton_AllRound btnThoat;
    private extended_JComponent.JButton_AllRound btnTraCuuChoKhachHang;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JLabel lblMatKhau;
    private javax.swing.JLabel lblTenDangNhap;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel pnlDangNhap;
    private extended_JComponent.JPasswordField_AllRound txtMatKhau;
    private extended_JComponent.JTextField_AllRound txtTenDangNhap;
    // End of variables declaration//GEN-END:variables

}
