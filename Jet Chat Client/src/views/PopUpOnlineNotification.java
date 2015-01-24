/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

/**
 *
 * @author Mostafa_ITI
 */
public class PopUpOnlineNotification {

 
    
    public PopUpOnlineNotification (String onlineUsername){
        JWindow onlinePopUpMessage = new JWindow( new JWindow());
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(getClass().getResource("/img/popUpOnlineMsg.jpg")));
        JLabel onlineUser = new JLabel("       "+onlineUsername + " Is Now Online");
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        onlinePopUpMessage.setSize(250, 70);
        background.setSize(250, 70);
        onlineUser.setSize(250, 50);
        onlineUser.setFont(new Font("Hobo Std", Font.BOLD, 18));
        onlineUser.setForeground(Color.WHITE);
        onlinePopUpMessage.add(onlineUser);
        onlinePopUpMessage.add(background);
        onlinePopUpMessage.setLocation(screenWidth - 300, screenHeight - 100);
        onlinePopUpMessage.setVisible(true);
        try {
            System.out.println("heree");
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally{
            onlinePopUpMessage.dispose();
        }
    }
}
