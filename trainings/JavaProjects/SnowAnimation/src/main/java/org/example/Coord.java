package org.example;

import java.util.Random;

public class Coord {
    public int x;
    public int y;
    private Random rand;
    Coord(int creatureStatus){
        if(creatureStatus == 0)
            spawnCoord();
        else {
            spawnSnowManCoord();
        }
    }
    public void spawnCoord(){
        rand = new Random();
        x = rand.nextInt(Graphic.WIDTH)*Graphic.SIZE;
        y = 0;
    }
    public void spawnSnowManCoord(){
        rand = new Random();
        x = rand.nextInt(6, Graphic.WIDTH-6) * Graphic.SIZE;
        y = 25*Graphic.SIZE;
    }
}
