package gui;


import java.time.LocalDate;

public class GUI_ThongKeQuanAoDaBan extends javax.swing.JPanel {
    
    private static GUI_ThongKeQuanAoDaBan instance = new GUI_ThongKeQuanAoDaBan();
    
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    public static GUI_ThongKeQuanAoDaBan getInstance() {
        return instance;
    }
    
    public static GUI_ThongKeQuanAoDaBan newInstance() {
        instance = new GUI_ThongKeQuanAoDaBan();
        return instance;
    }
    
    public GUI_ThongKeQuanAoDaBan() {
        initComponents();
        tblQuanAo.fixTable(scrQuanAo);
        
    }
    
    private void updateTable(){
        
    }
    
    private void inBaoCaoThongKe(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHoaDon = new javax.swing.JPanel();
        scrQuanAo = new javax.swing.JScrollPane();
        tblQuanAo = new extended_component.JTable_LightMode();
        pnlThongKe = new javax.swing.JPanel();
        lblNgayBatDau = new javax.swing.JLabel();
        txtNgayBatDau = new extended_component.JTextField_AllRound();
        lblNgayKetThuc = new javax.swing.JLabel();
        txtNgayKetThuc = new extended_component.JTextField_AllRound();
        lblTongSoQuanAo = new javax.swing.JLabel();
        txtTongSoQuanAo = new extended_component.JTextField_AllRound();
        lblTongSoDoanhThu = new javax.swing.JLabel();
        txtTongSoDoanhThu = new extended_component.JTextField_AllRound();
        txtTongSoDoanhThuThuan = new extended_component.JTextField_AllRound();
        lblTongSoDoanhThuThuan = new javax.swing.JLabel();
        btnThongKe = new extended_component.JButton_AllRound();
        btnInBaoCao = new extended_component.JButton_AllRound();

        setBackground(new java.awt.Color(68, 136, 255));
        setLayout(new java.awt.BorderLayout());

        pnlHoaDon.setOpaque(false);
        pnlHoaDon.setPreferredSize(new java.awt.Dimension(600, 700));
        pnlHoaDon.setLayout(new java.awt.BorderLayout());

        scrQuanAo.setBackground(new java.awt.Color(68, 136, 255));
        scrQuanAo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Quần Áo Đã Bán", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        tblQuanAo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Quần Áo", "Tên Quần Áo", "Số Lượng Đã Bán", "Doanh Thu", "Doanh Thu Thuần"
            }
        ));
        scrQuanAo.setViewportView(tblQuanAo);

        pnlHoaDon.add(scrQuanAo, java.awt.BorderLayout.CENTER);

        add(pnlHoaDon, java.awt.BorderLayout.CENTER);

        pnlThongKe.setBackground(new java.awt.Color(68, 136, 255));
        pnlThongKe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thống Kê Quần Áo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlThongKe.setPreferredSize(new java.awt.Dimension(300, 700));

        lblNgayBatDau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgayBatDau.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayBatDau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNgayBatDau.setText("Ngày bắt đầu");

        txtNgayBatDau.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblNgayKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNgayKetThuc.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayKetThuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNgayKetThuc.setText("Ngày kết thúc");

        txtNgayKetThuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblTongSoQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongSoQuanAo.setForeground(new java.awt.Color(255, 255, 255));
        lblTongSoQuanAo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongSoQuanAo.setText("Tổng số quần áo đã bán");

        txtTongSoQuanAo.setEditable(false);
        txtTongSoQuanAo.setBackground(new java.awt.Color(224, 224, 224));
        txtTongSoQuanAo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblTongSoDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongSoDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lblTongSoDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongSoDoanhThu.setText("Tổng doanh thu");

        txtTongSoDoanhThu.setEditable(false);
        txtTongSoDoanhThu.setBackground(new java.awt.Color(224, 224, 224));
        txtTongSoDoanhThu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtTongSoDoanhThuThuan.setEditable(false);
        txtTongSoDoanhThuThuan.setBackground(new java.awt.Color(224, 224, 224));
        txtTongSoDoanhThuThuan.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblTongSoDoanhThuThuan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongSoDoanhThuThuan.setForeground(new java.awt.Color(255, 255, 255));
        lblTongSoDoanhThuThuan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongSoDoanhThuThuan.setText("Tổng doanh thu thuần");

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
            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtTongSoQuanAo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtTongSoDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(lblNgayBatDau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(lblTongSoQuanAo, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(lblTongSoDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnInBaoCao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTongSoDoanhThuThuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(txtTongSoDoanhThuThuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addComponent(lblNgayBatDau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNgayKetThuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongSoQuanAo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongSoQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongSoDoanhThu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongSoDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongSoDoanhThuThuan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongSoDoanhThuThuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlThongKe, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnInBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBaoCaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInBaoCaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_component.JButton_AllRound btnInBaoCao;
    private extended_component.JButton_AllRound btnThongKe;
    private javax.swing.JLabel lblNgayBatDau;
    private javax.swing.JLabel lblNgayKetThuc;
    private javax.swing.JLabel lblTongSoDoanhThu;
    private javax.swing.JLabel lblTongSoDoanhThuThuan;
    private javax.swing.JLabel lblTongSoQuanAo;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlThongKe;
    private javax.swing.JScrollPane scrQuanAo;
    private extended_component.JTable_LightMode tblQuanAo;
    private extended_component.JTextField_AllRound txtNgayBatDau;
    private extended_component.JTextField_AllRound txtNgayKetThuc;
    private extended_component.JTextField_AllRound txtTongSoDoanhThu;
    private extended_component.JTextField_AllRound txtTongSoDoanhThuThuan;
    private extended_component.JTextField_AllRound txtTongSoQuanAo;
    // End of variables declaration//GEN-END:variables

}
