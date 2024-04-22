package entity;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietHoaDon {
    private HoaDon hoaDon;
    private QuanAo quanAo;
    private int soLuong;
    private double donGia;

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public QuanAo getQuanAo() {
        return quanAo;
    }

    public void setQuanAo(QuanAo quanAo) {
        this.quanAo = quanAo;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        try {
            if(soLuong < 0)
                throw new Exception("Số Lượng không hợp lệ");
            this.soLuong = soLuong;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        try {
            if(donGia < 0)
                throw new Exception("Đơn Giá không hợp lệ");
            this.donGia = donGia;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(HoaDon hoaDon, QuanAo quanAo, int soLuong, double donGia) {
        setHoaDon(hoaDon);
        setQuanAo(quanAo);
        setSoLuong(soLuong);
        setDonGia(donGia);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.hoaDon);
        hash = 79 * hash + Objects.hashCode(this.quanAo);
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
        final ChiTietHoaDon other = (ChiTietHoaDon) obj;
        if (!Objects.equals(this.hoaDon, other.hoaDon)) {
            return false;
        }
        return Objects.equals(this.quanAo, other.quanAo);
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "hoaDon=" + hoaDon + ", quanAo=" + quanAo + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }
}
