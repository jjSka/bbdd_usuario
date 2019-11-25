/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.sql;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class SQLConnection {
    //jdbc:derby://localhost:1527/db_users
    public Connection openConnection(String urlDB, String user, String pass){
        Connection con=null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            con = DriverManager.getConnection(urlDB, user, pass);
        } catch (Exception ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error creating connection");
        }
         return con;
    }
    public void closeConnection(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error closing connection");
        }
    }
}
