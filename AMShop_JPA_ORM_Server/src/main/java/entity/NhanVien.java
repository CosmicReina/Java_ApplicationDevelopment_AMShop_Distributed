package entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
	
	private static final long serialVersionUID = -105740186557329773L;
	
	private String maNhanVien;
	private String hoTen;
	private String soDienThoai;
	private String diaChi;
	private String chucVu;
	private String canCuocCongDan;
	private String gioiTinh;
	private LocalDate ngaySinh;
	private LocalDate ngayBatDauLam;
	private LocalDate ngayKetThucLam;
	private double luong;
	private String matKhau;
	

}
