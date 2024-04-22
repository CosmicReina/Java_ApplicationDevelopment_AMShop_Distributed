package entity;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHang {
    private String maKhachHang;
    private String hoTen;
    private String soDienThoai;
    private String diaChi;
    private String nhomKhachHang;

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        try {
            if(!maKhachHang.matches("^KH[0-9]{8}$"))
                throw new Exception("Mã Khách Hàng không hợp lệ");
            this.maKhachHang = maKhachHang;
        } catch (Exception ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
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

    public String getNhomKhachHang() {
        return nhomKhachHang;
    }

    public void setNhomKhachHang(String nhomKhachHang) {
        try {
            if(!nhomKhachHang.equals("Thường") && !nhomKhachHang.equals("Thân Thiết"))
                throw new Exception("Nhóm Khách Hàng không hợp lệ");
            this.nhomKhachHang = nhomKhachHang;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public KhachHang() {}

    public KhachHang(String maKhachHang, String hoTen, String soDienThoai, String diaChi, String nhomKhachHang) {
        setMaKhachHang(maKhachHang);
        setHoTen(hoTen);
        setSoDienThoai(soDienThoai);
        setDiaChi(diaChi);
        setNhomKhachHang(nhomKhachHang);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.maKhachHang);
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
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maKhachHang, other.maKhachHang);
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKhachHang=" + maKhachHang + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", nhomKhachHang=" + nhomKhachHang + '}';
    }
}
