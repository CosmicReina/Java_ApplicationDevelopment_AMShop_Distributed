package data;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;

import configuration.ServiceInitiator;
import entity.DonDatHang;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.QuanAo;

public class KhoiTaoMa {
    public static String generateMaNhanVien(){
        try {
			String maNhanVien;
			int soNhanVien;
			
			LocalDate localDate = LocalDate.now();
			String year = Integer.toString(localDate.getYear()).substring(2);
			String month = String.format("%02d", localDate.getMonth().getValue());
			String day = String.format("%02d", localDate.getDayOfMonth());
			
			String prefix = "NV" + year + month + day;
			System.out.println(prefix);
			
			NhanVien nhanVienCuoi = ServiceInitiator.getInstance().getServiceNhanVien().getNhanVienCuoi(prefix);
			if(nhanVienCuoi == null){
			    soNhanVien = 1;
			    maNhanVien = prefix + String.format("%02d", soNhanVien);
			}
			else{
			    soNhanVien = Integer.parseInt(nhanVienCuoi.getMaNhanVien().substring(8)) + 1;
			    maNhanVien = prefix + String.format("%02d", soNhanVien);
			}
			return maNhanVien;
		} catch (NumberFormatException | RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static String generateMaKhachHang(){
        try {
			String maKhachHang;
			int soKhachHang;
			
			LocalDate localDate = LocalDate.now();
			String year = Integer.toString(localDate.getYear()).substring(2);
			
			String prefix = "KH" + year;
			
			KhachHang khachHangCuoi = ServiceInitiator.getInstance().getServiceKhachHang().getKhachHangCuoi(prefix);
			if(khachHangCuoi == null){
			    soKhachHang = 1;
			    maKhachHang = prefix + String.format("%06d", soKhachHang);
			}
			else{
			    soKhachHang = Integer.parseInt(khachHangCuoi.getMaKhachHang().substring(4)) + 1;
			    maKhachHang = prefix + String.format("%06d", soKhachHang);
			}
			return maKhachHang;
		} catch (NumberFormatException | RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static String generateMaQuanAo(){
        try {
			String maQuanAo;
			int soQuanAo;
			
			String prefix = "QA";
			
			QuanAo quanAoCuoi = ServiceInitiator.getInstance().getServiceQuanAo().getQuanAoCuoi();
			if(quanAoCuoi == null){
			    soQuanAo = 1;
			    maQuanAo = prefix + String.format("%06d", soQuanAo);
			}
			else{
			    soQuanAo = Integer.parseInt(quanAoCuoi.getMaQuanAo().substring(2)) + 1;
			    maQuanAo = prefix + String.format("%06d", soQuanAo);
			}
			return maQuanAo;
		} catch (NumberFormatException | RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static String generateMaHoaDon(){
        try {
			String maHoaDon;
			int soHoaDon;
			
			LocalDate localDate = LocalDate.now();
			String year = Integer.toString(localDate.getYear()).substring(2);
			String month = String.format("%02d", localDate.getMonth().getValue());
			String day = String.format("%02d", localDate.getDayOfMonth());
			
			String prefix = "HD" + year + month + day;
			
			HoaDon hoaDon = ServiceInitiator.getInstance().getServiceHoaDon().getHoaDonCuoi(prefix);
			if(hoaDon == null){
			    soHoaDon = 1;
			    maHoaDon = prefix + String.format("%04d", soHoaDon);
			}
			else{
			    soHoaDon = Integer.parseInt(hoaDon.getMaHoaDon().substring(8)) + 1;
			    maHoaDon = prefix + String.format("%04d", soHoaDon);
			}
			return maHoaDon;
		} catch (NumberFormatException | RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static String generateMaDonDatHang(){
        try {
			String maDonDatHang;
			int soDonDatHang;
			
			LocalDate localDate = LocalDate.now();
			String year = Integer.toString(localDate.getYear()).substring(2);
			String month = String.format("%02d", localDate.getMonth().getValue());
			String day = String.format("%02d", localDate.getDayOfMonth());
			
			String prefix = "DD" + year + month + day;
			
			DonDatHang donDatHang = ServiceInitiator.getInstance().getServiceDonDatHang().getDonDatHangCuoi(prefix);
			if(donDatHang == null){
			    soDonDatHang = 1;
			    maDonDatHang = prefix + String.format("%04d", soDonDatHang);
			}
			else{
			    soDonDatHang = Integer.parseInt(donDatHang.getMaDonDatHang().substring(8)) + 1;
			    maDonDatHang = prefix + String.format("%04d", soDonDatHang);
			}
			return maDonDatHang;
		} catch (NumberFormatException | RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public static String generateMaLichLamViec(LocalDate localDate, String caLamViec){
        String maLichLamViec;
        
        String year = Integer.toString(localDate.getYear()).substring(2);
        String month = String.format("%02d", localDate.getMonth().getValue());
        String day = String.format("%02d", localDate.getDayOfMonth());
        
        maLichLamViec = "LH" + year + month + day + caLamViec;
        
        return maLichLamViec;
    }
}
