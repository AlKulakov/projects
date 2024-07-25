package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /**
     * Главный метод main
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<double[]> list = scanPoints();
        for(double[] expenses : list) {
            findMinAmount(expenses);
        }
    }

    /**
     * Нахождение минимальной суммы для обмена
     * @param expenses - список затрат студентов
     */
    public static void findMinAmount(double[] expenses){
        double totalExpenses = 0.0;
        for (double expense : expenses) {
            totalExpenses += expense;
        }
        double averageExpense = totalExpenses / expenses.length;
        double[] diffs = new double[expenses.length];
        double totalDiff = 0.0;
        for (int i = 0; i < expenses.length; i++) {
            diffs[i] = averageExpense - expenses[i];
            if (diffs[i] > 0) {
                totalDiff += diffs[i];
            }
        }

        System.out.println("$" + round(totalDiff, 2));
    }
    /**
     * Ввод затрат
     * @return - список затрат для студентов
     */
    public static ArrayList<double[]> scanPoints(){

        Scanner scanner1 = new Scanner(System.in);
        ArrayList<double[]> list = new ArrayList<>();
        double[] expenses;
        while(true){

            int N;

            try {
                System.out.println("Enter students count. Enter 0 to exit ");
                N = scanner1.nextInt();
                expenses = new double[N];

                if(N==0)
                    return list;

                if(N>0 && N <= 1000) {

                    System.out.println("Enter their expenses: ");
                    int i = 0;
                    while(i < N)

                        try {
                            Scanner scanner2 = new Scanner(System.in);
                            scanner2.useLocale(Locale.UK);
                            double num = scanner2.nextDouble();
                            if(num <= 10000 && num >= 0)
                                expenses[i] = num;

                            else {
                                System.out.println("Number should be >0 and <= 10000... Try again.");
                                continue;
                            }
                            i++;

                        } catch (Exception e) {

                            System.out.println("Wrong input. Try again...");
                            continue;
                        }

                    list.add(expenses);
                }
            } catch (Exception e){

                System.out.println("Wrong input number. Try again...");
                continue;

            }
        }
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
}