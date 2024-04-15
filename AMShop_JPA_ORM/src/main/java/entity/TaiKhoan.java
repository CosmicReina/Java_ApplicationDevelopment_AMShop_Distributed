package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "TaiKhoan")
public class TaiKhoan implements Serializable {

	private static final long serialVersionUID = -1628089611505215948L;

	@Id
	@OneToOne
	@JoinColumn(name = "MaNhanVien", columnDefinition = "nvarchar(10)", nullable = false)
	private NhanVien nhanVien;

	@Column(name = "TenDangNhap", columnDefinition = "nvarchar(10)", nullable = false)
	private String tenDangNhap;

	@Column(name = "MatKhau", columnDefinition = "nvarchar(32)", nullable = false)
	private String matKhau;

}
