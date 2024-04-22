package data;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class UtilityImageIcon {
    public static ImageIcon fromStringPath(String imagePath, int width, int height){
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage();
        if(image != null){
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon resizedImageIcon = new ImageIcon(resizedImage);
            return resizedImageIcon;
        }
        else
            return null;
    }
    
    public static byte[] toBytes(ImageIcon imageIcon){
        Image image = imageIcon.getImage();
        
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {
            ImageIO.write(bufferedImage, "jpg", baos);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        byte[] imageBytes = baos.toByteArray();
        return imageBytes;
    }
    
    public static ImageIcon fromBytes(byte[] bytes){
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            BufferedImage bufferedImage = ImageIO.read(bais);
            ImageIcon imageIcon = new ImageIcon(bufferedImage);
            return imageIcon;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}