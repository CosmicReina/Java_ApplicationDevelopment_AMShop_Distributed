package gui;

import dao.DAO_ChatLieu;
import dao.DAO_ChiTietDonDatHang;
import dao.DAO_ChiTietHoaDon;
import dao.DAO_CuaHang;
import dao.DAO_DanhMuc;
import dao.DAO_DonDatHang;
import dao.DAO_GioiTinh;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_KichThuoc;
import dao.DAO_MauSac;
import dao.DAO_NhaSanXuat;
import dao.DAO_NhanVien;
import dao.DAO_QuanAo;
import data.FormatDouble;
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

public class GUI_LapHoaDon extends javax.swing.JPanel {
    
    private static GUI_LapHoaDon instance = new GUI_LapHoaDon();
    
    private final ArrayList<ChiTietHoaDon> listDonHang = new ArrayList<>();
    private double tongTien = 0;
    
    public static GUI_LapHoaDon getInstance() {
        return instance;
    }
    
    public static GUI_LapHoaDon newInstance() {
        instance = new GUI_LapHoaDon();
        return instance;
    }

    public static void setInstance(GUI_LapHoaDon instance) {
        GUI_LapHoaDon.instance = instance;
    }

    public GUI_LapHoaDon() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
        capNhatTblQuanAo(DAO_QuanAo.getAllQuanAo());
        
        UtilityJTextField.addPlaceHolderStyle(txtMaQuanAo);
        UtilityJTextField.addPlaceHolderStyle(txtTenQuanAo);
        UtilityJTextField.addPlaceHolderStyle(txtSoLuong);
        UtilityJTextField.addPlaceHolderStyle(txtHoTen);
        UtilityJTextField.addPlaceHolderStyle(txtSoDienThoai);
        UtilityJTextField.addPlaceHolderStyle(txtDiaChi);
        
        ArrayList<String> listNhaSanXuat = DAO_NhaSanXuat.getAllNhaSanXuat();
        ArrayList<String> listDanhMuc = DAO_DanhMuc.getAllDanhMuc();
        ArrayList<String> listGioiTinh = DAO_GioiTinh.getAllGioiTinh();
        ArrayList<String> listMauSac = DAO_MauSac.getAllMauSac();
        ArrayList<String> listKichThuoc = DAO_KichThuoc.getAllKichThuoc();
        ArrayList<String> listChatLieu = DAO_ChatLieu.getAllChatLieu();
        
        for(String thisNhaSanXuat : listNhaSanXuat) cmbNhaSanXuat.addItem(thisNhaSanXuat);
        for(String thisDanhMuc : listDanhMuc) cmbDanhMuc.addItem(thisDanhMuc);
        for(String thisGioiTinh : listGioiTinh) cmbGioiTinh.addItem(thisGioiTinh);
        for(String thisMauSac : listMauSac) cmbMauSac.addItem(thisMauSac);
        for(String thisKichThuoc : listKichThuoc) cmbKichThuoc.addItem(thisKichThuoc);
        for(String thisChatLieu : listChatLieu) cmbChatLieu.addItem(thisChatLieu);
        
        tblQuanAo.fixTable(scrQuanAo);
        tblDonHang.fixTable(scrDonHang);
        scrQuanAo.getVerticalScrollBar().setUnitIncrement(40);
        
        txtTienDua.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {capNhatTienThua();}

            @Override
            public void removeUpdate(DocumentEvent e) {capNhatTienThua();}

