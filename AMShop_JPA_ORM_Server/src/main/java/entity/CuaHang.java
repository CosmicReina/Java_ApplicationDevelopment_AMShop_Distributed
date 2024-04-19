package entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "CuaHang")
@NamedQueries({
	@NamedQuery(name = "CuaHang.getCuaHang", query = "SELECT ch FROM CuaHang ch WHERE ch.maCuaHang =:maCuaHang")
})
public class CuaHang implements Serializable {

	private static final long serialVersionUID = 3283889400655708372L;
	
	@Id
	@Column(name = "MaCuaHang", columnDefinition = "nvarchar(16)", nullable = false)
	private String maCuaHang;
	
	@Column(name = "TenCuaHang", columnDefinition = "nvarchar(64)", nullable = false)
	private String tenCuaHang;
	
	@Column(name = "SoDienThoai", columnDefinition = "nvarchar(10)", nullable = false)
	private String soDienThoai;
	
	@Column(name = "DiaChi", columnDefinition = "nvarchar(128)", nullable = false)
	private String diaChi;

}
