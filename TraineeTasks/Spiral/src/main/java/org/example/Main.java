package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        int length = lengthScan();
        Point point = spiral.getPointsInSpiral(length);
        System.out.println("(" + point.x + ", " + point.y + ")");
    }
    public static int lengthScan(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                int number = scanner.nextInt();
                return number;
            } catch (Exception e) {
                System.out.println("Wrong input");
                continue;
            }
        }
    }
}