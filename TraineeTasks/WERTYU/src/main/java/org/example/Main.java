package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final char[] lowerCase = {
            'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\\',
            'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';', '\'',
            'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'
    };

    static final char[] upperCase = {
            'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '{', '}', '|',
            'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ':', '"',
            'Z', 'X', 'C', 'V', 'B', 'N', 'M', '<', '>', '?'
    };

    /**
     * Главный метод main
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> list = scanSting();
        System.out.println("Result: ");
        for(String item : list) {
            char[] input = item.toCharArray();

            for (int i = 0; i < input.length; i++)
                for (int j = 0; j < lowerCase.length; j++)
                    if (input[i] != 'Q' && input[i] != 'A' && input[i] != 'Z'
                            && input[i] != 'q' && input[i] != 'a' && input[i] != 'z') {
                        if (input[i] == upperCase[j])
                            input[i] = upperCase[j - 1];
                        if (input[i] == lowerCase[j])
                            input[i] = lowerCase[j - 1];
                    }
            System.out.println(input);
        }
    }

    /**
     * Ввод строк для изменения
     * @return Список введенных строк
     */
    public static ArrayList scanSting() {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Input strings. Input '0' string to exit...");
        String str;
        do {
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();
            if(!str.equals("0")){
                list.add(str);
            }
        } while (!str.equals("0"));
        return list;
    }
}