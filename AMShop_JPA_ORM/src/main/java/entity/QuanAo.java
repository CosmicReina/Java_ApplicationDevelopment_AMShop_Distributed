package entity;

import java.io.Serializable;

import javax.swing.ImageIcon;

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

public class QuanAo implements Serializable{
	
	private static final long serialVersionUID = 4899708714148214926L;
	
	private String maQuanAo;
	private String tenQuanAo;
	private double donGiaNhap;
	private double donGiaBan;
	private int soLuongTrongKho;
	private String nhaSanXuat;
	private String danhMuc;
	private String gioiTinh;
	private String mauSac;
	private String kichThuoc;
	private String chatLieu;
	private ImageIcon hinhAnh;
	private boolean ngungNhap;

}
