package extended_JComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

public class JTable_LightMode extends JTable {
    
    private class TableLightHeader extends DefaultTableCellRenderer{

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            component.setBackground(new Color(240, 240, 240));
            component.setForeground(new Color(0, 0, 0));
            component.setFont(component.getFont().deriveFont(Font.BOLD, 12));
            return component;
        }
        
    }
    
    private class TableLightCell extends DefaultTableCellRenderer{

        @Override
        @SuppressWarnings("null")
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if(component instanceof JLabel)
                ((JLabel) component).setHorizontalAlignment(JLabel.CENTER);
            if(isCellSelected(row, column)){
                if(row % 2 == 0){
                    component.setBackground(new Color(53, 209, 229));
                }
                else{
                    component.setBackground(new Color(47, 186, 204));
                }
            }
            else{
                if(row % 2 == 0){
                    component.setBackground(new Color(255, 255, 255));
                }
                else{
                    component.setBackground(new Color(240, 240, 240));
                }
            }
            
            component.setForeground(new Color(0, 0, 0));
            
            return component;
        }
        
    }

    public JTable_LightMode() {
        this.getTableHeader().setDefaultRenderer(new TableLightHeader());
        this.getTableHeader().setPreferredSize(new Dimension(0, 35));
        this.getTableHeader().setReorderingAllowed(false);
        this.getTableHeader().setResizingAllowed(false);
        this.setDefaultRenderer(Object.class, new TableLightCell());
        this.setRowHeight(30);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        DefaultTableCellRenderer rendererHeader = (DefaultTableCellRenderer)this.getTableHeader().getDefaultRenderer();
        rendererHeader.setHorizontalAlignment(JLabel.CENTER);
    }
    
    public void fixTable(JScrollPane scr){
        scr.setVerticalScrollBar(new JScrollBar_Custom());
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
