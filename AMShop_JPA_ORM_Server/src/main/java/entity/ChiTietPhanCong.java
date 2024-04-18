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
@Table(name = "ChiTietPhanCong")
public class ChiTietPhanCong implements Serializable {
	
	private static final long serialVersionUID = 3976431803293809833L;
	
	private LichLamViec lichLamViec;
	private NhanVien nhanVien;
	private LocalDateTime thoiGianVaoCa;
	private LocalDateTime thoiGianRaCa;

}
