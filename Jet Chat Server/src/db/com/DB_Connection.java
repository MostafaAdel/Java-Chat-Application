/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.com;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mostafa
 */
public class DB_Connection {

    public static Connection conn = null;

    public static Connection doConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/jetchat";
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, "root", "root");
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
       
    }

    //insert,update, delete statement
    public static void updateQuery(String query) throws SQLException {
        Connection con = DB_Connection.doConnection();
        Statement stmt = (Statement) con.createStatement();
        int x = stmt.executeUpdate(query);
        System.out.println("Correct : " + x);
    }

    // Select statement
    public static ResultSet selectQuery(String query) {
        try {
            Connection con = doConnection();
            Statement stmt = (Statement) con.createStatement();
            ResultSet results = stmt.executeQuery(query);
            return results;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void closeConnection() throws SQLException {
        conn.close();
    }
}