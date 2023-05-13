package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Главная функция main
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> list = scanNumbers();
        long units = 1;
        long unitsMult = 10;
        System.out.println("Result: ");
        for (int item : list){
            while(units%item!=0){
                units+=unitsMult;
                unitsMult*=10;
            }
            System.out.println((""+units).length());
            units = 1;
            unitsMult=10;
        }
    }

    /**
     * Ввод целых чисел
     * @return Список целых чисел
     */
    public static ArrayList scanNumbers(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int number=1;
        System.out.println("Input your numbers. '0' to exit...");
        while(true){
            try {
                number = scanner.nextInt();
                if(number==0){
                    break;
                }
                if(number >=0 && number <= 10000 && number%5!=0 && number%2!=0)
                    list.add(number);
                else System.out.println("Number should be >=0 and <=10000, not divisible by 5 and 2. Try again...");
            } catch (Exception e){
                System.out.println("Wrong input. Try again...");
                continue;
            }
        }
        return list;
    }
}