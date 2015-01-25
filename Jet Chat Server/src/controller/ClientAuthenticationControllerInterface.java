/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.UserEntity;

/**
 *
 * @author Mostafa_ITI
 */
interface ClientAuthenticationControllerInterface {
   /** @param username 
    * @param password
    * @pdOid fab8b71e-0c5b-436a-a3a0-9c30af344535 */
   boolean singIN(String username, String password);
   /********************************************************/
   
   /** @param username
    * @pdOid e92eba3b-a955-4df8-8076-769478e34d8e */
   boolean singOut(String username);
   
   /*************************************************/
   
   /** @param UserEntity user
    */
   /*********************************************************/
   boolean singUp(UserEntity user); 
   
   /************************************************************/
   /**@param String user name
    * 
    */
   UserEntity userViewData(String username );
}
