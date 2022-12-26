/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Александр
 */
public class MySqlData {
        private static String host;
        private static String port;
        private static String db_name;
        private static String userName;
        private static String password;
        private static Properties props = new Properties();;
        static {
            try {
                props.load(new FileInputStream(new File("C:\\ProgramData\\Booking system\\conf.ini")));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MySqlData.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MySqlData.class.getName()).log(Level.SEVERE, null, ex);
            }
            updatePropery();
        }
        public static void updatePropery(){
            host = String.valueOf(props.getProperty("host","1"));
            port = String.valueOf(props.getProperty("port","1"));
            db_name = String.valueOf(props.getProperty("db_name","1"));
            userName = String.valueOf(props.getProperty("username","1"));
            password = String.valueOf(props.getProperty("password","1"));
        }
        public static void setDataOfDB(String newHost, String newPort, String new_db_name, String newUserName, String newPassword) throws IOException{
            File f = new File("C:\\ProgramData\\Booking system\\conf.ini");
            f.getParentFile().mkdir();
                PrintWriter writer = new PrintWriter(new FileWriter(f, false));
                writer.println("host = " + newHost);
                writer.println("port = " + newPort);
                writer.println("db_name = " + new_db_name);
                writer.println("username = " + newUserName);
                writer.println("password = " + newPassword);
                writer.close();
            updatePropery();
        }
        public static String getHost(){
            return host;
        }
        public static String getPort(){
            return port;
        }
        public static String getDBname(){
            return db_name;
        }
        public static String getUserName(){
            return userName;
        }
        public static String getPassword(){
            return password;
        }
}
