/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accounting.MySqlSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private Connection connection;

        public Connection getConnection() throws SQLException{
            connection = DriverManager.getConnection("jdbc:mysql://"+ MySqlData.getHost()
                + ":"+ MySqlData.getPort() + "/"+ MySqlData.getDBname(), MySqlData.getUserName(), 
                MySqlData.getPassword());
            return connection;
        }
        public void connectionClose(){
            if(connection!=null)
                try { connection.close(); } catch (SQLException e) { /* Ignored */ }

        }
}
