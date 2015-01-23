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

/**
 *
 * @author Mohamed
 */
public class FriendListRenderer implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        JLabel eleemnt = new JLabel((String)value, new ImageIcon(getClass().getResource("/img/Penguins.jpg")), 10);
        
      //  if (isSelected || cellHasFocus)
          //  eleemnt.setBackground(Color.blue);
        return eleemnt;
    }


    
}
