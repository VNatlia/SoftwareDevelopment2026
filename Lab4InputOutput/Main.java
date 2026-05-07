package org.softwareDevelopment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ввід файлів
        System.out.println("-РОБОТА З ФАЙЛАМИ-");

        System.out.print("Введіть шлях до вхідного файлу: ");
        String inputFileName = scanner.nextLine();

        System.out.print("Введіть шлях до вихідного файлу: ");
        String outputFileName = scanner.nextLine();

        try {
            System.out.println("\n1) Відкриваємо файл");

            File inputFile = new File(inputFileName); 
            Scanner fileScanner = new Scanner(inputFile);

            System.out.println("2) Читаємо дані з файлу");

            int matrixSize = fileScanner.nextInt(); 
            System.out.println("Розмір матриці: " + matrixSize);

            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposed = new int[matrixSize][matrixSize];

            // Зчитування по символьно
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = fileScanner.nextInt();
                }
            }

            System.out.println("3) Початкова матриця:");
            printMatrix(matrix, matrixSize);

            System.out.println("4) Виконуємо транспонування");

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    transposed[j][i] = matrix[i][j];
                }
            }

            System.out.println("5) Транспонована матриця:");
            printMatrix(transposed, matrixSize);

            // Запис у файл
            System.out.println("6) Записуємо результат у файл");

            FileWriter writer = new FileWriter(outputFileName);

            writer.write(matrixSize + "\n");

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    writer.write(transposed[i][j] + " ");
                }
                writer.write("\n");
            }

            writer.close();
            fileScanner.close();

            System.out.println("7) Дані записані у файл: " + outputFileName);

        } catch (IOException e) {
            System.out.println("ПОМИЛКА: не вдалося відкрити або прочитати файл!");
        }
    }

    // Метод для виводу матриці
    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
