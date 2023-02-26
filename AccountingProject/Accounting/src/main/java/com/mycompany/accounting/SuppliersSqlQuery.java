/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accounting;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class SuppliersSqlQuery {
    MySqlConnection connection = new MySqlConnection();
    public boolean addSupplier(String name, String phone, String account, String address, String description){
        //Функция добавить в таблицу БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String addQuery = "INSERT INTO `suppliers`(`name`, `phone`, `account`, `address`, `description`) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.getConnection().prepareStatement(addQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, account);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, description);
            if(preparedStatement.executeUpdate() > 0) {
                return true;
            
            }else
                return false;
            
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
    
    public boolean editSupplier(int id, String name, String phone, String account, String address, String description){
        //Функция изменить в таблице БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String updateQuery = "UPDATE `suppliers` SET `name`=?,"
                + "`phone`=?, `account`=?, `address`=?, `description`=? WHERE `id`= ?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(updateQuery);
            preparedStatement.setString(1,  name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, account);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, description);
            preparedStatement.setInt(6, id);
            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(StuffSqlQuery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
    
    public boolean removeSupplier(int id){
        //Функция удалить в таблице БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String deleteQuery = "DELETE FROM `suppliers` WHERE `id`=?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            return (preparedStatement.executeUpdate() > 0);
        } catch (SQLException ex) {
            Logger.getLogger(StuffSqlQuery.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
    
    public void fillSupplierTable(JTable table){
        //Функция заполнить таблицу информацией из БД.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectQuery = "SELECT `id`, `name`, `phone`, `account`, `address`, `description` FROM `suppliers`";
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
            Logger.getLogger(StuffSqlQuery.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            connection.connectionClose();
        }
    }
}
