package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class Main {
    /**
     * Главный метод main
     * @param args
     */
    public static void main(String[] args) {

        TreeSet<Double> set = new TreeSet<>();
        ArrayList<ArrayList<Point>> list = scanPoints();

        for(ArrayList<Point> item : list) {

            for (int i = 0; i < item.size(); i++)

                for (int j = item.size()-1; j > 0; j--){

                    if (i != j) {
                        set.add(sqrt(pow(item.get(i).getX() - item.get(j).getX(), 2) + pow(item.get(i).getY() - item.get(j).getY(), 2)));
                    }
                }

            if (set.first() >= 10000) {
                System.out.println("INFINITY");
            } else
                System.out.println(round(set.first(), 4));
            set.clear();

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
        bigDecimal = bigDecimal.setScale(points, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
    /**
     * Ввод точек
     * @return Список точек
     */
    public static ArrayList<ArrayList<Point>> scanPoints(){

        Scanner scanner1 = new Scanner(System.in);
        ArrayList<ArrayList<Point>> list = new ArrayList<>();

        ArrayList<Point> points;
        while(true){

            int N;

            try {
                System.out.println("Enter coord amount: ");
                N = scanner1.nextInt();
                points = new ArrayList<>();

                if(N==0)
                    return list;

                if(N>0 && N <= 10000) {

                    System.out.println("Enter coords: ");
                    int i =0;
                    while(i < N)

                        try {
                            Scanner scanner2 = new Scanner(System.in);
                            String[] values = scanner2.nextLine().trim().split(" ");
                            points.add(new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
                            i++;

                        } catch (Exception e) {

                            System.out.println("Wrong input. Try again...");
                            continue;
                        }

                    list.add(points);
                }
            } catch (Exception e){

                System.out.println("Wrong input number. Try again...");
                continue;

            }
        }
    }
}