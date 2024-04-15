package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "ChiTietPhanCong")
public class ChiTietPhanCong implements Serializable {

	private static final long serialVersionUID = 4899708714148214926L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaLichLamViec")
	private LichLamViec lichLamViec;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MaNhanVien")
	private NhanVien nhanVien;

	@Column(name = "ThoiGianVaoCa", columnDefinition = "datetime")
	private LocalDateTime thoiGianVaoCa;

	@Column(name = "ThoiGianRaCa", columnDefinition = "datetime")
	private LocalDateTime thoiGianRaCa;

}
