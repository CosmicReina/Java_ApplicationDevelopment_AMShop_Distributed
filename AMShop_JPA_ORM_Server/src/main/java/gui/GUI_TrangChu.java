package gui;

public class GUI_TrangChu extends javax.swing.JPanel {
    
	private static final long serialVersionUID = -4976375294319308914L;
	
	private static GUI_TrangChu instance = new GUI_TrangChu();

    public static GUI_TrangChu getInstance() {
        return instance;
    }

    public static GUI_TrangChu newInstance() {
        instance = new GUI_TrangChu();
        return instance;
    }
    
    public GUI_TrangChu() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIMG = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        add(lblIMG, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIMG;
    // End of variables declaration//GEN-END:variables

}
