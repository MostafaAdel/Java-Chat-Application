/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import controller.*;
import entity.UserEntity;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
/**
 *
 * @author Rania
 */
public interface FreindshipServiceInterface extends ServerServicesInterface {
    
     /**@param String userName
     * @param  String  freindName
     */
    /************************************************************/
    boolean addFreind(String userName,String freindName) throws RemoteException;
    
      /**@param String userName
     * @param  String  freindName
     */
    /************************************************************/
    UserEntity acceptInvitation (String userName,String freindName) throws RemoteException;
    
      /**@param String userName
     * @param  String  freindName
     */
    /************************************************************/
    boolean ignoreInvitation (String userName,String freindName) throws RemoteException;
    
      /**@param String userName
     * @param  String  freindName
     */
    /************************************************************/
    
    boolean rejectInvitation (String userName,String freindName) throws RemoteException;
    
      /**@param String userName
     * @param  String  freindName
     */
    /************************************************************/
    boolean deleteFreind(String userName,String freindName)throws RemoteException;
      /**@param String userName
     * 
     */
    /************************************************************/
    Vector <UserEntity> getFreindList(String userName)throws RemoteException;
      /**@param String userName
     * 
     */
    /************************************************************/
    Vector <UserEntity> getFreindRequest(String userName)throws RemoteException;
    
    
        
    
    
    
}
