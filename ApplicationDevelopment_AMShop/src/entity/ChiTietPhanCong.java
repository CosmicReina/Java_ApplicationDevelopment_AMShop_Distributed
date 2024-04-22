package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChiTietPhanCong {
    private LichLamViec lichLamViec;
    private NhanVien nhanVien;
    private LocalDateTime thoiGianVaoCa;
    private LocalDateTime thoiGianRaCa;

    public LichLamViec getLichLamViec() {
        return lichLamViec;
    }

    public void setLichLamViec(LichLamViec lichLamViec) {
        this.lichLamViec = lichLamViec;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public LocalDateTime getThoiGianVaoCa() {
        return thoiGianVaoCa;
    }

    public void setThoiGianVaoCa(LocalDateTime thoiGianVaoCa) {
        this.thoiGianVaoCa = thoiGianVaoCa;
    }

    public LocalDateTime getThoiGianRaCa() {
        return thoiGianRaCa;
    }

    public void setThoiGianRaCa(LocalDateTime thoiGianRaCa) {
        try {
            if(thoiGianRaCa != null)
                if(thoiGianRaCa.isBefore(thoiGianVaoCa))
                    throw new Exception("Thời Gian Ra Ca không hợp lệ");
            this.thoiGianRaCa = thoiGianRaCa;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public ChiTietPhanCong() {}

    public ChiTietPhanCong(LichLamViec lichLamViec, NhanVien nhanVien, LocalDateTime thoiGianVaoCa, LocalDateTime thoiGianRaCa) {
        try {
            setLichLamViec(lichLamViec);
            setNhanVien(nhanVien);
            setThoiGianVaoCa(thoiGianVaoCa);
            setThoiGianRaCa(thoiGianRaCa);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.lichLamViec);
        hash = 17 * hash + Objects.hashCode(this.nhanVien);
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
        final ChiTietPhanCong other = (ChiTietPhanCong) obj;
        if (!Objects.equals(this.lichLamViec, other.lichLamViec)) {
            return false;
        }
        return Objects.equals(this.nhanVien, other.nhanVien);
    }

    @Override
    public String toString() {
        return "ChiTietPhanCong{" + "lichLamViec=" + lichLamViec + ", nhanVien=" + nhanVien + ", thoiGianVaoCa=" + thoiGianVaoCa + ", thoiGianRaCa=" + thoiGianRaCa + '}';
    }
}
