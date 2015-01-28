/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callbacks;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mohamed
 */
public interface ClientCallbackInterface extends Remote {
    /** @pdOid f825bde0-b247-44c9-810a-1d11f9698a72 */
   static final int chatController = 1;
   /** @pdOid 6cc393c1-0e19-4147-b003-11b806f27645 */
   static final int profileCotroller = 2;
   /** @pdOid eb1099f3-9479-417d-b296-c2ee7948ade1 */
   static final int chatGroupController = 3;
   
   /** @param callbackNumber
    * @pdOid 6aa7bf62-fb0d-4fcc-b14c-e5fad53bcd5f */
   ClientCallbackInterface getCallback(int callbackNumber) throws RemoteException;
   
}
