/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ServerController.UserProfileController;
import controller.ClientAuthenticationController;
import controller.UserProfileServices;
import entity.UserEntity;
import java.rmi.RemoteException;

import controller.*;
/**
 *
 * @author Mostafa_ITI
 */
public class testing {

    public static void main(String[] args) {
        UserEntity user = new UserEntity();
      //ClientAuthenticationController client = new ClientAuthenticationController();
        UserProfileController x = new UserProfileController();
        x.senduserModeToOnlineUsers("May");
         //client.signUp();
//         client.singIN("mostafa90", "12345");
//         user = client.userViewData("gaber92");

//        user.setUsername("Rania");  
//      user.setUserPassword("test");
//        user.setFirstName("hh");
//        user.setLastName("ook");
//        user.setGender('F');
//        user.setMobileNumber("01000000555");
//        user.setMode(1);
//         client.singUp(user);
//         user.setFirstName("May_tess");
//                  user.setUserPassword("pass");
//        UserProfileServices x = new UserProfileServices();
//         x.changeStatus("gaber92", UserProfileServices.onlineStatus);
//        x.editeUserInformation("1111", user);
//         System.out.println(user.getFirstName());
//         System.out.println(user.getLastName());
//         System.out.println(user.getGender());
//         System.out.println(user.getDateOfBirth());
       /*  user.setUsername("gaber92");
=======
         //client.singIN("mostafa90", "12345");
         //user = client.userViewData("gaber92");
        
         System.out.println(user.getFirstName());
         System.out.println(user.getLastName());
         System.out.println(user.getGender());
         System.out.println(user.getDateOfBirth());
        /* user.setUsername("gaber92");
>>>>>>> origin/master
         user.setUserPassword("12345");
         user.setFirstName("Mohamed");
         user.setLastName("Gaber");
         user.setGender('M');
         user.setMobileNumber("101020324");
         user.setMode(1);
         client.singUp(user);*/
        // FreindshipController freind=new FreindshipController(); 
         //freind.addFreind("rania", "may");
    }
}
