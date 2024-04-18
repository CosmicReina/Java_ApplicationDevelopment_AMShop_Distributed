package entity;

import java.io.Serializable;

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
@Table(name = "CuaHang")
public class CuaHang implements Serializable {

	private static final long serialVersionUID = 3283889400655708372L;
	
	private String maCuaHang;
	private String tenCuaHang;
	private String soDienThoai;
	private String diaChi;

}
