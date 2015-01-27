/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerController;

import controller.UserProfileServicesInterface;
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
    public boolean sendUserStatusToOnlineUsers(String userName) {
        try {
                String onlineUser;
            ResultSet result=   DB_Connection.selectQuery("SELECT USERNAME FROM USER WHERE STATUS = TRUE ");
            while (result.next())
            {
                onlineUser = result.getString("USERNAME");
                System.out.println( " " + userName+  "   is online now, "+ onlineUser);
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }

    @Override
    public boolean senduserModeToOnlineUsers(String userName) {
        try {
            String onlineUser;
          
            
            ResultSet result=   DB_Connection.selectQuery("SELECT USERNAME FROM USER WHERE STATUS = TRUE ");
            
            
            
            
              String mode="";
              int userMode ;
            
            while (result.next())
            {
                onlineUser = result.getString("USERNAME");
                userMode = result.getInt(9);
            switch (userMode) 
            {
//                case UserProfileServicesInterface.awayMode:
//                    mode = "away";
//                    break;
//             
//                case UserProfileServicesInterface.busyMode:
//                    mode = "busy";
//                    break;
//                case UserProfileServicesInterface.drinkingCoffeeMode:
//                    mode = "drinkking coffee";
//                    break;
            }
                System.out.println(userName +"is " + userMode + "now , " + onlineUser);
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
        
            return false;
        }
        }
    
}
