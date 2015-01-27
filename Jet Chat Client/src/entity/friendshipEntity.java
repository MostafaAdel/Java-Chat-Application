/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Mostafa_ITI
 */
public class friendshipEntity {
    String username_sender;
    String username_reciever;
    int friendshipStatus;

    public String getUsername_sender() {
        return username_sender;
    }

    public void setUsername_sender(String username_sender) {
        this.username_sender = username_sender;
    }

    public String getUsername_reciever() {
        return username_reciever;
    }

    public void setUsername_reciever(String username_reciever) {
        this.username_reciever = username_reciever;
    }

    public int getFriendshipStatus() {
        return friendshipStatus;
    }

    public void setFriendshipStatus(int friendshipStatus) {
        this.friendshipStatus = friendshipStatus;
    }
    
    
}
