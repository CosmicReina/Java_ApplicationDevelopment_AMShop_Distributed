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
@Table(name = "QuanAo")
@NamedQueries({
	@NamedQuery(name = "QuanAo.getAllQuanAo", query = "SELECT qa FROM QuanAo qa"),
	@NamedQuery(name = "QuanAo.getQuanAoTheoMaQuanAo", query = "SELECT qa FROM QuanAo qa WHERE qa.maQuanAo = :maQuanAo"),
	@NamedQuery(name = "QuanAo.getQuanAoCuoi", query = "SELECT qa FROM QuanAo qa WHERE qa.maQuanAo = (SELECT MAX(qa.maQuanAo) FROM QuanAo qa WHERE qa.maQuanAo LIKE :prefix ) ORDER BY qa.maQuanAo DESC")
})
public class QuanAo implements Serializable {
	
	private static final long serialVersionUID = 1874477133728963880L;
	
	@Id
	@Column(name = "MaQuanAo", columnDefinition = "nvarchar(8)", nullable = false)
	private String maQuanAo;
	
	@Column(name = "TenQuanAo", columnDefinition = "nvarchar(64)", nullable = false)
	private String tenQuanAo;
	
	@Column(name = "DonGiaNhap", columnDefinition = "decimal", nullable = false)
	private double donGiaNhap;
	
	@Column(name = "DonGiaBan", columnDefinition = "decimal", nullable = false)
	private double donGiaBan;
	
	@Column(name = "SoLuongTrongKho", columnDefinition = "int", nullable = false)
	private int soLuongTrongKho;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaNhaSanXuat", nullable = false)
	private NhaSanXuat nhaSanXuat;
	
	@Column(name = "DanhMuc", columnDefinition = "nvarchar(16)", nullable = false)
	private String danhMuc;
	
	@Column(name = "GioiTinh", columnDefinition = "nvarchar(8)", nullable = false)
	private String gioiTinh;
	
	@Column(name = "MauSac", columnDefinition = "nvarchar(8)", nullable = false)
	private String mauSac;
	
	@Column(name = "KichThuoc", columnDefinition = "nvarchar(8)", nullable = false)
	private String kichThuoc;
	
	@Column(name = "ChatLieu", columnDefinition = "nvarchar(32)", nullable = false)
	private String chatLieu;
	
	@ToString.Exclude
	@Column(name = "HinhAnh", columnDefinition = "varbinary(MAX)")
	private byte[] hinhAnh;
	
	@Column(name = "NgungNhap", columnDefinition = "bit", nullable = false)
	private boolean ngungNhap;

}
