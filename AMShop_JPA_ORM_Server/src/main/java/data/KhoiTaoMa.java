package data;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;

import configuration.ServiceInitiator;

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
			
			String maNhanVienCuoi = ServiceInitiator.getInstance().getServiceNhanVien().getNhanVienCuoi(prefix).getMaNhanVien();
			if(maNhanVienCuoi == null){
			    soNhanVien = 1;
			    maNhanVien = prefix + String.format("%02d", soNhanVien);
			}
			else{
			    soNhanVien = Integer.parseInt(maNhanVienCuoi.substring(8)) + 1;
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
			
			String maKhachHangCuoi = ServiceInitiator.getInstance().getServiceKhachHang().getKhachHangCuoi(prefix).getMaKhachHang();
			if(maKhachHangCuoi == null){
			    soKhachHang = 1;
			    maKhachHang = prefix + String.format("%06d", soKhachHang);
			}
			else{
			    soKhachHang = Integer.parseInt(maKhachHangCuoi.substring(4)) + 1;
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
			
			String maQuanAoCuoi = ServiceInitiator.getInstance().getServiceQuanAo().getQuanAoCuoi().getMaQuanAo();
			if(maQuanAoCuoi == null){
			    soQuanAo = 1;
			    maQuanAo = prefix + String.format("%06d", soQuanAo);
			}
			else{
			    soQuanAo = Integer.parseInt(maQuanAoCuoi.substring(2)) + 1;
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
			
			String maHoaDonCuoi = ServiceInitiator.getInstance().getServiceHoaDon().getHoaDonCuoi(prefix).getMaHoaDon();
			if(maHoaDonCuoi == null){
			    soHoaDon = 1;
			    maHoaDon = prefix + String.format("%04d", soHoaDon);
			}
			else{
			    soHoaDon = Integer.parseInt(maHoaDonCuoi.substring(8)) + 1;
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
			
			String maDonDatHangCuoi = ServiceInitiator.getInstance().getServiceDonDatHang().getDonDatHangCuoi(prefix).getMaDonDatHang();
			if(maDonDatHangCuoi == null){
			    soDonDatHang = 1;
			    maDonDatHang = prefix + String.format("%04d", soDonDatHang);
			}
			else{
			    soDonDatHang = Integer.parseInt(maDonDatHangCuoi.substring(8)) + 1;
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
