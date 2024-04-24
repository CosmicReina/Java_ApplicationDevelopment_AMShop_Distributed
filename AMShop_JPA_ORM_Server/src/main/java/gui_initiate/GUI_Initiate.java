package gui_initiate;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import configuration.Configuration_Client;
import configuration.ServiceInitiator;
import gui.GUI_DangNhap;
import gui.GUI_MainFrame;

@SuppressWarnings("unused")
public class GUI_Initiate {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
//		GUI_DangNhap gui_DangNhap = GUI_DangNhap.getInstance();
//		gui_DangNhap.setVisible(true);
		
		Configuration_Client.setNhanVienHienTai(ServiceInitiator.getInstance().getServiceNhanVien().getNhanVienTheoMaNhanVien("NV12312312"));
		GUI_MainFrame gui_MainFrame = GUI_MainFrame.newInstance();
		gui_MainFrame.setVisible(true);
	}
	
}
