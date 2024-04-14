package entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "LichLamViec")

public class LichLamViec implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	
	@Column(name = "MaCaLamViec")
	private String maCaLamViec;
	
	@Column(name = "NgayLamViec")
	private LocalDate ngayLamViec;
	
	@Column(name = "CaLamViec")
	private CaLamViec caLamViec;
	
}
