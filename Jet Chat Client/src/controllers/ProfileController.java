/***********************************************************************
 * Module:  ProfileController.java
 * Author:  Mohamed
 * Purpose: Defines the Class ProfileController
 ***********************************************************************/

package controllers;

import callbacks.ClientCallbackInterface;
import callbacks.ProfileCallbackInterface;
import java.awt.Image;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProfileController extends UnicastRemoteObject implements ProfileControllerInterface, ProfileCallbackInterface{
   
    
    ProfileController() throws RemoteException{
        
    }
    
    /**
     * @param String username
     * @return boolean
     * call server service to change username
    **/
   @Override   
   public boolean changeName(String name) {
      
      return false;
   }
   
   /** @param String password
     * @return boolean
     * call server service to change password
    **/
   @Override
   public boolean changePassword(String password) {
      // TODO: implement
      return false;
   }
   
   /** @param String mobile
     * @return boolean
     * call server service to change mobile
    **/
   @Override
   public boolean changeMobile(String mobile) {
      
      return false;
   }

    /** @param Image user image
     * @return boolean
     * call server service to change image
    **/
    @Override
    public boolean changeImage(Image image) {
        
        return false;
    }

    /** @param String friendName
     *  @param int mode
     * @return boolean
     * called by server to notify user if there is someone of his friends changes his mode
    **/
    @Override
    public boolean notifyFriendMode(String friendName, int mode) throws RemoteException {
        
        return false;
    }

    /** @param String friendName
     *  @param int status
     * @return boolean
     * called by server to notify user if there is someone of his friends goes offline or online
    **/
    @Override
    public boolean notifyFriendStatus(String friendName, int status) throws RemoteException {
        
        return false;
    }

    @Override
    public ClientCallbackInterface getCallback(int callbackNumber) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}