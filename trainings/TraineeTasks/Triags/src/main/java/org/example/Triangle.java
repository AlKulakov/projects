package org.example;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle {
    private int number;
    private Point coord;
    private boolean reverse = false;
    private double smallerSquare;
    private double biggerSquare;

    /**
     * Конструктор класса треугольника
     * @param number - номер треугольника
     */
    public Triangle(int number) {

        this.number = number;

        setSquares();

        setReverse();

        setPoints();

    }

    /**
     * Функция устанавливает перевернутость треугольника
     */
    public void setReverse(){
        if(!(smallerSquare%2 == number%2)){
            reverse=true;
        }
    }

    /**
     * Функция считает ближайшие квадраты числа.
     */
    public void setSquares(){

        this.smallerSquare = number;
        while(!(sqrt(smallerSquare)%1==0)){
            this.smallerSquare--;
        }

        this.biggerSquare = pow(sqrt(smallerSquare)+1, 2);

    }

    /**
     * Функция устанавливает координаты треугольника. Предполагается, что точка (0, 0) - самая верхняя вершина пирамиды.
     */
    public void setPoints(){
        if(reverse){
            coord = new Point((number-(smallerSquare+(biggerSquare-1))/2) * 0.5, 1/(2*sqrt(3)) + sqrt(3)/2 * sqrt(smallerSquare));
        } else {
            coord = new Point((number-(smallerSquare+(biggerSquare-1))/2) * 0.5, 1/(sqrt(3)) + sqrt(3)/2 * sqrt(smallerSquare));
        }
    }
    public int getNumber() {
        return number;
    }


    public Point getCoord() {
        return coord;
    }

    public double getSmallerSquare() {
        return smallerSquare;
    }

    public double getBiggerSquare() {
        return biggerSquare;
    }

}
