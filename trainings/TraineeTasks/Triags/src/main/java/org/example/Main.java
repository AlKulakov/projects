package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    /**
     * Метод main
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = scanNumbers();
        for(int i = 0; i < list.size(); i+=2) {
            Triangle triangle1 = new Triangle(list.get(i));
            Triangle triangle2 = new Triangle(list.get(i+1));
            System.out.println(round(getLength(triangle1.getCoord(), triangle2.getCoord()), 3));
        }
    }

    /**
     * Округление
     * @param length Расстояние между треугольниками
     * @param roundAmount Число знаков после запятой
     * @return Округленное число
     */
    private static double round(double length, int roundAmount) {
        BigDecimal number = BigDecimal.valueOf(length);
        number = number.setScale(roundAmount, RoundingMode.HALF_UP);
        return number.doubleValue();
    }

    /**
     * Функция подсчета расстояния между треугольниками
     * @param a Координаты первого треугольника
     * @param b Координаты второго треугольника
     * @return Возвращает расстояние между треугольникаами в виде числа с плавающей точной
     */
    public static double getLength(Point a, Point b) {
        return sqrt(pow((a.getX()-b.getX()), 2) + pow(a.getY()-b.getY(), 2));
    }

    /**
     * Функция ввода значений.
     * @return Возвращает список с введенными значениями
     */
    public static ArrayList scanNumbers() {
        System.out.println("Enter house numbers. When your input ends, please, enter '0' to complete...");
        ArrayList<Integer> list = new ArrayList<>();
        while(true){
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            if(value.equals("0")){
                return list;
            }
            try {
                String[] tmp = value.trim().split(" ");
                int n = Integer.parseInt(tmp[0]);
                int m = Integer.parseInt(tmp[1]);
                if(n >= 0 && n<=Integer.MAX_VALUE && m>=0 && m<=Integer.MAX_VALUE){
                    list.add(n);
                    list.add(m);
                }
            } catch (Exception e){
                System.out.println("Wrong input. Try again...");
                continue;
            }
        }
    }
}