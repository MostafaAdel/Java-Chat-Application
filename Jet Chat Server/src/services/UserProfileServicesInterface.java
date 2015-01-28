/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.UserEntity;
import java.rmi.Remote;

/**
 *
 * @author May
 */
public interface UserProfileServicesInterface extends Remote{
   static final int ONLINE_STATUS = 1;
   static final int OFFLINE_STATUS = 2;
   static final int AVIALBALE_MODE = 1;
   static final int BUSY_MODE = 2;
   static final int AWAY_MODE = 3;
   static final int DRINKING_COFFEE_MODE = 4;
    
    
    boolean changeMode(String userName,int userMode);
    boolean changeStatus(String userName, int userStatus) ;
    public boolean editeUserInformation(String oldPassword, UserEntity user);
    
}
