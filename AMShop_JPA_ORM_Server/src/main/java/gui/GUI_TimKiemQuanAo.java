package gui;

import entity.NhaSanXuat;
import entity.QuanAo;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import configuration.ServiceInitiator;
import data.FormatDouble;
import data.UtilityImageIcon;
import data.UtilityJTextField;

public class GUI_TimKiemQuanAo extends javax.swing.JPanel {

	private static final long serialVersionUID = 7160171076358233374L;

	private static GUI_TimKiemQuanAo instance = new GUI_TimKiemQuanAo();

	public static GUI_TimKiemQuanAo getInstance() {
		return instance;
	}

	public static GUI_TimKiemQuanAo newInstance() {
		instance = new GUI_TimKiemQuanAo();
		return instance;
	}

	public static void setInstance(GUI_TimKiemQuanAo instance) {
		GUI_TimKiemQuanAo.instance = instance;
	}

	public GUI_TimKiemQuanAo() {
		initComponents();
		initExtra();
	}

	private void initExtra() {
		try {
			updateTableQuanAo(ServiceInitiator.getInstance().getServiceQuanAo().getAllQuanAo());

			UtilityJTextField.addPlaceHolderStyle(txtMaQuanAo);
			UtilityJTextField.addPlaceHolderStyle(txtTenQuanAo);

			tblQuanAo.fixTable(scrQuanAo);

			List<NhaSanXuat> listNhaSanXuat = ServiceInitiator.getInstance().getServiceNhaSanXuat().getAllNhaSanXuat();

			cmbNhaSanXuat.removeAllItems();
			cmbNhaSanXuat.addItem("Nhà Sản Xuất");
			for (NhaSanXuat thisNhaSanXuat : listNhaSanXuat)
				cmbNhaSanXuat.addItem(thisNhaSanXuat.toString());

			cmbDanhMuc.removeAllItems();
			cmbDanhMuc.addItem("Danh Mục");
			cmbDanhMuc.addItem("Áo Khoác");
			cmbDanhMuc.addItem("Áo sơ mi");
			cmbDanhMuc.addItem("Áo Thun");
			cmbDanhMuc.addItem("Quần");
			cmbDanhMuc.addItem("Vải Chiffon");
			cmbDanhMuc.addItem("Vải Cotton");
			cmbDanhMuc.addItem("Vải Kate");
			cmbDanhMuc.addItem("Vải Lụa");
			cmbDanhMuc.addItem("Vải nỉ");
			cmbDanhMuc.addItem("Váy");

			cmbChatLieu.removeAllItems();
			cmbChatLieu.addItem("Chất Liệu");
			cmbChatLieu.addItem("Gấm");
			cmbChatLieu.addItem("Thun");
			cmbChatLieu.addItem("Vải Chiffon");
			cmbChatLieu.addItem("Vải Cotton");
			cmbChatLieu.addItem("Vải Jean");
			cmbChatLieu.addItem("Vải Kaki");
			cmbChatLieu.addItem("Vải Kate");
			cmbChatLieu.addItem("Vải Lụa");
			cmbChatLieu.addItem("Vải Nỉ");
			cmbChatLieu.addItem("Vải thường");
			cmbChatLieu.addItem("Vải trơn ");

			cmbGioiTinh.removeAllItems();
			cmbGioiTinh.addItem("Giới Tính");
			cmbGioiTinh.addItem("Chung");
			cmbGioiTinh.addItem("Nam");
			cmbGioiTinh.addItem("Nữ");

			cmbMauSac.removeAllItems();
			cmbMauSac.addItem("Màu Sắc");
			cmbMauSac.addItem("Cam");
			cmbMauSac.addItem("Đen");
			cmbMauSac.addItem("Đỏ");
			cmbMauSac.addItem("Khác");
			cmbMauSac.addItem("Lam");
			cmbMauSac.addItem("Lục");
			cmbMauSac.addItem("Tím");
			cmbMauSac.addItem("Trắng");
			cmbMauSac.addItem("Vàng");

			cmbKichThuoc.removeAllItems();
			cmbKichThuoc.addItem("Kích Thước");
			cmbKichThuoc.addItem("L");
			cmbKichThuoc.addItem("M");
			cmbKichThuoc.addItem("S");
			cmbKichThuoc.addItem("XL");
			cmbKichThuoc.addItem("XS");
			cmbKichThuoc.addItem("XXL");
			cmbKichThuoc.addItem("XXXL");
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	private void updateTableQuanAo(List<QuanAo> list) {
		DefaultTableModel model = (DefaultTableModel) tblQuanAo.getModel();
		model.getDataVector().removeAllElements();
		tblQuanAo.revalidate();
		tblQuanAo.repaint();
		for (QuanAo thisQuanAo : list) {
			model.addRow(new Object[]{thisQuanAo.getMaQuanAo(), thisQuanAo.getTenQuanAo(),
					FormatDouble.toMoney(thisQuanAo.getDonGiaBan()), thisQuanAo.getSoLuongTrongKho(),
					thisQuanAo.getNhaSanXuat(), thisQuanAo.getDanhMuc(), thisQuanAo.getGioiTinh(),
					thisQuanAo.getMauSac(), thisQuanAo.getKichThuoc(), thisQuanAo.getChatLieu()});
		}
	}

	private void timKiemQuanAo() {
		try {
			List<QuanAo> list = ServiceInitiator.getInstance().getServiceQuanAo().getAllQuanAo();
			List<QuanAo> listRemove = new ArrayList<>();
			
			if(!txtMaQuanAo.getText().equals("Mã Quần Áo")){
			    for(int i = 0; i < list.size(); i ++){
			        QuanAo thisQuanAo = list.get(i);
			        if(!thisQuanAo.getMaQuanAo().equals(txtMaQuanAo.getText()))
			            listRemove.add(thisQuanAo);
			    }
			}
			
			if(!txtTenQuanAo.getText().equals("Tên Quần Áo")){
			    for(int i = 0; i < list.size(); i ++){
			        QuanAo thisQuanAo = list.get(i);
			        if(!thisQuanAo.getTenQuanAo().toLowerCase().contains(txtTenQuanAo.getText().toLowerCase()))
			            listRemove.add(thisQuanAo);
			    }
			}
			
			if(!cmbNhaSanXuat.getSelectedItem().toString().equals("Nhà Sản Xuất")){
			    for(int i = 0; i < list.size(); i ++){
			        QuanAo thisQuanAo = list.get(i);
			        if(!thisQuanAo.getNhaSanXuat().getTenNhaSanXuat().equals(cmbNhaSanXuat.getSelectedItem().toString()))
			            listRemove.add(thisQuanAo);
			    }
			}
			
			if(!cmbDanhMuc.getSelectedItem().toString().equals("Danh Mục")){
			    for(int i = 0; i < list.size(); i ++){
			        QuanAo thisQuanAo = list.get(i);
			        if(!thisQuanAo.getDanhMuc().equals(cmbDanhMuc.getSelectedItem().toString()))
			            listRemove.add(thisQuanAo);
			    }
			}
			
			if(!cmbGioiTinh.getSelectedItem().toString().equals("Giới Tính")){
			    for(int i = 0; i < list.size(); i ++){
			        QuanAo thisQuanAo = list.get(i);
			        if(!thisQuanAo.getGioiTinh().equals(cmbGioiTinh.getSelectedItem().toString()))
			            listRemove.add(thisQuanAo);
			    }
			}
			
			if(!cmbMauSac.getSelectedItem().toString().equals("Màu Sắc")){
			    for(int i = 0; i < list.size(); i ++){
			        QuanAo thisQuanAo = list.get(i);
			        if(!thisQuanAo.getMauSac().equals(cmbMauSac.getSelectedItem().toString()))
			            listRemove.add(thisQuanAo);
			    }
			}
			
			if(!cmbKichThuoc.getSelectedItem().toString().equals("Kích Thước")){
			    for(int i = 0; i < list.size(); i ++){
			        QuanAo thisQuanAo = list.get(i);
			        if(!thisQuanAo.getKichThuoc().equals(cmbKichThuoc.getSelectedItem().toString()))
			            listRemove.add(thisQuanAo);
			    }
			}
			
			if(!cmbChatLieu.getSelectedItem().toString().equals("Chất Liệu")){
			    for(int i = 0; i < list.size(); i ++){
			        QuanAo thisQuanAo = list.get(i);
			        if(!thisQuanAo.getChatLieu().equals(cmbChatLieu.getSelectedItem().toString()))
			            listRemove.add(thisQuanAo);
			    }
			}
			
			list.removeAll(listRemove);
			updateTableQuanAo(list);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	private void updateHinhAnh() {
		try {
			int i = tblQuanAo.getSelectedRow();
			if(i < 0) return;
			String maQuanAo = tblQuanAo.getValueAt(i, 0).toString();
			QuanAo quanAo = ServiceInitiator.getInstance().getServiceQuanAo().getQuanAoTheoMaQuanAo(maQuanAo);

			lblHinhAnh.setText("");
			lblHinhAnh.setIcon(UtilityImageIcon.fromBytes(quanAo.getHinhAnh()));
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		pnlQuanAo = new javax.swing.JPanel();
		scrQuanAo = new javax.swing.JScrollPane();
		tblQuanAo = new extended_component.JTable_LightMode();
		pnlTimKiem = new javax.swing.JPanel();
		txtMaQuanAo = new extended_component.JTextField_AllRound();
		txtTenQuanAo = new extended_component.JTextField_AllRound();
		cmbNhaSanXuat = new javax.swing.JComboBox<>();
		cmbDanhMuc = new javax.swing.JComboBox<>();
		cmbGioiTinh = new javax.swing.JComboBox<>();
		cmbMauSac = new javax.swing.JComboBox<>();
		cmbKichThuoc = new javax.swing.JComboBox<>();
		cmbChatLieu = new javax.swing.JComboBox<>();
		pnlHinhAnh = new javax.swing.JPanel();
		lblHinhAnh = new javax.swing.JLabel();
		btnTimKiem = new extended_component.JButton_AllRound();
		btnLamMoi = new extended_component.JButton_AllRound();

		setPreferredSize(new java.awt.Dimension(1166, 700));
		setLayout(new java.awt.BorderLayout());

		pnlQuanAo.setPreferredSize(new java.awt.Dimension(916, 700));
		pnlQuanAo.setLayout(new java.awt.BorderLayout());

		tblQuanAo.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

		}, new String[]{"Mã Quần Áo", "Tên Quần Áo", "Đơn Giá", "Số Lượng", "Nhà Sản Xuất", "Danh Mục", "Giới Tính",
				"Màu Sắc", "Kích Thước", "Chất Liệu"}));
		tblQuanAo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblQuanAoMouseClicked(evt);
			}
		});
		scrQuanAo.setViewportView(tblQuanAo);
		if (tblQuanAo.getColumnModel().getColumnCount() > 0) {
			tblQuanAo.getColumnModel().getColumn(1).setPreferredWidth(150);
		}

