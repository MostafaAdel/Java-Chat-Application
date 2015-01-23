/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Mohamed
 */
public class StatusComboBoxRenderer implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        ImageIcon img = new ImageIcon(getClass().getResource("/img/offline-icon.png"));
        JLabel label = new JLabel(value.toString());

        switch (value.toString()) {

            case "Available":
                img = new ImageIcon(getClass().getResource("/img/online-icon.png"));
                label.setForeground(new Color(4708935));
                break;

            case "Busy":
                 img = new ImageIcon(getClass().getResource("/img/online-red-icon.png"));
                label.setForeground(new Color(15084331));
                break;

            case "Invisible":
                img = new ImageIcon(getClass().getResource("/img/offline-icon.png"));
                label.setForeground(Color.GRAY);
                break;

            case "Drinking Coffee":
                img = new ImageIcon(getClass().getResource("/img/lunchbreak-girl-icon.png"));
                label.setForeground(new Color(16738996));
                break;
        }

        // label.setFont(new Font("Hobo Std", Font.PLAIN, 12));
        label.setIcon(img);

        return label;

    }

}
