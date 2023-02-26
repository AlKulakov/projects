/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accounting.MySqlOperations;

import com.mycompany.accounting.MySqlSetup.MySqlConnection;
import com.mycompany.accounting.MySqlOperations.SuppliesSqlQuery;
import static com.mycompany.accounting.UI.LoginForm.connection;
import static com.mycompany.accounting.UI.LoginForm.preparedStatement;
import static com.mycompany.accounting.UI.LoginForm.resultSet;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class RealizationSqlQuery {
    MySqlConnection connection = new MySqlConnection();
    
    public void fillRealizationsTable(JTable table){
        //Функция заполнить таблицу информацией из БД.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectQuery = "SELECT `realizations`.`id`, `products`.`name`, `amount`, `date` from `realizations` "
                + "LEFT JOIN `products` on `realizations`.`product_id` = `products`.`id`";
        try {
            preparedStatement = connection.getConnection().prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            Object[] row;
            while(resultSet.next()){
                row = new Object[5];
                row[0] = resultSet.getInt(1);
                row[1] = resultSet.getString(2);
                row[2] = resultSet.getString(3);
                row[3] = resultSet.getString(4);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppliesSqlQuery.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
    
    public void fillStuffCombobox(JComboBox comboBox, String type){
        //Функция заполнить выдвижной список информацией из БД.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectQuery = "SELECT `name` from `products` where `type` = ?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(selectQuery);
            preparedStatement.setString(1, type);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
        
                comboBox.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppliesSqlQuery.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }

    public boolean addRealization(String stuffName, int amount, String date){
        //Функция добавить в таблицу БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String addQuery = "insert into realizations (product_id, amount, date)\n" +
        "select (select `id` from `products` where `name`=?), ?, ?\n" +
        "where (SELECT total FROM accountings WHERE name=?) > ?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(addQuery);
            preparedStatement.setString(1, stuffName);
            preparedStatement.setInt(2, amount);
            preparedStatement.setString(3, date);
            preparedStatement.setString(4, stuffName);
            preparedStatement.setInt(5, amount);
            
                return preparedStatement.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        }finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
    
    public boolean editRealization(int id, String stuffName, int amount, String date){
        //Функция изменить в таблице БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String updateQuery = "update `realizations` set "
                + "`product_id` = (select `id` from `products` where `name`=?)," +
"amount = ?, date= ? WHERE id = ? and (SELECT total from accountings where name = ?) > ?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(updateQuery);
            preparedStatement.setString(1, stuffName);
            preparedStatement.setInt(2, amount);
            preparedStatement.setString(3, date);
            preparedStatement.setInt(4, id);
            preparedStatement.setString(5, stuffName);
            preparedStatement.setInt(6, amount);
            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(SuppliesSqlQuery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
    
    public boolean removeRealization(int number){
        //Функция удалить в таблице БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String deleteQuery = "DELETE FROM `realizations` WHERE `id`=?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(deleteQuery);
            preparedStatement.setInt(1, number);
            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(SuppliesSqlQuery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
}
