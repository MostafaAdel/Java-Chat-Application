/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mohamed
 */
public interface ServerServicesInterface extends Remote{
 
   static final int PROFILE_SERVICE = 1;
   /** @pdOid 52028f9f-1395-408d-b77e-cadad53bf67c */
   static final int AUTHENTICATION_SERVICE = 2;
   /** @pdOid 3f11634f-7f79-4ba7-a4cb-bc964cf0bec4 */
   static final int FRIENDSHIP_SERVICE = 3;
   /** @pdOid 486b711c-f1e9-49f3-a2eb-43c0064bbc37 */
   static final int CHAT_SERVICE = 4;
   
   /** @param serviceNumber
    * @pdOid 22323290-0005-42b4-9c8f-587e0542c000 */
   ServerServicesInterface getService(int serviceNumber) throws RemoteException;

}

