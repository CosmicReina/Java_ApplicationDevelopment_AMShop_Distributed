package extended_JComponent;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class JScrollBar_Custom extends JScrollBar {

	private static final long serialVersionUID = -1618518248846597654L;

	public JScrollBar_Custom() {
        setUI(new BasicScrollBarUI_Modern());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(new Color(255, 255, 255));
    }
    
}
