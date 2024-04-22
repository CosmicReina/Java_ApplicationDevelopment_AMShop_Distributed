package gui;

import dao.DAO_NhanVien;
import entity.NhanVien;
import extended_JComponent.JButton_AllRound;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI_Main extends javax.swing.JPanel {
    
    private static GUI_Main instance = new GUI_Main();
    
    private ArrayList<JButton_AllRound> listBtnNhanVien = new ArrayList<>();
    private ArrayList<JButton_AllRound> listBtnKhachHang = new ArrayList<>();
    private ArrayList<JButton_AllRound> listBtnHoaDon = new ArrayList<>();
    private ArrayList<JButton_AllRound> listBtnQuanAo = new ArrayList<>();
    private ArrayList<JButton_AllRound> listBtnLichLamViec = new ArrayList<>();
    private ArrayList<JButton_AllRound> listBtnThongKe = new ArrayList<>();

    public static GUI_Main getInstance() {
        return instance;
    }
    
    public static GUI_Main newInstance() {
        instance = new GUI_Main();
        return instance;
    }

    public GUI_Main() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
        addButtonToList();
        showPanel(GUI_TrangChu.newInstance());
    }
    
    private void addButtonToList(){
        NhanVien nhanVien = DAO_NhanVien.nhanVienHienTai;
        if(nhanVien.getChucVu().equals("Người Quản Lý")){
            listBtnNhanVien.add(btnLapHoaDon);
            listBtnNhanVien.add(btnDanhSachDonDatHang);
            listBtnNhanVien.add(btnDanhSachNhanVien);
            listBtnNhanVien.add(btnTimKiemNhanVien);
            listBtnNhanVien.add(btnThemNhanVien);
            listBtnNhanVien.add(btnCapNhatNhanVien);
            listBtnNhanVien.add(btnThongTinNhanVien);

            listBtnKhachHang.add(btnDanhSachKhachHang);
            listBtnKhachHang.add(btnTimKiemKhachHang);
            listBtnKhachHang.add(btnCapNhatKhachHang);
            
            listBtnHoaDon.add(btnDanhSachHoaDon);
            listBtnHoaDon.add(btnTimKiemHoaDon);

            listBtnQuanAo.add(btnDanhSachQuanAo);
            listBtnQuanAo.add(btnTimKiemQuanAo);
            listBtnQuanAo.add(btnThemQuanAo);
            listBtnQuanAo.add(btnCapNhatQuanAo);

            listBtnLichLamViec.add(btnDanhSachLichLamViec);
            listBtnLichLamViec.add(btnTinhLuong);

            listBtnThongKe.add(btnThongKeDoanhThu);
            listBtnThongKe.add(btnThongKeKhachHang);
            listBtnThongKe.add(btnThongKeQuanAoDaBan);
            listBtnThongKe.add(btnThongKeQuanAoDaHet);
        }
        else{
            listBtnNhanVien.add(btnLapHoaDon);
            listBtnNhanVien.add(btnDanhSachDonDatHang);
            listBtnNhanVien.add(btnThongTinNhanVien);
            
            listBtnKhachHang.add(btnDanhSachKhachHang);
            listBtnKhachHang.add(btnTimKiemKhachHang);
            listBtnKhachHang.add(btnCapNhatKhachHang);
            
            listBtnHoaDon.add(btnDanhSachHoaDon);
            listBtnHoaDon.add(btnTimKiemHoaDon);
            
            listBtnQuanAo.add(btnDanhSachQuanAo);
            listBtnQuanAo.add(btnTimKiemQuanAo);
            
            btnLichLamViec.setVisible(false);
            btnThongKe.setVisible(false);
        }
    }
    
    public void showPanel(JPanel panel){
        pnlWork.removeAll();
    	pnlWork.revalidate();
    	pnlWork.repaint();
    	pnlWork.setLayout(new BorderLayout());
    	pnlWork.add(panel, BorderLayout.CENTER);
    }
    
    public void tatHetChucNang(){
        btnTrangChu.setVisible(false);
        btnNhanVien.setVisible(false);
        btnKhachHang.setVisible(false);
        btnHoaDon.setVisible(false);
        btnQuanAo.setVisible(false);
        btnLichLamViec.setVisible(false);
        btnThongKe.setVisible(false);
        
        showPanel(GUI_TimKiemQuanAo.newInstance());
    }
    
    private void dangXuat(){
        int i = JOptionPane.showConfirmDialog(null, "Đăng Xuất Chương Trình?", "Đăng Xuất", JOptionPane.YES_NO_OPTION);
        if(i == JOptionPane.YES_OPTION){
            GUI_DangNhap.newInstance().setVisible(true);
            GUI_MainFrame.getInstance().dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLapHoaDon = new extended_JComponent.JButton_AllRound();
        btnDanhSachDonDatHang = new extended_JComponent.JButton_AllRound();
        btnDanhSachNhanVien = new extended_JComponent.JButton_AllRound();
        btnTimKiemNhanVien = new extended_JComponent.JButton_AllRound();
        btnThemNhanVien = new extended_JComponent.JButton_AllRound();
        btnCapNhatNhanVien = new extended_JComponent.JButton_AllRound();
        btnThongTinNhanVien = new extended_JComponent.JButton_AllRound();
        btnDanhSachKhachHang = new extended_JComponent.JButton_AllRound();
        btnTimKiemKhachHang = new extended_JComponent.JButton_AllRound();
        btnCapNhatKhachHang = new extended_JComponent.JButton_AllRound();
        btnDanhSachHoaDon = new extended_JComponent.JButton_AllRound();
        btnTimKiemHoaDon = new extended_JComponent.JButton_AllRound();
        btnDanhSachQuanAo = new extended_JComponent.JButton_AllRound();
        btnTimKiemQuanAo = new extended_JComponent.JButton_AllRound();
        btnThemQuanAo = new extended_JComponent.JButton_AllRound();
        btnCapNhatQuanAo = new extended_JComponent.JButton_AllRound();
        btnDanhSachLichLamViec = new extended_JComponent.JButton_AllRound();
        btnTinhLuong = new extended_JComponent.JButton_AllRound();
        btnThongKeDoanhThu = new extended_JComponent.JButton_AllRound();
        btnThongKeKhachHang = new extended_JComponent.JButton_AllRound();
        btnThongKeQuanAoDaBan = new extended_JComponent.JButton_AllRound();
        btnThongKeQuanAoDaHet = new extended_JComponent.JButton_AllRound();
        pnlTitle = new extended_JComponent.JPanel_AllRound();
        lblTitle = new javax.swing.JLabel();
        pnlButton = new extended_JComponent.JPanel_AllRound();
        pnlActionButton = new extended_JComponent.JPanel_AllRound();
        btnTrangChu = new extended_JComponent.JButton_AllRound();
        btnNhanVien = new extended_JComponent.JButton_AllRound();
        btnKhachHang = new extended_JComponent.JButton_AllRound();
        btnHoaDon = new extended_JComponent.JButton_AllRound();
        btnQuanAo = new extended_JComponent.JButton_AllRound();
        btnLichLamViec = new extended_JComponent.JButton_AllRound();
        btnThongKe = new extended_JComponent.JButton_AllRound();
        vg = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        pnlLogoutButton = new extended_JComponent.JPanel_AllRound();
        btnDangXuat = new extended_JComponent.JButton_AllRound();
        pnlWork = new javax.swing.JPanel();

        btnLapHoaDon.setText("Lập Hóa Đơn Bán Hàng");
        btnLapHoaDon.setBorderRadius(20);
        btnLapHoaDon.setBorderThickness(1);
        btnLapHoaDon.setColorBackground(new java.awt.Color(170, 238, 255));
        btnLapHoaDon.setColorBorder(new java.awt.Color(255, 255, 255));
        btnLapHoaDon.setColorClick(new java.awt.Color(119, 204, 255));
        btnLapHoaDon.setColorEnter(new java.awt.Color(119, 238, 255));
        btnLapHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapHoaDonActionPerformed(evt);
            }
        });

        btnDanhSachDonDatHang.setText("Danh Sách Đơn Đặt Hàng");
        btnDanhSachDonDatHang.setBorderRadius(20);
        btnDanhSachDonDatHang.setBorderThickness(1);
        btnDanhSachDonDatHang.setColorBackground(new java.awt.Color(170, 238, 255));
        btnDanhSachDonDatHang.setColorBorder(new java.awt.Color(255, 255, 255));
        btnDanhSachDonDatHang.setColorClick(new java.awt.Color(119, 204, 255));
        btnDanhSachDonDatHang.setColorEnter(new java.awt.Color(119, 238, 255));
        btnDanhSachDonDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachDonDatHangActionPerformed(evt);
            }
        });

        btnDanhSachNhanVien.setText("Danh Sách Nhân Viên");
        btnDanhSachNhanVien.setBorderRadius(20);
        btnDanhSachNhanVien.setColorBackground(new java.awt.Color(170, 238, 255));
        btnDanhSachNhanVien.setColorBorder(new java.awt.Color(255, 255, 255));
        btnDanhSachNhanVien.setColorClick(new java.awt.Color(119, 204, 255));
        btnDanhSachNhanVien.setColorEnter(new java.awt.Color(119, 238, 255));
        btnDanhSachNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachNhanVienActionPerformed(evt);
            }
        });

        btnTimKiemNhanVien.setText("Tìm Kiếm Nhân Viên");
        btnTimKiemNhanVien.setBorderRadius(20);
        btnTimKiemNhanVien.setBorderThickness(1);
        btnTimKiemNhanVien.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTimKiemNhanVien.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTimKiemNhanVien.setColorClick(new java.awt.Color(119, 204, 255));
        btnTimKiemNhanVien.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTimKiemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNhanVienActionPerformed(evt);
            }
        });

        btnThemNhanVien.setText("Thêm Nhân Viên");
        btnThemNhanVien.setBorderRadius(20);
        btnThemNhanVien.setBorderThickness(1);
        btnThemNhanVien.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThemNhanVien.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThemNhanVien.setColorClick(new java.awt.Color(119, 204, 255));
        btnThemNhanVien.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        btnCapNhatNhanVien.setText("Cập Nhật Thông Tin Nhân Viên");
        btnCapNhatNhanVien.setBorderRadius(20);
        btnCapNhatNhanVien.setBorderThickness(1);
        btnCapNhatNhanVien.setColorBackground(new java.awt.Color(170, 238, 255));
        btnCapNhatNhanVien.setColorBorder(new java.awt.Color(255, 255, 255));
        btnCapNhatNhanVien.setColorClick(new java.awt.Color(119, 204, 255));
        btnCapNhatNhanVien.setColorEnter(new java.awt.Color(119, 238, 255));
        btnCapNhatNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatNhanVienActionPerformed(evt);
            }
        });

        btnThongTinNhanVien.setText("Xem Thông Tin Cá Nhân");
        btnThongTinNhanVien.setBorderRadius(20);
        btnThongTinNhanVien.setBorderThickness(1);
        btnThongTinNhanVien.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThongTinNhanVien.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThongTinNhanVien.setColorClick(new java.awt.Color(119, 204, 255));
        btnThongTinNhanVien.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThongTinNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongTinNhanVienActionPerformed(evt);
            }
        });

        btnDanhSachKhachHang.setText("Danh Sách Khách Hàng");
        btnDanhSachKhachHang.setBorderRadius(20);
        btnDanhSachKhachHang.setColorBackground(new java.awt.Color(170, 238, 255));
        btnDanhSachKhachHang.setColorBorder(new java.awt.Color(255, 255, 255));
        btnDanhSachKhachHang.setColorClick(new java.awt.Color(119, 204, 255));
        btnDanhSachKhachHang.setColorEnter(new java.awt.Color(119, 238, 255));
        btnDanhSachKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachKhachHangActionPerformed(evt);
            }
        });

        btnTimKiemKhachHang.setText("Tìm Kiếm Khách Hàng");
        btnTimKiemKhachHang.setBorderRadius(20);
        btnTimKiemKhachHang.setBorderThickness(1);
        btnTimKiemKhachHang.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTimKiemKhachHang.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTimKiemKhachHang.setColorClick(new java.awt.Color(119, 204, 255));
        btnTimKiemKhachHang.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTimKiemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKhachHangActionPerformed(evt);
            }
        });

        btnCapNhatKhachHang.setText("Cập Nhật Thông Tin Khách Hàng");
        btnCapNhatKhachHang.setBorderRadius(20);
        btnCapNhatKhachHang.setBorderThickness(1);
        btnCapNhatKhachHang.setColorBackground(new java.awt.Color(170, 238, 255));
        btnCapNhatKhachHang.setColorBorder(new java.awt.Color(255, 255, 255));
        btnCapNhatKhachHang.setColorClick(new java.awt.Color(119, 204, 255));
        btnCapNhatKhachHang.setColorEnter(new java.awt.Color(119, 238, 255));
        btnCapNhatKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatKhachHangActionPerformed(evt);
            }
        });

        btnDanhSachHoaDon.setText("Xem Danh Sách Hóa Đơn");
        btnDanhSachHoaDon.setBorderRadius(20);
        btnDanhSachHoaDon.setColorBackground(new java.awt.Color(170, 238, 255));
        btnDanhSachHoaDon.setColorBorder(new java.awt.Color(255, 255, 255));
        btnDanhSachHoaDon.setColorClick(new java.awt.Color(119, 204, 255));
        btnDanhSachHoaDon.setColorEnter(new java.awt.Color(119, 238, 255));
        btnDanhSachHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachHoaDonActionPerformed(evt);
            }
        });

        btnTimKiemHoaDon.setText("Tìm Kiếm Hóa Đơn");
        btnTimKiemHoaDon.setBorderRadius(20);
        btnTimKiemHoaDon.setBorderThickness(1);
        btnTimKiemHoaDon.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTimKiemHoaDon.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTimKiemHoaDon.setColorClick(new java.awt.Color(119, 204, 255));
        btnTimKiemHoaDon.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTimKiemHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemHoaDonActionPerformed(evt);
            }
        });

        btnDanhSachQuanAo.setText("Danh Sách Quần Áo");
        btnDanhSachQuanAo.setBorderRadius(20);
        btnDanhSachQuanAo.setColorBackground(new java.awt.Color(170, 238, 255));
        btnDanhSachQuanAo.setColorBorder(new java.awt.Color(255, 255, 255));
        btnDanhSachQuanAo.setColorClick(new java.awt.Color(119, 204, 255));
        btnDanhSachQuanAo.setColorEnter(new java.awt.Color(119, 238, 255));
        btnDanhSachQuanAo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachQuanAoActionPerformed(evt);
            }
        });

        btnTimKiemQuanAo.setText("Tìm Kiếm Quần Áo");
        btnTimKiemQuanAo.setBorderRadius(20);
        btnTimKiemQuanAo.setBorderThickness(1);
        btnTimKiemQuanAo.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTimKiemQuanAo.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTimKiemQuanAo.setColorClick(new java.awt.Color(119, 204, 255));
        btnTimKiemQuanAo.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTimKiemQuanAo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemQuanAoActionPerformed(evt);
            }
        });

        btnThemQuanAo.setText("Thêm Quần Áo");
        btnThemQuanAo.setBorderRadius(20);
        btnThemQuanAo.setBorderThickness(1);
        btnThemQuanAo.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThemQuanAo.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThemQuanAo.setColorClick(new java.awt.Color(119, 204, 255));
        btnThemQuanAo.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThemQuanAo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemQuanAoActionPerformed(evt);
            }
        });

        btnCapNhatQuanAo.setText("Cập Nhật Quần Áo");
        btnCapNhatQuanAo.setBorderRadius(20);
        btnCapNhatQuanAo.setBorderThickness(1);
        btnCapNhatQuanAo.setColorBackground(new java.awt.Color(170, 238, 255));
        btnCapNhatQuanAo.setColorBorder(new java.awt.Color(255, 255, 255));
        btnCapNhatQuanAo.setColorClick(new java.awt.Color(119, 204, 255));
        btnCapNhatQuanAo.setColorEnter(new java.awt.Color(119, 238, 255));
        btnCapNhatQuanAo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatQuanAoActionPerformed(evt);
            }
        });

        btnDanhSachLichLamViec.setText("Chấm Công Nhân Viên");
        btnDanhSachLichLamViec.setBorderRadius(20);
        btnDanhSachLichLamViec.setBorderThickness(1);
        btnDanhSachLichLamViec.setColorBackground(new java.awt.Color(170, 238, 255));
        btnDanhSachLichLamViec.setColorBorder(new java.awt.Color(255, 255, 255));
        btnDanhSachLichLamViec.setColorClick(new java.awt.Color(119, 204, 255));
        btnDanhSachLichLamViec.setColorEnter(new java.awt.Color(119, 238, 255));
        btnDanhSachLichLamViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachLichLamViecActionPerformed(evt);
            }
        });

        btnTinhLuong.setText("Tính Lương Nhân Viên");
        btnTinhLuong.setBorderRadius(20);
        btnTinhLuong.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTinhLuong.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTinhLuong.setColorClick(new java.awt.Color(119, 204, 255));
        btnTinhLuong.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhLuongActionPerformed(evt);
            }
        });

        btnThongKeDoanhThu.setText("Thống Kê Doanh Thu Bán Hàng");
        btnThongKeDoanhThu.setBorderRadius(20);
        btnThongKeDoanhThu.setBorderThickness(1);
        btnThongKeDoanhThu.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThongKeDoanhThu.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThongKeDoanhThu.setColorClick(new java.awt.Color(119, 204, 255));
        btnThongKeDoanhThu.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThongKeDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeDoanhThuActionPerformed(evt);
            }
        });

        btnThongKeKhachHang.setText("Thống Kê Khách Hàng");
        btnThongKeKhachHang.setBorderRadius(20);
        btnThongKeKhachHang.setBorderThickness(1);
        btnThongKeKhachHang.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThongKeKhachHang.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThongKeKhachHang.setColorClick(new java.awt.Color(119, 204, 255));
        btnThongKeKhachHang.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThongKeKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeKhachHangActionPerformed(evt);
            }
        });

        btnThongKeQuanAoDaBan.setText("Thống Kê Quần Áo Đã Bán");
        btnThongKeQuanAoDaBan.setBorderRadius(20);
        btnThongKeQuanAoDaBan.setBorderThickness(1);
        btnThongKeQuanAoDaBan.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThongKeQuanAoDaBan.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThongKeQuanAoDaBan.setColorClick(new java.awt.Color(119, 204, 255));
        btnThongKeQuanAoDaBan.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThongKeQuanAoDaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeQuanAoDaBanActionPerformed(evt);
            }
        });

        btnThongKeQuanAoDaHet.setText("Thống Kê Quần Áo Đã Hết");
        btnThongKeQuanAoDaHet.setBorderRadius(20);
        btnThongKeQuanAoDaHet.setBorderThickness(1);
        btnThongKeQuanAoDaHet.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThongKeQuanAoDaHet.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThongKeQuanAoDaHet.setColorClick(new java.awt.Color(119, 204, 255));
        btnThongKeQuanAoDaHet.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThongKeQuanAoDaHet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeQuanAoDaHetActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        pnlTitle.setBackground(new java.awt.Color(170, 238, 255));
        pnlTitle.setBorderBottomRight(50);
        pnlTitle.setBorderTopRight(50);
        pnlTitle.setPreferredSize(new java.awt.Dimension(1366, 68));
        pnlTitle.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setText("PHẦN MỀM QUẢN LÝ CỬA HÀNG BÁN QUẦN ÁO - AMSHOP");
        pnlTitle.add(lblTitle, new java.awt.GridBagConstraints());

        add(pnlTitle, java.awt.BorderLayout.PAGE_START);

        pnlButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlButton.setBorderBottomRight(50);
        pnlButton.setBorderTopRight(50);
        pnlButton.setPreferredSize(new java.awt.Dimension(200, 700));
        pnlButton.setLayout(new javax.swing.BoxLayout(pnlButton, javax.swing.BoxLayout.Y_AXIS));

        pnlActionButton.setBackground(new java.awt.Color(170, 238, 255));
        pnlActionButton.setBorderBottomRight(50);
        pnlActionButton.setBorderTopRight(50);
        pnlActionButton.setPreferredSize(new java.awt.Dimension(200, 500));
        pnlActionButton.setLayout(new java.awt.GridLayout(7, 1));

        btnTrangChu.setText("Trang Chủ");
        btnTrangChu.setBorderRadius(50);
        btnTrangChu.setBorderThickness(1);
        btnTrangChu.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTrangChu.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTrangChu.setColorClick(new java.awt.Color(119, 204, 255));
        btnTrangChu.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTrangChu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });
        pnlActionButton.add(btnTrangChu);

        btnNhanVien.setText("Nhân Viên");
        btnNhanVien.setBorderRadius(50);
        btnNhanVien.setBorderThickness(1);
        btnNhanVien.setColorBackground(new java.awt.Color(170, 238, 255));
        btnNhanVien.setColorBorder(new java.awt.Color(255, 255, 255));
        btnNhanVien.setColorClick(new java.awt.Color(119, 204, 255));
        btnNhanVien.setColorEnter(new java.awt.Color(119, 238, 255));
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });
        pnlActionButton.add(btnNhanVien);

        btnKhachHang.setText("Khách Hàng");
        btnKhachHang.setBorderRadius(50);
        btnKhachHang.setBorderThickness(1);
        btnKhachHang.setColorBackground(new java.awt.Color(170, 238, 255));
        btnKhachHang.setColorBorder(new java.awt.Color(255, 255, 255));
        btnKhachHang.setColorClick(new java.awt.Color(119, 204, 255));
        btnKhachHang.setColorEnter(new java.awt.Color(119, 238, 255));
        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });
        pnlActionButton.add(btnKhachHang);

        btnHoaDon.setText("Hóa Đơn");
        btnHoaDon.setBorderRadius(50);
        btnHoaDon.setBorderThickness(1);
        btnHoaDon.setColorBackground(new java.awt.Color(170, 238, 255));
        btnHoaDon.setColorBorder(new java.awt.Color(255, 255, 255));
        btnHoaDon.setColorClick(new java.awt.Color(119, 204, 255));
        btnHoaDon.setColorEnter(new java.awt.Color(119, 238, 255));
        btnHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });
        pnlActionButton.add(btnHoaDon);

        btnQuanAo.setText("Quần Áo");
        btnQuanAo.setBorderRadius(50);
        btnQuanAo.setBorderThickness(1);
        btnQuanAo.setColorBackground(new java.awt.Color(170, 238, 255));
        btnQuanAo.setColorBorder(new java.awt.Color(255, 255, 255));
        btnQuanAo.setColorClick(new java.awt.Color(119, 204, 255));
        btnQuanAo.setColorEnter(new java.awt.Color(119, 238, 255));
        btnQuanAo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnQuanAo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanAoActionPerformed(evt);
            }
        });
        pnlActionButton.add(btnQuanAo);

        btnLichLamViec.setText("Lịch Làm Việc");
        btnLichLamViec.setBorderRadius(50);
        btnLichLamViec.setBorderThickness(1);
        btnLichLamViec.setColorBackground(new java.awt.Color(170, 238, 255));
        btnLichLamViec.setColorBorder(new java.awt.Color(255, 255, 255));
        btnLichLamViec.setColorClick(new java.awt.Color(119, 204, 255));
        btnLichLamViec.setColorEnter(new java.awt.Color(119, 238, 255));
        btnLichLamViec.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLichLamViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLichLamViecActionPerformed(evt);
            }
        });
        pnlActionButton.add(btnLichLamViec);

        btnThongKe.setText("Thống Kê");
        btnThongKe.setBorderRadius(50);
        btnThongKe.setBorderThickness(1);
        btnThongKe.setColorBackground(new java.awt.Color(170, 238, 255));
        btnThongKe.setColorBorder(new java.awt.Color(255, 255, 255));
        btnThongKe.setColorClick(new java.awt.Color(119, 204, 255));
        btnThongKe.setColorEnter(new java.awt.Color(119, 238, 255));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        pnlActionButton.add(btnThongKe);

        pnlButton.add(pnlActionButton);
        pnlButton.add(vg);

        pnlLogoutButton.setBackground(new java.awt.Color(255, 102, 102));
        pnlLogoutButton.setBorderBottomRight(50);
        pnlLogoutButton.setBorderTopRight(50);
        pnlLogoutButton.setPreferredSize(new java.awt.Dimension(200, 0));
        pnlLogoutButton.setLayout(new java.awt.GridLayout(1, 1));

        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.setBorderRadius(50);
        btnDangXuat.setBorderThickness(1);
        btnDangXuat.setColorBackground(new java.awt.Color(255, 102, 102));
        btnDangXuat.setColorBorder(new java.awt.Color(255, 255, 255));
        btnDangXuat.setColorClick(new java.awt.Color(255, 0, 0));
        btnDangXuat.setColorEnter(new java.awt.Color(255, 34, 102));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        pnlLogoutButton.add(btnDangXuat);

        pnlButton.add(pnlLogoutButton);

        add(pnlButton, java.awt.BorderLayout.LINE_START);

        pnlWork.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlWorkLayout = new javax.swing.GroupLayout(pnlWork);
        pnlWork.setLayout(pnlWorkLayout);
        pnlWorkLayout.setHorizontalGroup(
            pnlWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );
        pnlWorkLayout.setVerticalGroup(
            pnlWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        add(pnlWork, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        dangXuat();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        showPanel(GUI_TrangChu.newInstance());
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        GUI_MainFrame.getInstance().createPopupForButton(btnNhanVien, listBtnNhanVien);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        GUI_MainFrame.getInstance().createPopupForButton(btnKhachHang, listBtnKhachHang);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        GUI_MainFrame.getInstance().createPopupForButton(btnHoaDon, listBtnHoaDon);
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnQuanAoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanAoActionPerformed
        GUI_MainFrame.getInstance().createPopupForButton(btnQuanAo, listBtnQuanAo);
    }//GEN-LAST:event_btnQuanAoActionPerformed

    private void btnLichLamViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLichLamViecActionPerformed
        GUI_MainFrame.getInstance().createPopupForButton(btnLichLamViec, listBtnLichLamViec);
    }//GEN-LAST:event_btnLichLamViecActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        GUI_MainFrame.getInstance().createPopupForButton(btnThongKe, listBtnThongKe);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnLapHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapHoaDonActionPerformed
        showPanel(GUI_LapHoaDon.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnLapHoaDonActionPerformed

    private void btnDanhSachDonDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachDonDatHangActionPerformed
        showPanel(GUI_DanhSachDonDatHang.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnDanhSachDonDatHangActionPerformed

    private void btnTimKiemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNhanVienActionPerformed
        showPanel(GUI_TimKiemNhanVien.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnTimKiemNhanVienActionPerformed

    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        showPanel(GUI_ThemNhanVien.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void btnCapNhatNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatNhanVienActionPerformed
        showPanel(GUI_CapNhatNhanVien.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnCapNhatNhanVienActionPerformed

    private void btnThongTinNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongTinNhanVienActionPerformed
        showPanel(GUI_ChiTietNhanVien.newInstance());
        GUI_ChiTietNhanVien.getInstance().showChiTietNhanVien(DAO_NhanVien.nhanVienHienTai.getMaNhanVien());
        GUI_ChiTietNhanVien.getInstance().setPnlBefore(GUI_TrangChu.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnThongTinNhanVienActionPerformed

    private void btnTimKiemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKhachHangActionPerformed
        showPanel(GUI_TimKiemKhachHang.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnTimKiemKhachHangActionPerformed

    private void btnCapNhatKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatKhachHangActionPerformed
        showPanel(GUI_CapNhatKhachHang.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnCapNhatKhachHangActionPerformed

    private void btnTimKiemHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemHoaDonActionPerformed
        showPanel(GUI_TimKiemHoaDon.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnTimKiemHoaDonActionPerformed

    private void btnTimKiemQuanAoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemQuanAoActionPerformed
        showPanel(GUI_TimKiemQuanAo.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnTimKiemQuanAoActionPerformed

    private void btnThemQuanAoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemQuanAoActionPerformed
        showPanel(GUI_ThemQuanAo.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnThemQuanAoActionPerformed

    private void btnCapNhatQuanAoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatQuanAoActionPerformed
        showPanel(GUI_CapNhatQuanAo.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnCapNhatQuanAoActionPerformed

    private void btnDanhSachLichLamViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachLichLamViecActionPerformed
        showPanel(GUI_LichLamViec.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnDanhSachLichLamViecActionPerformed

    private void btnThongKeDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeDoanhThuActionPerformed
        showPanel(GUI_ThongKeDoanhThu.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnThongKeDoanhThuActionPerformed

    private void btnThongKeKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeKhachHangActionPerformed
        showPanel(GUI_ThongKeKhachHang.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnThongKeKhachHangActionPerformed

    private void btnThongKeQuanAoDaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeQuanAoDaBanActionPerformed
        showPanel(GUI_ThongKeQuanAoDaBan.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnThongKeQuanAoDaBanActionPerformed

    private void btnThongKeQuanAoDaHetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeQuanAoDaHetActionPerformed
        showPanel(GUI_ThongKeQuanAoDaHet.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnThongKeQuanAoDaHetActionPerformed

    private void btnTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhLuongActionPerformed
        // TODO add your handling code here:
        showPanel(GUI_TinhLuongNhanVien.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnTinhLuongActionPerformed

    private void btnDanhSachHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachHoaDonActionPerformed
        // TODO add your handling code here:
        showPanel(GUI_DanhSachHoaDon.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnDanhSachHoaDonActionPerformed

    private void btnDanhSachKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachKhachHangActionPerformed
        // TODO add your handling code here:
        showPanel(GUI_DanhSachKhachHang.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnDanhSachKhachHangActionPerformed

    private void btnDanhSachNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachNhanVienActionPerformed
        // TODO add your handling code here:
        showPanel(GUI_DanhSachNhanVien.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnDanhSachNhanVienActionPerformed

    private void btnDanhSachQuanAoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachQuanAoActionPerformed
        // TODO add your handling code here:
        showPanel(GUI_DanhSachQuanAo.newInstance());
        GUI_MainFrame.getInstance().resetPopupPanel();
    }//GEN-LAST:event_btnDanhSachQuanAoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_JComponent.JButton_AllRound btnCapNhatKhachHang;
    private extended_JComponent.JButton_AllRound btnCapNhatNhanVien;
    private extended_JComponent.JButton_AllRound btnCapNhatQuanAo;
    private extended_JComponent.JButton_AllRound btnDangXuat;
    private extended_JComponent.JButton_AllRound btnDanhSachDonDatHang;
    private extended_JComponent.JButton_AllRound btnDanhSachHoaDon;
    private extended_JComponent.JButton_AllRound btnDanhSachKhachHang;
    private extended_JComponent.JButton_AllRound btnDanhSachLichLamViec;
    private extended_JComponent.JButton_AllRound btnDanhSachNhanVien;
    private extended_JComponent.JButton_AllRound btnDanhSachQuanAo;
    private extended_JComponent.JButton_AllRound btnHoaDon;
    private extended_JComponent.JButton_AllRound btnKhachHang;
    private extended_JComponent.JButton_AllRound btnLapHoaDon;
    private extended_JComponent.JButton_AllRound btnLichLamViec;
    private extended_JComponent.JButton_AllRound btnNhanVien;
    private extended_JComponent.JButton_AllRound btnQuanAo;
    private extended_JComponent.JButton_AllRound btnThemNhanVien;
    private extended_JComponent.JButton_AllRound btnThemQuanAo;
    private extended_JComponent.JButton_AllRound btnThongKe;
    private extended_JComponent.JButton_AllRound btnThongKeDoanhThu;
    private extended_JComponent.JButton_AllRound btnThongKeKhachHang;
    private extended_JComponent.JButton_AllRound btnThongKeQuanAoDaBan;
    private extended_JComponent.JButton_AllRound btnThongKeQuanAoDaHet;
    private extended_JComponent.JButton_AllRound btnThongTinNhanVien;
    private extended_JComponent.JButton_AllRound btnTimKiemHoaDon;
    private extended_JComponent.JButton_AllRound btnTimKiemKhachHang;
    private extended_JComponent.JButton_AllRound btnTimKiemNhanVien;
    private extended_JComponent.JButton_AllRound btnTimKiemQuanAo;
    private extended_JComponent.JButton_AllRound btnTinhLuong;
    private extended_JComponent.JButton_AllRound btnTrangChu;
    private javax.swing.JLabel lblTitle;
    private extended_JComponent.JPanel_AllRound pnlActionButton;
    private extended_JComponent.JPanel_AllRound pnlButton;
    private extended_JComponent.JPanel_AllRound pnlLogoutButton;
    private extended_JComponent.JPanel_AllRound pnlTitle;
    private javax.swing.JPanel pnlWork;
    private javax.swing.Box.Filler vg;
    // End of variables declaration//GEN-END:variables

}
