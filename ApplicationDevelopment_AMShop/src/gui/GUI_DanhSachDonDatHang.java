package gui;

import dao.DAO_ChiTietDonDatHang;
import dao.DAO_ChiTietHoaDon;
import dao.DAO_CuaHang;
import dao.DAO_DonDatHang;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import data.FormatDouble;
import data.FormatLocalDateTime;
import data.KhoiTaoMa;
import data.InHoaDon;
import data.UtilityJTextField;
import entity.ChiTietDonDatHang;
import entity.ChiTietHoaDon;
import entity.CuaHang;
import entity.DonDatHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.QuanAo;
import java.awt.Color;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class GUI_DanhSachDonDatHang extends javax.swing.JPanel {
    
    private static GUI_DanhSachDonDatHang instance = new GUI_DanhSachDonDatHang();
    
    private ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();
    
    private ArrayList<ChiTietDonDatHang> listChiTietDonDatHang = new ArrayList<>();
    
    private double tongTien = 0;
    
    private DonDatHang donDatHangHienTai = null;

    public static GUI_DanhSachDonDatHang getInstance() {
        return instance;
    }
    
    public static GUI_DanhSachDonDatHang newInstance() {
        instance = new GUI_DanhSachDonDatHang();
        return instance;
    }

    public static void setInstance(GUI_DanhSachDonDatHang instance) {
        GUI_DanhSachDonDatHang.instance = instance;
    }

    public GUI_DanhSachDonDatHang() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
        updateTableDanhSachDonDatHang(DAO_DonDatHang.getAllDonDatHang());
        
        UtilityJTextField.addPlaceHolderStyle(txtSoDienThoaiTimKiem);
        UtilityJTextField.addPlaceHolderStyle(txtHoTen);
        UtilityJTextField.addPlaceHolderStyle(txtSoDienThoai);
        UtilityJTextField.addPlaceHolderStyle(txtDiaChi);

        txtTienDua.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTienThua();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTienThua();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTienThua();
            }
        });
        
    }
    
    private void lapHoaDon(){
        String error = "";
        
        if(donDatHangHienTai == null){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Đơn Đặt Hàng để thanh toán.");
            return;
        }
        
        String maHoaDon = KhoiTaoMa.generateMaHoaDon();
        
        String hoTen = txtHoTen.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();
        
        String tienKhachDuaString = txtTienDua.getText();
        double tienKhachDua = 0;
        
        if(tienKhachDuaString.equals(""))
            error += "\n- Vui lòng nhập Tiền Khách Đưa.";
        else{
            try{
                tienKhachDua = Double.parseDouble(tienKhachDuaString);
                if(tienKhachDua < tongTien){
                    error += "\n- Tiền Khách Đưa phải lớn hơn hoặc bằng Tổng Tiền.";
                }
            }
            catch(NumberFormatException e){
                error += "\n- Vui lòng nhập Tiền Khách Đưa hợp lệ.";
            }
        }
        
        if(!error.equals("")){
            String throwMessage = "Lỗi nhập liệu: " + error;
            JOptionPane.showMessageDialog(null, throwMessage);
            return;
        }
        
        int prompt = JOptionPane.showConfirmDialog(null, "Xác Nhận Thanh Toán Cho Đơn Đặt Hàng Này?", "Xác Nhận Thanh Toán", JOptionPane.YES_NO_OPTION);
        if(prompt == JOptionPane.NO_OPTION)
           return;
        
        KhachHang khachHang = DAO_KhachHang.getKhachHangTheoSoDienThoai(soDienThoai);
        if(khachHang == null){
            String maKhachHang = KhoiTaoMa.generateMaKhachHang();
            String nhomKhachHang = "Thường";
            khachHang = new KhachHang(maKhachHang, hoTen, soDienThoai, diaChi, nhomKhachHang);
            DAO_KhachHang.createKhachHang(khachHang);
        }

        CuaHang cuaHang = DAO_CuaHang.getCuaHang();
        NhanVien nhanVien = DAO_NhanVien.nhanVienHienTai;
        LocalDateTime thoiGianTao = LocalDateTime.now();
        

        HoaDon hoaDon = new HoaDon(maHoaDon, cuaHang, nhanVien, khachHang, thoiGianTao, tienKhachDua);

        boolean themHoaDon = DAO_HoaDon.createHoaDon(hoaDon);

        for(ChiTietDonDatHang thisChiTietDonDatHang : listChiTietDonDatHang){
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(
                    hoaDon, 
                    thisChiTietDonDatHang.getQuanAo(), 
                    thisChiTietDonDatHang.getSoLuong(), 
                    thisChiTietDonDatHang.getQuanAo().getDonGiaBan());
            listChiTietHoaDon.add(chiTietHoaDon);
            DAO_ChiTietHoaDon.createChiTietHoaDon(chiTietHoaDon);
        }
        
        if(themHoaDon){
            try {
                InHoaDon.createAMShopInvoice(maHoaDon);
                donDatHangHienTai.setTrangThaiThanhToan(true);
                DAO_DonDatHang.updateDonDatHang(donDatHangHienTai);
                JOptionPane.showMessageDialog(null, "Thanh Toán Thành Công.");
                GUI_Main.getInstance().showPanel(newInstance());
                
                GUI_Main.getInstance().showPanel(GUI_ChiTietHoaDon.newInstance());
                GUI_ChiTietHoaDon.getInstance().showThongTinHoaDon(maHoaDon);
                GUI_ChiTietHoaDon.getInstance().setPnlBefore(newInstance());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Gặp Lỗi Khi In Hóa Đơn.");
            }
        }
    }
    
    private void updateTienThua(){
        if(listChiTietDonDatHang.isEmpty()){
            txtTienThua.setText("Đơn hàng trống");
            txtTienThua.setForeground(Color.RED);
            return;
        }
        String tienDuaString = txtTienDua.getText();
        double tienDua;
        try{
            tienDua = Double.parseDouble(tienDuaString);
            double tienThua = tienDua - tongTien;
            txtTienThua.setText(FormatDouble.toMoney(tienThua));
            txtTienThua.setForeground(Color.BLACK);
        }
        catch(NumberFormatException e){
            txtTienThua.setText("Lỗi nhập tiền");
            txtTienThua.setForeground(Color.RED);
        }
    }
    
    private void updateTableDanhSachDonDatHang(ArrayList<DonDatHang> list){
        DefaultTableModel model = (DefaultTableModel) tblDonDatHang.getModel();
        model.getDataVector().removeAllElements();
        tblDonDatHang.revalidate();
        tblDonDatHang.repaint();
        for(DonDatHang thisDonDatHang : list){
            if(thisDonDatHang.isTrangThaiThanhToan() == false){
                ArrayList<ChiTietDonDatHang> listCTDDH = DAO_ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang(thisDonDatHang.getMaDonDatHang());
                double tongTienThanhPhan = 0;
                for(ChiTietDonDatHang thisChiTietDonDatHang : listCTDDH)
                    tongTienThanhPhan += thisChiTietDonDatHang.getSoLuong() * thisChiTietDonDatHang.getQuanAo().getDonGiaBan();
                model.addRow(new Object[]{
                    thisDonDatHang.getMaDonDatHang(),
                    thisDonDatHang.getNhanVien().getHoTen(),
                    thisDonDatHang.getKhachHang().getHoTen(),
                    thisDonDatHang.getKhachHang().getSoDienThoai(),
                    FormatLocalDateTime.toFormattedLocalDateTime(thisDonDatHang.getThoiGianTao()),
                    FormatDouble.toMoney(tongTienThanhPhan)
                });
            }
        }
    }
    
    private void updateTableChiTietDonHang(){
        int i = tblDonDatHang.getSelectedRow();
        if(i < 0) return;
        String maDonDatHang = tblDonDatHang.getValueAt(i, 0).toString();
        DonDatHang donDatHang = DAO_DonDatHang.getDonDatHangTheoMaDonDatHang(maDonDatHang);
        donDatHangHienTai = donDatHang;
        ArrayList<ChiTietDonDatHang> list = DAO_ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang(maDonDatHang);
        listChiTietDonDatHang = list;
        
        txtHoTen.setText(donDatHang.getKhachHang().getHoTen());
        txtSoDienThoai.setText(donDatHang.getKhachHang().getSoDienThoai());
        txtDiaChi.setText(donDatHang.getKhachHang().getDiaChi());
        
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.getDataVector().removeAllElements();
        tblDonHang.revalidate();
        tblDonHang.repaint();
        tongTien = 0;
        for(ChiTietDonDatHang thisChiTietDonDatHang : list){
            QuanAo quanAo = thisChiTietDonDatHang.getQuanAo();
            double giaThanhPhan = thisChiTietDonDatHang.getSoLuong() * quanAo.getDonGiaBan();
            tongTien += giaThanhPhan;
            model.addRow(new Object[]{
                quanAo.getMaQuanAo(),
                quanAo.getTenQuanAo(),
                thisChiTietDonDatHang.getSoLuong(),
                FormatDouble.toMoney(quanAo.getDonGiaBan()),
                FormatDouble.toMoney(giaThanhPhan)
            });
        }
        
        txtTongTien.setText(FormatDouble.toMoney(tongTien));
    }
    
    private void timKiemDonDatHang(){
        String soDienThoai = txtSoDienThoaiTimKiem.getText();
        if(soDienThoai.equals("Số Điện Thoại Khách Hàng")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Số Điện Thoại khách hàng.");
        }
        
        ArrayList<DonDatHang> list = DAO_DonDatHang.getAllDonDatHang();
        ArrayList<DonDatHang> listRemove = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            DonDatHang thisDonDatHang = list.get(i);
            String soDienThoaiKhachHang = thisDonDatHang.getKhachHang().getSoDienThoai();
            if(!soDienThoaiKhachHang.equals(soDienThoai))
                listRemove.add(thisDonDatHang);
        }
        list.removeAll(listRemove);
        updateTableDanhSachDonDatHang(list);
    }
    
    private void xoaDonDatHang(){
        int i = tblDonDatHang.getSelectedRow();
        if(i < 0){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Đơn đặt hàng.");
            return;
        }
        
        int prompt = JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Chắn Muốn Xóa Đơn Đặt Hàng Này?", "Xóa Đơn Đặt Hàng", JOptionPane.YES_NO_OPTION);
        if(prompt == JOptionPane.NO_OPTION)
            return;
        
        String maDonDatHang = tblDonDatHang.getValueAt(i, 0).toString();
        boolean xoaDonDatHang = DAO_DonDatHang.deleteDonDatHangTheoMaDonDatHang(maDonDatHang);
        if(xoaDonDatHang)
            JOptionPane.showMessageDialog(null, "Xóa Đơn Đặt Hàng Thành Công");
        
        updateTableDanhSachDonDatHang(DAO_DonDatHang.getAllDonDatHang());
        
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.getDataVector().removeAllElements();
        tblDonHang.revalidate();
        tblDonHang.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTimKiem = new javax.swing.JPanel();
        pnlHinhAnh = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        txtSoDienThoaiTimKiem = new extended_JComponent.JTextField_AllRound();
        btnTimKiem = new extended_JComponent.JButton_AllRound();
        btnXoaDonDatHang = new extended_JComponent.JButton_AllRound();
        btnLamMoi = new extended_JComponent.JButton_AllRound();
        pnlLapHoaDon = new javax.swing.JPanel();
        pnlDonDatHang = new javax.swing.JPanel();
        scrDonDatHang = new javax.swing.JScrollPane();
        tblDonDatHang = new extended_JComponent.JTable_LightMode();
        pnlHoaDon = new javax.swing.JPanel();
        pnlDonHang = new javax.swing.JPanel();
        scrDonHang = new javax.swing.JScrollPane();
        tblDonHang = new extended_JComponent.JTable_LightMode();
        pnlThongTinThanhToan = new javax.swing.JPanel();
        pnlKhachHang = new javax.swing.JPanel();
        txtSoDienThoai = new extended_JComponent.JTextField_AllRound();
        txtHoTen = new extended_JComponent.JTextField_AllRound();
        txtDiaChi = new extended_JComponent.JTextField_AllRound();
        pnlThanhToan = new javax.swing.JPanel();
        btnThanhToan = new extended_JComponent.JButton_AllRound();
        txtTongTien = new extended_JComponent.JTextField_AllRound();
        txtTienDua = new extended_JComponent.JTextField_AllRound();
        txtTienThua = new extended_JComponent.JTextField_AllRound();
        lblTienThua = new javax.swing.JLabel();
        lblTienDua = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        pnlTimKiem.setBackground(new java.awt.Color(68, 136, 255));
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiem.setPreferredSize(new java.awt.Dimension(250, 700));

        pnlHinhAnh.setBackground(new java.awt.Color(204, 204, 204));
        pnlHinhAnh.setPreferredSize(new java.awt.Dimension(196, 270));
        pnlHinhAnh.setLayout(new java.awt.GridBagLayout());

        lblHinhAnh.setText("IMG");
        pnlHinhAnh.add(lblHinhAnh, new java.awt.GridBagConstraints());

        txtSoDienThoaiTimKiem.setText("Số Điện Thoại Khách Hàng");
        txtSoDienThoaiTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiTimKiemFocusLost(evt);
            }
        });

        btnTimKiem.setText("Tìm Kiếm Đơn Đặt Hàng");
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

        btnXoaDonDatHang.setText("Xóa Đơn Đặt Hàng");
        btnXoaDonDatHang.setBorderRadius(20);
        btnXoaDonDatHang.setColorBackground(new java.awt.Color(255, 102, 102));
        btnXoaDonDatHang.setColorBorder(new java.awt.Color(255, 255, 255));
        btnXoaDonDatHang.setColorClick(new java.awt.Color(255, 0, 0));
        btnXoaDonDatHang.setColorEnter(new java.awt.Color(255, 34, 102));
        btnXoaDonDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDonDatHangActionPerformed(evt);
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

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSoDienThoaiTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(pnlHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnXoaDonDatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addComponent(txtSoDienThoaiTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189)
                .addComponent(btnXoaDonDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(pnlTimKiem, java.awt.BorderLayout.EAST);

        pnlLapHoaDon.setLayout(new java.awt.BorderLayout());

        pnlDonDatHang.setPreferredSize(new java.awt.Dimension(916, 300));
        pnlDonDatHang.setLayout(new java.awt.BorderLayout());

        tblDonDatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Đơn Đặt Hàng", "Tên Nhân Viên Lập Đơn", "Tên Khách Hàng", "Số Điện Thoại", "Thời Gian Lập Đơn", "Tổng Tiền"
            }
        ));
        tblDonDatHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonDatHangMouseClicked(evt);
            }
        });
        scrDonDatHang.setViewportView(tblDonDatHang);

        pnlDonDatHang.add(scrDonDatHang, java.awt.BorderLayout.CENTER);

        pnlLapHoaDon.add(pnlDonDatHang, java.awt.BorderLayout.NORTH);

        pnlHoaDon.setLayout(new java.awt.BorderLayout());

        pnlDonHang.setPreferredSize(new java.awt.Dimension(400, 400));
        pnlDonHang.setLayout(new java.awt.BorderLayout());

        tblDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Quần Áo", "Tên Quần Áo", "Số Lượng", "Đơn Giá", "Tổng Tiền"
            }
        ));
        scrDonHang.setViewportView(tblDonHang);

        pnlDonHang.add(scrDonHang, java.awt.BorderLayout.CENTER);

        pnlHoaDon.add(pnlDonHang, java.awt.BorderLayout.EAST);

        pnlThongTinThanhToan.setLayout(new java.awt.BorderLayout());

        pnlKhachHang.setBackground(new java.awt.Color(68, 136, 255));
        pnlKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlKhachHang.setPreferredSize(new java.awt.Dimension(516, 150));

        txtSoDienThoai.setEditable(false);
        txtSoDienThoai.setBackground(new java.awt.Color(224, 224, 224));
        txtSoDienThoai.setText("Số Điện Thoại");
        txtSoDienThoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusLost(evt);
            }
        });

        txtHoTen.setEditable(false);
        txtHoTen.setBackground(new java.awt.Color(224, 224, 224));
        txtHoTen.setText("Họ Tên");
        txtHoTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoTenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoTenFocusLost(evt);
            }
        });

        txtDiaChi.setEditable(false);
        txtDiaChi.setBackground(new java.awt.Color(224, 224, 224));
        txtDiaChi.setText("Địa Chỉ");
        txtDiaChi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlKhachHangLayout.createSequentialGroup()
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlThongTinThanhToan.add(pnlKhachHang, java.awt.BorderLayout.PAGE_START);

        pnlThanhToan.setBackground(new java.awt.Color(68, 136, 255));
        pnlThanhToan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thanh Toán", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.setBorderRadius(20);
        btnThanhToan.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThanhToan.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThanhToan.setColorClick(new java.awt.Color(119, 204, 255));
        btnThanhToan.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(224, 224, 224));

        txtTienThua.setEditable(false);
        txtTienThua.setBackground(new java.awt.Color(224, 224, 224));

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienThua.setText("Tiền Thừa");

        lblTienDua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTienDua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienDua.setText("Tiền Khách Đưa");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 255, 255));
        lblTongTien.setText("Tổng Tiền");

        javax.swing.GroupLayout pnlThanhToanLayout = new javax.swing.GroupLayout(pnlThanhToan);
        pnlThanhToan.setLayout(pnlThanhToanLayout);
        pnlThanhToanLayout.setHorizontalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addComponent(lblTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                .addComponent(txtTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlThanhToanLayout.setVerticalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTienDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );

        pnlThongTinThanhToan.add(pnlThanhToan, java.awt.BorderLayout.CENTER);

        pnlHoaDon.add(pnlThongTinThanhToan, java.awt.BorderLayout.CENTER);

        pnlLapHoaDon.add(pnlHoaDon, java.awt.BorderLayout.CENTER);

        add(pnlLapHoaDon, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoDienThoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtSoDienThoai, "Số Điện Thoại");
    }//GEN-LAST:event_txtSoDienThoaiFocusGained

    private void txtSoDienThoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtSoDienThoai, "Số Điện Thoại");
    }//GEN-LAST:event_txtSoDienThoaiFocusLost

    private void txtHoTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtHoTen, "Họ Tên");
    }//GEN-LAST:event_txtHoTenFocusGained

    private void txtHoTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtHoTen, "Họ Tên");
    }//GEN-LAST:event_txtHoTenFocusLost

    private void txtDiaChiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtDiaChi, "Địa Chỉ");
    }//GEN-LAST:event_txtDiaChiFocusGained

    private void txtDiaChiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtDiaChi, "Địa Chỉ");
    }//GEN-LAST:event_txtDiaChiFocusLost

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        lapHoaDon();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        timKiemDonDatHang();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaDonDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDonDatHangActionPerformed
        // TODO add your handling code here:
        xoaDonDatHang();
    }//GEN-LAST:event_btnXoaDonDatHangActionPerformed

    private void tblDonDatHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonDatHangMouseClicked
        // TODO add your handling code here:
        updateTableChiTietDonHang();
    }//GEN-LAST:event_tblDonDatHangMouseClicked

    private void txtSoDienThoaiTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiTimKiemFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtSoDienThoaiTimKiem, "Số Điện Thoại Khách Hàng");
    }//GEN-LAST:event_txtSoDienThoaiTimKiemFocusGained

    private void txtSoDienThoaiTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiTimKiemFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtSoDienThoaiTimKiem, "Số Điện Thoại Khách Hàng");
    }//GEN-LAST:event_txtSoDienThoaiTimKiemFocusLost

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        updateTableDanhSachDonDatHang(DAO_DonDatHang.getAllDonDatHang());
    }//GEN-LAST:event_btnLamMoiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnLamMoi;
    private extended_JComponent.JButton_AllRound btnThanhToan;
    private extended_JComponent.JButton_AllRound btnTimKiem;
    private extended_JComponent.JButton_AllRound btnXoaDonDatHang;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblTienDua;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlDonDatHang;
    private javax.swing.JPanel pnlDonHang;
    private javax.swing.JPanel pnlHinhAnh;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlLapHoaDon;
    private javax.swing.JPanel pnlThanhToan;
    private javax.swing.JPanel pnlThongTinThanhToan;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JScrollPane scrDonDatHang;
    private javax.swing.JScrollPane scrDonHang;
    private extended_JComponent.JTable_LightMode tblDonDatHang;
    private extended_JComponent.JTable_LightMode tblDonHang;
    private extended_JComponent.JTextField_AllRound txtDiaChi;
    private extended_JComponent.JTextField_AllRound txtHoTen;
    private extended_JComponent.JTextField_AllRound txtSoDienThoai;
    private extended_JComponent.JTextField_AllRound txtSoDienThoaiTimKiem;
    private extended_JComponent.JTextField_AllRound txtTienDua;
    private extended_JComponent.JTextField_AllRound txtTienThua;
    private extended_JComponent.JTextField_AllRound txtTongTien;
    // End of variables declaration//GEN-END:variables

}
