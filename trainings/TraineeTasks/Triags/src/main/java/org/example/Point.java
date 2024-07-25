package org.example;

public class Point {
    private double x, y;

    /**
     * Конструктор координаты
     * @param x - координата x
     * @param y - координата y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
