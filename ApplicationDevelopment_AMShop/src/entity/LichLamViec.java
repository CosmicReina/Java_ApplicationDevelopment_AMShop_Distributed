package entity;

import java.time.LocalDate;
import java.util.Objects;

public class LichLamViec {
    private String maLichLamViec;
    private LocalDate ngayLamViec;
    private CaLamViec caLamViec;

    public String getMaLichLamViec() {
        return maLichLamViec;
    }

    public void setMaLichLamViec(String maLichLamViec) {
        try {
            if(!maLichLamViec.matches("^LH[0-9]{6}[SC]$"))
                throw new Exception("Mã Lịch Làm Việc không hợp lệ");
            this.maLichLamViec = maLichLamViec;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public LocalDate getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(LocalDate ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }

    public CaLamViec getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(CaLamViec caLamViec) {
        this.caLamViec = caLamViec;
    }

    public LichLamViec() {}

    public LichLamViec(String maLichLamViec, LocalDate ngayLamViec, CaLamViec caLamViec) {
        setMaLichLamViec(maLichLamViec);
        setNgayLamViec(ngayLamViec);
        setCaLamViec(caLamViec);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.maLichLamViec);
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
        final LichLamViec other = (LichLamViec) obj;
        return Objects.equals(this.maLichLamViec, other.maLichLamViec);
    }

    @Override
    public String toString() {
        return "LichLamViec{" + "maLichLamViec=" + maLichLamViec + ", ngayLamViec=" + ngayLamViec + ", caLamViec=" + caLamViec + '}';
    }
}
