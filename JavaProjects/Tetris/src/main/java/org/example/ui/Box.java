package org.example.ui;

import org.example.model.Coord;

import javax.swing.*;

public class Box extends JPanel {
    public Box(int x, int y){
        setBounds(Config.SIZE * x, Config.SIZE * y, Config.SIZE, Config.SIZE);
        setLocation(x * Config.SIZE, y * Config.SIZE);
        setBackground(Config.BACKGROUND);
    }
    public void setColor(int j){
        if(j == 0)
            setBackground(Config.BACKGROUND);
        else setBackground(Config.FOREGROUND);
    }
}
