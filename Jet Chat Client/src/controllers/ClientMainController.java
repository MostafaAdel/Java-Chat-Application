/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import callbacks.ChatCallbackInterface;
import callbacks.ChatGroupCallbackInterface;
import callbacks.ClientCallbackInterface;
import entity.UserEntity;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ClientAuthenticationServiceInterface;
import services.ServerServicesInterface;

/**
 *
 * @author Mohamed
 */
public class ClientMainController extends UnicastRemoteObject implements ClientCallbackInterface {

    ChatCallbackInterface chatCallbackInterface;
    ChatGroupCallbackInterface chatGroupCallbackInterface;
    ProfileControllerInterface profileControllerInterface;
    private Registry registry;
    public ServerServicesInterface serverServices;
    UserEntity userData;
    
    ClientMainController() throws RemoteException {
        
        registry = LocateRegistry.getRegistry("127.0.0.1", 1993);
        try {
            serverServices = (ServerServicesInterface) registry.lookup("ChatServices");
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientMainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(ClientMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        profileControllerInterface = new ProfileController(this);
        
        
        //----for testing-----
//        ClientAuthenticationServiceInterface auth = (ClientAuthenticationServiceInterface) serverServices.getService(ServerServicesInterface.AUTHENTICATION_SERVICE);
//        userData = auth.userViewData("mostafa90");
//        profileControllerInterface.changeMobile("01286737088");
        //-----for testing----
    }
    
    public static void main(String[] args) {
        try {
            new ClientMainController();
        } catch (RemoteException ex) {
            Logger.getLogger(ClientMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ClientCallbackInterface getCallback(int callbackNumber) throws RemoteException {
        return null;
    }

}
