package entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DonDatHang {
    private String maDonDatHang;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private LocalDateTime thoiGianTao;
    private boolean trangThaiThanhToan;

    public String getMaDonDatHang() {
        return maDonDatHang;
    }

    public void setMaDonDatHang(String maDonDatHang) {
        try {
            if(!maDonDatHang.matches("^DD[0-9]{10}$"))
                throw new Exception("Mã Đơn Đặt Hàng không hợp lệ");
            this.maDonDatHang = maDonDatHang;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public LocalDateTime getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(LocalDateTime thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public boolean isTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(boolean trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public DonDatHang() {
    }

    public DonDatHang(String maDonDatHang, NhanVien nhanVien, KhachHang khachHang, LocalDateTime thoiGianTao, boolean trangThaiThanhToan) {
        setMaDonDatHang(maDonDatHang);
        setNhanVien(nhanVien);
        setKhachHang(khachHang);
        setThoiGianTao(thoiGianTao);
        setTrangThaiThanhToan(trangThaiThanhToan);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.maDonDatHang);
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
        final DonDatHang other = (DonDatHang) obj;
        return Objects.equals(this.maDonDatHang, other.maDonDatHang);
    }

    @Override
    public String toString() {
        return "DonDatHang{" + "maDonDatHang=" + maDonDatHang + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", thoiGianTao=" + thoiGianTao + ", trangThaiThanhToan=" + trangThaiThanhToan + '}';
    }
}
