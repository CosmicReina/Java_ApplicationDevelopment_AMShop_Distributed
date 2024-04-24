package gui;


import entity.KhachHang;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import configuration.ServiceInitiator;
import data.UtilityJTextField;

public class GUI_TimKiemKhachHang extends javax.swing.JPanel {
    
	private static final long serialVersionUID = 638559583448403109L;
	
	private static GUI_TimKiemKhachHang instance = new GUI_TimKiemKhachHang();

    public static GUI_TimKiemKhachHang getInstance() {
        return instance;
    }
    
    public static GUI_TimKiemKhachHang newInstance() {
        instance = new GUI_TimKiemKhachHang();
        return instance;
    }

    public GUI_TimKiemKhachHang() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
    	try {
			hienThiBang(ServiceInitiator.getInstance().getServiceKhachHang().getAllKhachHang());
			UtilityJTextField.addPlaceHolderStyle(txtSoDienThoai);
			tblDanhSachKhachHang.fixTable(scrTable);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
    }
    
    private void hienThiBang(List<KhachHang> list){
    	DefaultTableModel model = (DefaultTableModel) tblDanhSachKhachHang.getModel();
        model.getDataVector().removeAllElements();
        tblDanhSachKhachHang.revalidate();
        tblDanhSachKhachHang.repaint();
        for(KhachHang thisKhachHang : list){
            model.addRow(new Object[]{
                thisKhachHang.getMaKhachHang(),
                thisKhachHang.getHoTen(),
                thisKhachHang.getSoDienThoai(),
                thisKhachHang.getDiaChi(),
                thisKhachHang.getNhomKhachHang()
            });
        }
    }
    
    private void timKiemTheoSoDienThoai(){
    	try {
			String soDienThoai = txtSoDienThoai.getText();
			
			List<KhachHang> list = ServiceInitiator.getInstance().getServiceKhachHang().getAllKhachHang();
			List<KhachHang> listRemove = new ArrayList<>();
			
			if(!soDienThoai.equals("")){
			    for(KhachHang thisKhachHang : list){
			        if(!thisKhachHang.getSoDienThoai().equals(soDienThoai))
			            listRemove.add(thisKhachHang);
			    }
			}
			
			list.removeAll(listRemove);
			hienThiBang(list);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
    }

    private void xemChiTietKhachHang(){
    	int i = tblDanhSachKhachHang.getSelectedRow();
        if(i < 0){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một Khách Hàng.");
            return;
        }
        String maKhachHang = tblDanhSachKhachHang.getValueAt(i, 0).toString();
        
        GUI_Main.getInstance().showPanel(GUI_ChiTietKhachHang.newInstance());
        GUI_ChiTietKhachHang.getInstance().showThongTinKhachHang(maKhachHang);
        GUI_ChiTietKhachHang.getInstance().setPnlBefore(this);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTimKiem = new javax.swing.JPanel();
        txtSoDienThoai = new extended_component.JTextField_AllRound();
        btnTimKiem = new extended_component.JButton_AllRound();
        btnLamMoi = new extended_component.JButton_AllRound();
        btnChiTiet = new extended_component.JButton_AllRound();
        pnlTable = new javax.swing.JPanel();
        scrTable = new javax.swing.JScrollPane();
        tblDanhSachKhachHang = new extended_component.JTable_LightMode();

        setLayout(new java.awt.BorderLayout());

        pnlTimKiem.setBackground(new java.awt.Color(68, 136, 255));
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiem.setPreferredSize(new java.awt.Dimension(300, 700));

        txtSoDienThoai.setText("Số Điện Thoại");
        txtSoDienThoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDienThoaiFocusLost(evt);
            }
        });

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setBorderRadius(30);
        btnTimKiem.setColorBackground(new java.awt.Color(170, 238, 255));
        btnTimKiem.setColorBorder(new java.awt.Color(255, 255, 255));
        btnTimKiem.setColorClick(new java.awt.Color(119, 204, 255));
        btnTimKiem.setColorEnter(new java.awt.Color(119, 238, 255));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setBorderRadius(30);
        btnLamMoi.setColorBackground(new java.awt.Color(170, 238, 255));
        btnLamMoi.setColorBorder(new java.awt.Color(255, 255, 255));
        btnLamMoi.setColorClick(new java.awt.Color(119, 204, 255));
        btnLamMoi.setColorEnter(new java.awt.Color(119, 238, 255));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnChiTiet.setText("Xem Chi Tiết Khách Hàng");
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
            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 476, Short.MAX_VALUE))
        );

        add(pnlTimKiem, java.awt.BorderLayout.EAST);

        pnlTable.setLayout(new java.awt.BorderLayout());

        tblDanhSachKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Họ Tên", "Số Điện Thoại", "Địa Chỉ", "Nhóm Khách Hàng"
            }
        ));
        scrTable.setViewportView(tblDanhSachKhachHang);
        if (tblDanhSachKhachHang.getColumnModel().getColumnCount() > 0) {
            tblDanhSachKhachHang.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblDanhSachKhachHang.getColumnModel().getColumn(3).setPreferredWidth(300);
        }

        pnlTable.add(scrTable, java.awt.BorderLayout.CENTER);

        add(pnlTable, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoDienThoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusGained
    	UtilityJTextField.focusGained(txtSoDienThoai, "Số Điện Thoại");
    }//GEN-LAST:event_txtSoDienThoaiFocusGained

    private void txtSoDienThoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDienThoaiFocusLost
    	UtilityJTextField.focusLost(txtSoDienThoai, "Số Điện Thoại");
    }//GEN-LAST:event_txtSoDienThoaiFocusLost

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
    	timKiemTheoSoDienThoai();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
    	GUI_Main.getInstance().showPanel(newInstance());
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
    	xemChiTietKhachHang();
    }//GEN-LAST:event_btnChiTietActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private extended_component.JButton_AllRound btnChiTiet;
    private extended_component.JButton_AllRound btnLamMoi;
    private extended_component.JButton_AllRound btnTimKiem;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JScrollPane scrTable;
    private extended_component.JTable_LightMode tblDanhSachKhachHang;
    private extended_component.JTextField_AllRound txtSoDienThoai;
    // End of variables declaration//GEN-END:variables

}
