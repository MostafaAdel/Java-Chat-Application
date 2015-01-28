/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import callbacks.ChatCallbackInterface;
import callbacks.ChatGroupCallbackInterface;
import callbacks.ClientCallbackInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Mohamed
 */
public class ClientMainController extends UnicastRemoteObject implements ClientCallbackInterface {

    ChatCallbackInterface chatCallbackInterface;
    ChatGroupCallbackInterface chatGroupCallbackInterface;
    ProfileControllerInterface profileControllerInterface;
    Registry registry;
    ClientMainController() throws RemoteException {
        registry = LocateRegistry.getRegistry("127.0.0.1", 1993);
    }

    @Override
    public ClientCallbackInterface getCallback(int callbackNumber) throws RemoteException {
        return null;
    }

}
