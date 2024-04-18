package entity;

import java.io.Serializable;
import java.time.LocalDate;

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

	private static final long serialVersionUID = -1434004774413758052L;

	private String maLichLamViec;
	private LocalDate ngayLamViec;
	private CaLamViec caLamViec;

}
