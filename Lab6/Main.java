package org.softwareDevelopment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(12);
        numbers.add(5);
        numbers.add(8);
        numbers.add(12);
        numbers.add(3);

        int choice;

        do
        {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Показати список");
            System.out.println("2. Додати елемент");
            System.out.println("3. Сортувати список");
            System.out.println("4. Перевірити повтори");
            System.out.println("0. Вихід");

            System.out.print("Ваш вибір: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("Список елементів:");
                    System.out.println(numbers);
                    break;

                case 2:
                    System.out.print("Введіть число: ");
                    int number = scanner.nextInt();

                    numbers.add(number);

                    System.out.println("Елемент додано");
                    break;

                case 3:
                    Collections.sort(numbers);

                    System.out.println("Список відсортовано");
                    System.out.println(numbers);
                    break;

                case 4:
                    TreeSet<Integer> uniqueNumbers = new TreeSet<>(numbers);

                    if (uniqueNumbers.size() == numbers.size())
                    {
                        System.out.println("Повторів немає");
                    }
                    else
                    {
                        System.out.println("У списку є повтори");
                    }

                    System.out.println("Елементи без повторів:");
                    System.out.println(uniqueNumbers);
                    break;

                case 0:
                    System.out.println("Програма завершена");
                    break;

                default:
                    System.out.println("Неправильний вибір");
            }

        } while (choice != 0);

        scanner.close();
    }
}