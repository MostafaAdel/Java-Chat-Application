/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Vector;
import db.com.DB_Connection;
import entity.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import services.FreindshipServiceInterface;
import services.ServerServicesInterface;

/**
 *
 * @author Rania
 */
public class FreindshipController extends UnicastRemoteObject implements FreindshipServiceInterface, FreindshipControllerInterface {

    private ServerController serverController;
    static final int ADD_FRIEND = 1;
    static final int ACCEPT_INVITATION = 2;
    static final int IGNORE_INVITATION = 3;

    FreindshipController(ServerController controller) throws RemoteException {

        this.serverController = controller;
    }

    public FreindshipController() throws RemoteException {

    }

    /**
     * @param String userName
     * @param String freindName
     */
    @Override
    public boolean addFreind(String userName, String friendName) throws RemoteException {

        String userNameTemp;
        String friendNameTemp;
        friendshipEntity friendship = new friendshipEntity();
        try {
            ResultSet result;

            result = DB_Connection.selectQuery("SELECT * FROM FRIENDSHIP WHERE (USERNAME = '" + userName + "' AND USE_USERNAME='" + friendName + "') OR (USERNAME = '" + friendName + "' AND USE_USERNAME='" + userName + " ')"
                    + " ");
            System.out.println("cghjk");
            //  System.out.println(result.getString(2));
            if (result.next() == false) {

                DB_Connection.updateQuery("INSERT INTO friendship (USERNAME, USE_USERNAME, friendshipStatus)VALUES "
                        + "('" + userName + "','" + friendName + "','" + FreindshipController.ADD_FRIEND + "')");
            } else {

                userNameTemp = result.getString(1);
                friendNameTemp = result.getString(2);
                System.out.println(result.getString(1));
                if (((userNameTemp.equals(userName)) & (friendNameTemp.equals(friendName)) || (((userNameTemp.equals(friendName)) & (friendNameTemp.equals(userName)))))) {
                    System.out.println("you aready friend");

                }

            }

        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }

        return true;

    }

    /**
     * @param String userName
     * @param String freindName
     */
    @Override
    public UserEntity acceptInvitation(String userName, String friendName) throws RemoteException {

        String userNameTemp;
        String friendNameTemp;
        int friendshipStatusTemp;
        UserEntity user = new UserEntity();

        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FRIENDSHIP WHERE (USERNAME = '" + userName + "' AND USE_USERNAME='" + friendName + "' AND friendshipStatus <> '" + FreindshipController.ADD_FRIEND + "')  ");

            while (result.next()) {

                userNameTemp = result.getString(1);
                friendNameTemp = result.getString(2);
                friendshipStatusTemp = result.getInt(3);
                if (((userNameTemp.equals(userName)) & (friendNameTemp.equals(friendName)) & (friendshipStatusTemp != FreindshipController.ACCEPT_INVITATION))) {

                    DB_Connection.updateQuery("UPDATE friendship SET friendshipStatus='" + FreindshipController.ACCEPT_INVITATION + "' WHERE USERNAME='" + userName + "' AND USE_USERNAME='" + friendName + "'  ");
                    result = DB_Connection.selectQuery("SELECT * FROM USER WHERE USERNAME ='" + friendName + "' ");
                    result.next();
                    user.setUsername(result.getString("USERNAME"));
                    user.setFirstName((result.getString("FIRSTNAME")));
                    user.setLastName(result.getString("LASTNAME"));
                    user.setDateOfBirth(result.getString("DATEOFBIRTH"));
                    user.setMode(result.getInt("MODE"));
                    user.setStatus(result.getBoolean("STATUS"));
                    user.setGender(result.getString("GENDER").charAt(0));
                    return user;

                }
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

        return user;

    }

    /**
     * @param String userName
     * @param String freindName
     */
    @Override
    public boolean ignoreInvitation(String userName, String friendName) throws RemoteException {

        String userNameTemp;
        String friendNameTemp;
        int friendshipStatusTemp;
        UserEntity user = new UserEntity();

        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FRIENDSHIP WHERE USERNAME = '" + userName + "' AND USE_USERNAME='" + friendName + "' AND friendshipStatus NOT IN(2,3) ");

            while (result.next()) {
                userNameTemp = result.getString(1);
                friendNameTemp = result.getString(2);
                friendshipStatusTemp = result.getInt(3);

                if ((userNameTemp.equals(userName)) & (friendNameTemp.equals(friendName))) {
                    DB_Connection.updateQuery("UPDATE friendship SET friendshipStatus='" + FreindshipController.IGNORE_INVITATION + "' WHERE USERNAME='" + userName + "' AND USE_USERNAME='" + friendName + "'  ");
                    break;
                }

            }
        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;

        }
        return true;
    }

