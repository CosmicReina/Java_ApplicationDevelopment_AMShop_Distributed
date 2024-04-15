package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "NhaSanXuat")
public class NhaSanXuat implements Serializable {

	private static final long serialVersionUID = 4899708714148214926L;

	@Id
	@Column(name = "MaNhaSanXuat", columnDefinition = "int", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNhaSanXuat;

	@Column(name = "TenNhaSanXuat", columnDefinition = "nvarchar(64)", nullable = false)
	private String tenNhaSanXuat;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "nhaSanXuat")
	private List<QuanAo> listQuanAo;

}
