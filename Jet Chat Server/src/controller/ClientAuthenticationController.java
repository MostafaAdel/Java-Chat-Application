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
/** @pdOid a65e1049-0ed2-4c53-b7cc-5708c8135857 */
public class ClientAuthenticationController implements ClientAuthenticationControllerInterface {
   /** @pdOid 80ebf55c-60b1-4145-b957-7a3b3bfe2355
       @pdRoleInfo migr=yes name=ServerController assc=association5 */
   private ServerController serverController;
    private  ServerController ServerController;
   
   /** @param controller
    * @pdOid 0245b621-1174-4f8a-9f8b-ae266a5e1167 */
   ClientAuthenticationController(ServerController controller) {
      
      this.ServerController = controller;
   }
   
   /** @param userName 
    * @param password
    * @pdOid 47782f03-aaf6-4f26-85db-06e03b6da19a */
   public boolean signIn(String userName, String password) {
      // TODO: implement
      return false;
   }
   
   /** @param user
    * @pdOid bd7a7e0d-c1c7-4db8-864f-a2dc633f6b57 */
   public boolean signUp(UserEntity user) {
      // TODO: implement
      return false;
   }
   
   /** @param userName
    * @pdOid e11ba090-748b-4ea3-babe-e9b25a5d4fa9 */
   public boolean signOut(String userName) {
      // TODO: implement
      return false;
   }
   
   /** @param userName
    * @pdOid c399a949-29b3-4779-8bff-9ab9d5d71ffe */
   public UserEntity userViewData(String userName) {
      // TODO: implement
      return null;
   }

}
