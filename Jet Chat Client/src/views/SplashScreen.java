/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

/**
 *
 * @author Mostafa_ITI
 */
public class SplashScreen {

    public SplashScreen() {
        JWindow splachWindow = new JWindow(new JWindow());
        JLabel splachimg = new JLabel();
        splachimg.setIcon(new ImageIcon(getClass().getResource("/img/splash_screen.jpg")));
        splachWindow.setSize(500, 300);
        splachimg.setSize(500, 300);
        splachWindow.add(splachimg);
        splachWindow.setLocation(500, 200);
        splachWindow.setVisible(true);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            splachWindow.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new SplashScreen();
    }
}
