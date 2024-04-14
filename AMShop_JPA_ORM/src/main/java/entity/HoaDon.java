package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "HoaDon")

public class HoaDon implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	
	@Column(name = "MaHoaDon")
	private String maHoaDon;
	
	@Column(name = "CuaHang")
	private CuaHang cuaHang;
	
	@Column(name = "NhanVien")
	private NhanVien nhanVien;
	
	@Column(name = "KhachHang")
	private KhachHang khachHang;
	
	@Column(name = "ThoiGianTao")
	private LocalDateTime thoiGianTao;
	
}
