package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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

@Entity
@Table(name = "NhanVien")

public class NhanVien implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	
	@Column(name = "MaNhanVien")
	private String maNhanVien;
	
	@Column(name = "HoTen")
    private String hoTen;
	
	@Column(name = "SoDienThoai")
    private String soDienThoai;
	
	@Column(name = "DiaChi")
    private String diaChi;
	
	@Column(name = "ChucVu")
    private String chucVu;
	
	@Column(name = "NgaySinh")
    private LocalDate ngaySinh;
	
	@Column(name = "CanCuocCongDan")
    private String canCuocCongDan;
	
	@Column(name = "GioiTinh")
    private String gioiTinh;
	
	@Column(name = "NgayBatDayLam")
    private LocalDate ngayBatDauLam;
	
	@Column(name = "NgayKetThucLam")
    private LocalDate ngayKetThucLam;
	
	@Column(name = "Luong")
    private double luong;
	
	@Column(name = "TenDangNhap")
    private String tenDangNhap;
	
	@Column(name = "MatKhau")
    private String matKhau;
    
}
