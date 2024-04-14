package entity;

import java.io.Serializable;
import java.time.LocalDate;

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

public class LichLamViec implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	private String maCaLamViec;
	private LocalDate ngayLamViec;
	private CaLamViec caLamViec;
	
}
