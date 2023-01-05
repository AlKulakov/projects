/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Александр
 */
public class Client {
    MySqlConnection connection = new MySqlConnection();
    public boolean addClient(String firstName, String fatherName,String lastName, String phone, String email){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String addQuery = "INSERT INTO `clients`(`first_name`, `father_name`, `second_name`, `phone_number`, `e_mail`) VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.getConnection().prepareStatement(addQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, fatherName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, email);
            
            if(preparedStatement.executeUpdate() > 0) {
                return true;
            
            }else
                return false;
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean editClient(int id, String firstName, String fatherName,String lastName, String phone, String email){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String updateQuery = "UPDATE `clients` SET `first_name`=?,"
                + "`father_name`=?,`second_name`=?,`phone_number`=?,`e_mail`=? WHERE `id`= ?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(updateQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, fatherName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, id);
            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean removeClient(int id){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String deleteQuery = "DELETE FROM `clients` WHERE `id`=?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void fillClientTable(JTable table){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String selectQuery = "SELECT * FROM `clients`";
        try {
            preparedStatement = connection.getConnection().prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            Object[] row;
            while(resultSet.next()){
                row = new Object[6];
                row[0] = resultSet.getInt(1);
                row[1] = resultSet.getString(2);
                row[2] = resultSet.getString(3);
                row[3] = resultSet.getString(4);
                row[4] = resultSet.getString(5);
                row[5] = resultSet.getString(6);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
