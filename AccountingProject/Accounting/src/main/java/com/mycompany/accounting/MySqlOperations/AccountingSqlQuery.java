/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accounting.MySqlOperations;

import com.mycompany.accounting.MySqlOperations.StuffSqlQuery;
import com.mycompany.accounting.MySqlSetup.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 select p.`name` as name, p.`description`, p.`type`,
    COALESCE(supply_amount.totalSupplies, 0) -
    COALESCE(realizations_amount.totalRealizations, 0) as total
    from products p
    left JOIN 
    (
        SELECT s.product_id as product_id, sum(amount) as totalSupplies
        from supplies s
        GROUP by s.product_id
    ) supply_amount
    ON p.id = supply_amount.product_id
    LEFT JOIN
    (
        SELECT r.product_id as product_id, SUM(amount) as totalRealizations
        from realizations r
        GROUP BY r.product_id
    ) realizations_amount
    ON p.id = realizations_amount.product_id
    GROUP by 1
    order by total desc
 */
public class AccountingSqlQuery {
    MySqlConnection connection = new MySqlConnection();
    public void fillAccountingTable(JTable table, String type){
        //Функция заполнить таблицу информацией из БД.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String selectQuery = "SELECT `name`, `description`,`total` from accountings where type = ?";
        try {
            preparedStatement = connection.getConnection().prepareStatement(selectQuery);
            preparedStatement.setString(1, type);
            resultSet = preparedStatement.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            Object[] row;
            while(resultSet.next()){
                row = new Object[3];
                row[0] = resultSet.getString(1);
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
    public void fillAccountingSearchTable(JTable table, String type, String regex){
        //Функция заполнить таблицу информацией из БД с необходимыми ключевыми словами.
        //PreparedStatement - подготовка запроса по ключевым аргументам.
        //ResultSet - Информация результата запроса
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        regex = "%"+regex+"%";
        String selectQuery = "SELECT `name`, `description`,`total` from accountings where type = ? and (`name` LIKE ? or `description` LIKE ?)";
        try {
            preparedStatement = connection.getConnection().prepareStatement(selectQuery);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, regex);
            preparedStatement.setString(3, regex);
            resultSet = preparedStatement.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            Object[] row;
            while(resultSet.next()){
                row = new Object[3];
                row[0] = resultSet.getString(1);
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