            @Override
            public void changedUpdate(DocumentEvent e) {capNhatTienThua();}
        });
    }
    
    private void capNhatTblQuanAo(ArrayList<QuanAo> list){
        DefaultTableModel model = (DefaultTableModel) tblQuanAo.getModel();
        model.getDataVector().removeAllElements();
        tblQuanAo.revalidate();
        tblQuanAo.repaint();
        for(QuanAo thisQuanAo : list){
            model.addRow(new Object[]{
                thisQuanAo.getMaQuanAo(),
                thisQuanAo.getTenQuanAo(),
                FormatDouble.toMoney(thisQuanAo.getDonGiaBan()),
                thisQuanAo.getSoLuongTrongKho(),
                thisQuanAo.getNhaSanXuat(),
                thisQuanAo.getDanhMuc(),
                thisQuanAo.getGioiTinh(),
                thisQuanAo.getMauSac(),
                thisQuanAo.getKichThuoc(),
                thisQuanAo.getChatLieu()
            });
        }
    }
    
    private void capNhatTblDonHang(ArrayList<ChiTietHoaDon> list){
        tongTien = 0;
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.getDataVector().removeAllElements();
        tblDonHang.revalidate();
        tblDonHang.repaint();
        for(ChiTietHoaDon thisChiTietHoaDon : list){
            tongTien += thisChiTietHoaDon.getSoLuong() * thisChiTietHoaDon.getDonGia();
            model.addRow(new Object[]{
                thisChiTietHoaDon.getQuanAo().getMaQuanAo(),
                thisChiTietHoaDon.getQuanAo().getTenQuanAo(),
                thisChiTietHoaDon.getSoLuong(),
                FormatDouble.toMoney(thisChiTietHoaDon.getDonGia()),
                FormatDouble.toMoney(thisChiTietHoaDon.getSoLuong() * thisChiTietHoaDon.getDonGia())
            });
        }
        txtTongTien.setText(FormatDouble.toMoney(tongTien));
    }
    
    private void timKiemQuanAo(){
        ArrayList<QuanAo> list = DAO_QuanAo.getAllQuanAo();
        ArrayList<QuanAo> listRemove = new ArrayList<>();
        
        if(!txtMaQuanAo.getText().equals("Mã Quần Áo")){
            for(int i = 0; i < list.size(); i ++){
                QuanAo thisQuanAo = list.get(i);
                if(!thisQuanAo.getMaQuanAo().equals(txtMaQuanAo.getText()))
                    listRemove.add(thisQuanAo);
            }
        }
        
        if(!txtTenQuanAo.getText().equals("Tên Quần Áo")){
            for(int i = 0; i < list.size(); i ++){
                QuanAo thisQuanAo = list.get(i);
                if(!thisQuanAo.getTenQuanAo().toLowerCase().contains(txtTenQuanAo.getText().toLowerCase()))
                    listRemove.add(thisQuanAo);
            }
        }
        
        if(!cmbNhaSanXuat.getSelectedItem().toString().equals("Nhà Sản Xuất")){
            for(int i = 0; i < list.size(); i ++){
                QuanAo thisQuanAo = list.get(i);
                if(!thisQuanAo.getNhaSanXuat().equals(cmbNhaSanXuat.getSelectedItem().toString()))
                    listRemove.add(thisQuanAo);
            }
        }
        
        if(!cmbDanhMuc.getSelectedItem().toString().equals("Danh Mục")){
            for(int i = 0; i < list.size(); i ++){
                QuanAo thisQuanAo = list.get(i);
                if(!thisQuanAo.getDanhMuc().equals(cmbDanhMuc.getSelectedItem().toString()))
                    listRemove.add(thisQuanAo);
            }
        }
        
        if(!cmbGioiTinh.getSelectedItem().toString().equals("Giới Tính")){
            for(int i = 0; i < list.size(); i ++){
                QuanAo thisQuanAo = list.get(i);
                if(!thisQuanAo.getGioiTinh().equals(cmbGioiTinh.getSelectedItem().toString()))
                    listRemove.add(thisQuanAo);
            }
        }
        
        if(!cmbMauSac.getSelectedItem().toString().equals("Màu Sắc")){
            for(int i = 0; i < list.size(); i ++){
                QuanAo thisQuanAo = list.get(i);
                if(!thisQuanAo.getMauSac().equals(cmbMauSac.getSelectedItem().toString()))
                    listRemove.add(thisQuanAo);
            }
        }
        
        if(!cmbKichThuoc.getSelectedItem().toString().equals("Kích Thước")){
            for(int i = 0; i < list.size(); i ++){
                QuanAo thisQuanAo = list.get(i);
                if(!thisQuanAo.getKichThuoc().equals(cmbKichThuoc.getSelectedItem().toString()))
                    listRemove.add(thisQuanAo);
            }
        }
        
        if(!cmbChatLieu.getSelectedItem().toString().equals("Chất Liệu")){
            for(int i = 0; i < list.size(); i ++){
                QuanAo thisQuanAo = list.get(i);
                if(!thisQuanAo.getChatLieu().equals(cmbChatLieu.getSelectedItem().toString()))
                    listRemove.add(thisQuanAo);
            }
        }
        
        list.removeAll(listRemove);
        capNhatTblQuanAo(list);
    }
    
    private void lamMoiQuanAo(){
        txtMaQuanAo.setText("");
        txtTenQuanAo.setText("");
        cmbNhaSanXuat.setSelectedItem("Nhà Sản Xuất");
        cmbDanhMuc.setSelectedItem("Danh Mục");
        cmbGioiTinh.setSelectedItem("Giới Tính");
        cmbMauSac.setSelectedItem("Màu Sắc");
        cmbKichThuoc.setSelectedItem("Kích Thước");
        cmbChatLieu.setSelectedItem("Chất Liệu");
        
        UtilityJTextField.focusLost(txtMaQuanAo, "Mã Quần Áo");
        UtilityJTextField.focusLost(txtTenQuanAo, "Tên Quần Áo");
        
        capNhatTblQuanAo(DAO_QuanAo.getAllQuanAo());
    }
    
    private void themQuanAoVaoDonHang(){
        int i = tblQuanAo.getSelectedRow();
        if(i < 0){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Quần Áo.");
            return;
        }
            
        String soLuongString = txtSoLuong.getText();
        int soLuong;
        if(soLuongString.equals("Số Lượng"))
            soLuong = 1;
        else{
            try{
                soLuong = Integer.parseInt(soLuongString);
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập Số Lượng hợp lệ.");
                return;
            }
        }
        
        String maQuanAo = tblQuanAo.getValueAt(i, 0).toString();
        QuanAo quanAo = DAO_QuanAo.getQuanAoTheoMaQuanAo(maQuanAo);
        
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(null, quanAo, soLuong, quanAo.getDonGiaBan());
        if(listDonHang.contains(chiTietHoaDon)){
            ChiTietHoaDon cthd = listDonHang.get(listDonHang.indexOf(chiTietHoaDon));
            int soLuongNew = cthd.getSoLuong() + chiTietHoaDon.getSoLuong();
            if(soLuongNew > quanAo.getSoLuongTrongKho()){
                JOptionPane.showMessageDialog(null, "Số Lượng Nhập vượt quá số lượng trong kho.");
                return;
            }
            else{
                cthd.setSoLuong(soLuongNew);
            }
        }
        else{
            if(soLuong > quanAo.getSoLuongTrongKho()){
                JOptionPane.showMessageDialog(null, "Số Lượng Nhập vượt quá số lượng trong kho.");
                return;
            }
            else{
                listDonHang.add(chiTietHoaDon);
            }
        }
        tblQuanAo.clearSelection();
        txtSoLuong.setText("");
        UtilityJTextField.focusLost(txtSoLuong, "Số Lượng");
        capNhatTblDonHang(listDonHang);
    }
    
    private void xoaQuanAoKhoiDonHang(){
        int number = tblDonHang.getSelectedRow();
        if(number < 0){
            JOptionPane.showMessageDialog(null, "Vui lòng Chọn Quần Áo cần xóa.");
            return;
        }
        
        String maQuanAo = tblDonHang.getValueAt(number, 0).toString();
        for(int i = 0; i < listDonHang.size(); i++){
            ChiTietHoaDon thisChiTietHoaDon = listDonHang.get(i);
            if(thisChiTietHoaDon.getQuanAo().getMaQuanAo().equals(maQuanAo))
                listDonHang.remove(thisChiTietHoaDon);
        }
        
        DefaultTableModel model = (DefaultTableModel) tblDonHang.getModel();
        model.removeRow(number);
        tblDonHang.revalidate();
        tblDonHang.repaint();
    }
    
    private void timKiemSDT(){
        String soDienThoai = txtSoDienThoai.getText();
        KhachHang khachHang = DAO_KhachHang.getKhachHangTheoSoDienThoai(soDienThoai);
        if(khachHang == null){
            JOptionPane.showMessageDialog(null, "Không tồn tại Khách Hàng với Số Điện Thoại này.");
        }
        else{
            txtHoTen.setText(khachHang.getHoTen());
            txtDiaChi.setText(khachHang.getDiaChi());
            UtilityJTextField.removePlaceHolderStyle(txtHoTen);
            UtilityJTextField.removePlaceHolderStyle(txtDiaChi);
        }
    }
    
    private void taoDonDatHang(){
        String error = "";
        
        String maDonDatHang = KhoiTaoMa.generateMaDonDatHang();
        
        String hoTen = txtHoTen.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();
        
        if(listDonHang.isEmpty()){
            JOptionPane.showMessageDialog(null, "Không có Quần Áo trong đơn hàng.");
            return;
        }
        
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
        
        if(diaChi.equals("Địa Chỉ")) // Kiểm tra rỗng
            error += "\n- Vui lòng nhập Địa Chỉ.";
        
        if(!error.equals("")){
            String throwMessage = "Lỗi nhập liệu: " + error;
            JOptionPane.showMessageDialog(null, throwMessage);
            return;
        }
        
        int prompt = JOptionPane.showConfirmDialog(null, "Xác Nhận Tạo Đơn Đặt Hàng?", "Tạo Đơn Đặt Hàng", JOptionPane.YES_NO_OPTION);
        if(prompt == JOptionPane.NO_OPTION)
            return;
        
        KhachHang khachHang = DAO_KhachHang.getKhachHangTheoSoDienThoai(soDienThoai);
        if(khachHang == null){
            String maKhachHang = KhoiTaoMa.generateMaKhachHang();
            String nhomKhachHang = "Thường";
            khachHang = new KhachHang(maKhachHang, hoTen, soDienThoai, diaChi, nhomKhachHang);
            DAO_KhachHang.createKhachHang(khachHang);
        }

        NhanVien nhanVien = DAO_NhanVien.nhanVienHienTai;
        LocalDateTime thoiGianTao = LocalDateTime.now();

        DonDatHang donDatHang = new DonDatHang(maDonDatHang, nhanVien, khachHang, thoiGianTao, false);

        boolean themDonDatHang = DAO_DonDatHang.createDonDatHang(donDatHang);

        for(ChiTietHoaDon thisChiTietHoaDon : listDonHang){
            ChiTietDonDatHang chiTietDonDatHang = new ChiTietDonDatHang(donDatHang, thisChiTietHoaDon.getQuanAo(), thisChiTietHoaDon.getSoLuong());
            DAO_ChiTietDonDatHang.createChiTietDonDatHang(chiTietDonDatHang);
            
            QuanAo quanAo = thisChiTietHoaDon.getQuanAo();
            quanAo.setSoLuongTrongKho(quanAo.getSoLuongTrongKho() - thisChiTietHoaDon.getSoLuong());
            DAO_QuanAo.updateQuanAo(quanAo);
        }
        
        if(themDonDatHang == true){
            JOptionPane.showMessageDialog(null, "Tạo Đơn Đặt Hàng Thành Công");
            GUI_Main.getInstance().showPanel(newInstance());
        }
        else{
            JOptionPane.showMessageDialog(null, "Tạo Đơn Đặt Hàng Thất Bại");
        }
    }
    
    private void lapHoaDon(){
        String error = "";
        
        String maHoaDon = KhoiTaoMa.generateMaHoaDon();
        
        String hoTen = txtHoTen.getText();
        String soDienThoai = txtSoDienThoai.getText();
        String diaChi = txtDiaChi.getText();
        
        String tienKhachDuaString = txtTienDua.getText();
        double tienKhachDua = 0;
        
        if(listDonHang.isEmpty()){
            JOptionPane.showMessageDialog(null, "Không có Quần Áo trong đơn hàng.");
            return;
        }
        
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
        
        if(diaChi.equals("Địa Chỉ")) // Kiểm tra rỗng
            error += "\n- Vui lòng nhập Địa Chỉ.";
        
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
        
        int prompt = JOptionPane.showConfirmDialog(null, "Xác Nhận Thanh Toán Cho Đơn Hàng Này?", "Xác Nhận Thanh Toán", JOptionPane.YES_NO_OPTION);
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

        for(ChiTietHoaDon thisChiTietHoaDon : listDonHang){
            thisChiTietHoaDon.setHoaDon(hoaDon);
            DAO_ChiTietHoaDon.createChiTietHoaDon(thisChiTietHoaDon);
            
            QuanAo quanAo = thisChiTietHoaDon.getQuanAo();
            quanAo.setSoLuongTrongKho(quanAo.getSoLuongTrongKho() - thisChiTietHoaDon.getSoLuong());
            DAO_QuanAo.updateQuanAo(quanAo);
        }
        
        if(themHoaDon){
            try {
                InHoaDon.createAMShopInvoice(maHoaDon);
                JOptionPane.showMessageDialog(null, "Thanh toán thành công.");
                
                KhachHang khachHangDaMua = DAO_KhachHang.getKhachHangTheoMaKhachHang(hoaDon.getKhachHang().getMaKhachHang());
                if(khachHangDaMua.getNhomKhachHang().equals("Thường")){
                    double soTienKhachHangDaMua = DAO_KhachHang.getSoTienKhachHangDaThanhToanTheoMaKhachHang(khachHangDaMua.getMaKhachHang());
                    if(soTienKhachHangDaMua > 10000000){
                        khachHangDaMua.setNhomKhachHang("Thân Thiết");
                        DAO_KhachHang.updateKhachHang(khachHangDaMua);
                    }
                }
                
                GUI_Main.getInstance().showPanel(GUI_ChiTietHoaDon.newInstance());
                GUI_ChiTietHoaDon.getInstance().showThongTinHoaDon(maHoaDon);
                GUI_ChiTietHoaDon.getInstance().setPnlBefore(newInstance());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Gặp Lỗi Khi In Hóa Đơn.");
            }
        }
    }
    
    private void capNhatHinhAnh(){
        int i = tblQuanAo.getSelectedRow();
        if(i < 0) return;
        String maQuanAo = tblQuanAo.getValueAt(i, 0).toString();
        QuanAo quanAo = DAO_QuanAo.getQuanAoTheoMaQuanAo(maQuanAo);

        lblHinhAnh.setText("");
        lblHinhAnh.setIcon(quanAo.getHinhAnh());
    }
    
    private void capNhatTienThua(){
        if(listDonHang.isEmpty()){
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTimKiem = new javax.swing.JPanel();
        txtMaQuanAo = new extended_JComponent.JTextField_AllRound();
        txtTenQuanAo = new extended_JComponent.JTextField_AllRound();
        cmbNhaSanXuat = new javax.swing.JComboBox<>();
        cmbDanhMuc = new javax.swing.JComboBox<>();
        cmbGioiTinh = new javax.swing.JComboBox<>();
        cmbMauSac = new javax.swing.JComboBox<>();
        cmbKichThuoc = new javax.swing.JComboBox<>();
        cmbChatLieu = new javax.swing.JComboBox<>();
        pnlHinhAnh = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        btnTimKiem = new extended_JComponent.JButton_AllRound();
        btnLamMoi = new extended_JComponent.JButton_AllRound();
        btnThem = new extended_JComponent.JButton_AllRound();
        btnXoa = new extended_JComponent.JButton_AllRound();
        txtSoLuong = new extended_JComponent.JTextField_AllRound();
        pnlLapHoaDon = new javax.swing.JPanel();
        pnlQuanAo = new javax.swing.JPanel();
        scrQuanAo = new javax.swing.JScrollPane();
        tblQuanAo = new extended_JComponent.JTable_LightMode();
        pnlHoaDon = new javax.swing.JPanel();
        pnlDonHang = new javax.swing.JPanel();
        scrDonHang = new javax.swing.JScrollPane();
        tblDonHang = new extended_JComponent.JTable_LightMode();
        pnlThongTinThanhToan = new javax.swing.JPanel();
        pnlKhachHang = new javax.swing.JPanel();
        txtHoTen = new extended_JComponent.JTextField_AllRound();
        txtSoDienThoai = new extended_JComponent.JTextField_AllRound();
        txtDiaChi = new extended_JComponent.JTextField_AllRound();
        btnTimKiemSDT = new extended_JComponent.JButton_AllRound();
        pnlThanhToan = new javax.swing.JPanel();
        lblTongTien = new javax.swing.JLabel();
        lblTienDua = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        txtTongTien = new extended_JComponent.JTextField_AllRound();
        txtTienDua = new extended_JComponent.JTextField_AllRound();
        txtTienThua = new extended_JComponent.JTextField_AllRound();
        btnTaoDonDatHang = new extended_JComponent.JButton_AllRound();
        btnThanhToan = new extended_JComponent.JButton_AllRound();

        setLayout(new java.awt.BorderLayout());

        pnlTimKiem.setBackground(new java.awt.Color(68, 136, 255));
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Quần Áo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiem.setPreferredSize(new java.awt.Dimension(250, 700));

        txtMaQuanAo.setText("Mã Quần Áo");
        txtMaQuanAo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaQuanAoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaQuanAoFocusLost(evt);
            }
        });

        txtTenQuanAo.setText("Tên Quần Áo");
        txtTenQuanAo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenQuanAoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenQuanAoFocusLost(evt);
            }
        });

        cmbNhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhà Sản Xuất" }));

        cmbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Danh Mục" }));

        cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giới Tính" }));

        cmbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Màu Sắc" }));

        cmbKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kích Thước" }));

        cmbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chất Liệu" }));

        pnlHinhAnh.setBackground(new java.awt.Color(224, 224, 224));
        pnlHinhAnh.setPreferredSize(new java.awt.Dimension(196, 270));
        pnlHinhAnh.setLayout(new java.awt.GridBagLayout());

        lblHinhAnh.setText("IMG");
        pnlHinhAnh.add(lblHinhAnh, new java.awt.GridBagConstraints());

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

        btnThem.setText("Thêm");
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

        btnXoa.setText("Xóa Quần Áo Khỏi Đơn Hàng");
        btnXoa.setBorderRadius(20);
        btnXoa.setColorBackground(new java.awt.Color(255, 255, 204));
        btnXoa.setColorBorder(new java.awt.Color(255, 255, 255));
        btnXoa.setColorClick(new java.awt.Color(255, 255, 0));
        btnXoa.setColorEnter(new java.awt.Color(255, 255, 153));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtSoLuong.setText("Số Lượng");
        txtSoLuong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoLuongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoLuongFocusLost(evt);
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
                        .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbKichThuoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNhaSanXuat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbDanhMuc, 0, 112, Short.MAX_VALUE)
                            .addComponent(cmbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(pnlHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(txtMaQuanAo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenQuanAo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlTimKiemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addComponent(txtMaQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        add(pnlTimKiem, java.awt.BorderLayout.EAST);

        pnlLapHoaDon.setLayout(new java.awt.BorderLayout());

        pnlQuanAo.setPreferredSize(new java.awt.Dimension(916, 300));
        pnlQuanAo.setLayout(new java.awt.BorderLayout());

        tblQuanAo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Quần Áo", "Tên Quần Áo", "Đơn Giá", "Số Lượng", "Nhà Sản Xuất", "Danh Mục", "Giới Tính", "Màu Sắc", "Kích Thước", "Chất Liệu"
            }
        ));
        tblQuanAo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanAoMouseClicked(evt);
            }
        });
        scrQuanAo.setViewportView(tblQuanAo);
        if (tblQuanAo.getColumnModel().getColumnCount() > 0) {
            tblQuanAo.getColumnModel().getColumn(0).setResizable(false);
            tblQuanAo.getColumnModel().getColumn(1).setResizable(false);
            tblQuanAo.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblQuanAo.getColumnModel().getColumn(2).setResizable(false);
            tblQuanAo.getColumnModel().getColumn(3).setResizable(false);
            tblQuanAo.getColumnModel().getColumn(4).setResizable(false);
            tblQuanAo.getColumnModel().getColumn(5).setResizable(false);
            tblQuanAo.getColumnModel().getColumn(6).setResizable(false);
            tblQuanAo.getColumnModel().getColumn(7).setResizable(false);
        }

        pnlQuanAo.add(scrQuanAo, java.awt.BorderLayout.CENTER);

        pnlLapHoaDon.add(pnlQuanAo, java.awt.BorderLayout.NORTH);

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

        btnTimKiemSDT.setText("Tìm Kiếm Theo SĐT");
        btnTimKiemSDT.setBorderRadius(20);
        btnTimKiemSDT.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTimKiemSDT.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTimKiemSDT.setColorClick(new java.awt.Color(119, 204, 255));
        btnTimKiemSDT.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTimKiemSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSDTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiemSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKhachHangLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTimKiemSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlThongTinThanhToan.add(pnlKhachHang, java.awt.BorderLayout.PAGE_START);

        pnlThanhToan.setBackground(new java.awt.Color(68, 136, 255));
        pnlThanhToan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thanh Toán", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 255, 255));
        lblTongTien.setText("Tổng Tiền");

        lblTienDua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTienDua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienDua.setText("Tiền Khách Đưa");

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienThua.setText("Tiền Thừa");

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(224, 224, 224));

        txtTienThua.setEditable(false);
        txtTienThua.setBackground(new java.awt.Color(224, 224, 224));

        btnTaoDonDatHang.setText("Tạo Đơn Đặt Hàng");
        btnTaoDonDatHang.setBorderRadius(20);
        btnTaoDonDatHang.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTaoDonDatHang.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTaoDonDatHang.setColorClick(new java.awt.Color(119, 204, 255));
        btnTaoDonDatHang.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTaoDonDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDonDatHangActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout pnlThanhToanLayout = new javax.swing.GroupLayout(pnlThanhToan);
        pnlThanhToan.setLayout(pnlThanhToanLayout);
        pnlThanhToanLayout.setHorizontalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlThanhToanLayout.createSequentialGroup()
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTaoDonDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlThanhToanLayout.createSequentialGroup()
                                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlThanhToanLayout.setVerticalGroup(
            pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongTien)
                    .addComponent(btnTaoDonDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTienDua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(105, 105, 105))
        );

        pnlThongTinThanhToan.add(pnlThanhToan, java.awt.BorderLayout.CENTER);

        pnlHoaDon.add(pnlThongTinThanhToan, java.awt.BorderLayout.CENTER);

        pnlLapHoaDon.add(pnlHoaDon, java.awt.BorderLayout.CENTER);

        add(pnlLapHoaDon, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaQuanAoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaQuanAoFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtMaQuanAo, "Mã Quần Áo");
    }//GEN-LAST:event_txtMaQuanAoFocusGained

    private void txtMaQuanAoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaQuanAoFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtMaQuanAo, "Mã Quần Áo");
    }//GEN-LAST:event_txtMaQuanAoFocusLost

    private void txtTenQuanAoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenQuanAoFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtTenQuanAo, "Tên Quần Áo");
    }//GEN-LAST:event_txtTenQuanAoFocusGained

    private void txtTenQuanAoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenQuanAoFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtTenQuanAo, "Tên Quần Áo");
    }//GEN-LAST:event_txtTenQuanAoFocusLost

    private void txtSoLuongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLuongFocusGained
        // TODO add your handling code here:
        UtilityJTextField.focusGained(txtSoLuong, "Số Lượng");
    }//GEN-LAST:event_txtSoLuongFocusGained

    private void txtSoLuongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoLuongFocusLost
        // TODO add your handling code here:
        UtilityJTextField.focusLost(txtSoLuong, "Số Lượng");
    }//GEN-LAST:event_txtSoLuongFocusLost

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
        timKiemQuanAo();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lamMoiQuanAo();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        themQuanAoVaoDonHang();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        xoaQuanAoKhoiDonHang();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSDTActionPerformed
        // TODO add your handling code here:
        timKiemSDT();
    }//GEN-LAST:event_btnTimKiemSDTActionPerformed

    private void btnTaoDonDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoDonDatHangActionPerformed
        // TODO add your handling code here:
        taoDonDatHang();
    }//GEN-LAST:event_btnTaoDonDatHangActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        lapHoaDon();
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblQuanAoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanAoMouseClicked
        // TODO add your handling code here:
        capNhatHinhAnh();
    }//GEN-LAST:event_tblQuanAoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnLamMoi;
    private extended_JComponent.JButton_AllRound btnTaoDonDatHang;
    private extended_JComponent.JButton_AllRound btnThanhToan;
    private extended_JComponent.JButton_AllRound btnThem;
    private extended_JComponent.JButton_AllRound btnTimKiem;
    private extended_JComponent.JButton_AllRound btnTimKiemSDT;
    private extended_JComponent.JButton_AllRound btnXoa;
    private javax.swing.JComboBox<String> cmbChatLieu;
    private javax.swing.JComboBox<String> cmbDanhMuc;
    private javax.swing.JComboBox<String> cmbGioiTinh;
    private javax.swing.JComboBox<String> cmbKichThuoc;
    private javax.swing.JComboBox<String> cmbMauSac;
    private javax.swing.JComboBox<String> cmbNhaSanXuat;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblTienDua;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlDonHang;
    private javax.swing.JPanel pnlHinhAnh;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlLapHoaDon;
    private javax.swing.JPanel pnlQuanAo;
    private javax.swing.JPanel pnlThanhToan;
    private javax.swing.JPanel pnlThongTinThanhToan;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JScrollPane scrDonHang;
    private javax.swing.JScrollPane scrQuanAo;
    private extended_JComponent.JTable_LightMode tblDonHang;
    private extended_JComponent.JTable_LightMode tblQuanAo;
    private extended_JComponent.JTextField_AllRound txtDiaChi;
    private extended_JComponent.JTextField_AllRound txtHoTen;
    private extended_JComponent.JTextField_AllRound txtMaQuanAo;
    private extended_JComponent.JTextField_AllRound txtSoDienThoai;
    private extended_JComponent.JTextField_AllRound txtSoLuong;
    private extended_JComponent.JTextField_AllRound txtTenQuanAo;
    private extended_JComponent.JTextField_AllRound txtTienDua;
    private extended_JComponent.JTextField_AllRound txtTienThua;
    private extended_JComponent.JTextField_AllRound txtTongTien;
    // End of variables declaration//GEN-END:variables

}
