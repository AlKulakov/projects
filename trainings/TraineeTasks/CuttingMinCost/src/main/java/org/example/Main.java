package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> n = new ArrayList<>();
        ArrayList<int[]> c = new ArrayList<int[]>();

        dataInput(l, n, c);

        for(int item : l){
            System.out.println("Минимальная стоимость: " + getMinCost(c.get(l.indexOf(item)), item));
        }
    }
    public static int getMinCost(int[] cuts, int length) {
        int n = cuts.length;
        int[] arr = new int[n+2]; // массив отметок + начало и конец бруса
        System.arraycopy(cuts, 0, arr, 1, n);
        arr[0] = 0;
        arr[n+1] = length;
        n += 2;

        // dp[i][j] - минимальная стоимость распила отметок i...j
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) { // длина текущего отрезка
            for (int i = 0; i + len < n; i++) { // начало текущего отрезка
                int j = i + len; // конец текущего отрезка
                dp[i][j] = Integer.MAX_VALUE; // начинаем с очень большого значения

                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[j] - arr[i]);
                }
            }
        }

        return dp[0][n-1];
    }
    public static void dataInput(ArrayList<Integer> l_list, ArrayList<Integer> n_list, ArrayList<int[]> c_list) {

        int l, n;
        int[] c;
        while(true){
            System.out.println("Введите данные: ");
            try {
                Scanner scanner1 = new Scanner(System.in);
                l = scanner1.nextInt();
                if(l > 1000){
                    System.out.println("Ошибка. Максимальная длина бруса - 1000");
                    continue;
                }
                if(l==0){
                    break;
                }
                l_list.add(l);
                Scanner scanner2 = new Scanner(System.in);
                n = scanner2.nextInt();
                if(n >= 50){
                    System.out.println("Ошибка. Максимальное число распилов - 50");
                    continue;
                }
                n_list.add(n);
                c = new int[n];
                while(true){
                    try{
                        Scanner scanner3 = new Scanner(System.in);
                        String line = scanner3.nextLine();
                        String[] c_str = line.split(" ");
                        if(c_str.length != n) {
                            System.out.println("Количество мест распила не соответствует веденному числу распилов");
                            continue;
                        }
                        for(int i = 0; i < c_str.length; i++)
                            c[i] = Integer.parseInt(c_str[i]);
                        Arrays.sort(c);

                        break;
                    } catch(Exception e){
                        System.out.println("Ошибка ввода массива данных. Пример: 12 32 53");
                    }

                }
                c_list.add(c);
            } catch(Exception e){
                System.out.println("Ошибка ввода!");
                continue;
            }
        }
    }
}