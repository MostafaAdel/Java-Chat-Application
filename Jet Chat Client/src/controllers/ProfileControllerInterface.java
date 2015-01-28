/***********************************************************************
 * Module:  ProfileControllerInterface.java
 * Author:  Mohamed
 * Purpose: Defines the Interface ProfileControllerInterface
 ***********************************************************************/

package controllers;

import java.awt.Image;


public interface ProfileControllerInterface {
   
   boolean changeName(String name);
   
   boolean changePassword(String password);
   
   boolean changeImage(Image image);
   
   boolean changeMobile(String mobile);

}