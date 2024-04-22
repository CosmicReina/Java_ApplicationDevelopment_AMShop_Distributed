package extended_JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class BasicScrollBarUI_Modern extends BasicScrollBarUI {
    
    private final int THUMB_SIZE = 60;

    @Override
    protected Dimension getMaximumThumbSize() {
        if(scrollbar.getOrientation() == JScrollBar.VERTICAL){
            return new Dimension(0, THUMB_SIZE);
        }
        else{
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        if(scrollbar.getOrientation() == JScrollBar.VERTICAL){
            return new Dimension(0, THUMB_SIZE);
        }
        else{
            return new Dimension(THUMB_SIZE, 0);
        }
        
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int size;
        int x;
        int y;
        int width;
        int height;
        if(scrollbar.getOrientation() == JScrollBar.VERTICAL){
            size = trackBounds.width / 2;
            x = trackBounds.x + ((trackBounds.width - size) / 2);
            y = trackBounds.y;
            width = size;
            height = trackBounds.height;
        }
        else{
            size = trackBounds.height / 2;
            x = trackBounds.x;
            y = trackBounds.y + ((trackBounds.height - size) / 2);
            width = trackBounds.width;
            height = size;
        }
        g2d.setColor(new Color(240, 240, 240));
        g2d.fillRect(x, y, width, height);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = thumbBounds.x;
        int y = thumbBounds.y;
        int width = thumbBounds.width;
        int height = thumbBounds.height;
        g2d.setColor(scrollbar.getForeground());
        g2d.fillRoundRect(x, y, width, height, 10, 10);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }
    
    private JButton createZeroButton(){
        JButton btn = new JButton();
        btn.setPreferredSize(new Dimension(0, 0));
        btn.setMinimumSize(new Dimension(0, 0));
        btn.setMaximumSize(new Dimension(0, 0));
        return btn;
    }
}
