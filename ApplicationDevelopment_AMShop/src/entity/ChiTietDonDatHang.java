package entity;

import java.util.Objects;

public class ChiTietDonDatHang {
    private DonDatHang donDatHang;
    private QuanAo quanAo;
    private int soLuong;

    public DonDatHang getDonDatHang() {
        return donDatHang;
    }

    public void setDonDatHang(DonDatHang donDatHang) {
        this.donDatHang = donDatHang;
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

    public ChiTietDonDatHang() {}

    public ChiTietDonDatHang(DonDatHang donDatHang, QuanAo quanAo, int soLuong) {
        setDonDatHang(donDatHang);
        setQuanAo(quanAo);
        setSoLuong(soLuong);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.donDatHang);
        hash = 97 * hash + Objects.hashCode(this.quanAo);
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
        final ChiTietDonDatHang other = (ChiTietDonDatHang) obj;
        if (!Objects.equals(this.donDatHang, other.donDatHang)) {
            return false;
        }
        return Objects.equals(this.quanAo, other.quanAo);
    }

    @Override
    public String toString() {
        return "ChiTietDonDatHang{" + "donDatHang=" + donDatHang + ", quanAo=" + quanAo + ", soLuong=" + soLuong + '}';
    }
}
