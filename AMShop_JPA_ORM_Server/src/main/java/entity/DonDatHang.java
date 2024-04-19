package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "DonDatHang")
@NamedQueries({
	@NamedQuery(name = "DonDatHang.getAllDonDatHang", query = "SELECT ddh FROM DonDatHang ddh"),
	@NamedQuery(name = "DonDatHang.getDonDatHangTheoMaDonDatHang", query = "SELECT ddh FROM DonDatHang ddh WHERE ddh.maDonDatHang =:maDonDatHang"),
	@NamedQuery(name = "DonDatHang.getDonDatHangCuoi", query = "SELECT ddh FROM DonDatHang ddh WHERE ddh.maDonDatHang = (SELECT MAX(ddh.maDonDatHang) FROM DonDatHang ddh WHERE ddh.maDonDatHang LIKE :prefix) ORDER BY ddh.maDonDatHang DESC")
})
public class DonDatHang implements Serializable {

	private static final long serialVersionUID = 3810553860496793695L;

	@Id
	@Column(name = "MaDonDatHang", columnDefinition = "nvarchar(12)", nullable = false)
	private String maDonDatHang;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaNhanVien")
	private NhanVien nhanVien;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaKhachHang")
	private KhachHang khachHang;
	
	@Column(name = "ThoiGianTao", columnDefinition = "datetime", nullable = false)
	private LocalDateTime thoiGianTao;
	
	@Column(name = "TrangThaiThanhToan", columnDefinition = "bit", nullable = false)
	private boolean trangThaiThanhToan;

}
