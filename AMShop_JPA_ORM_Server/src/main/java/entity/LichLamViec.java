package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@NamedQueries({@NamedQuery(name = "LichLamViec.getAllLichLamViec", query = "SELECT llv FROM LichLamViec llv ORDER BY llv.maLichLamViec DESC"),
		@NamedQuery(name = "LichLamViec.getLichLamViecTheoMaLichLamViec", query = "SELECT llv FROM LichLamViec llv WHERE llv.maLichLamViec =:maLichLamViec")})
public class LichLamViec implements Serializable {

	private static final long serialVersionUID = -1434004774413758052L;

	@Id
	@Column(name = "MaLichLamViec", columnDefinition = "nvarchar(9)", nullable = false)
	private String maLichLamViec;

	@Column(name = "NgayLamViec", columnDefinition = "date", nullable = false)
	private LocalDate ngayLamViec;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaCaLamViec")
	private CaLamViec caLamViec;

	public LichLamViec(String maLichLamViec, LocalDate ngayLamViec, CaLamViec caLamViec) {
		super();
		this.maLichLamViec = maLichLamViec;
		this.ngayLamViec = ngayLamViec;
		this.caLamViec = caLamViec;
	}

}
