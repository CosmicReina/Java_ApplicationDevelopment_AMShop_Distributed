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
@Table(name = "ChiTietDonDatHang")
@NamedQueries({
	@NamedQuery(name = "ChiTietDonDatHang.getAllChiTietDonDatHangTheoMaDonDatHang", query = "SELECT ctddh FROM ChiTietDonDatHang ctddh WHERE ctddh.donDatHang.maDonDatHang = :maDonDatHang")
})
public class ChiTietDonDatHang implements Serializable {
	
	private static final long serialVersionUID = -4562237941463187542L;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaDonDatHang")
	private DonDatHang donDatHang;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaQuanAo")
	private QuanAo quanAo;
	
	@Column(name = "SoLuong", columnDefinition = "int", nullable = false)
	private int soLuong;

	public ChiTietDonDatHang(DonDatHang donDatHang, QuanAo quanAo, int soLuong) {
		super();
		this.donDatHang = donDatHang;
		this.quanAo = quanAo;
		this.soLuong = soLuong;
	}

}
