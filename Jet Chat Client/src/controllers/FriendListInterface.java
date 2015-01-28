/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Mostafa_ITI
 */
public interface FriendListInterface {
    void startNewChatWithFriend();
       
   void changeUserIimage();
   void changeUserMode();
   void addNewFriend();
   void displayNewAdvertisement();
   void signOut();
   void exit();
   void showFriendRequests();
   void deleteFriend();
   void searchFriend();
   void notifyMode();
   void notifyStatus();

}
