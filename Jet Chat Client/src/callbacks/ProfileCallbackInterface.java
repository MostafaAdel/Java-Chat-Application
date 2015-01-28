/**
 * *********************************************************************
 * Module: ProfileCallbackInterface.java Author: Mohamed Purpose: Defines the
 * Interface ProfileCallbackInterface
 **********************************************************************
 */
package callbacks;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProfileCallbackInterface extends ClientCallbackInterface{

    boolean notifyFriendMode(String friendName, int mode) throws RemoteException;

    boolean notifyFriendStatus(String friendName, int status) throws RemoteException;

}
