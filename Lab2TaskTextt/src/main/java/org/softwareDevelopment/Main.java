package org.softwareDevelopment;

import java.util.Random;
import java.util.Scanner;




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
        System.out.println();


        System.out.println("Числа без парних цифр:");
        for (int i = 0; i < numbers.length; i++) {
            String string = String.valueOf(numbers[i]);
            boolean onlyOdd = true;

            for (int j = 0; j < string.length(); j++) {
                char symbol = string.charAt(j);
                int digit = symbol - '0';

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

        // ===== ЗАВДАННЯ 2 =====
        Scanner scanner = new Scanner(System.in);

        String text = "Думи мої думи тяжко мені з вами";

        System.out.println("\nТекст до обробки:");
        System.out.println(text);

        System.out.print("\nВвести довжину слова щоб видалити: ");
        int length = scanner.nextInt();

        String prigolosni = "бвгґджзйклмнпрстфхцчшщ";

        String[] words = text.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String cleanWord = word.replaceAll("[^а-яА-ЯіїєІЇЄa-zA-Z]", "");

            if (cleanWord.length() == length) {
                char firstChar = Character.toLowerCase(cleanWord.charAt(0));

                if (prigolosni.indexOf(firstChar) != -1) {
                    continue;
                }
            }

            result.append(word).append(" ");
        }

        System.out.println("\nТекст після обробки:");
        System.out.println(result.toString().trim());

        System.out.println("\nВхідні дані:");
        System.out.println("Довжина слова: " + length);
    }

    }

