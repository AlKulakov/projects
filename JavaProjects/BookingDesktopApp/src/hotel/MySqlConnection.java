/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Александр
 */
public class MySqlConnection {

        private Connection connection;

        Connection getConnection() throws SQLException{
            connection = DriverManager.getConnection("jdbc:mysql://"+ MySqlData.getHost()
                + ":"+ MySqlData.getPort() + "/"+ MySqlData.getDBname(), MySqlData.getUserName(), 
                MySqlData.getPassword());
            return connection;
        }
        void connectionClose(){
            if(connection!=null)
                try { connection.close(); } catch (SQLException e) { /* Ignored */ }

        }
}
