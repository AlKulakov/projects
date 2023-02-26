/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accounting.MySqlOperations;

import com.mycompany.accounting.MySqlSetup.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class SuppliesSqlQuery {
    MySqlConnection connection = new MySqlConnection();
    
    public void fillSuppliesTable(JTable table){
        //Функция заполнить таблицу информацией из БД.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectQuery = "SELECT `supplies`.`id`, `products`.`name`, `suppliers`.`name`, `amount`, `date` from `supplies` "
                + "LEFT JOIN `suppliers` on `supplies`.`suplier_id` = `suppliers`.`id` "
                + "LEFT JOIN `products` on `supplies`.`product_id` = `products`.`id`";
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
                row[4] = resultSet.getString(5);
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppliesSqlQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        } finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
    public void fillSuppliersCombobox(JComboBox comboBox){
        //Функция заполнить выдвижной список информацией из БД.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectQuery = "SELECT `name` from `suppliers`";
        try {
            preparedStatement = connection.getConnection().prepareStatement(selectQuery);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                comboBox.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuppliesSqlQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
    public boolean addSupply(String supplierName, String stuffName, int amount, String date){
        //Функция добавить в таблицу БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String addQuery = "INSERT INTO `supplies`(`suplier_id`, `product_id`, `amount`, `date`) "
                + "VALUES ((SELECT `id` FROM suppliers where `name`=?), (SELECT `id` FROM products where `name`=?), ?, ?)";
        try {
            preparedStatement = connection.getConnection().prepareStatement(addQuery);
            preparedStatement.setString(1, supplierName);
            preparedStatement.setString(2, stuffName);
            preparedStatement.setInt(3, amount);
            preparedStatement.setString(4, date);
            
                return preparedStatement.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            return false;
        } finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
    
    public boolean editSupply(int id, String supplierName, String stuffName, int amount, String date){
        //Функция изменить в таблице БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String updateQuery = "UPDATE `supplies` SET `suplier_id`=(SELECT `id` FROM suppliers where `name`=?), "
                + "`product_id`=(SELECT `id` FROM products where `name`=?),`amount`= ?, `date`= ? WHERE id = ?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(updateQuery);
            preparedStatement.setString(1, supplierName);
            preparedStatement.setString(2, stuffName);
            preparedStatement.setInt(3, amount);
            preparedStatement.setString(4, date);
            preparedStatement.setInt(5, id);
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
    
    public boolean removeSupply(int number){
        //Функция удалить в таблице БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String deleteQuery = "DELETE FROM `supplies` WHERE `id`=?";
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
