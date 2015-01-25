/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClientAuthenticationController;
import entity.UserEntity;

/**
 *
 * @author Mostafa_ITI
 */
public class testing {
     public static void main(String[] args) {
         UserEntity user = new UserEntity();
         ClientAuthenticationController client = new ClientAuthenticationController();
         //client.signUp();
         client.singIN("mostafa90", "12345");
         user = client.userViewData("gaber92");
        
         System.out.println(user.getFirstName());
         System.out.println(user.getLastName());
         System.out.println(user.getGender());
         System.out.println(user.getDateOfBirth());
        /* user.setUsername("gaber92");
         user.setUserPassword("12345");
         user.setFirstName("Mohamed");
         user.setLastName("Gaber");
         user.setGender('M');
         user.setMobileNumber("101020324");
         user.setMode(1);
         client.singUp(user);*/
    }
}
