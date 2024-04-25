package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@NamedQueries({@NamedQuery(name = "NhanVien.getAllNhanVien", query = "SELECT nv FROM NhanVien nv"),
		@NamedQuery(name = "NhanVien.getNhanVienTheoMaNhanVien", query = "SELECT nv FROM NhanVien nv WHERE nv.maNhanVien =:maNhanVien"),
		@NamedQuery(name = "NhanVien.getNhanVienTheoSoDienThoai", query = "SELECT nv FROM NhanVien nv WHERE nv.soDienThoai =:soDienThoai"),
		@NamedQuery(name = "NhanVien.getNhanVienTheoCanCuocCongDan", query = "SELECT nv FROM NhanVien nv WHERE nv.canCuocCongDan =:canCuocCongDan"),
		@NamedQuery(name = "NhanVien.getDanhSachNhanVienChuaCoTrongNgayLamViec", query = "SELECT nv FROM NhanVien nv WHERE nv.maNhanVien NOT IN ( SELECT c.nhanVien.maNhanVien FROM ChiTietPhanCong c WHERE c.lichLamViec.ngayLamViec =:ngayLamViec)"),
		@NamedQuery(name = "NhanVien.getNhanVienCuoi", query = "SELECT nv FROM NhanVien nv WHERE nv.maNhanVien = (SELECT MAX(nv.maNhanVien) FROM NhanVien nv WHERE nv.maNhanVien LIKE :prefix ) ORDER BY nv.maNhanVien DESC"),
		@NamedQuery(name = "NhanVien.getNhanVienTheoThongTinDangNhap", query = "SELECT nv FROM NhanVien nv WHERE nv.maNhanVien =:maNhanVien AND nv.matKhau =:matKhau"),})
@NamedNativeQueries({
		@NamedNativeQuery(name = "NhanVien.getTongThoiGianLamViecTheoThang", query = 
		"SELECT MaNhanVien, SUM(DATEDIFF(SECOND, '00:00:00', CONVERT(DATETIME, ThoiGianRaCa - ThoiGianVaoCa))) AS TotalSeconds "
				+ "FROM LichLamViec L JOIN ChiTietPhanCong CT ON L.MaLichLamViec = CT.MaLichLamViec "
				+ "WHERE YEAR(NgayLamViec) = :year AND MONTH(NgayLamViec) = :month " + "GROUP BY MaNhanVien")})
public class NhanVien implements Serializable {

	private static final long serialVersionUID = -105740186557329773L;

	@Id
	@Column(name = "MaNhanVien", columnDefinition = "nvarchar(10)", nullable = false)
	private String maNhanVien;

	@Column(name = "HoTen", columnDefinition = "nvarchar(64)", nullable = false)
	private String hoTen;

	@Column(name = "SoDienThoai", columnDefinition = "nvarchar(10)", nullable = false, unique = true)
	private String soDienThoai;

	@Column(name = "DiaChi", columnDefinition = "nvarchar(128)", nullable = false)
	private String diaChi;

	@Column(name = "ChucVu", columnDefinition = "nvarchar(32)", nullable = false)
	private String chucVu;

	@Column(name = "CanCuocCongDan", columnDefinition = "nvarchar(12)", nullable = false, unique = true)
	private String canCuocCongDan;

	@Column(name = "GioiTinh", columnDefinition = "nvarchar(8)", nullable = false)
	private String gioiTinh;

	@Column(name = "NgaySinh", columnDefinition = "date", nullable = false)
	private LocalDate ngaySinh;

	@Column(name = "NgayBatDauLam", columnDefinition = "date", nullable = false)
	private LocalDate ngayBatDauLam;

	@Column(name = "NgayKetThucLam", columnDefinition = "date")
	private LocalDate ngayKetThucLam;

	@Column(name = "Luong", columnDefinition = "decimal", nullable = false)
	private double luong;

	@Column(name = "MatKhau", columnDefinition = "nvarchar(32)", nullable = false)
	private String matKhau;

	public NhanVien(String maNhanVien, String hoTen, String soDienThoai, String diaChi, String chucVu,
			String canCuocCongDan, String gioiTinh, LocalDate ngaySinh, LocalDate ngayBatDauLam,
			LocalDate ngayKetThucLam, double luong, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.canCuocCongDan = canCuocCongDan;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.ngayBatDauLam = ngayBatDauLam;
		this.ngayKetThucLam = ngayKetThucLam;
		this.luong = luong;
		this.matKhau = matKhau;
	}

}
