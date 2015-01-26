/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Vector;
import db.com.DB_Connection;
import entity.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Rania
 */
public class FreindshipController implements FreindshipControllerInterface {

    private ServerController serverController;
    
    
    
     FreindshipController(ServerController controller) {

        this.serverController = controller;
    }

    public FreindshipController() {

    }

    

    @Override
    public boolean addFreind(String userName, String friendName) {

        String userNameTemp;
        String friendNameTemp;
        friendshipEntity friendship = new friendshipEntity();
        try {
            ResultSet result;
           // ResultSet result1;
            result = DB_Connection.selectQuery("SELECT * FROM FRIENDSHIP WHERE USERNAME = '" + userName + "' AND USE_USERNAME='" + friendName + "' OR USERNAME = '" + friendName + "' AND USE_USERNAME='" + userName + " ' ");
            
            while (result.next()) {

                userNameTemp = result.getString(1);
                friendNameTemp = result.getString(2);
                if (((userNameTemp == userName) & (friendNameTemp == friendName)) || (((userNameTemp == friendName) & (friendNameTemp == userName) ))) {
                    System.out.println("you aready friend");
                    break;
                    // return true ;
                } /*else if ((userNameTemp == friendName) & (friendNameTemp == userName)) {
                    System.out.println("you aready friend");
                    break;
                } */
             //   if ()
                else {

                    //  DB_Connection.updateQuery("UPDATE friendship SET friendshipStatus=1 WHERE USERNAME='" + userName + "'&USE_USERNAME='" + friendName + "'  ");
                    DB_Connection.updateQuery("INSERT INTO friendship (USERNAME, USER_USERNAME, friendshipStatus)VALUES "
                            + "('" + userName + "','" + friendName + "','1')");
                }
                // return true ;
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
            return false;
        }

        return true;

    }

    @Override
    public UserEntity acceptInvitation(String userName, String friendName) {

        String userNameTemp;
        String friendNameTemp;
        int friendshipStatusTemp;
        UserEntity user = new UserEntity();

        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FREINDSHIP WHERE USERNAME = '" + userName + "' AND USE_USERNAME='" + friendName + "' AND friendshipStatus <> '2'  ");

            while (result.next()) {

                userNameTemp = result.getString(1);
                friendNameTemp = result.getString(2);
                friendshipStatusTemp = result.getInt(3);
                if (((userNameTemp == userName) & (friendNameTemp == friendName) & (friendshipStatusTemp != 2))  ) {
                    DB_Connection.updateQuery("UPDATE friendship SET friendshipStatus=1 WHERE USERNAME='" + userName + "', USE_USERNAME='" + friendName + "'  ");
                    result = DB_Connection.selectQuery("SELECT * FROM USER WHERE USERNAME ='" + friendName +"' ");

                    user.setUsername(result.getString("USERNAME"));
                    user.setFirstName((result.getString("FIRSTNAME")));
                    user.setLastName(result.getString("LASTNAME"));
                    user.setDateOfBirth(result.getString("DATEOFBIRTH"));
                    user.setMode(result.getInt("MODE"));
                    user.setStatus(result.getBoolean("STATUS"));
                    user.setGender(result.getString("GENDER").charAt(0));
                    // user.setImageProfile(result.getBinaryStream(""));
                    return user;

                } /*else if ((userNameTemp == userName) & (friendNameTemp == friendName) & (friendshipStatusTemp == 2)) {
                    System.out.println("you aready friend");
                    break;
                } else if ((userNameTemp == friendName) & (friendNameTemp == userName) & (friendshipStatusTemp == 2)) {
                    System.out.println("you aready friend");
                    break;
                } else if ((userNameTemp == friendName) & (friendNameTemp == userName) & (friendshipStatusTemp == 1)) {
                    System.out.println("you aready friend");
                    break;
                } else if ((userNameTemp == friendName) & (friendNameTemp == userName) & (friendshipStatusTemp == 3)) {
                    System.out.println("you aready friend");
                    break;
                }*/
                /* else if((userNameTemp == friendName) & (friendNameTemp == userName)&(friendshipStatusTemp==4))
                 {
                 System.out.println("you aready friend");
                 break;
                 }*/

                // return true ;
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
            return null;
        }

        return user;

    }

    @Override
    public boolean ignoreInvitation(String userName, String friendName) {

        String userNameTemp;
        String friendNameTemp;
        int friendshipStatusTemp;
        UserEntity user = new UserEntity();

        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FREINDSHIP WHERE USERNAME = '" + userName + "' AND USE_USERNAME='" + friendName + "' AND friendshipStatus NOT IN(2,3) ");

             while (result.next()) {
            userNameTemp = result.getString(1);
            friendNameTemp = result.getString(2);
            friendshipStatusTemp = result.getInt(3);
            if ((userNameTemp == userName) & (friendNameTemp == friendName)) {
                DB_Connection.updateQuery("UPDATE friendship SET friendshipStatus=3 WHERE USERNAME='" + userName + "'&USE_USERNAME='" + friendName + "'  ");
                break ;
            }
          /*  else if((userNameTemp == userName) & (friendNameTemp == friendName) & (friendshipStatusTemp == 3))
            {
                System.out.println("you already ignore him");
                
            }
            else if((userNameTemp == friendName) & (friendNameTemp == userName) & (friendshipStatusTemp == 3))
            {
                System.out.println("you send him invite");
                
            }*/
            
             }
              } catch (SQLException ex) {

            ex.printStackTrace();
            return false ;
          
        }
        return true;
        }


