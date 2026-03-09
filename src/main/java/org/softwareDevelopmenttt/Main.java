package org.softwareDevelopmenttt;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("Роботу виконала студентка Волинець Н.В. ");
        System.out.println();

        int rows = 2; // рядки
        int cols = 3; // стовпці
        int[][] A = new int[rows][cols];
        Random rand = new Random();

        // Заповнення матриці
       /* for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                A[i][j] = rand.nextInt(2); // 0 або 1
            }
        }*/

        // Матриця ДО
        System.out.println("Початковий вигляд матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                A[i][j] = rand.nextInt(2);
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        // Заміна 0 на "a"
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


        System.out.println("Матриця після перетворення:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


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

