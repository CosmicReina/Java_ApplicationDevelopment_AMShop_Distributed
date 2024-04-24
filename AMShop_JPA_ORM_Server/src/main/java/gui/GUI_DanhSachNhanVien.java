package gui;


import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import configuration.ServiceInitiator;
import entity.NhanVien;

public class GUI_DanhSachNhanVien extends javax.swing.JPanel {
    
	private static final long serialVersionUID = 9129108097974058889L;
	
	private static GUI_DanhSachNhanVien instance = new GUI_DanhSachNhanVien();

    public static GUI_DanhSachNhanVien getInstance() {
        return instance;
    }
    
    public static GUI_DanhSachNhanVien newInstance() {
        instance = new GUI_DanhSachNhanVien();
        return instance;
    }

    public GUI_DanhSachNhanVien() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
    	try {
			updateTable(ServiceInitiator.getInstance().getServiceNhanVien().getAllNhanVien());
			tblTable.fixTable(scrTable);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
    }
    
    private void updateTable(List<NhanVien> list){
    	DefaultTableModel model = (DefaultTableModel) tblTable.getModel();
        model.getDataVector().removeAllElements();
        tblTable.revalidate();
        tblTable.repaint();
        for(NhanVien thisNhanVien : list){
            model.addRow(new Object[]{
                thisNhanVien.getMaNhanVien(),
                thisNhanVien.getHoTen(),
                thisNhanVien.getSoDienThoai(),
                thisNhanVien.getCanCuocCongDan(),
                thisNhanVien.getChucVu()
            });
        }
    }

    private void xemChiTietNhanVien(){
    	try {
			int i = tblTable.getSelectedRow();
			if(i < 0){
			    JOptionPane.showMessageDialog(null, "Vui lòng chọn một Nhân Viên.");
			    return;
			}
			String maNhanVien = tblTable.getValueAt(i, 0).toString();
			NhanVien nhanVien = ServiceInitiator.getInstance().getServiceNhanVien().getNhanVienTheoMaNhanVien(maNhanVien);
			
			GUI_Main.getInstance().showPanel(GUI_ChiTietNhanVien.newInstance());
			GUI_ChiTietNhanVien.getInstance().showChiTietNhanVien(nhanVien);
			GUI_ChiTietNhanVien.getInstance().setPnlBefore(this);
		} catch (HeadlessException | RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTimKiem = new javax.swing.JPanel();
        btnChiTiet = new extended_component.JButton_AllRound();
        pnlTable = new javax.swing.JPanel();
        scrTable = new javax.swing.JScrollPane();
        tblTable = new extended_component.JTable_LightMode();

        setLayout(new java.awt.BorderLayout());

        pnlTimKiem.setBackground(new java.awt.Color(68, 136, 255));
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Xem Chi Tiết", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiem.setPreferredSize(new java.awt.Dimension(300, 100));

        btnChiTiet.setText("Xem Chi Tiết Nhân Viên");
        btnChiTiet.setBorderRadius(30);
        btnChiTiet.setColorBackground(new java.awt.Color(170, 238, 255));
        btnChiTiet.setColorBorder(new java.awt.Color(255, 255, 255));
        btnChiTiet.setColorClick(new java.awt.Color(119, 204, 255));
        btnChiTiet.setColorEnter(new java.awt.Color(119, 238, 255));
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(pnlTimKiem, java.awt.BorderLayout.SOUTH);

        pnlTable.setLayout(new java.awt.BorderLayout());

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Căn Cước Công Dân", "Chức Vụ"
            }
        ));
        scrTable.setViewportView(tblTable);

        pnlTable.add(scrTable, java.awt.BorderLayout.CENTER);

        add(pnlTable, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
    	xemChiTietNhanVien();
    }//GEN-LAST:event_btnChiTietActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_component.JButton_AllRound btnChiTiet;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JScrollPane scrTable;
    private extended_component.JTable_LightMode tblTable;
    // End of variables declaration//GEN-END:variables

}
