package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class HoaDon {
    private String maHoaDon;
    private CuaHang cuaHang;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private LocalDateTime thoiGianTao;
    private double tienKhachDua;

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        try {
            if(!maHoaDon.matches("^HD[0-9]{10}$"))
                throw new Exception("Mã Hóa Đơn không hợp lệ");
            this.maHoaDon = maHoaDon;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public CuaHang getCuaHang() {
        return cuaHang;
    }

    public void setCuaHang(CuaHang cuaHang) {
        this.cuaHang = cuaHang;
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

    public double getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(double tienKhachDua) {
        try {
            if(tienKhachDua < 0)
                throw new Exception("Tiền Khách Đưa không hợp lệ");
            this.tienKhachDua = tienKhachDua;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public HoaDon() {}

    public HoaDon(String maHoaDon, CuaHang cuaHang, NhanVien nhanVien, KhachHang khachHang, LocalDateTime thoiGianTao, double tienKhachDua) {
        setMaHoaDon(maHoaDon);
        setCuaHang(cuaHang);
        setNhanVien(nhanVien);
        setKhachHang(khachHang);
        setThoiGianTao(thoiGianTao);
        setTienKhachDua(tienKhachDua);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.maHoaDon);
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
        final HoaDon other = (HoaDon) obj;
        return Objects.equals(this.maHoaDon, other.maHoaDon);
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", cuaHang=" + cuaHang + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", thoiGianTao=" + thoiGianTao + ", tienKhachDua=" + tienKhachDua + '}';
    }

}
