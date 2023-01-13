package org.example;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        add(new Graphic());
        setTitle("Змейка");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}