		pnlQuanAo.add(scrQuanAo, java.awt.BorderLayout.CENTER);

		add(pnlQuanAo, java.awt.BorderLayout.CENTER);

		pnlTimKiem.setBackground(new java.awt.Color(68, 136, 255));
		pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP,
				new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
		pnlTimKiem.setPreferredSize(new java.awt.Dimension(250, 700));

		txtMaQuanAo.setText("Mã Quần Áo");
		txtMaQuanAo.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtMaQuanAoFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txtMaQuanAoFocusLost(evt);
			}
		});

		txtTenQuanAo.setText("Tên Quần Áo");
		txtTenQuanAo.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtTenQuanAoFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txtTenQuanAoFocusLost(evt);
			}
		});

		cmbNhaSanXuat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nhà Sản Xuất"}));

		cmbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Danh Mục"}));

		cmbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Giới Tính"}));

		cmbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Màu Sắc"}));

		cmbKichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Kích Thước"}));

		cmbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Chất Liệu"}));

		pnlHinhAnh.setBackground(new java.awt.Color(224, 224, 224));
		pnlHinhAnh.setPreferredSize(new java.awt.Dimension(196, 270));
		pnlHinhAnh.setLayout(new java.awt.GridBagLayout());

		lblHinhAnh.setText("IMG");
		pnlHinhAnh.add(lblHinhAnh, new java.awt.GridBagConstraints());

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

		javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
		pnlTimKiem.setLayout(pnlTimKiemLayout);
		pnlTimKiemLayout.setHorizontalGroup(pnlTimKiemLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						pnlTimKiemLayout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20))
				.addComponent(txtMaQuanAo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(txtTenQuanAo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(pnlTimKiemLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										pnlTimKiemLayout.createSequentialGroup()
												.addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28,
														Short.MAX_VALUE)
												.addComponent(cmbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(pnlTimKiemLayout.createSequentialGroup()
										.addComponent(cmbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(pnlTimKiemLayout.createSequentialGroup()
										.addComponent(cmbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		pnlTimKiemLayout.setVerticalGroup(pnlTimKiemLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlTimKiemLayout.createSequentialGroup()
						.addComponent(txtMaQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(4, 4, 4)
						.addComponent(txtTenQuanAo, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cmbNhaSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cmbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(cmbKichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnlHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(84, Short.MAX_VALUE)));

		add(pnlTimKiem, java.awt.BorderLayout.EAST);
	}// </editor-fold>//GEN-END:initComponents

	private void txtMaQuanAoFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtMaQuanAoFocusGained
		UtilityJTextField.focusGained(txtMaQuanAo, "Mã Quần Áo");
	}// GEN-LAST:event_txtMaQuanAoFocusGained

	private void txtMaQuanAoFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtMaQuanAoFocusLost
		UtilityJTextField.focusLost(txtMaQuanAo, "Mã Quần Áo");
	}// GEN-LAST:event_txtMaQuanAoFocusLost

	private void txtTenQuanAoFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtTenQuanAoFocusGained
		UtilityJTextField.focusGained(txtTenQuanAo, "Tên Quần Áo");
	}// GEN-LAST:event_txtTenQuanAoFocusGained

	private void txtTenQuanAoFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtTenQuanAoFocusLost
		UtilityJTextField.focusLost(txtTenQuanAo, "Tên Quần Áo");
	}// GEN-LAST:event_txtTenQuanAoFocusLost

	private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimKiemActionPerformed
		timKiemQuanAo();
	}// GEN-LAST:event_btnTimKiemActionPerformed

	private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLamMoiActionPerformed
		GUI_Main.getInstance().showPanel(newInstance());
	}// GEN-LAST:event_btnLamMoiActionPerformed

	private void tblQuanAoMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblQuanAoMouseClicked
		updateHinhAnh();
	}// GEN-LAST:event_tblQuanAoMouseClicked

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private extended_component.JButton_AllRound btnLamMoi;
	private extended_component.JButton_AllRound btnTimKiem;
	private javax.swing.JComboBox<String> cmbChatLieu;
	private javax.swing.JComboBox<String> cmbDanhMuc;
	private javax.swing.JComboBox<String> cmbGioiTinh;
	private javax.swing.JComboBox<String> cmbKichThuoc;
	private javax.swing.JComboBox<String> cmbMauSac;
	private javax.swing.JComboBox<String> cmbNhaSanXuat;
	private javax.swing.JLabel lblHinhAnh;
	private javax.swing.JPanel pnlHinhAnh;
	private javax.swing.JPanel pnlQuanAo;
	private javax.swing.JPanel pnlTimKiem;
	private javax.swing.JScrollPane scrQuanAo;
	private extended_component.JTable_LightMode tblQuanAo;
	private extended_component.JTextField_AllRound txtMaQuanAo;
	private extended_component.JTextField_AllRound txtTenQuanAo;
	// End of variables declaration//GEN-END:variables

}
