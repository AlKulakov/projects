package org.example;

import java.util.Random;

public class Apple {
    private int posX;
    private int posY;
    public Apple(){
        posX = generatePos(Graphic.WIDTH);
        posY = generatePos(Graphic.HEIGHT);
    }
    private int generatePos(int size){
        Random rand = new Random();
        return rand.nextInt(size/Graphic.TICK)*Graphic.TICK;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
}
