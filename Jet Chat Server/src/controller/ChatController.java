/***********************************************************************
 * Module:  ChatController.java
 * Author:  Mohamed
 * Purpose: Defines the Class ChatController
 ***********************************************************************/

package controller;

import entity.UserEntity;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.util.*;
import services.ChatServiceInterface;


public class ChatController implements ChatControllerInterface, ChatServiceInterface {
 
    private ServerControllerInterface serverController;
   
   /** @param ServerController
   **/
    ChatController(ServerControllerInterface controller) {
      this.serverController = controller;
   }

    @Override
    public RemoteObject getFriendRemoteObject(String friendName) throws RemoteException {
        
        return serverController.getUserRemoteObject(friendName);
    }

    @Override
    public Vector<RemoteObject> getGroupRemoteObjects(Vector<String> groupUsers) throws RemoteException {
        
        Vector<RemoteObject> group = new Vector<>();
        
        for(String username : groupUsers){
            
            RemoteObject userRemoteObject = serverController.getUserRemoteObject(username);
            group.addElement(userRemoteObject);
        }
            
        
        return group;
    }

    public boolean singIN(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean singOut(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean singUp(UserEntity user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}