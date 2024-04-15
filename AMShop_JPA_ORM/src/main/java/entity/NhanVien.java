package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

	@Id
	@Column(name = "MaNhanVien", columnDefinition = "nvarchar(10)", nullable = false)
	private String maNhanVien;

	@Column(name = "HoTen", columnDefinition = "nvarchar(64)", nullable = false)
	private String hoTen;

	@Column(name = "SoDienThoai", columnDefinition = "nvarchar(10)", nullable = false)
	private String soDienThoai;

	@Column(name = "DiaChi", columnDefinition = "nvarchar(128)", nullable = false)
	private String diaChi;

	@Column(name = "ChucVu", columnDefinition = "nvarchar(32)", nullable = false)
	private String chucVu;

	@Column(name = "CanCuocCongDan", columnDefinition = "nvarchar(12)", nullable = false)
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

}
