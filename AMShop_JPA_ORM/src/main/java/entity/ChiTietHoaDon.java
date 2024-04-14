package entity;

import java.io.Serializable;

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
@Table(name = "ChiTietHoaDon")

public class ChiTietHoaDon implements Serializable{

	private static final long serialVersionUID = 4899708714148214926L;
	
	
	@Column(name = "HoaDon")
	private HoaDon hoaDon;
	
	@Column(name = "QuanAo")
	private QuanAo quanAo;
	
	@Column(name = "SoLuong")
	private int soLuong;
	
	@Column(name = "DonGia")
	private double donGia;
	
}
