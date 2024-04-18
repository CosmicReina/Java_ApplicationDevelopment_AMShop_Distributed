package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "HoaDon")
public class HoaDon implements Serializable {
	
	private static final long serialVersionUID = -3005357045012742305L;
	
	private String maHoaDon;
	private CuaHang cuaHang;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private double tienKhachDua;
	private LocalDateTime thoiGianTao;

}
