package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    /**
     * Функция main
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = scanValues();
        for(ArrayList<Integer> item : list)
            reversePancakes1(item);
    }

    /**
     * Функция переворота стопок оладий
     * @param pancakesList - Список оладий
     */
    public static void reversePancakes1(ArrayList<Integer> pancakesList){

        for(int i : pancakesList)
            System.out.print(i + " ");
        int count = 0;
        boolean isReversed = true;
        while(isReversed){
            boolean flag = pancakesList.get(0) > pancakesList.get(1);
            isReversed=false;
            for(int i=0; i < pancakesList.size()-1; i++){
                if(pancakesList.get(i)>pancakesList.get(i+1)!=flag){
                    ArrayList<Integer> tmpList = new ArrayList<>(pancakesList.subList(i+1, pancakesList.size()));
                    pancakesList = new ArrayList<>(pancakesList.subList(0, i+1));
                    Collections.reverse(tmpList);
                    pancakesList.addAll(i, tmpList);
                    count++;
                    isReversed=true;
                    break;
                }
            }
        }
        if(pancakesList.get(0)>pancakesList.get(1)) {
            Collections.reverse(pancakesList);
            count++;
        }
        if(count==0){
            System.out.println("\n" + 0);
        } else {
            System.out.println("");
            for(int i = 1; i <= count; i++)
                System.out.print(i+" ");
            System.out.println(0);
        }
    }

    /**
     * Ввод значений
     * @return Список списков чисел
     */
    public static ArrayList scanValues(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        String[] values;
        while(true) {
            try {
                System.out.println("Enter pancakes row...");
                values = scanner.nextLine().split(" ");
                if(values[0].equals("0")){
                    return list;
                }
            } catch (Exception e) {
                System.out.println("Wrong input... Try again");
                continue;
            }
            try {

                ArrayList<Integer> tmpList = new ArrayList<>();

                for(String value : values){
                    int pancake = Integer.parseInt(value);
                    if(pancake>=1 && pancake <= 100 && values.length >= 1 && values.length<=30)
                        tmpList.add(pancake);
                    else System.out.println("Wrong input...");
                }
                list.add(tmpList);
            }
            catch (Exception e){
                System.out.println("Wrong input...try again");
                continue;
            }
        }
    }
}