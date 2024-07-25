package org.example;

import javax.swing.*;

public class Window extends JFrame {
    Window(){
        add(new Graphic());
        setTitle("Снег");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}
