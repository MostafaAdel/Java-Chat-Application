/***********************************************************************
 * Module:  ServerController.java
 * Author:  Mohamed
 * Purpose: Defines the Class ServerController
 ***********************************************************************/

package controller;

import controller.ServerControllerInterface;
import datatypes.Advertisement;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServerServicesInterface;


public class ServerController extends UnicastRemoteObject implements ServerControllerInterface, ServerServicesInterface {

   private int serverStatus;
   private ClientAuthenticationControllerInterface clientAuthController;
   private FreindshipControllerInterface friendshipController;
   private UserProfileControllerInterface userProfileController;
   private ChatControllerInterface chatController;
   private Hashtable<String, RemoteObject> allUsersRemoteObjects;
   private Registry registery;
   
    private ServerController() throws RemoteException{
        
        
        allUsersRemoteObjects = new Hashtable<>();
        clientAuthController = new ClientAuthenticationController(this);
        friendshipController = new FreindshipController(this);
        userProfileController = new UserProfileController(this);
        chatController = new ChatController(this);
        
        //binding Now !!
        registery = LocateRegistry.createRegistry(1993);
       try {
           registery.bind("ChatServices", this);
       } catch (AlreadyBoundException | AccessException ex) {
           Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
   
   
   /** @param args
    **/
   public static void main(String[] args) {
       try {
           new ServerController();
       } catch (RemoteException ex) {
           Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
       }
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

    @Override
    public ServerServicesInterface getService(int serviceNumber) throws RemoteException {
        
        if (serviceNumber == ServerServicesInterface.AUTHENTICATION_SERVICE)
             return (ServerServicesInterface) clientAuthController;
        else  if (serviceNumber == ServerServicesInterface.CHAT_SERVICE)
             return (ServerServicesInterface) chatController;
        else  if (serviceNumber == ServerServicesInterface.FRIENDSHIP_SERVICE)
             return (ServerServicesInterface) friendshipController;
        else  if (serviceNumber == ServerServicesInterface.PROFILE_SERVICE)
             return (ServerServicesInterface) userProfileController;
        else 
            return null;
        
        
        
    }

}