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

public class ChiTietDonDatHang implements Serializable {

	private static final long serialVersionUID = 4899708714148214926L;
	
	private DonDatHang donDatHang;
	private QuanAo quanAo;
	private int soLuong;
}
