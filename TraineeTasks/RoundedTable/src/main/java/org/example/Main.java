package org.example;

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Triangle triangle;

        triangle = scanValues();

        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        System.out.println("The radius of the round table is: " + decimalFormat.format(triangle.findRadius()));
    }

    public static Triangle scanValues(){
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = new Triangle();
        String[] values;
        while(true) {
            try {
                values = scanner.nextLine().split(" ");
            } catch (Exception e) {
                System.out.println("Wrong input...try again");
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