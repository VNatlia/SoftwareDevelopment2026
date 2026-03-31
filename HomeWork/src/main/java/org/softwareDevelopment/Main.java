package org.softwareDevelopment;

public class Main {
public static void main (String[] args) {
    new Thread(() -> {
        try {
            Thread.sleep(1000);
            System.out.println("1");
        } catch (InterruptedException e) {

        }
    }).start();

    new Thread(() -> {
        try {
            Thread.sleep(2000);
            System.out.println("2");
        } catch (InterruptedException e) {

        }
    }).start();

    new Thread(() -> {
        try {
            Thread.sleep(3000);
            System.out.println("3");
        } catch (InterruptedException e) {

        }
    }).start();
}
}