        @Override
        public boolean rejectInvitation  (String userName, String friendName)
        {
        
        
         
         String userNameTemp;
        String friendNameTemp;
        int friendshipStatusTemp;
        UserEntity user = new UserEntity();

        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FREINDSHIP WHERE USERNAME = '" + userName + "'&USE_USERNAME='" + friendName + "' ");

             while (result.next()) {
            userNameTemp = result.getString(1);
            friendNameTemp = result.getString(2);
            friendshipStatusTemp = result.getInt(3);
            if ((userNameTemp == userName) & (friendNameTemp == friendName) & (friendshipStatusTemp != 2)) {
                DB_Connection.updateQuery("DELETE FROM  friendship  WHERE USERNAME='" + userName + "',USE_USERNAME='" + friendName + "'  ");

            }
            
             }
              } catch (SQLException ex) {

            ex.printStackTrace();
            return false ;
          
        }
        return true;
    }

    @Override
        public boolean deleteFreind (String userName, String friendName)
        {
        String userNameTemp;
        String friendNameTemp;
        int friendshipStatusTemp;
        UserEntity user = new UserEntity();

        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FREINDSHIP WHERE USERNAME = '" + userName + "'&USE_USERNAME='" + friendName + "' OR USERNAME = '" + friendName + "' AND USE_USERNAME='" + userName + "' AND freindshipStatus='2' ");

             while (result.next()) {
            userNameTemp = result.getString(1);
            friendNameTemp = result.getString(2);
            friendshipStatusTemp = result.getInt(3);
            if ((userNameTemp == userName) & (friendNameTemp == friendName) & (friendshipStatusTemp == 2)) {
                DB_Connection.updateQuery("DELETE FROM  friendship  WHERE USERNAME='" + userName + "',USE_USERNAME='" + friendName + "'  ");

            }
            else if((userNameTemp == friendName) & (friendNameTemp == userName) & (friendshipStatusTemp == 2))
            {
                 DB_Connection.updateQuery("DELETE FROM  friendship  WHERE USERNAME='" + friendName + "',USE_USERNAME='" + userName + "'  ");
            }
            
            }
              } catch (SQLException ex) {

            ex.printStackTrace();
            System.out.println("you are already not friend with him");
            return false ;
          
        }
        
         
       return true;
    }

    /**
     *
     * @param userName
     * @return
     */
    @Override
        public Vector<UserEntity> getFreindList(String userName)
        { 
         UserEntity user = new UserEntity();
        
         Vector<UserEntity> friendList;
      friendList = new Vector<UserEntity>();
        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FREINDSHIP ,FREIND WHERE USERNAME = '" + userName + "' | USE_USERNAME='" + userName + "' & friendshipStatus= '2 '");
         
           while(result.next()) 
           {
               
                    user.setUsername(result.getString("USERNAME"));
                    user.setFirstName((result.getString("FIRSTNAME")));
                    user.setLastName(result.getString("LASTNAME"));
                    user.setDateOfBirth(result.getString("DATEOFBIRTH"));
                    user.setMode(result.getInt("MODE"));
                    user.setStatus(result.getBoolean("STATUS"));
                    user.setGender(result.getString("GENDER").charAt(0));
                    friendList.add(user);
           }
           
           
        
        } catch (SQLException ex) {

            ex.printStackTrace();
    }
        return friendList ;
        }

    /**
     *
     * @param userName
     * @return
     */
    @Override
        public Vector<UserEntity> getFreindRequest(String userName)
        { 
        
        
    
        UserEntity user = new UserEntity();
        
         Vector<UserEntity> friendRequest;
      friendRequest = new Vector<UserEntity>();
        try {
            ResultSet result;
            result = DB_Connection.selectQuery("SELECT * FROM FREINDSHIP WHERE  USE_USERNAME='" + userName + "' & friendshipStatus ='1' | friendshipStatus='3'");
         
           while(result.next()) 
           {
               
                    user.setUsername(result.getString("USERNAME"));
                    user.setFirstName((result.getString("FIRSTNAME")));
                    user.setLastName(result.getString("LASTNAME"));
                    user.setDateOfBirth(result.getString("DATEOFBIRTH"));
                    user.setMode(result.getInt("MODE"));
                    user.setStatus(result.getBoolean("STATUS"));
                    user.setGender(result.getString("GENDER").charAt(0));
                    friendRequest.add(user);
           }
           
           
        
        } catch (SQLException ex) {

            ex.printStackTrace();
    }
        return friendRequest ;
        }


}
