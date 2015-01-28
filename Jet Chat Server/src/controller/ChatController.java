/***********************************************************************
 * Module:  ChatController.java
 * Author:  Mohamed
 * Purpose: Defines the Class ChatController
 ***********************************************************************/

package controller;

import callbacks.ClientCallbackInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import services.ChatServiceInterface;
import services.ServerServicesInterface;


public class ChatController extends UnicastRemoteObject implements ChatControllerInterface, ChatServiceInterface {
 
    private ServerControllerInterface serverController;
   
   /** @param ServerController
   **/
    ChatController(ServerControllerInterface controller) throws RemoteException{
      this.serverController = controller;
   }

    @Override
    public ClientCallbackInterface getFriendRemoteObject(String friendName) throws RemoteException {
        
        return serverController.getUserRemoteObject(friendName);
    }

    @Override
    public Vector<ClientCallbackInterface> getGroupRemoteObjects(Vector<String> groupUsers) throws RemoteException {
        
        Vector<ClientCallbackInterface> group = new Vector<>();
        
        for(String username : groupUsers){
            
            ClientCallbackInterface userRemoteObject = serverController.getUserRemoteObject(username);
            group.addElement(userRemoteObject);
        }
            
        
        return group;
    }

    @Override
    public ServerServicesInterface getService(int serviceNumber) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
