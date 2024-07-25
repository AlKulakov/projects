package org.example;

import static java.lang.Math.sqrt;

public class Triangle {
    double a, b, c;


    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    /**
     * Функция нахождения радиуса
     * @return - Радиус вписанной окружности
     */
    public double findRadius(){
        double P2 = (a+b+c)/2;
        double S = sqrt(P2*(P2-a)*(P2-b)*(P2-c));
        return S/P2;
    }
}
