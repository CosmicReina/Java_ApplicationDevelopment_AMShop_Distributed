package gui;

import dao.DAO_ChiTietHoaDon;
import dao.DAO_HoaDon;
import data.FormatDouble;
import data.FormatLocalDateTime;
import data.InHoaDon;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.QuanAo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jpedal.examples.viewer.Viewer;

public class GUI_ChiTietHoaDon extends javax.swing.JPanel {
    
    private static GUI_ChiTietHoaDon instance = new GUI_ChiTietHoaDon();
    
    private String maHoaDon;
    
    private JPanel pnlBefore = null;

    public void setPnlBefore(JPanel pnlBefore) {
        this.pnlBefore = pnlBefore;
    }

    public static GUI_ChiTietHoaDon getInstance() {
        return instance;
    }
    
    public static GUI_ChiTietHoaDon newInstance() {
        instance = new GUI_ChiTietHoaDon();
        return instance;
    }
    
    public GUI_ChiTietHoaDon() {
        initComponents();
        tblQuanAo.fixTable(scrQuanAo);
    }
    
    public void showThongTinHoaDon(String maHoaDon){
        this.maHoaDon = maHoaDon;
        HoaDon hoaDon = DAO_HoaDon.getHoaDonTheoMaHoaDon(maHoaDon);
        if(hoaDon == null) return;
        
        ArrayList<ChiTietHoaDon> list = DAO_ChiTietHoaDon.getAllChiTietHoaDonTheoMaHoaDon(maHoaDon);
        double tongTien = 0;
        
        DefaultTableModel model = (DefaultTableModel) tblQuanAo.getModel();
        for(ChiTietHoaDon thisChiTietHoaDon : list){
            double tongTienThanhPhan = thisChiTietHoaDon.getSoLuong() * thisChiTietHoaDon.getDonGia();
            tongTien += tongTienThanhPhan;
            QuanAo quanAo = thisChiTietHoaDon.getQuanAo();
            model.addRow(new Object[]{
                quanAo.getTenQuanAo(),
                thisChiTietHoaDon.getSoLuong(),
                FormatDouble.toMoney(thisChiTietHoaDon.getDonGia()),
                FormatDouble.toMoney(tongTienThanhPhan)
            });
        }
        
        txtMaHoaDon.setText(hoaDon.getMaHoaDon());
        txtNhanVienLapDon.setText(hoaDon.getNhanVien().getHoTen());
        txtKhachHang.setText(hoaDon.getKhachHang().getHoTen());
        txtThoiGianTao.setText(FormatLocalDateTime.toFormattedLocalDateTime(hoaDon.getThoiGianTao()));
        txtTongTien.setText(FormatDouble.toMoney(tongTien));
        txtTienKhachDua.setText(FormatDouble.toMoney(hoaDon.getTienKhachDua()));
        txtTienThua.setText(FormatDouble.toMoney(hoaDon.getTienKhachDua() - tongTien));
    }

    private void xemFileHoaDon(){
        try {
            InHoaDon.createTempAMShopInvoice(maHoaDon);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        String path = "files//hoaDon//temp.pdf";
        File file = new File(path);
        if(file.exists()) {
            Viewer viewer = new Viewer();
            viewer.setupViewer();
            viewer.getSwingGUI().getFrame().setSize(690, 768);
            viewer.getSwingGUI().getFrame().setLocation(512, 16);
            viewer.openDefaultFile(file.getAbsolutePath());
        }
        else
            JOptionPane.showMessageDialog(null, "File Hóa Đơn không tồn tại. Vui lòng kiểm tra lại.");
    }
    
    private void quayLai(){
        if(pnlBefore != null){GUI_Main.getInstance().showPanel(pnlBefore);}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThongTinHoaDon = new javax.swing.JPanel();
        lblMaHoaDon = new javax.swing.JLabel();
        lblNhanVienLapDon = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblThoiGianTao = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblTienKhachDua = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        txtMaHoaDon = new extended_JComponent.JTextField_AllRound();
        txtNhanVienLapDon = new extended_JComponent.JTextField_AllRound();
        txtKhachHang = new extended_JComponent.JTextField_AllRound();
        txtThoiGianTao = new extended_JComponent.JTextField_AllRound();
        txtTongTien = new extended_JComponent.JTextField_AllRound();
        txtTienKhachDua = new extended_JComponent.JTextField_AllRound();
        txtTienThua = new extended_JComponent.JTextField_AllRound();
        btnXemFileHoaDon = new extended_JComponent.JButton_AllRound();
        btnQuayLai = new extended_JComponent.JButton_AllRound();
        scrQuanAo = new javax.swing.JScrollPane();
        tblQuanAo = new extended_JComponent.JTable_LightMode();

        setBackground(new java.awt.Color(68, 136, 255));
        setMinimumSize(new java.awt.Dimension(1166, 700));
        setLayout(new java.awt.BorderLayout());

        pnlThongTinHoaDon.setBackground(new java.awt.Color(68, 136, 255));
        pnlThongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Hóa Đơn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlThongTinHoaDon.setPreferredSize(new java.awt.Dimension(350, 700));

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblMaHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        lblMaHoaDon.setText("Mã Hóa Đơn");

        lblNhanVienLapDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNhanVienLapDon.setForeground(new java.awt.Color(255, 255, 255));
        lblNhanVienLapDon.setText("Nhân Viên Lập Đơn");

        lblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setText("Khách Hàng");

        lblThoiGianTao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblThoiGianTao.setForeground(new java.awt.Color(255, 255, 255));
        lblThoiGianTao.setText("Thời Gian Tạo");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 255, 255));
        lblTongTien.setText("Tổng Tiền");

        lblTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTienKhachDua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienKhachDua.setText("Tiền Khách Đưa");

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienThua.setText("Tiền Thừa");

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.setBackground(new java.awt.Color(224, 224, 224));

        txtNhanVienLapDon.setEditable(false);
        txtNhanVienLapDon.setBackground(new java.awt.Color(224, 224, 224));

        txtKhachHang.setEditable(false);
        txtKhachHang.setBackground(new java.awt.Color(224, 224, 224));

        txtThoiGianTao.setEditable(false);
        txtThoiGianTao.setBackground(new java.awt.Color(224, 224, 224));

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(224, 224, 224));

        txtTienKhachDua.setEditable(false);
        txtTienKhachDua.setBackground(new java.awt.Color(224, 224, 224));

        txtTienThua.setEditable(false);
        txtTienThua.setBackground(new java.awt.Color(224, 224, 224));

        btnXemFileHoaDon.setText("Xem File Hóa Đơn");
        btnXemFileHoaDon.setBorderRadius(30);
        btnXemFileHoaDon.setColorBackground(new java.awt.Color(170, 238, 255));
        btnXemFileHoaDon.setColorBorder(new java.awt.Color(255, 255, 255));
        btnXemFileHoaDon.setColorClick(new java.awt.Color(119, 204, 255));
        btnXemFileHoaDon.setColorEnter(new java.awt.Color(119, 238, 255));
        btnXemFileHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemFileHoaDonActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay Về");
        btnQuayLai.setBorderRadius(30);
        btnQuayLai.setColorBackground(new java.awt.Color(255, 255, 204));
        btnQuayLai.setColorBorder(new java.awt.Color(255, 255, 255));
        btnQuayLai.setColorClick(new java.awt.Color(255, 255, 0));
        btnQuayLai.setColorEnter(new java.awt.Color(255, 255, 153));
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinHoaDonLayout = new javax.swing.GroupLayout(pnlThongTinHoaDon);
        pnlThongTinHoaDon.setLayout(pnlThongTinHoaDonLayout);
        pnlThongTinHoaDonLayout.setHorizontalGroup(
            pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblThoiGianTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNhanVienLapDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addComponent(lblTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNhanVienLapDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtThoiGianTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnXemFileHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlThongTinHoaDonLayout.setVerticalGroup(
            pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinHoaDonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNhanVienLapDon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhanVienLapDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblThoiGianTao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiGianTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(btnXemFileHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlThongTinHoaDon, java.awt.BorderLayout.WEST);

        scrQuanAo.setBackground(new java.awt.Color(68, 136, 255));
        scrQuanAo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Quần Áo Trong Đơn Hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        tblQuanAo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Quần Áo", "Số Lượng", "Đơn Giá", "Tổng Tiền"
            }
        ));
        scrQuanAo.setViewportView(tblQuanAo);
        if (tblQuanAo.getColumnModel().getColumnCount() > 0) {
            tblQuanAo.getColumnModel().getColumn(0).setPreferredWidth(300);
        }

        add(scrQuanAo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXemFileHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemFileHoaDonActionPerformed
        // TODO add your handling code here:
        xemFileHoaDon();
    }//GEN-LAST:event_btnXemFileHoaDonActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        quayLai();
    }//GEN-LAST:event_btnQuayLaiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnQuayLai;
    private extended_JComponent.JButton_AllRound btnXemFileHoaDon;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblNhanVienLapDon;
    private javax.swing.JLabel lblThoiGianTao;
    private javax.swing.JLabel lblTienKhachDua;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlThongTinHoaDon;
    private javax.swing.JScrollPane scrQuanAo;
    private extended_JComponent.JTable_LightMode tblQuanAo;
    private extended_JComponent.JTextField_AllRound txtKhachHang;
    private extended_JComponent.JTextField_AllRound txtMaHoaDon;
    private extended_JComponent.JTextField_AllRound txtNhanVienLapDon;
    private extended_JComponent.JTextField_AllRound txtThoiGianTao;
    private extended_JComponent.JTextField_AllRound txtTienKhachDua;
    private extended_JComponent.JTextField_AllRound txtTienThua;
    private extended_JComponent.JTextField_AllRound txtTongTien;
    // End of variables declaration//GEN-END:variables

}
