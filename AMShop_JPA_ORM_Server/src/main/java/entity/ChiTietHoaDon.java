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
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDon implements Serializable {
	
	private static final long serialVersionUID = 981997143910971196L;
	
	private HoaDon hoaDon;
	private QuanAo quanAo;
	private int soLuong;
	private double donGia;

}
