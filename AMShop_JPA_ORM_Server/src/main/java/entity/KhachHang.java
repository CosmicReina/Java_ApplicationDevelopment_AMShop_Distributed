package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "KhachHang")
@NamedQueries({
	@NamedQuery(name = "KhachHang.getAllKhachHang", query = "SELECT kh FROM KhachHang kh"),
	@NamedQuery(name = "KhachHang.getKhachHangTheoMaKhachHang", query = "SELECT kh FROM KhachHang kh WHERE kh.maKhachHang = :maKhachHang"),
	@NamedQuery(name = "KhachHang.getKhachHangTheoSoDienThoai", query = "SELECT kh FROM KhachHang kh WHERE kh.soDienThoai = :soDienThoai"),
	@NamedQuery(name = "KhachHang.getKhachHangCuoi", query = "SELECT kh FROM KhachHang kh WHERE kh.maKhachHang = (SELECT MAX(kh.maKhachHang) FROM KhachHang kh WHERE kh.maKhachHang LIKE :prefix) ORDER BY kh.maKhachHang")
})
public class KhachHang implements Serializable {
	
	private static final long serialVersionUID = -2722597617514255913L;
	
	@Id
	@Column(name = "MaKhachHang", columnDefinition = "nvarchar(10)", nullable = false)
	private String maKhachHang;
	
	@Column(name = "HoTen", columnDefinition = "nvarchar(64)", nullable = false)
	private String hoTen;
	
	@Column(name = "SoDienThoai", columnDefinition = "nvarchar(10)", nullable = false, unique = true)
	private String soDienThoai;
	
	@Column(name = "DiaChi", columnDefinition = "nvarchar(128)", nullable = false)
	private String diaChi;
	
	@Column(name = "NhomKhachHang", columnDefinition = "nvarchar(32)", nullable = false)
	private String nhomKhachHang;

}
