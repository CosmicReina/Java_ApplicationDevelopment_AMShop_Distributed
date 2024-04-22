package extended_JComponent;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class JPanel_AllRound extends JPanel {
    
    private int borderTopLeft = 0;
    private int borderTopRight = 0;
    private int borderBottomLeft = 0;
    private int borderBottomRight = 0;
    
    public int getBorderTopLeft() {
        return borderTopLeft;
    }

    public void setBorderTopLeft(int borderTopLeft) {
        this.borderTopLeft = borderTopLeft;
        this.repaint();
    }

    public int getBorderTopRight() {
        return borderTopRight;
    }

    public void setBorderTopRight(int borderTopRight) {
        this.borderTopRight = borderTopRight;
        this.repaint();
    }

    public int getBorderBottomLeft() {
        return borderBottomLeft;
    }

    public void setBorderBottomLeft(int borderBottomLeft) {
        this.borderBottomLeft = borderBottomLeft;
        this.repaint();
    }

    public int getBorderBottomRight() {
        return borderBottomRight;
    }

    public void setBorderBottomRight(int borderBottomRight) {
        this.borderBottomRight = borderBottomRight;
        this.repaint();
    }

    public JPanel_AllRound() {
        setOpaque(false);
    }
    
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if(borderTopRight > 0){
            area.intersect(new Area(createRoundTopRight()));
        }
        if(borderBottomLeft > 0){
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if(borderBottomRight > 0){
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2d.fill(area);
        g2d.dispose();
        super.paintComponent(g);
    }
    
    private Shape createRoundTopLeft() {
        int width = this.getWidth();
        int height = this.getHeight();
        int roundX = Math.min(width, borderTopLeft);
        int roundY = Math.min(height, borderTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY /2, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRoundTopRight() {
        int width = this.getWidth();
        int height = this.getHeight();
        int roundX = Math.min(width, borderTopRight);
        int roundY = Math.min(height, borderTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY /2, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRoundBottomLeft() {
        int width = this.getWidth();
        int height = this.getHeight();
        int roundX = Math.min(width, borderBottomLeft);
        int roundY = Math.min(height, borderBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRoundBottomRight() {
        int width = this.getWidth();
        int height = this.getHeight();
        int roundX = Math.min(width, borderBottomRight);
        int roundY = Math.min(height, borderBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    
}
