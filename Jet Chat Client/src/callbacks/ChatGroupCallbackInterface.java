/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callbacks;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author Mohamed
 */
public interface ChatGroupCallbackInterface extends ClientCallbackInterface {

    /**
     * @param groupFreindsRemoteObjects
     * @pdOid 455fe16b-2dfd-47ba-a5fc-4aac5ca45412
     */
    boolean receiveGroupRemoteObject(Vector<Object> groupFreindsRemoteObjects) throws RemoteException;

    /**
     * @param userName
     * @param groupId
     * @param msg
     * @pdOid 658da5b8-2aa3-4e11-b664-9a1003c26d79
     */
    //boolean receiveMsgfromGroup(String userName, int groupId, /*Message msg*/);
}
