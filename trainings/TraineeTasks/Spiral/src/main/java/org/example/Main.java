package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * Главный метод main
     * @param args
     */
    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        int length = lengthScan();
        Point point = spiral.getPointsInSpiral(length);
        System.out.println("(" + point.x + ", " + point.y + ")");
    }

    /**
     * Ввод длины пути
     * @return - Длина пути, введенная с клавиатуры
     */
    public static int lengthScan(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.println(
                        "Input Willy's way length..."
                );
                int number = scanner.nextInt();
                if(number>0 && number <= 100000)
                    return number;
                else System.out.println("Number should be >0 and <100000");
            } catch (Exception e) {
                System.out.println("Wrong input");
                continue;
            }
        }
    }
}