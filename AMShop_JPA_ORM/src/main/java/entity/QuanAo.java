package entity;

import java.io.Serializable;

import javax.swing.ImageIcon;

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
@Table(name = "QuanAo")

public class QuanAo implements Serializable{
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	
	@Column(name = "MaQuanAo")
	private String maQuanAo;
	
	@Column(name = "TenQuanAo")
	private String tenQuanAo;
	
	@Column(name = "DonGiaNhap")
	private double donGiaNhap;
	
	@Column(name = "DonGiaBan")
	private double donGiaBan;
	
	@Column(name = "SoLuongTrongKho")
	private int soLuongTrongKho;
	
	@Column(name = "NhaSanXuat")
	private NhaSanXuat nhaSanXuat;
	
	@Column(name = "DanhMuc")
	private DanhMuc danhMuc;
	
	@Column(name = "GioiTinh")
	private String gioiTinh;
	
	@Column(name = "MauSac")
	private String mauSac;
	
	@Column(name = "KichThuoc")
	private String kichThuoc;
	
	@Column(name = "ChatLieu")
	private ChatLieu chatLieu;
	
	@Column(name = "HinhAnh")
	private ImageIcon hinhAnh;
	
	@Column(name = "NgungNhap")
	private boolean ngungNhap;

}
