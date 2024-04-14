package entity;

import java.io.Serializable;
import java.time.LocalTime;

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

public class CaLamViec implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	private String maCaLamViec;
	private String tenCaLamViec;
	private LocalTime thoiGianBatDau;
	private LocalTime thoiGianKetThuc;
	
}
