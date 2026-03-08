package org.workingWithArrays;

import java.util.Random;


public class Main {
    public static void main(String[] args) {
        System.out.println("Волинець Наталія Вікторівна");
        System.out.println();


        int rows = 2; // рядки
        int cols = 3; // стовпці
        int[][] A = new int[rows][cols];
        Random rand = new Random();


        System.out.println("Початковий вигляд матриці:");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++) {
                A[i][j] = rand.nextInt(2);
                System.out.print(A[i][j] + " ");
            }
           System.out.println();
        }
        System.out.println();


        String[][] B = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 0) {
                    B[i][j] = "a";
                } else {
                    B[i][j] = "1";
                }
            }
        }


        System.out.println("Перетворений вигляд матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        // Підрахунок кількості 0 та 1
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 0) count0++;
                else count1++;
            }
        }

        System.out.println("Кількість «0»: " + count0);
        System.out.println("Кількість «1»: " + count1);
    }
}




