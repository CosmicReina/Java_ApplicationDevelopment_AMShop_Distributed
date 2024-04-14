package entity;

import java.io.Serializable;

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

public class CuaHang implements Serializable {
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	private String maCuaHang;
	private String tenCuaHang;
	private String diaChi;
	private String soDienThoai;

}
