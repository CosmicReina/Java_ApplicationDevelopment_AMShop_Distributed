package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@Id
	@Column(name = "MaHoaDon")
	private String maHoaDon;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaCuaHang")
	private CuaHang cuaHang;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaNhanVien")
	private NhanVien nhanVien;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaKhachHang")
	private KhachHang khachHang;

	@Column(name = "TienKhachDua", columnDefinition = "decimal", nullable = false)
	private double tienKhachDua;

	@Column(name = "ThoiGianTao", columnDefinition = "datetime", nullable = false)
	private LocalDateTime thoiGianTao;

}
