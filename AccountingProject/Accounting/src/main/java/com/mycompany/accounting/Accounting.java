/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accounting;

import com.mycompany.accounting.UI.LoginForm;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Accounting {
    //Главный класс, создающий файл с настройками БД и вызывающий окно логина.
    public static void main(String[] args) throws IOException {
    File f = new File("C:\\ProgramData\\AccountingProgram\\conf.ini");
        f.getParentFile().mkdir();
        if (!(f.exists() || f.isDirectory())) {
            PrintWriter writer = new PrintWriter(new FileWriter(f, true));
            writer.println("host = localhost");
            writer.println("port = 3306");
            writer.println("db_name = pizza_db");
            writer.println("username =root");
            writer.println("password =");
            writer.close();
        }
        LoginForm loginForm = new LoginForm();
        loginForm.setLocationRelativeTo(null);
        loginForm.pack();
        loginForm.show();
    }
}
