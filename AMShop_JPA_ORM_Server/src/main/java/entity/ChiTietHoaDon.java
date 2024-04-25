package entity;

import java.io.Serializable;

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
@Table(name = "ChiTietHoaDon")
@NamedQueries({
	@NamedQuery(name = "ChiTietHoaDon.getAllChiTietHoaDonTheoMaHoaDon", query = "SELECT cthd FROM ChiTietHoaDon cthd WHERE cthd.hoaDon.maHoaDon = :maHoaDon")
})
public class ChiTietHoaDon implements Serializable {
	
	private static final long serialVersionUID = 981997143910971196L;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaHoaDon")
	private HoaDon hoaDon;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaQuanAo")
	private QuanAo quanAo;
	
	@Column(name = "SoLuong", columnDefinition = "int", nullable = false)
	private int soLuong;
	
	@Column(name = "DonGia", columnDefinition = "decimal", nullable = false)
	private double donGia;

	public ChiTietHoaDon(HoaDon hoaDon, QuanAo quanAo, int soLuong, double donGia) {
		super();
		this.hoaDon = hoaDon;
		this.quanAo = quanAo;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

}
