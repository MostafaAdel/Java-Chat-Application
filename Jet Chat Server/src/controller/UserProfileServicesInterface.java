/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.UserEntity;
import java.rmi.Remote;

/**
 *
 * @author May
 */
public interface UserProfileServicesInterface extends Remote{
   static final int onlineStatus = 1;
   static final int offlineStatus = 2;
   static final int busyMode = 3;
   static final int awayMode = 4;
   static final int drinkingCoffeeMode = 5;
    
    
    boolean changeMode(String userName,int userMode);
    boolean changeStatus(String userName, int userStatus) ;
    public boolean editeUserInformation(String oldPassword, UserEntity user);
    
}
