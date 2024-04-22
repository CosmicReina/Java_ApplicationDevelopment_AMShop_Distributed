package data;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class UtilityJTextField {
    public static void addPlaceHolderStyle(JTextField txt){
        Font font = txt.getFont();
        font = font.deriveFont(Font.ITALIC);
        txt.setFont(font);
        txt.setForeground(Color.GRAY);
    }
    
    public static void removePlaceHolderStyle(JTextField txt){
        Font font = txt.getFont();
        font = font.deriveFont(Font.PLAIN);
        txt.setFont(font);
        txt.setForeground(Color.BLACK);
    }
    
    public static void focusGained(JTextField txt, String string){
        if(txt.getText().equals(string))
            txt.setText("");
        txt.requestFocus();
        removePlaceHolderStyle(txt);
    }
    
    public static void focusLost(JTextField txt, String string){
        if(txt.getText().equals("")){
            addPlaceHolderStyle(txt);
            txt.setText(string);
        }
    }
}
