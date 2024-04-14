package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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

public class DonDatHang implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	private String maDonDatHang;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private LocalDateTime thoiGianTao;
	private boolean trangThaiThanhToan;
	
}
