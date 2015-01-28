/***********************************************************************
 * Module:  ServerControllerInterface.java
 * Author:  Mohamed
 * Purpose: Defines the Interface ServerControllerInterface
 ***********************************************************************/

package controller;

import callbacks.ClientCallbackInterface;
import datatypes.Advertisement;
import java.util.*;
import java.rmi.server.RemoteObject;

public interface ServerControllerInterface {

   static final int serverStoped = 1;
   static final int serverPaused = 2;
   static final int serverRuning = 3;
   static final int serverStarted = 4;
   
   /**
    * @return void
    * start server and bind all services to registry
    */
   void startServer();
   
   /**
    * @return void
    * stop server and unbind all services to registry
    */
   void stopServer();
   
   /** @param Advertisement
    * send Advertisement to all users 
    */
   void sendAdvirtise(Advertisement advertisement);
   
   /**
    * @return int[]
    * get array of statistics
    */
   int[] getStatistics();
   
   /** @param String username
    * get remote object for specific username from allUsersRemoteObejcts Hashtable
    */
   ClientCallbackInterface getUserRemoteObject(String username);
   
   /** @param String username 
    * @param RemoteObejct remoteObject
    * remove remote obejct for specific username from allUsersRemoteObejcts Hashtable
    */
   void removeUserRemoteObject(String username);
   
   /** @param String username 
    * @param RemoteObejct remoteObject
    * insert remote obejct with username in allUsersRemoteObejcts Hashtable
    */
   void insertUserRemoteObject(String username, ClientCallbackInterface remoteObject);

}