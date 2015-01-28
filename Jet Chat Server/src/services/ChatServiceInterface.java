/***********************************************************************
 * Module:  ChatServiceInterface.java
 * Author:  Mohamed
 * Purpose: Defines the Interface ChatServiceInterface
 ***********************************************************************/

package services;

import callbacks.ClientCallbackInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.util.*;

public interface ChatServiceInterface extends ServerServicesInterface{
   
    /** @param String friendName
     * @return ClientCallbackInterface
     * @throws RemoteException
     * return remote object for specific username of friend
     */
    ClientCallbackInterface getFriendRemoteObject(String friendName) throws RemoteException;
   
   /** @param Vector<String> group usernames
     * @return Vector<ClientCallbackInterface>
     * @throws RemoteException
     * return vector of remote objects for specific usernames of a group
     */
   Vector<ClientCallbackInterface> getGroupRemoteObjects(Vector<String> groupUsers) throws RemoteException;

}