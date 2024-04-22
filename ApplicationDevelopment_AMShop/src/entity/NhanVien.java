package entity;

import java.time.LocalDate;
import java.util.Objects;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;
    private String chucVu;
    private LocalDate ngaySinh;
    private String canCuocCongDan;
    private String gioiTinh;
    private LocalDate ngayBatDauLam;
    private LocalDate ngayKetThucLam;
    private double luong;
    private String tenDangNhap;
    private String matKhau;

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        try {
            if(!maNhanVien.matches("^NV[0-9]{8}$"))
                throw new Exception("Mã Nhân Viên không hợp lệ");
            this.maNhanVien = maNhanVien;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        try {
            if(!hoTen.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$"))
                throw new Exception("Họ Tên không hợp lệ");
            this.hoTen = hoTen;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        try {
            if(!soDienThoai.matches("^[0-9]{10}$"))
                throw new Exception("Số điện thoại không hợp lệ");
            this.soDienThoai = soDienThoai;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        try {
            if(diaChi.isBlank())
                throw new Exception("Địa chỉ không hợp lệ");
            this.diaChi = diaChi;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        try {
            if(!chucVu.equals("Nhân Viên") && !(chucVu.equals("Người Quản Lý")))
                throw new Exception("Chức vụ không hợp lệ");
            this.chucVu = chucVu;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        try {
            if(LocalDate.now().getYear() - ngaySinh.getYear() < 18)
                throw new Exception("Năm sinh không hợp lệ");
            this.ngaySinh = ngaySinh;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getCanCuocCongDan() {
        return canCuocCongDan;
    }

    public void setCanCuocCongDan(String canCuocCongDan) {
        try {
            if(!canCuocCongDan.matches("^[0-9]{12}$"))
                throw new Exception("CCCD không hợp lệ");
            this.canCuocCongDan = canCuocCongDan;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        try {
            if(!gioiTinh.equals("Nam") && (!gioiTinh.equals("Nữ")))
                throw new Exception("Giới Tính không hợp lệ");
            this.gioiTinh = gioiTinh;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public LocalDate getNgayBatDauLam() {
        return ngayBatDauLam;
    }

    public void setNgayBatDauLam(LocalDate ngayBatDauLam) {
        this.ngayBatDauLam = ngayBatDauLam;
    }

    public LocalDate getNgayKetThucLam() {
        return ngayKetThucLam;
    }

    public void setNgayKetThucLam(LocalDate ngayKetThucLam) {
        try {
            if(ngayKetThucLam != null)
                if(ngayKetThucLam.isBefore(ngayBatDauLam))
                    throw new Exception("Ngày Kết Thúc Làm phải lớn hơn Ngày Bắt Đầu làm");
            this.ngayKetThucLam = ngayKetThucLam;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        try {
            if(luong <= 0)
                throw new Exception("Lương phải lớn hơn 0");
            this.luong = luong;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        try {
            if(!tenDangNhap.equals(maNhanVien))
                throw new Exception("Tên đăng nhập không hợp lệ");
            this.tenDangNhap = tenDangNhap;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        try {
            if(matKhau.isBlank())
                throw new Exception("Mật khẩu không hợp lệ");
            this.matKhau = matKhau;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public NhanVien() {}

    public NhanVien(String maNhanVien, String hoTen, String soDienThoai, String diaChi, String chucVu, LocalDate ngaySinh, String canCuocCongDan, String gioiTinh, LocalDate ngayBatDauLam, LocalDate ngayKetThucLam, double luong, String tenDangNhap, String matKhau) {
        setMaNhanVien(maNhanVien);
        setHoTen(hoTen);
        setSoDienThoai(soDienThoai);
        setDiaChi(diaChi);
        setChucVu(chucVu);
        setNgaySinh(ngaySinh);
        setCanCuocCongDan(canCuocCongDan);
        setGioiTinh(gioiTinh);
        setNgayBatDauLam(ngayBatDauLam);
        setNgayKetThucLam(ngayKetThucLam);
        setLuong(luong);
        setTenDangNhap(tenDangNhap);
        setMatKhau(matKhau);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.maNhanVien);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NhanVien other = (NhanVien) obj;
        return Objects.equals(this.maNhanVien, other.maNhanVien);
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", chucVu=" + chucVu + ", ngaySinh=" + ngaySinh + ", canCuocCongDan=" + canCuocCongDan + ", gioiTinh=" + gioiTinh + ", ngayBatDauLam=" + ngayBatDauLam + ", ngayKetThucLam=" + ngayKetThucLam + ", luong=" + luong + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + '}';
    }
    
}
