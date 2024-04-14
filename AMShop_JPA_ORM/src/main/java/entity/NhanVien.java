package entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class NhanVien implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
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
}
