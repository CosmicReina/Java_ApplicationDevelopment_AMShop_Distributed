package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

//	MaLichLamViec nvarchar(9) NOT NULL,
//	NgayLamViec date,
//	MaCaLamViec int NOT NULL
	
	@Id
	@Column(name = "MaLichLamViec", columnDefinition = "nvarchar(9)", nullable = false)
	private String maLichLamViec;
	
	@Column(name = "NgayLamViec", columnDefinition = "date", nullable = false)
	private LocalDate ngayLamViec;
	
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaCaLamViec")
	private CaLamViec caLamViec;

}
