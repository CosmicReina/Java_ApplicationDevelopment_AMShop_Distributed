package data;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JButton;

public class UtilityJButton {
    public static ArrayList<JButton> getAllJButtons(Container container){
		ArrayList<JButton> buttonList = new ArrayList<>();
		Component[] components = container.getComponents();
		
		for(Component thisComponent : components) {
                    if(thisComponent instanceof JButton) {
                            buttonList.add((JButton)thisComponent);
                    }
                    else
                        if(thisComponent instanceof Container) {
                                buttonList.addAll(getAllJButtons((Container)thisComponent));
                        }
		}
		
		return buttonList;
	}
	
	public static void removeFocusPainted(ArrayList<JButton> list) {
		for(JButton thisJButton : list) {
			thisJButton.setFocusPainted(false);
		}
	}
        
        public static void changeBackgroundColor(ArrayList<JButton> list, String decode) {
		for(JButton thisJButton : list) {
			thisJButton.setBackground(Color.decode(decode));
		}
	}
}