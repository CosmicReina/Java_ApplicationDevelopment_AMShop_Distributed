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
@Table(name = "DonDatHang")
public class DonDatHang implements Serializable {

	private static final long serialVersionUID = 3810553860496793695L;

	private String maDonDatHang;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private LocalDateTime thoiGianTao;
	private boolean trangThaiThanhToan;

}
