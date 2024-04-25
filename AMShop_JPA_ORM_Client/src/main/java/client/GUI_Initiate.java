package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import configuration.Configuration_Client;
import configuration.ServiceInitiator;
import gui.GUI_MainFrame;

public class GUI_Initiate {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {		
		Configuration_Client.setNhanVienHienTai(ServiceInitiator.getInstance().getServiceNhanVien().getNhanVienTheoMaNhanVien("NV12312312"));
		GUI_MainFrame gui_MainFrame = GUI_MainFrame.newInstance();
		gui_MainFrame.setVisible(true);
	}
	
}
