package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graphic  extends JPanel implements ActionListener {
    final static int SIZE = 20;
    final static int WIDTH = 40;
    final static int HEIGHT = 30;
    final Timer timer = new Timer(15, this);
    JPanel ground;
    private Set<Coord> snow = new HashSet<>();
    private Coord snowmanCoords = new Coord(1);
    Graphic() {
        setPreferredSize(new Dimension(SIZE * WIDTH, SIZE*HEIGHT));
        setBackground(new Color(0, 0, 50));
        timer.start();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        for (Coord snowy : snow)
            g.fillOval(snowy.x, snowy.y, SIZE / 4, SIZE / 4);
        for (int height = 25; height < HEIGHT; height++)
            for (int width = 0; width < WIDTH; width++) {
                g.fillRect(width * SIZE, height * SIZE, SIZE, SIZE);
            }
        g.fillOval(snowmanCoords.x, snowmanCoords.y - 5 * SIZE, SIZE * 6, SIZE * 6);
        g.fillOval(snowmanCoords.x + SIZE, snowmanCoords.y - 8 * SIZE, SIZE * 4, SIZE * 4);
        g.fillOval(snowmanCoords.x + 2 * SIZE, snowmanCoords.y - 9 * SIZE - SIZE / 4, SIZE * 2, SIZE * 2);
        g.setColor(Color.ORANGE);
        g.fillRect(snowmanCoords.x + 2 * SIZE, snowmanCoords.y - 10 * SIZE, SIZE * 2, SIZE);
    }
    private void moveSnow(){
        Iterator<Coord> iter = snow.iterator();
        while(iter.hasNext()){
            Coord snowy = iter.next();
            if(isOnGround(snowy)){
                iter.remove();
            }
            snowy.y += 2;
        }
    }
    private boolean isOnGround(Coord snowy){
        if(snowy.y >= 25*SIZE){
            return true;
        }
        else return false;
    }
    public void actionPerformed(ActionEvent e){
        moveSnow();
        snow.add(new Coord(0));
        repaint();
    }
}
