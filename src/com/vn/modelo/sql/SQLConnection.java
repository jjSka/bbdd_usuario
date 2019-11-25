/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelo.sql;

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

    public static final String urldb = "jdbc:derby://localhost:1527/db_users", user = "root", pwd = "1234";
    private boolean flag = true;
    //jdbc:derby://localhost:1527/db_users

    public Connection openConnection() {
        System.err.println("Trying... connection set up");

        if (flag) {
            cargaDrivers();
        }
        
        Connection con = null;
        
                System.err.println("Trying... driver manager");
        try {
            con = DriverManager.getConnection(urldb, user, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error creating connection couldn't find");
        }

        return con;
    }

    public void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error closing connection");
        }
    }

    public void cargaDrivers() {
        System.err.println("Trying... driver set up");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            System.err.println("Connection stablished!");
            flag = false;
        } catch (Exception ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error creating connection (Failed Drivers)");
        }
    }
}
