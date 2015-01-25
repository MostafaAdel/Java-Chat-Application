/***********************************************************************
 * Module:  ServerController.java
 * Author:  Mohamed
 * Purpose: Defines the Class ServerController
 ***********************************************************************/

package controller;

import controller.ServerControllerInterface;
import datatypes.Advertisement;
import datatypes.User;
import java.rmi.server.RemoteObject;
import java.util.*;


public class ServerController implements ServerControllerInterface {

   private int serverStatus;
   //private ClientAuthenticationControllerInterface clientAuthController;
   //private UserFriendShipControllerInterface friendshipController;
   //private UserProfileControllerInterface userProfileController;
   //private ChatControllerInterface chatController;
   private Hashtable<String, RemoteObject> allUsersRemoteObjects;

    private ServerController() {
        
        allUsersRemoteObjects = new Hashtable<>();
    }
   
   
   /** @param args
    **/
   public static void main(String[] args) {
      
   }
   
    @Override
    public void startServer() {
        
    }

    @Override
    public void stopServer() {
       
    }

    @Override
    public void sendAdvirtise(Advertisement advertisement) {
       
    }

    @Override
    public int[] getStatistics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RemoteObject getUserRemoteObject(String username) {
        
        return allUsersRemoteObjects.get(username);
    }

    @Override
    public void removeUserRemoteObject(String username) {
        
        allUsersRemoteObjects.remove(username);
    }

    @Override
    public void insertUserRemoteObject(String username, RemoteObject remoteObject) {
        
        allUsersRemoteObjects.put(username, remoteObject);
    }

}