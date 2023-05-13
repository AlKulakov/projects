package org.example;

import java.util.ArrayList;
import java.util.List;

public class Spiral {
    public Point getPointsInSpiral(int length) {
        int x = 0;
        int y = 0;
        int size = 1;
        int direction = 1;

        for (int i = 0; i < length-1; i++) {
            switch (direction) {
                //Движение вправо
                case 0:
                    x++;
                    if (x == size) {
                        size++;
                        direction = 1;
                    }
                    break;
                    //Движение вверх
                case 1:
                    y++;
                    if(y>1)
                        x--;
                    if (y == size) {
                        direction = 2;
                    }
                    break;
                    //движение влево
                case 2:
                    x--;
                    if (-x == size) {
                        direction = 3;
                    }
                    break;
                    //движение вниз
                case 3:
                    y--;
                    if(y<0){
                        x++;
                    }
                    if (-y == size) {
                        direction = 0;
                    }
                    break;
            }
        }

        return new Point(x, y);
    }
}
