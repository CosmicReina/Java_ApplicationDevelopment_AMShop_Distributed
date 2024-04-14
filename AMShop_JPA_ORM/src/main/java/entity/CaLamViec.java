package entity;

import java.io.Serializable;
import java.time.LocalTime;

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
@Table(name = "CaLamViec")

public class CaLamViec implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	
	@Column(name = "MaCaLamViec")
	private String maCaLamViec;
	
	@Column(name = "TenCaLamViec")
	private String tenCaLamViec;
	
	@Column(name = "ThoiGianBatDau")
	private LocalTime thoiGianBatDau;
	
	@Column(name = "ThoiGianKetThuc")
	private LocalTime thoiGianKetThuc;
	
}
