package entity;

public class CuaHang {
    private String maCuaHang;
    private String tenCuaHang;
    private String soDienThoai;
    private String diaChi;

    public String getMaCuaHang() {
        return maCuaHang;
    }

    public void setMaCuaHang(String maCuaHang) {
        try {
            if(maCuaHang.isBlank())
                throw new Exception("Mã Cửa Hàng không hợp lệ");
            this.maCuaHang = maCuaHang;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    public String getTenCuaHang() {
        return tenCuaHang;
    }

    public void setTenCuaHang(String tenCuaHang) {
        try {
            if(tenCuaHang.isBlank())
                throw new Exception("Tên Cửa Hàng không hợp lệ");
            this.tenCuaHang = tenCuaHang;
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

    public CuaHang() {}

    public CuaHang(String maCuaHang, String tenCuaHang, String soDienThoai, String diaChi) {
        setMaCuaHang(maCuaHang);
        setTenCuaHang(tenCuaHang);
        setSoDienThoai(soDienThoai);
        setDiaChi(diaChi);
    }

    @Override
    public String toString() {
        return "CuaHang{" + "maCuaHang=" + maCuaHang + ", tenCuaHang=" + tenCuaHang + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + '}';
    }
}
