package gui;


import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import configuration.ServiceInitiator;
import data.FormatDouble;
import data.UtilityImageIcon;
import entity.QuanAo;

public class GUI_DanhSachQuanAo extends javax.swing.JPanel {
    
	private static final long serialVersionUID = 7403599211447402244L;
	
	private static GUI_DanhSachQuanAo instance = new GUI_DanhSachQuanAo();

    public static GUI_DanhSachQuanAo getInstance() {
        return instance;
    }
    
    public static GUI_DanhSachQuanAo newInstance() {
        instance = new GUI_DanhSachQuanAo();
        return instance;
    }

    public static void setInstance(GUI_DanhSachQuanAo instance) {
        GUI_DanhSachQuanAo.instance = instance;
    }

    public GUI_DanhSachQuanAo() {
        initComponents();
        initExtra();
    }
    
    private void initExtra(){
    	try {
			updateTableQuanAo(ServiceInitiator.getInstance().getServiceQuanAo().getAllQuanAo());
			tblQuanAo.fixTable(scrQuanAo);
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
    }
    
    private void updateTableQuanAo(List<QuanAo> list){
    	DefaultTableModel model = (DefaultTableModel) tblQuanAo.getModel();
        model.getDataVector().removeAllElements();
        tblQuanAo.revalidate();
        tblQuanAo.repaint();
        for(QuanAo thisQuanAo : list){
            model.addRow(new Object[]{
                thisQuanAo.getMaQuanAo(),
                thisQuanAo.getTenQuanAo(),
                FormatDouble.toMoney(thisQuanAo.getDonGiaBan()),
                thisQuanAo.getSoLuongTrongKho(),
                thisQuanAo.getNhaSanXuat().getTenNhaSanXuat(),
                thisQuanAo.getDanhMuc(),
                thisQuanAo.getGioiTinh(),
                thisQuanAo.getMauSac(),
                thisQuanAo.getKichThuoc(),
                thisQuanAo.getChatLieu()
            });
        }
    }
    
    private void updateHinhAnh(){
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
        pnlHinhAnh = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1166, 700));
        setLayout(new java.awt.BorderLayout());

        pnlQuanAo.setPreferredSize(new java.awt.Dimension(916, 700));
        pnlQuanAo.setLayout(new java.awt.BorderLayout());

        tblQuanAo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Quần Áo", "Tên Quần Áo", "Đơn Giá", "Số Lượng", "Nhà Sản Xuất", "Danh Mục", "Giới Tính", "Màu Sắc", "Kích Thước", "Chất Liệu"
            }
        ));
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
        pnlTimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        pnlTimKiem.setPreferredSize(new java.awt.Dimension(250, 700));

        pnlHinhAnh.setBackground(new java.awt.Color(204, 204, 204));
        pnlHinhAnh.setPreferredSize(new java.awt.Dimension(196, 270));
        pnlHinhAnh.setLayout(new java.awt.GridBagLayout());

        lblHinhAnh.setText("IMG");
        pnlHinhAnh.add(lblHinhAnh, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout pnlTimKiemLayout = new javax.swing.GroupLayout(pnlTimKiem);
        pnlTimKiem.setLayout(pnlTimKiemLayout);
        pnlTimKiemLayout.setHorizontalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(pnlHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        pnlTimKiemLayout.setVerticalGroup(
            pnlTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(430, Short.MAX_VALUE))
        );

        add(pnlTimKiem, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void tblQuanAoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanAoMouseClicked
    	updateHinhAnh();
    }//GEN-LAST:event_tblQuanAoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JPanel pnlHinhAnh;
    private javax.swing.JPanel pnlQuanAo;
    private javax.swing.JPanel pnlTimKiem;
    private javax.swing.JScrollPane scrQuanAo;
    private extended_component.JTable_LightMode tblQuanAo;
    // End of variables declaration//GEN-END:variables

}
