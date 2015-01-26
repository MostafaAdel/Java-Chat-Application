/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerController;

import db.com.DB_Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author May
 */
public class UserProfileController implements UserProfileControllerInterface{

    @Override
    public boolean sendUserStatusToOnlineUsers() {
        try {
                String onlineUser;
            ResultSet result=   DB_Connection.selectQuery("SELECT USERNAME FROM USER WHERE STSTUS = TRUE ");
            while (result.next())
            {
                onlineUser = result.getString("USERNAME");
                /*call backMethod for viewieng popup with user name who is online now */
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }

    @Override
    public boolean senduserModeToOnlineUsers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
