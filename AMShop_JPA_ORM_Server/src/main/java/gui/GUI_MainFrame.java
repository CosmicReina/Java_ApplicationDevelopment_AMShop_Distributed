package gui;

import extended_component.JButton_AllRound;
import extended_component.JPanel_AllRound;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GUI_MainFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1924448773125630034L;

	private static GUI_MainFrame instance;

	public static GUI_MainFrame getInstance() {
		return instance;
	}

	public static GUI_MainFrame newInstance() {
		instance = new GUI_MainFrame();
		return instance;
	}

	public GUI_MainFrame() {
		initComponents();
		initiateLayeredPane();
	}

	private void initiateLayeredPane() {
		pnlMain.setBounds(0, 0, 1366, 768);
		pnlMain.setLayout(new BorderLayout());
		pnlMain.add(GUI_Main.newInstance(), BorderLayout.CENTER);
		GUI_Main.getInstance().addButtonToList();

		lypMain.add(pnlMain, Integer.valueOf(1));

		pnlPopup = null;
	}

	public void actionHienThiPopup(JPanel panel, int x, int y) {
		lypMain.remove(panel);
		lypMain.revalidate();
		lypMain.repaint();
		lypMain.add(panel, Integer.valueOf(2));

		panel.setLocation(x, y);
	}

	public void actionTaoPopupChoButton(JButton_AllRound button, ArrayList<JButton_AllRound> listAddedButton) {
		if (pnlPopup == null)
			actionTaoPopup(button, listAddedButton);
		else
			actionXoaPopup();
	}

	public void actionTaoPopup(JButton_AllRound button, ArrayList<JButton_AllRound> listAddedButton) {
		int listSize = listAddedButton.size();
		int popUpHeight = 40 * listSize;
		pnlPopup = new JPanel_AllRound();
		pnlPopup.setBorderTopRight(20);
		pnlPopup.setBorderBottomRight(20);
		pnlPopup.revalidate();
		pnlPopup.repaint();
		pnlPopup.setBounds(0, 0, 300, popUpHeight);
		pnlPopup.setLayout(new GridLayout(listSize, 1));
		for (JButton_AllRound thisButton : listAddedButton)
			pnlPopup.add(thisButton);
		int x = button.getLocation().x + button.getSize().width;
		int y = button.getLocation().y + button.getSize().height - popUpHeight / 3;
		actionHienThiPopup(pnlPopup, x, y);
	}

	public void actionXoaPopup() {
		lypMain.remove(pnlPopup);
		lypMain.revalidate();
		lypMain.repaint();
		
		pnlPopup = null;
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		pnlMain = new javax.swing.JPanel();
		pnlPopup = new extended_component.JPanel_AllRound();
		lypMain = new javax.swing.JLayeredPane();

		javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
		pnlMain.setLayout(pnlMainLayout);
		pnlMainLayout.setHorizontalGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		pnlMainLayout.setVerticalGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		javax.swing.GroupLayout pnlPopupLayout = new javax.swing.GroupLayout(pnlPopup);
		pnlPopup.setLayout(pnlPopupLayout);
		pnlPopupLayout.setHorizontalGroup(pnlPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		pnlPopupLayout.setVerticalGroup(pnlPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);

		javax.swing.GroupLayout lypMainLayout = new javax.swing.GroupLayout(lypMain);
		lypMain.setLayout(lypMainLayout);
		lypMainLayout.setHorizontalGroup(lypMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 1366, Short.MAX_VALUE));
		lypMainLayout.setVerticalGroup(lypMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 768, Short.MAX_VALUE));

		getContentPane().add(lypMain, java.awt.BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLayeredPane lypMain;
	private javax.swing.JPanel pnlMain;
	private extended_component.JPanel_AllRound pnlPopup;
	// End of variables declaration//GEN-END:variables

}
