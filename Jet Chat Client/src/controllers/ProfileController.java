/**
 * *********************************************************************
 * Module: ProfileController.java Author: Mohamed Purpose: Defines the Class
 * ProfileController
 **********************************************************************
 */
package controllers;

import callbacks.ClientCallbackInterface;
import callbacks.ProfileCallbackInterface;
import java.awt.Image;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServerServicesInterface;
import services.UserProfileServicesInterface;
import views.ProfileInfoViewInterface;

public class ProfileController extends UnicastRemoteObject implements ProfileControllerInterface, ProfileCallbackInterface {

    private ClientMainController mainController;
    private UserProfileServicesInterface profileService;
    private ProfileInfoViewInterface editProfileView;

    ProfileController(ClientMainController mainController) throws RemoteException {

        this.mainController = mainController;
        try {
            profileService = (UserProfileServicesInterface) mainController.serverServices.getService(ServerServicesInterface.PROFILE_SERVICE);
        } catch (AccessException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param String username
     * @return boolean call server service to change username
    *
     */
    @Override
    public boolean changeName(String name) {

        boolean updateStatus = false;

        //split Name to FirstName and LastName
        String[] nameSplitted = name.split(" ");

        //update user data
        mainController.userData.setFirstName(nameSplitted[0]);
        mainController.userData.setLastName(nameSplitted[1]);

        try {
            //send updated data to server
            
            updateStatus = profileService.editeUserInformation(mainController.userData.getUserPassword(), mainController.userData);
        } catch (RemoteException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return updateStatus;
    }

    /**
     * @param String password
     * @return boolean call server service to change password
    *
     */
    @Override
    public boolean changePassword(String newPassword) {
        
        boolean updateStatus = false;
        
        //store old password int temp
        String oldPassword = mainController.userData.getUserPassword();
        
        //update user data
        mainController.userData.setUserPassword(newPassword);
        
        try {
            //send updated data to server
            updateStatus = profileService.editeUserInformation(oldPassword, mainController.userData);
        } catch (RemoteException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return updateStatus;
    }

    /**
     * @param String mobile
     * @return boolean call server service to change mobile
    *
     */
    @Override
    public boolean changeMobile(String mobile) {

        boolean updateStatus = false;
        
        //update user data
        mainController.userData.setMobileNumber(mobile);
        
        try {
            //send updated data to server
            updateStatus = profileService.editeUserInformation(mainController.userData.getUserPassword(), mainController.userData);
        } catch (RemoteException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return updateStatus;
    }

    /**
     * @param Image user image
     * @return boolean call server service to change image
    *
     */
    @Override
    public boolean changeImage(Image image) {

        return false;
    }

    /**
     * @param String friendName
     * @param int mode
     * @return boolean called by server to notify user if there is someone of
     * his friends changes his mode
    *
     */
    @Override
    public boolean notifyFriendMode(String friendName, int mode) throws RemoteException {

        return false;
    }

    /**
     * @param String friendName
     * @param int status
     * @return boolean called by server to notify user if there is someone of
     * his friends goes offline or online
    *
     */
    @Override
    public boolean notifyFriendStatus(String friendName, int status) throws RemoteException {

        return false;
    }

    @Override
    public ClientCallbackInterface getCallback(int callbackNumber) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
