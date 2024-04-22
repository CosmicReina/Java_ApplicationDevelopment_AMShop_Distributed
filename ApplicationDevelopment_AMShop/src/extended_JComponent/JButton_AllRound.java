package extended_JComponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class JButton_AllRound extends JButton {
    
    private boolean entered;
    private Color colorBackground;
    private Color colorBorder;
    private Color colorClick;
    private Color colorEnter;
    private int borderThickness = 2;
    private int borderRadius = 0;

    public boolean isEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
    }

    public Color getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(Color colorBackground) {
        this.colorBackground = colorBackground;
        this.setBackground(colorBackground);
    }

    public Color getColorBorder() {
        return colorBorder;
    }

    public void setColorBorder(Color colorBorder) {
        this.colorBorder = colorBorder;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getColorEnter() {
        return colorEnter;
    }

    public void setColorEnter(Color colorEnter) {
        this.colorEnter = colorEnter;
    }

    public int getBorderThickness() {
        return borderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        this.borderThickness = borderThickness;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }

    public JButton_AllRound() {
        this.initColor();
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorEnter);
                entered = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(colorBackground);
                entered = false;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(entered){
                    setBackground(colorEnter);
                }
                else{
                    setBackground(colorBackground);
                }
            }
        });
    }
    
    private void initColor(){
        setColorBackground(Color.WHITE);
        setColorBorder(Color.BLACK);
        setColorClick(Color.CYAN);
        setColorEnter(Color.GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(colorBorder);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(borderThickness, borderThickness, getWidth()-borderThickness*2, getHeight()-borderThickness*2, borderRadius, borderRadius);
        super.paintComponent(g);
    }
}
