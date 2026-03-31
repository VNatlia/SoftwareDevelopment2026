package org.softwareDevelopment;

import java.util.Random;



public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int sum = 0;
        int[] numbers = new int[5];


        System.out.println("Згенеровані числа:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = 100 + random.nextInt(900);
            System.out.print(numbers[i] + " ");
        }


        System.out.println("Числа без парних цифр:");
        for (int i = 0; i < numbers.length; i++) {
            String string = String.valueOf(numbers[i]);
            boolean onlyOdd = true;

            for (int j = 0; j < string.length(); j++) {
                char c = string.charAt(j);
                int digit = c - '0';

                if (digit % 2 == 0) {
                    onlyOdd = false;
                    break;
                }
            }

            if (onlyOdd) {
                System.out.println(numbers[i]);
                sum += numbers[i];
            }
        }

        System.out.println("Сума:" + sum);
    }
}
