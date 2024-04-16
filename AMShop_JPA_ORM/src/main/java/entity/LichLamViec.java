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
@NamedQueries({
	@NamedQuery(name = "LichLamViec.getAllLichLamViec", query = "SELECT llv FROM LichLamViec llv"),
	@NamedQuery(name = "LichLamViec.getLichLamViecTheoMaLichLamViec", query = "SELECT llv FROM LichLamViec llv WHERE llv.maLichLamViec =:maLichLamViec")
})
public class LichLamViec implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	@Id
	@Column(name = "MaLichLamViec", columnDefinition = "nvarchar(9)", nullable = false)
	private String maLichLamViec;
	
	@Column(name = "NgayLamViec", columnDefinition = "date", nullable = false)
	private LocalDate ngayLamViec;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaCaLamViec")
	private CaLamViec caLamViec;
	
}
