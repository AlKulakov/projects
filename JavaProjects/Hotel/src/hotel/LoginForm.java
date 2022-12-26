/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package hotel;
import java.awt.GraphicsEnvironment;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author Александр
 */
public class LoginForm extends javax.swing.JFrame {
    /**
     * Создание формы для авторизации
     */
    public LoginForm() {
        initComponents();
    }
    public static int frameSettingsCount = 0;
    public static int frameMainCount = 0;
    public static PreparedStatement preparedStatement = null;
    public static Connection connection = null;
    public static ResultSet resultSet = null;
    /**
     * Метод выше инициализирует компоненты
     * WARNING: Не изменять код ниже. Он создан при помощи редактора форм.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        dataPanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();
        authorizationButton = new javax.swing.JButton();
        loginPanel = new javax.swing.JPanel();
        passwordField = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        userNameLabel = new javax.swing.JLabel();
        headerNameLabel = new javax.swing.JLabel();
        wrongDataLabel = new javax.swing.JLabel();
        programNameLabel = new javax.swing.JLabel();
        developerAddressLabel = new javax.swing.JLabel();
        settingsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(255, 204, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dataPanel.setBackground(new java.awt.Color(255, 255, 204));
        dataPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        exitButton.setBackground(new java.awt.Color(255, 255, 204));
        exitButton.setForeground(new java.awt.Color(51, 51, 0));
        exitButton.setText("Выход");
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        authorizationButton.setBackground(new java.awt.Color(255, 255, 204));
        authorizationButton.setForeground(new java.awt.Color(51, 51, 0));
        authorizationButton.setText("Авторизация");
        authorizationButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        authorizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorizationButtonActionPerformed(evt);
            }
        });

        loginPanel.setBackground(new java.awt.Color(255, 204, 102));
        loginPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        passwordField.setBackground(new java.awt.Color(255, 255, 204));
        passwordField.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        passwordField.setForeground(new java.awt.Color(51, 51, 0));
        passwordField.setText("qwerty12F");
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(51, 51, 0));
        passwordLabel.setText("Пароль");

        userNameField.setBackground(new java.awt.Color(255, 255, 204));
        userNameField.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        userNameField.setForeground(new java.awt.Color(51, 51, 0));
        userNameField.setText("kulakov");
        userNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameFieldKeyPressed(evt);
            }
        });

        userNameLabel.setBackground(new java.awt.Color(255, 255, 204));
        userNameLabel.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(51, 51, 0));
        userNameLabel.setText("Имя пользователя");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userNameField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                                .addComponent(passwordLabel)
                                .addGap(110, 110, 110))
                            .addComponent(userNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        headerNameLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        headerNameLabel.setForeground(new java.awt.Color(51, 51, 0));
        headerNameLabel.setText("Авторизация");

        wrongDataLabel.setForeground(new java.awt.Color(51, 51, 0));
        wrongDataLabel.setText("Неправильный логин или пароль");
        wrongDataLabel.setVisible(false);

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(authorizationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wrongDataLabel)
                    .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(headerNameLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPanelLayout.createSequentialGroup()
                        .addComponent(headerNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wrongDataLabel)
                        .addContainerGap(69, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataPanelLayout.createSequentialGroup()
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(authorizationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        programNameLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        programNameLabel.setForeground(new java.awt.Color(51, 51, 0));
        programNameLabel.setText("Система бронирования отеля");

        developerAddressLabel.setForeground(new java.awt.Color(51, 51, 0));
        developerAddressLabel.setText("© github.com/AlKulakov");

        settingsButton.setBackground(new java.awt.Color(255, 255, 204));
        settingsButton.setForeground(new java.awt.Color(51, 51, 0));
        settingsButton.setText("⚙");
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 153, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(programNameLabel)
                        .addGap(96, 96, 96)
                        .addComponent(settingsButton))
                    .addComponent(developerAddressLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(programNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(settingsButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(developerAddressLabel)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void wrongDataDelay(){
        wrongDataLabel.setVisible(true);
        Timer timer = new Timer(4000, e-> {
        wrongDataLabel.setVisible(false);});
        timer.start();
        userNameField.setText(null);
        passwordField.setText(null);
    }
    public void closeFrame(){
        this.dispose();
    }
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);        // Выход из системы при помощи системной команды:
    }//GEN-LAST:event_exitButtonActionPerformed
    private void loginOperation() throws SQLException{
        String selectQuery = "SELECT * FROM `users` where `username`=? and `password`=?";
        String username = userNameField.getText();
        String password = String.valueOf(passwordField.getPassword());    
        try {
                connection = new MySqlConnection().getConnection();
                preparedStatement = connection.prepareStatement(selectQuery);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    if(frameMainCount < 1){
                        frameMainCount++;
                        MainForm mainForm = new MainForm();
                        mainForm.setVisible(true);
                        mainForm.pack();
                        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();  
                        mainForm.setMaximizedBounds(env.getMaximumWindowBounds());
                        mainForm.setExtendedState(MAXIMIZED_BOTH);
                        mainForm.setLocationRelativeTo(null);
                        this.dispose();
                    }
                } else {
                    wrongDataDelay();
                }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, 
                    "Пожалуйста, проверьте настройки базы данных.", 
                    "Ошибка базы данных", 2);
        }finally {
            if(resultSet != null) 
                try { resultSet.close(); } catch (SQLException e) { /* Ignored */ }
            if(preparedStatement!=null)
                try { preparedStatement.close(); } catch (SQLException e) { /* Ignored */ }
            if(connection!=null)
             try { connection.close();} catch (SQLException e) { /* Ignored */ }
            }
    }
    private void authorizationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorizationButtonActionPerformed
        try {
            loginOperation();
// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_authorizationButtonActionPerformed

    private void userNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            if(passwordField.getText().isEmpty()!=true)
                try {
                    loginOperation();
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            else {
                passwordField.requestFocus();
            }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN)
            passwordField.requestFocus();
    }//GEN-LAST:event_userNameFieldKeyPressed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            try {
                loginOperation();
        } catch (SQLException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if(evt.getKeyCode()==KeyEvent.VK_UP)
            userNameField.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        if(frameSettingsCount<1){
            frameSettingsCount++;
            LoginSettings loginSettings = new LoginSettings();
            loginSettings.setVisible(true);
            loginSettings.pack();
            loginSettings.setLocationRelativeTo(null);
        } // TODO add your handling code here:
    }//GEN-LAST:event_settingsButtonActionPerformed

    /**
     * @param args вызов функции main
     */
    public static void main(String args[]) throws IOException {
        /* Содержимое главной функции */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        File f = new File("C:\\ProgramData\\Booking system\\conf.ini");
        f.getParentFile().mkdir();
        if (!(f.exists() || f.isDirectory())) {
            PrintWriter writer = new PrintWriter(new FileWriter(f, true));
            writer.println("host = localhost");
            writer.println("port = 3306");
            writer.println("db_name = booking_db");
            writer.println("username = java");
            writer.println("password = hitler1488F");
            writer.close();
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Вывод окна при помощи интерфейса Runnable */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton authorizationButton;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JLabel developerAddressLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel headerNameLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel programNameLabel;
    private javax.swing.JButton settingsButton;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel wrongDataLabel;
    // End of variables declaration//GEN-END:variables
}
