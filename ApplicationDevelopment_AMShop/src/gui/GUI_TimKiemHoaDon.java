package gui;

import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import data.FormatDouble;
import data.FormatLocalDateTime;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_TimKiemHoaDon extends javax.swing.JPanel {
    
    private static GUI_TimKiemHoaDon instance = new GUI_TimKiemHoaDon();

    public static GUI_TimKiemHoaDon getInstance() {
        return instance;
    }
    
    public static GUI_TimKiemHoaDon newInstance() {
        instance = new GUI_TimKiemHoaDon();
        return instance;
    }
    
    public GUI_TimKiemHoaDon() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
        hienThiBang(DAO_HoaDon.getAllHoaDon());
        tblDanhSachHoaDon.fixTable(scrDanhSachHoaDon);
    }

    private void hienThiBang(ArrayList<HoaDon> list){
        DefaultTableModel model = (DefaultTableModel) tblDanhSachHoaDon.getModel();
        model.getDataVector().removeAllElements();
        tblDanhSachHoaDon.revalidate();
        tblDanhSachHoaDon.repaint();
        for(HoaDon thisHoaDon : list){
            ArrayList<ChiTietHoaDon> listCTHD = DAO_ChiTietHoaDon.getAllChiTietHoaDonTheoMaHoaDon(thisHoaDon.getMaHoaDon());
            double tongTienThanhPhan = 0;
            for(ChiTietHoaDon thisChiTietHoaDon : listCTHD){
                tongTienThanhPhan += thisChiTietHoaDon.getSoLuong() * thisChiTietHoaDon.getDonGia();
            }
            model.addRow(new Object[]{
                thisHoaDon.getMaHoaDon(),
                thisHoaDon.getNhanVien().getHoTen(),
                thisHoaDon.getKhachHang().getHoTen(),
                thisHoaDon.getKhachHang().getSoDienThoai(),
                FormatLocalDateTime.toFormattedLocalDateTime(thisHoaDon.getThoiGianTao()),
                FormatDouble.toMoney(tongTienThanhPhan)
            });
        }
    }

    private void timKiemHoaDon(){
        String maHoaDon = txtMaHoaDon.getText();
        String soDienThoai = txtSoDienThoai.getText();
        
        if(maHoaDon.equals("") && soDienThoai.equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm.");
        }
        
        ArrayList<HoaDon> list = DAO_HoaDon.getAllHoaDon();
        ArrayList<HoaDon> listRemove = new ArrayList<>();
        
        if(!maHoaDon.equals("")){
            for(int i = 0; i < list.size(); i++){
                HoaDon thisHoaDon = list.get(i);
                if(!thisHoaDon.getMaHoaDon().equals(maHoaDon))
                    listRemove.add(thisHoaDon);
            }
            list.removeAll(listRemove);
            hienThiBang(list);
            return;
        }
        
        if(!soDienThoai.equals("")){
            for(int i = 0; i < list.size(); i++){
                HoaDon thisHoaDon = list.get(i);
                if(!thisHoaDon.getKhachHang().getSoDienThoai().equals(soDienThoai))
                    listRemove.add(thisHoaDon);
            }
            list.removeAll(listRemove);
            hienThiBang(list);
        }
    }
    
    private void xemChiTietHoaDon(){
        int i = tblDanhSachHoaDon.getSelectedRow();
        if(i < 0){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Hóa Đơn");
            return;
        }
        String maHoaDon = tblDanhSachHoaDon.getValueAt(i, 0).toString();
        
        GUI_Main.getInstance().showPanel(GUI_ChiTietHoaDon.newInstance());
        GUI_ChiTietHoaDon.getInstance().showThongTinHoaDon(maHoaDon);
        GUI_ChiTietHoaDon.getInstance().setPnlBefore(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTimKiem = new javax.swing.JPanel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        txtMaHoaDon = new extended_JComponent.JTextField_AllRound();
        txtSoDienThoai = new extended_JComponent.JTextField_AllRound();
        btnTimKiem = new extended_JComponent.JButton_AllRound();
        btnLamMoi = new extended_JComponent.JButton_AllRound();
        btnXemChiTiet = new extended_JComponent.JButton_AllRound();
        scrDanhSachHoaDon = new javax.swing.JScrollPane();
        tblDanhSachHoaDon = new extended_JComponent.JTable_LightMode();

        setMinimumSize(new java.awt.Dimension(1166, 700));
        setPreferredSize(new java.awt.Dimension(1166, 700));
        setLayout(new java.awt.BorderLayout());

        pnlTimKiem.setBackground(new java.awt.Color(79, 137, 255));
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiem.setPreferredSize(new java.awt.Dimension(300, 700));

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHoaDon.setText("Mã Hóa Đơn");

        lblSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSoDienThoai.setForeground(new java.awt.Color(255, 255, 255));
        lblSoDienThoai.setText("Số Điện Thoại");

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
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXemChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(398, Short.MAX_VALUE))
        );

        add(pnlTimKiem, java.awt.BorderLayout.EAST);

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

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        timKiemHoaDon();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        GUI_Main.getInstance().showPanel(newInstance());
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
        xemChiTietHoaDon();
    }//GEN-LAST:event_btnXemChiTietActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnLamMoi;
    private extended_JComponent.JButton_AllRound btnTimKiem;
    private extended_JComponent.JButton_AllRound btnXemChiTiet;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JScrollPane scrDanhSachHoaDon;
    private extended_JComponent.JTable_LightMode tblDanhSachHoaDon;
    private extended_JComponent.JTextField_AllRound txtMaHoaDon;
    private extended_JComponent.JTextField_AllRound txtSoDienThoai;
    // End of variables declaration//GEN-END:variables

}
