package org.example;

public class Point {
    private int x;
    private int y;

    /**
     * Класс координаты
     * @param x - координата x
     * @param y - координата y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
