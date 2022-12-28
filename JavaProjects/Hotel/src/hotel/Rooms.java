
package hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Александр
 */
public class Rooms {
    
    MySqlConnection connection = new MySqlConnection();
    
    public void fillTypeTable(JTable table){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String selectQuery = "SELECT * FROM `type`";
        try {
            preparedStatement = connection.getConnection().prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            Object[] row;
            while(resultSet.next()){
                row = new Object[3];
                row[0] = resultSet.getInt(1);
                row[1] = resultSet.getString(2);
                row[2] = resultSet.getString(3);
        
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fillRoomsTable(JTable table){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String selectQuery = "SELECT * FROM `rooms`";
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
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fillTypeCombobox(JComboBox comboBox){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String selectQuery = "SELECT * FROM `type`";
        try {
            preparedStatement = connection.getConnection().prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
        
                comboBox.addItem(resultSet.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean addRoom(int number, int type, String phone, String status){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String addQuery = "INSERT INTO `rooms`(`room_number`, `type`, `phone`, `reserve_status`) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.getConnection().prepareStatement(addQuery);
            preparedStatement.setInt(1, number);
            preparedStatement.setInt(2, type);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, status);
            
                return preparedStatement.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean editRoom(int number, int type, String phone, String isReserved){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String updateQuery = "UPDATE `rooms` SET "
                + "`type`=?,`phone`=?, `reserve_status`=? WHERE `room_number`= ?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(updateQuery);
            preparedStatement.setInt(1, type);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, isReserved);
            preparedStatement.setInt(4, number);
            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean removeRoom(int number){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String deleteQuery = "DELETE FROM `rooms` WHERE `room_number`=?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(deleteQuery);
            preparedStatement.setInt(1, number);
            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
