package entity;

import java.io.Serializable;
import java.time.LocalTime;

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

	private static final long serialVersionUID = 4835084769831146647L;

	private String maCaLamViec;
	private String tenCaLamViec;
	private LocalTime gioBatDau;
	private LocalTime gioKetThuc;

}
