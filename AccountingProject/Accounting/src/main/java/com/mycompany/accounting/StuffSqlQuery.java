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


public class StuffSqlQuery {
    //Создание объекта подключения к бд
    MySqlConnection connection = new MySqlConnection();
    public boolean addStuff(String name, String description, String type){
        //Функция добавить в таблицу БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String addQuery = "INSERT INTO `products`(`name`, `description`, `type`) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.getConnection().prepareStatement(addQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, type);
            
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
    
    public boolean editStuff(int id, String name, String description){
        //Функция изменить в таблице БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String updateQuery = "UPDATE `products` SET `name`=?,"
                + "`description`=? WHERE `id`= ?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(updateQuery);
            preparedStatement.setString(1,  name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, id);
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
    
    public boolean removeStuff(int id){
        //Функция удалить в таблице БД информацию.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String deleteQuery = "DELETE FROM `products` WHERE `id`=?";
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
    
    public void fillStuffTable(JTable table, String type){
        //Функция заполнить таблицу информацией из БД.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectQuery = "SELECT `id`, `name`, `description` FROM `products` where `type`=?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(selectQuery);
            preparedStatement.setString(1, type);
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
