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

public class ChiTietPhanCong implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	private LichLamViec lichLamViec;
	private NhanVien nhanVien;
	private LocalDateTime thoiGianVaoCa;
	private LocalDateTime thoiGianRaCa;
	
}
