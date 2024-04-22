package initiate_old;

import connect_old.ConnectDB;
import gui_old.GUI_DangNhap;

public class Initiate {
    public static void main(String[] args) {
//        ConnectDB.getInstance().connectDatabase();
        GUI_DangNhap gui = GUI_DangNhap.getInstance();
        gui.setVisible(true);
    }
}
