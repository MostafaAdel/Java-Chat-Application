/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callbacks;

import entity.UserEntity;
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mohamed
 */
public interface ChatCallbackInterface extends ClientCallbackInterface {

    /**
     * @param senderName
     * @param msg
     * @pdOid 73b80023-73cb-4c3f-8f3b-316ede7805da
     */
    boolean receiveFromOneFreind(String senderName, String msg) throws RemoteException;

    /**
     * take remote object
     *
     *
     * @param user
     * @pdOid 23a0a2cd-c087-463d-a4c6-ec1cbcf40ba5
     */
    boolean receiveRemoteObjectFromFreind(UserEntity user) throws RemoteException;

    /**
     * @param file
     * @pdOid 904c0bb6-8e90-4061-a2da-bf9ad37fbd93
     */
    boolean downloadFile(File file) throws RemoteException;

    /**
     * @pdOid bc1d21fe-063f-4414-84a0-794646630ffe
     */
    boolean updateFriendData() throws RemoteException;

}
