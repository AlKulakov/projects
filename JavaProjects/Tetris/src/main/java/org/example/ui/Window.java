package org.example.ui;

import org.example.model.Coord;
import org.example.model.Figure;
import org.example.model.Mappable;
import org.example.service.Subject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Window extends JFrame implements Runnable, Mappable {
    private Box[][] boxes;
    private Subject subject;
    public Window(){
        boxes = new Box[Config.WIDTH][Config.HEIGHT];
        initFrame();
        initBoxes();
        addKeyListener(new KeyAdapter());
        TimerAdapter timerAdapter = new TimerAdapter();
        Timer timer = new Timer(300, timerAdapter);
        timer.start();
    }
    public void addFigure(){
        subject = new Subject(this);
        if(subject.canPlayAsFigure()){
            showFigure();
        }
        else
        {
            System.exit(0);
        }

    }
    private void initFrame() {
        setSize(Config.WIDTH*Config.SIZE + 15,
                Config.HEIGHT*Config.SIZE + 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tetris");
        setLayout(null);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void initBoxes(){
        for(int x = 0; x < Config.WIDTH; x++)
            for(int y = 0; y < Config.HEIGHT; y++){
                boxes[x][y] = new Box(x, y);
                add(boxes[x][y]);
        }
    }
    public void run(){
        repaint();
    }
    private void showFigure(){
        showFigure(1);
    }
    private void hideFigure(){
        showFigure(0);
    }
    private void showFigure(int color){
        for (Coord dot : subject.getFigure().dot){
                       setBoxesColor(subject.getCoord().x + dot.x, subject.getCoord().y + dot.y, color);
        }
    }

    private void setBoxesColor(int x, int y, int color){
        if (x < 0 || x >= Config.WIDTH) return;
        if (y < 0 || x >= Config.HEIGHT) return;
        boxes[x][y].setColor(color);
    }
    private void moveSubject(int sx, int sy){
        hideFigure();
        subject.moveFigure(sx, sy);
        showFigure();
    }
    private void turnSubject(int direction){
        hideFigure();
        subject.turnFigure(direction);
        showFigure();
    }
    public int getBoxColor(int x, int y){
        if (x < 0 || x >= Config.WIDTH) return -1;
        if (y < 0 || x >= Config.HEIGHT) return -1;
        return boxes[x][y].getColor();
    }
    class KeyAdapter implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT : moveSubject(-1, 0); break;
                case KeyEvent.VK_RIGHT : moveSubject(+1, 0); break;
                case KeyEvent.VK_UP : turnSubject(1); break;
                case KeyEvent.VK_DOWN : turnSubject(1); break;
                case KeyEvent.VK_U : moveSubject(0, -1);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
    private void stripLines(){
        for(int y = Config.HEIGHT-1; y >= 0; y--) {
            while(isFillLine(y)) {
                dropLine(y);
            }
        }
    }
    private void dropLine(int y) {
        for(int moveY = y-1; moveY>=0; moveY--)
            for(int x = 0; x < Config.WIDTH; x++)
                setBoxesColor(x, moveY+1, getBoxColor(x, moveY));
            for(int x = 0; x < Config.WIDTH; x++)
                setBoxesColor(x, 0, 0);
    }
    private boolean isFillLine(int y){
        for(int x=0; x< Config.WIDTH; x++)
            if(getBoxColor(x, y)!=2){
                return false;
            }
        return true;
    }
    class TimerAdapter implements ActionListener{
        public void actionPerformed(ActionEvent e){
            moveSubject(0, 1);
            if(subject.isLanded()){
                showFigure(2);
                stripLines();
                addFigure();
            }
        }
    }
}
