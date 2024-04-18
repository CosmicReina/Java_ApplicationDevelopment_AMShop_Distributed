package entity;

import java.io.Serializable;

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
@Table(name = "KhachHang")
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
