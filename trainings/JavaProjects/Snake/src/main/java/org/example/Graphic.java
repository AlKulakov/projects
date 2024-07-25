package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.String.format;

public class Graphic extends JPanel implements ActionListener {
    final static int WIDTH = 600;
    final static int HEIGHT = 600;
    final static int TICK = 30;
    final static int BOARD_SIZE = (WIDTH * HEIGHT) / (TICK * TICK);
    final Font font = new Font("Monospaced", Font.BOLD, 16);
    private int snakePosX[] = new int[BOARD_SIZE];
    private int snakePosY[] = new int[BOARD_SIZE];
    private Apple apple;
    private int snakeLength;
    private boolean isMoving = false;
    private int appleEaten = 0;

    char direction = 'R';

    final Timer timer = new Timer(150, this);

    Graphic(){
        setPreferredSize(new Dimension(HEIGHT, WIDTH));
        setBackground(Color.white);
        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (isMoving) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            if (direction != 'D')
                                direction = 'U';
                            break;
                        case KeyEvent.VK_S:
                            if (direction != 'U')
                                direction = 'D';
                            break;
                        case KeyEvent.VK_A:
                            if (direction != 'R')
                                direction = 'L';
                            break;
                        case KeyEvent.VK_D:
                            if (direction != 'A')
                                direction = 'R';
                            break;
                    }
                } else
                    start();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        start();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isMoving) {
            g.setColor(Color.RED);
            g.fillOval(apple.getPosX(), apple.getPosY(), TICK, TICK);
            g.setColor(Color.GREEN);
            for(int i = 0; i < snakeLength; i++){
                g.fillRect(snakePosX[i], snakePosY[i], TICK, TICK);
            }
        } else {
            String scoreText = String.format("You LOST! Total score: %d ... Press any key to try again...", appleEaten);
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString(scoreText, (WIDTH - g.getFontMetrics(g.getFont()).stringWidth(scoreText))/2, HEIGHT/2);
        }
    }
    private void collisionTest(){
        for(int i = snakeLength; i>0; i--) {
            if (snakePosX[0] == snakePosX[i] && snakePosY[0] == snakePosY[i]) {
                isMoving = false;
                break;
            }
        }
        if(snakePosX[0] < 0 || snakePosX[0] > (WIDTH - TICK) || snakePosY[0] < 0 || snakePosY[0] > (HEIGHT-TICK)) {
            if(snakePosX[0] < 0){
                snakePosX[0] = WIDTH - TICK;
            } else if (snakePosX[0] > (WIDTH - TICK)) {
                snakePosX[0] = 0;
            }
            else if(snakePosY[0] < 0){
                snakePosY[0] = WIDTH - TICK;
            } else if (snakePosY[0] > (WIDTH - TICK)) {
                snakePosY[0] = 0;
            }
        }
        if(!isMoving)
            timer.stop();
    }
    private void start() {
        snakePosX = new int[BOARD_SIZE];
        snakePosY = new int[BOARD_SIZE];
        snakeLength = 5;
        appleEaten = 0;
        direction = 'R';
        isMoving = true;
        spawnApple();
        timer.start();
    }
    private void spawnApple(){
        apple = new Apple();
    }
    private void eatFood(){
        if(snakePosX[0] == apple.getPosX() && snakePosY[0] == apple.getPosY()){
            snakeLength++;
            appleEaten++;
            spawnApple();
        }
    }
    private void move(){
        for(int i = snakeLength; i > 0; i--){
            snakePosX[i] = snakePosX[i-1];
            snakePosY[i] = snakePosY[i-1];
        }
        switch(direction){
            case 'U' ->
                snakePosY[0] -=TICK;
            case 'D' ->
                snakePosY[0] += TICK;
            case 'R' ->
                snakePosX[0] += TICK;
            case 'L' ->
                snakePosX[0] -= TICK;
        }
    }
    public void actionPerformed(ActionEvent e) {
        if(isMoving) {
            move();
            collisionTest();
            eatFood();
        }
        repaint();
    }
}
