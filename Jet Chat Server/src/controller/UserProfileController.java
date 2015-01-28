/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import services.UserProfileServicesInterface;
import db.com.DB_Connection;
import entity.UserEntity;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServerServicesInterface;

/**
 *
 * @author May
 */
public class UserProfileController extends UnicastRemoteObject implements UserProfileServicesInterface, UserProfileControllerInterface{

    private ServerControllerInterface serverController;
    
    

    UserProfileController(ServerController serverController)throws RemoteException{
        serverController = serverController;
    }

    @Override
    public boolean changeMode(String userName, int userMode) throws RemoteException{
        try {
            DB_Connection.updateQuery("UPDATE USER SET MODE = ' " + userMode + "'" + "WHERE USERNAME = '" + userName + "'");

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean changeStatus(String userName, int userStatus) throws RemoteException{
        try {
            DB_Connection.updateQuery("UPDATE USER SET Status = ' " + userStatus + "'" + "WHERE USERNAME = '" + userName + "'");

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean editeUserInformation(String oldPassword, UserEntity user) throws RemoteException{

        try {
            System.out.println("oldPassowrd" + oldPassword);
            DB_Connection.updateQuery("UPDATE USER SET FIRSTNAME = '" + user.getFirstName() + "'"
                    + ", LASTNAME = '" + user.getLastName() + "'"
                    + ", USERPASSWORD = '" + user.getUserPassword() + "'"
                    + " , MOBILENUMBER =  '" + user.getMobileNumber() + "' "
                    + "WHERE (USERPASSWORD =  '" + oldPassword + "') AND (USERNAME = '" + user.getUsername() + "')");

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
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

    @Override
    public ServerServicesInterface getService(int serviceNumber) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
