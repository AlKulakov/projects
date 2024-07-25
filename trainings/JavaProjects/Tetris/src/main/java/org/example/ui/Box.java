package org.example.ui;

import org.example.model.Coord;

import javax.swing.*;

public class Box extends JPanel {
    public int getColor() {
        return color;
    }

    private int color;
    public Box(int x, int y){
        color = 0;
        setBounds(Config.SIZE * x, Config.SIZE * y, Config.SIZE, Config.SIZE);
        setLocation(x * Config.SIZE, y * Config.SIZE);
        setBackground(Config.COLORS[0]);
    }
    public void setColor(int color){
        this.color = color;
        if(color >= 0 && color < Config.COLORS.length)
            setBackground(Config.COLORS[color]);
    }
}
