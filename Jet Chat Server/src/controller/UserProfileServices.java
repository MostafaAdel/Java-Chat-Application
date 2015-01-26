/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.com.DB_Connection;
import entity.UserEntity;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author May
 */
public class UserProfileServices /*extends UnicastRemoteObject*/ implements UserProfileServicesInterface{

    public UserProfileServices() {
    }

    @Override
    public boolean changeMode(String userName, int userMode) {
        try {
            DB_Connection.updateQuery("UPDATE USER SET MODE = ' " + userMode + "'" + "WHERE USERNAME = '" + userName + "'");

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileServices.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean changeStatus(String userName, int userStatus) {
        try {
            DB_Connection.updateQuery("UPDATE USER SET Status = ' " + userStatus + "'" + "WHERE USERNAME = '" + userName + "'");

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileServices.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean editeUserInformation(String oldPassword, UserEntity user) {

        try {
            System.out.println("oldPassowrd" + oldPassword);
            DB_Connection.updateQuery("UPDATE USER SET FIRSTNAME = '" + user.getFirstName() + "'"
                    + ", LASTNAME = '" + user.getLastName() + "'"
                    + ", USERPASSWORD = '" + user.getUserPassword() + "'"
                    + " , MOBILENUMBER =  '" + user.getMobileNumber() + "' "
                    + "WHERE (USERPASSWORD =  '" + oldPassword + "') AND (USERNAME = '" + user.getUsername() + "')");

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserProfileServices.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
