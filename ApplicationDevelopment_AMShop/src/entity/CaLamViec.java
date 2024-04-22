package entity;

import java.time.LocalTime;

public class CaLamViec {
    private int maCaLamViec;
    private String tenCaLamViec;
    private LocalTime thoiGianBatDau;
    private LocalTime thoiGianKetThuc;

    public int getMaCaLamViec() {
        return maCaLamViec;
    }

    public void setMaCaLamViec(int maCaLamViec) {
        try {
            if(maCaLamViec < 0)
                throw new Exception("Mã Ca Làm Việc không hợp lệ");
            this.maCaLamViec = maCaLamViec;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getTenCaLamViec() {
        return tenCaLamViec;
    }

    public void setTenCaLamViec(String tenCaLamViec) {
        try {
            if(tenCaLamViec.isBlank())
                throw new Exception("Tên Ca Làm Việc không hợp lệ");
            this.tenCaLamViec = tenCaLamViec;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public LocalTime getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalTime getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalTime thoiGianKetThuc) {
        try {
            if(thoiGianKetThuc.isBefore(thoiGianBatDau))
                throw new Exception("Thời Gian Kết Thúc không hợp lệ");
            this.thoiGianKetThuc = thoiGianKetThuc;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public CaLamViec() {
    }

    public CaLamViec(int maCaLamViec, String tenCaLamViec, LocalTime thoiGianBatDau, LocalTime thoiGianKetThuc) {
        setMaCaLamViec(maCaLamViec);
        setTenCaLamViec(tenCaLamViec);
        setThoiGianBatDau(thoiGianBatDau);
        setThoiGianKetThuc(thoiGianKetThuc);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.maCaLamViec;
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
        final CaLamViec other = (CaLamViec) obj;
        return this.maCaLamViec == other.maCaLamViec;
    }

    @Override
    public String toString() {
        return "CaLamViec{" + "maCaLamViec=" + maCaLamViec + ", tenCaLamViec=" + tenCaLamViec + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc + '}';
    }
}
