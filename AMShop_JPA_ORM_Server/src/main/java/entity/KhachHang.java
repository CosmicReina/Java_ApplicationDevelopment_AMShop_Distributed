package entity;

import java.io.Serializable;
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
public class KhachHang implements Serializable {
	
	private static final long serialVersionUID = -2722597617514255913L;
	
	private String maKhachHang;
	private String hoTen;
	private String soDienThoai;
	private String diaChi;
	private String nhomKhachHang;

}
