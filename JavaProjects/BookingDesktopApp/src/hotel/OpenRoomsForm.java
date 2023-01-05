/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Александр
 */
public class OpenRoomsForm extends javax.swing.JFrame {

    /**
     * Creates new form OpenRoomsForm
     */
    Rooms room = new Rooms();
    public OpenRoomsForm() {
        initComponents();
        
        room.fillTypeCombobox(typeComboBox);
        room.fillRoomsTable(roomsTable);
    }
    private int x, y;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        dataPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        roomLabel = new javax.swing.JLabel();
        roomField = new javax.swing.JTextField();
        typeLabel = new javax.swing.JLabel();
        phoneNumberLabel = new javax.swing.JLabel();
        phoneNumberField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        infoButton = new javax.swing.JButton();
        phoneNumberLabel1 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomsTable = new javax.swing.JTable();
        resultLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(255, 204, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mainPanelMouseDragged(evt);
            }
        });
        mainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainPanelMousePressed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(255, 204, 102));
        closeButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        closeButton.setForeground(new java.awt.Color(255, 255, 204));
        closeButton.setText("X");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeButtonMouseExited(evt);
            }
        });
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        dataPanel.setBackground(new java.awt.Color(255, 255, 204));
        dataPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        dataPanel.setPreferredSize(new java.awt.Dimension(4, 325));

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        roomLabel.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        roomLabel.setForeground(new java.awt.Color(51, 51, 0));
        roomLabel.setText("Номер");

        roomField.setBackground(new java.awt.Color(255, 255, 204));
        roomField.setForeground(new java.awt.Color(51, 51, 0));
        roomField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                roomFieldKeyPressed(evt);
            }
        });

        typeLabel.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        typeLabel.setForeground(new java.awt.Color(51, 51, 0));
        typeLabel.setText("Тип");

        phoneNumberLabel.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        phoneNumberLabel.setForeground(new java.awt.Color(51, 51, 0));
        phoneNumberLabel.setText("Телефон* +7");

        phoneNumberField.setBackground(new java.awt.Color(255, 255, 204));
        phoneNumberField.setForeground(new java.awt.Color(51, 51, 0));
        phoneNumberField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNumberFieldKeyPressed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(255, 255, 204));
        editButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(51, 51, 0));
        editButton.setText("Изменить");
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(255, 255, 204));
        addButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(51, 51, 0));
        addButton.setText("Добавить");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setBackground(new java.awt.Color(255, 255, 204));
        removeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        removeButton.setForeground(new java.awt.Color(51, 51, 0));
        removeButton.setText("Удалить");
        removeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(255, 255, 204));
        clearButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(51, 51, 0));
        clearButton.setText("Очистить");
        clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        refreshButton.setBackground(new java.awt.Color(255, 255, 204));
        refreshButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        refreshButton.setText("Обновить");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("* - обязательные поля");

        typeComboBox.setBackground(new java.awt.Color(255, 204, 102));
        typeComboBox.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        typeComboBox.setForeground(new java.awt.Color(51, 51, 0));
        typeComboBox.setOpaque(true);

        infoButton.setBackground(new java.awt.Color(255, 255, 204));
        infoButton.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        infoButton.setForeground(new java.awt.Color(51, 51, 0));
        infoButton.setText("Инфо");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        phoneNumberLabel1.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        phoneNumberLabel1.setForeground(new java.awt.Color(51, 51, 0));
        phoneNumberLabel1.setText("Статус");

        statusComboBox.setBackground(new java.awt.Color(255, 255, 204));
        statusComboBox.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        statusComboBox.setForeground(new java.awt.Color(51, 51, 0));
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Свободно", "Занято" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(refreshButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(phoneNumberLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(statusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(phoneNumberLabel)
                                        .addGap(2, 2, 2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(roomLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneNumberField)
                                    .addComponent(roomField)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                    .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(typeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)
                                .addComponent(infoButton)))))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomLabel)
                    .addComponent(roomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(typeLabel)
                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberLabel)
                    .addComponent(phoneNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberLabel1)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(editButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(clearButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshButton)
                .addGap(13, 13, 13))
        );

        roomsTable.setBackground(new java.awt.Color(255, 255, 204));
        roomsTable.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        roomsTable.setForeground(new java.awt.Color(51, 51, 0));
        roomsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Номер", "Тип", "Телефон", "Статус"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        jScrollPane1.getViewport().setBackground(new Color(255,255,204));
        headerRenderer = (DefaultTableCellRenderer)
        roomsTable.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        headerRenderer.setBackground(new Color(255, 204, 102));
        roomsTable.setGridColor(new java.awt.Color(255, 204, 102));
        DefaultTableCellRenderer rendar = new DefaultTableCellRenderer();
        rendar.setHorizontalAlignment(jLabel1.CENTER);
        for(int i = 0; i<4; i++){
            roomsTable.getColumnModel().getColumn(i).setCellRenderer(rendar);
        }
        roomsTable.setRowHeight(30);
        roomsTable.setSelectionBackground(new java.awt.Color(255, 204, 102));
        roomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(roomsTable);
        jScrollPane1.getViewport().setBackground(new Color(255,255,204));

        resultLabel.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        resultLabel.setForeground(new java.awt.Color(255, 0, 0));
        resultLabel.setText(" ");

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resultLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(resultLabel)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        nameLabel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(51, 51, 0));
        nameLabel.setText("Номера отеля");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(634, Short.MAX_VALUE)
                .addComponent(nameLabel)
                .addGap(535, 535, 535)
                .addComponent(closeButton)
                .addContainerGap())
            .addComponent(dataPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1382, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents
private void wrongDataDelay(){
            resultLabel.setText("Ошибка. Введены неверные данные.");
            Timer timer = new Timer(4000, e-> {
            resultLabel.setText(" ");});
            timer.start();
    }
    private void wrongFieldDelay(javax.swing.JTextField field){
        if(!field.getBackground().equals(Color.red)){
            field.setBackground(Color.red);
            field.setForeground(new Color(255, 255,204));
            Timer timer = new Timer(1000, e-> {
            field.setBackground(new Color(255, 255,204));
            field.setForeground(new Color(51, 51, 0));});
            timer.start();
        }
    }
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        MainForm.OpenRoomsFormsCount--;
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_closeButtonActionPerformed

    private void closeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseEntered
        closeButton.setBackground(Color.RED);        // TODO add your handling code here:
    }//GEN-LAST:event_closeButtonMouseEntered

    private void closeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseExited
        closeButton.setBackground(new Color(255, 204, 102));// TODO add your handling code here:
    }//GEN-LAST:event_closeButtonMouseExited

    private void mainPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMousePressed
        x = evt.getX();
        y = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_mainPanelMousePressed

    private void mainPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPanelMouseDragged
        this.setLocation(evt.getXOnScreen() - x, evt.getYOnScreen() - y);        // TODO add your handling code here:
    }//GEN-LAST:event_mainPanelMouseDragged

    private void roomFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roomFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN)
        phoneNumberField.requestFocus();
    }//GEN-LAST:event_roomFieldKeyPressed

    private void phoneNumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberFieldKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_UP){
            roomField.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberFieldKeyPressed
    private void refreshTable(){
        roomsTable.setModel(new DefaultTableModel(null, new Object[]{"Номер","Тип","Телефон","Статус"}));
        room.fillRoomsTable(roomsTable);
    }
    public boolean isNumeric(String number){
        try{
            for(char letter : number.toCharArray())
                Integer.parseInt("" + letter);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        boolean numberAccept = false;
        int number = 0;
        try{
            number = Integer.parseInt(roomField.getText());
        numberAccept = true;
        }
        catch(NumberFormatException e){
            wrongDataDelay();
            wrongFieldDelay(roomField);
            
        }
        String phone = phoneNumberField.getText();
        int type = Integer.parseInt(typeComboBox.getSelectedItem().toString());
        if(numberAccept == true && isNumeric(phone) && phone.length()==10){
            if(room.editRoom(number, type, phone, statusComboBox.getSelectedItem().toString())){
                resultLabel.setText("Данные изменены!");
                refreshTable();
            }
            else wrongDataDelay();
        } else {
            wrongDataDelay();
            wrongFieldDelay(phoneNumberField);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        boolean numberAccept = false;
        int number = 0;
        try{
            number = Integer.parseInt(roomField.getText());
        numberAccept = true;
        }
        catch(NumberFormatException e){
            wrongDataDelay();
            wrongFieldDelay(roomField);
            
        }
        String phone = phoneNumberField.getText();
        int type = Integer.parseInt(typeComboBox.getSelectedItem().toString());
        String status = statusComboBox.getSelectedItem().toString();
        if(numberAccept == true && isNumeric(phone) && phone.length()==10){
            if(room.addRoom(number, type, phone, status)){
                resultLabel.setText("Комната добавлена!");
                clearFields();
                refreshTable();
            }
            else wrongDataDelay();
        } else {
            wrongDataDelay();
            wrongFieldDelay(phoneNumberField);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int number = 0;
        try{     
            number = Integer.parseInt(roomField.getText().toString());
        } catch(NumberFormatException e){
            wrongFieldDelay(roomField);
            wrongDataDelay();
        }
        if(room.removeRoom(number)){
            resultLabel.setText("Номер удален!");
            clearFields();
            refreshTable();
        }
        else {
            wrongDataDelay();
            wrongFieldDelay(roomField);
        }
    }//GEN-LAST:event_removeButtonActionPerformed
    private void clearFields(){
         roomField.setText("");
         phoneNumberField.setText("");
         typeComboBox.setSelectedIndex(0);
         statusComboBox.setSelectedIndex(0);
    }
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
          clearFields();
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshTable();        // TODO add your handling code here:
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        AllRoomsTypeFrame AllroomsType = new   AllRoomsTypeFrame();
        AllroomsType.setVisible(true);
        AllroomsType.pack();
        AllroomsType.setLocationRelativeTo(null);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_infoButtonActionPerformed

    private void roomsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomsTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) roomsTable.getModel();
        int rowIndex = roomsTable.getSelectedRow();
        roomField.setText(model.getValueAt(rowIndex, 0).toString());
        typeComboBox.setSelectedItem(Integer.parseInt(model.getValueAt(rowIndex, 1).toString()));
        phoneNumberField.setText(model.getValueAt(rowIndex, 2).toString());
        statusComboBox.setSelectedItem(model.getValueAt(rowIndex, 3).toString());        // TODO add your handling code here:
    }//GEN-LAST:event_roomsTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OpenRoomsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpenRoomsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpenRoomsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenRoomsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpenRoomsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JButton editButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField phoneNumberField;
    private javax.swing.JLabel phoneNumberLabel;
    private javax.swing.JLabel phoneNumberLabel1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JTextField roomField;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JTable roomsTable;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JComboBox<String> typeComboBox;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}