    /**
     * @param String userName
     * @param String freindName
     */
    @Override
    public boolean rejectInvitation(String userName, String friendName) throws RemoteException {

        String userNameTemp;
        String friendNameTemp;
        int friendshipStatusTemp;
        UserEntity user = new UserEntity();

        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FRIENDSHIP WHERE USERNAME = '" + userName + "' AND USE_USERNAME='" + friendName + "' ");

            while (result.next()) {
                userNameTemp = result.getString(1);
                friendNameTemp = result.getString(2);
                friendshipStatusTemp = result.getInt(3);
                if ((userNameTemp.equals(userName)) & (friendNameTemp.equals(friendName)) & (friendshipStatusTemp != ACCEPT_INVITATION)) {
                    DB_Connection.updateQuery("DELETE FROM  friendship  WHERE USERNAME='" + userName + "' AND USE_USERNAME='" + friendName + "'  ");

                }

            }
        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;

        }
        return true;
    }

    /**
     * @param String userName
     * @param String freindName
     */
    @Override
    public boolean deleteFreind(String userName, String friendName) throws RemoteException {
        String userNameTemp;
        String friendNameTemp;
        int friendshipStatusTemp;
        UserEntity user = new UserEntity();

        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FRIENDSHIP WHERE (USERNAME = '" + userName + "'AND USE_USERNAME='" + friendName + "') OR( USERNAME = '" + friendName + "' AND USE_USERNAME='" + userName + "') AND friendshipStatus='" + FreindshipController.ACCEPT_INVITATION + "' ");

            while (result.next()) {
                userNameTemp = result.getString(1);
                friendNameTemp = result.getString(2);
                friendshipStatusTemp = result.getInt(3);
                if ((userNameTemp.equals(userName)) & (friendNameTemp.equals(friendName)) & (friendshipStatusTemp == ACCEPT_INVITATION)) {
                    DB_Connection.updateQuery("DELETE FROM  friendship  WHERE USERNAME='" + userName + "'AND USE_USERNAME='" + friendName + "'  ");

                } else if ((userNameTemp.equals(friendName)) & (friendNameTemp.equals(userName)) & (friendshipStatusTemp == ACCEPT_INVITATION)) {
                    DB_Connection.updateQuery("DELETE FROM  friendship  WHERE USERNAME='" + friendName + "' AND USE_USERNAME='" + userName + "'  ");
                }

            }
        } catch (SQLException ex) {

            ex.printStackTrace();
            System.out.println("you are already not friend with him");
            return false;

        }

        return true;
    }

    /**
     *
     * @param userName
     * @return
     */
    @Override
    public Vector<UserEntity> getFreindList(String userName) throws RemoteException {
        UserEntity user = new UserEntity();

        Vector<UserEntity> friendList;
        friendList = new Vector<UserEntity>();
        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FRIENDSHIP ,FREIND WHERE( USERNAME = '" + userName + "' OR USE_USERNAME='" + userName + "') & friendshipStatus= '" + FreindshipController.ACCEPT_INVITATION + "'");

            while (result.next()) {

                user.setUsername(result.getString("USERNAME"));
                user.setFirstName((result.getString("FIRSTNAME")));
                user.setLastName(result.getString("LASTNAME"));
                user.setDateOfBirth(result.getString("DATEOFBIRTH"));
                user.setMode(result.getInt("MODE"));
                user.setStatus(result.getBoolean("STATUS"));
                user.setGender(result.getString("GENDER").charAt(0));
                friendList.add(user);

            }

        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
        return friendList;
    }

    /**
     *
     * @param userName
     * @return
     */
    @Override
    public Vector<UserEntity> getFreindRequest(String userName) throws RemoteException {

        UserEntity user = new UserEntity();

        Vector<UserEntity> friendRequest;
        friendRequest = new Vector<UserEntity>();
        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FREINDSHIP WHERE  USE_USERNAME='" + userName + "' AND (friendshipStatus ='" + FreindshipController.ADD_FRIEND + "' OR friendshipStatus='" + FreindshipController.IGNORE_INVITATION + "' ')");

            while (result.next()) {

                user.setUsername(result.getString("USERNAME"));
                user.setFirstName((result.getString("FIRSTNAME")));
                user.setLastName(result.getString("LASTNAME"));
                user.setDateOfBirth(result.getString("DATEOFBIRTH"));
                user.setMode(result.getInt("MODE"));
                user.setStatus(result.getBoolean("STATUS"));
                user.setGender(result.getString("GENDER").charAt(0));
                friendRequest.add(user);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }
        return friendRequest;
    }

    @Override
    public ServerServicesInterface getService(int serviceNumber) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
