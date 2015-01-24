/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.renderers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import views.FriendElement;

/**
 *
 * @author Mohamed
 */
public class FriendListRenderer implements ListCellRenderer {
    
    private static boolean colored;
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        
        FriendElement element = new FriendElement();
        element.getDisplayName().setText(value.toString());
        
        if(colored){
            element.setBackground(new Color(15529466));
            colored = false;
            return element;
        }
        
        colored = true;
        return element;
    }

}
