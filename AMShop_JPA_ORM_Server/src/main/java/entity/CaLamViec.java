package entity;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

	private static final long serialVersionUID = 4835084769831146647L;
	
	@Id
	@Column(name = "MaCaLamViec", columnDefinition = "int", nullable = false)
	private int maCaLamViec;
	
	@Column(name = "TenCaLamViec", columnDefinition = "nvarchar(16)", nullable = false)
	private String tenCaLamViec;
	
	@Column(name = "ThoiGianBatDau", columnDefinition = "time", nullable = false)
	private LocalTime gioBatDau;
	
	@Column(name = "ThoiGianKetThuc", columnDefinition = "time", nullable = false)
	private LocalTime gioKetThuc;

}
