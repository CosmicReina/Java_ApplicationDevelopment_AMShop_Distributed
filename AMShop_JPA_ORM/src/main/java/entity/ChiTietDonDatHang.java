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
@Table(name = "ChiTietDonDatHang")

public class ChiTietDonDatHang implements Serializable {

	private static final long serialVersionUID = 4899708714148214926L;
	
	
	@Column(name = "DonDatHang")
	private DonDatHang donDatHang;
	
	@Column(name = "QuanAo")
	private QuanAo quanAo;
	
	@Column(name = "SoLuong")
	private int soLuong;
	
}
