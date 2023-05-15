package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    /**
     * Функция main
     * @param args
     */
    public static void main(String[] args) {


        ArrayList<Long> list = scanNumbers();
        for (int i = 0; i < list.size(); i += 2) {
            findCarryAmount(list.get(i), list.get(i + 1));
        }

    }

    /**
     * Функция нахождения и отображения количества переносов
     * @param firstNumber - первое число
     * @param secondNumber - второе число
     */
    public static void findCarryAmount(long firstNumber, long secondNumber){
            int count = 0;
            int carry = 0;
            int sum = 0;
            while (firstNumber > 0 || secondNumber > 0) {
                int digit1 = (int) (firstNumber % 10);
                int digit2 = (int) secondNumber % 10;
                sum = digit1 + digit2 + carry;
                if (sum >= 10) {
                    carry = 1;
                    count++;
                } else {
                    carry = 0;
                }
                firstNumber = firstNumber / 10;
                secondNumber = secondNumber / 10;
            }
            if(count>0){
                System.out.println(count + " carry operation");
            } else{
                System.out.println("No carry operation");
            }
    }
    /**
     * Ввод двух чисел
     * @return - список из чисел
     */
    public static ArrayList scanNumbers() {
        System.out.println("Enter numbers. When your input ends, please, enter '0 0' to complete...");
        ArrayList<Long> list = new ArrayList<>();
        while(true){
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            if(value.equals("0 0")){
                return list;
            }
            try {
                String[] tmp = value.trim().split(" ");
                if(tmp[0].length()>10 || tmp[1].length()>10){
                    System.out.println("Too many numbers... Try again");
                    continue;
                }
                long n = Long.parseLong(tmp[0]);
                long m = Long.parseLong(tmp[1]);
                if(n >= 0 && m>=0){
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