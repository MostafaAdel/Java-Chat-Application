/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerController;

/**
 *
 * @author May
 */
public interface UserProfileControllerInterface {
    
    boolean sendUserStatusToOnlineUsers(String userName);
    boolean senduserModeToOnlineUsers(String userName);
    
    


}
