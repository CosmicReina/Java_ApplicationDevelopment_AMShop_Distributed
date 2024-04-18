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
@Table(name = "ChiTietDonDatHang")
public class ChiTietDonDatHang implements Serializable {
	
	private static final long serialVersionUID = -4562237941463187542L;
	
	private DonDatHang donDatHang;
	private QuanAo quanAo;
	private int soLuong;

}
