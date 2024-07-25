package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    /**
     * Главный метод main
     * @param args
     */
    public static void main(String[] args) {
        Triangle triangle;

        triangle = scanValues();

        System.out.println("The radius of the round table is: " + round(triangle.findRadius(), 3));
    }
    /**
     * Округление
     * @param number - число
     * @param points - кол-во знаков
     * @return - округленное число
     */
    public static double round(double number, int points){
        BigDecimal bigDecimal = BigDecimal.valueOf(number);
        bigDecimal = bigDecimal.setScale(points, RoundingMode.FLOOR);
        return bigDecimal.doubleValue();
    }
    /**
     * Ввод длин сторон
     * @return - Объект класса треугольника
     */
    public static Triangle scanValues(){
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = new Triangle();
        String[] values;
        while(true) {
            try {
                System.out.println("Enter sides of the triangle values...");
                values = scanner.nextLine().split(" ");
            } catch (Exception e) {
                System.out.println("Wrong input... Try again");
                continue;
            }
            try {

                double a, b, c;

                a = abs(Double.parseDouble(values[0]));
                b = abs(Double.parseDouble(values[1]));
                c = abs(Double.parseDouble(values[2]));




                if(a <= 1000000 && b <= 1000000 && c <= 1000000 && max(max(a,b), c) <= (a+b+c)/2){
                    triangle.setA(a);
                    triangle.setB(b);
                    triangle.setC(c);
                    return triangle;
                }
                else {
                    System.out.println("Wrong input... Try again");
                }
            }
            catch (Exception e){
                System.out.println("Wrong input...try again");
                continue;
            }
        }
    }
}