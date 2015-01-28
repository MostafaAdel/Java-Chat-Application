/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.UserEntity;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mostafa_ITI
 */
public interface ClientAuthenticationServiceInterface extends ServerServicesInterface{
   /** @param username 
    * @param password
    * @pdOid fab8b71e-0c5b-436a-a3a0-9c30af344535 */
   boolean singIN(String username, String password) throws RemoteException;
   /********************************************************/
   
   /** @param username
    * @pdOid e92eba3b-a955-4df8-8076-769478e34d8e */
   boolean singOut(String username) throws RemoteException;
   
   /*************************************************/
   
   /** @param UserEntity user
    */
   /*********************************************************/
   boolean singUp(UserEntity user) throws RemoteException; 
   
   /************************************************************/
   /**@param String user name
    * 
    */
   UserEntity userViewData(String username ) throws RemoteException;
}
