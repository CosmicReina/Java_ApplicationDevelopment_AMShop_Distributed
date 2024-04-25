package configuration;

import java.util.ArrayList;
import java.util.List;

public class Configuration_QuanAo {
	private static List<String> listDanhMuc = new ArrayList<String>() {

		private static final long serialVersionUID = 6167907392277776504L;
		{
			add("Danh Mục");
			add("Áo Khoác");
			add("Áo sơ mi");
			add("Áo Thun");
			add("Quần");
			add("Vải Chiffon");
			add("Vải Cotton");
			add("Vải Kate");
			add("Vải Lụa");
			add("Vải nỉ");
			add("Váy");
		}

	};

	public static List<String> getListDanhMuc() {
		return listDanhMuc;
	}

	private static List<String> listChatLieu = new ArrayList<String>() {

		private static final long serialVersionUID = 6797701772006154252L;

		{
			add("Chất Liệu");
			add("Gấm");
			add("Thun");
			add("Vải Chiffon");
			add("Vải Cotton");
			add("Vải Jean");
			add("Vải Kaki");
			add("Vải Kate");
			add("Vải Lụa");
			add("Vải Nỉ");
			add("Vải thường");
			add("Vải trơn ");
		}

	};

	public static List<String> getListChatLieu() {
		return listChatLieu;
	}

	private static List<String> listGioiTinh = new ArrayList<String>() {

		private static final long serialVersionUID = 6797701772006154252L;

		{
			add("Giới Tính");
			add("Chung");
			add("Nam");
			add("Nữ");
		}

	};

	public static List<String> getListGioiTinh() {
		return listGioiTinh;
	}

	private static List<String> listMauSac = new ArrayList<String>() {

		private static final long serialVersionUID = -6047793005848948172L;

		{
			add("Màu Sắc");
			add("Cam");
			add("Đen");
			add("Đỏ");
			add("Khác");
			add("Lam");
			add("Lục");
			add("Tím");
			add("Trắng");
			add("Vàng");
			add("Xám");
		}

	};

	public static List<String> getListMauSac() {
		return listMauSac;
	}

	private static List<String> listKichThuoc = new ArrayList<String>() {

		private static final long serialVersionUID = -5337075727158479976L;

		{
			add("Kích Thước");
			add("L");
			add("M");
			add("S");
			add("XL");
			add("XS");
			add("XXL");
			add("XXXL");
		}

	};
	
	public static List<String> getListKichThuoc() {
		return listKichThuoc;
	}
	
}
