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
@Table(name = "KhachHang")

public class KhachHang implements Serializable{
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	
	@Column(name = "MaKhachHang")
	private String maKhachHang;
	
	@Column(name = "HoTen")
    private String hoTen;
	
	@Column(name = "SoDienThoai")
    private String soDienThoai;
	
	@Column(name = "DiaChi")
    private String diaChi;
	
	@Column(name = "nhomKhachHang")
    private String nhomKhachHang;
    
}
