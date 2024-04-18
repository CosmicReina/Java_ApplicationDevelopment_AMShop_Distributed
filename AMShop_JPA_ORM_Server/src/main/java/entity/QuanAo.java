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
@Table(name = "QuanAo")
public class QuanAo implements Serializable {
	
	private static final long serialVersionUID = 1874477133728963880L;
	
	private String maQuanAo;
	private String tenQuanAo;
	private double donGiaNhap;
	private double donGiaBan;
	private int soLuongTrongKho;
	private NhaSanXuat nhaSanXuat;
	private String danhMuc;
	private String gioiTinh;
	private String mauSac;
	private String kichThuoc;
	private String chatLieu;
	private byte[] hinhAnh;
	private boolean ngungNhap;

}
