/***********************************************************************
 * Module:  ChatServiceInterface.java
 * Author:  Mohamed
 * Purpose: Defines the Interface ChatServiceInterface
 ***********************************************************************/

package services;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.util.*;

public interface ChatServiceInterface extends Remote{
   
    /** @param String friendName
     * @return RemoteObject
     * @throws RemoteException
     * return remote object for specific username of friend
     */
   RemoteObject getFriendRemoteObject(String friendName) throws RemoteException;
   
   /** @param Vector<String> group usernames
     * @return Vector<RemoteObject>
     * @throws RemoteException
     * return vector of remote objects for specific usernames of a group
     */
   Vector<RemoteObject> getGroupRemoteObjects(Vector<String> groupUsers) throws RemoteException;

}