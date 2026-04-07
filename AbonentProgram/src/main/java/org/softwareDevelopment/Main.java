package org.softwareDevelopment;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        Abonent[] abonents = new Abonent[5];

        String[] surnames = {"Волинець", "Микитюк", "Феденко", "Чін", "Браун"};
        String[] addresses = {"Лондон", "Токіо", "Львів", "Харків", "Київ"};

        for (int i = 0; i < abonents.length; i++) {
            String surname = surnames[rand.nextInt(surnames.length)];
            String address = addresses[rand.nextInt(addresses.length)];
            double localTime = rand.nextDouble(201);
            double internationalTime = rand.nextDouble(101);
            abonents[i] = new Abonent(surname, address, localTime, internationalTime);
        }

        System.out.println("\n\tвсі абоненти:");
        System.out.printf("%-15s %-20s %-15s %-15s\n",
                "прізвище", "адреса", "внутрішні", "міжнародні");
        for (Abonent abonent : abonents) {
            abonent.print();
        }

        while (true) {
            System.out.println("\n\tМЕНЮ");
            System.out.println("1 - фільтр за внутрішнім часом");
            System.out.println("2 - фільтр за міжнародним часом");
            System.out.println("0 - вихід");
            System.out.print("ваш вибір: ");

            String choice = scanner.next();

            switch (choice) {
                case "1":
                    while(true) {
                        System.out.print("Введіть мінімальний час внутрішніх переговорів: ");
                        try {
                            double minLocal = Double.parseDouble(scanner.next());
                            System.out.println("\nабоненти з внутрішнім часом > " + minLocal + ":");
                            System.out.printf("%-15s %-20s %-15s %-15s\n",
                                    "прізвище", "адреса", "внутрішні", "міжнародні");
                            printFiltered(abonents, minLocal, true);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Помилка, треба ввести число");
                        }
                    }
                    break;
                case "2":
                    while(true) {
                        System.out.print("Введіть мінімальний час міжнародних переговорів: ");
                        try {
                            double minInternational = Double.parseDouble(scanner.next());
                            System.out.println("\nабоненти з міжнародним часом > " + minInternational + ":");
                            System.out.printf("%-15s %-20s %-15s %-15s\n",
                                    "прізвище", "адреса", "внутрішні", "міжнародні");
                            printFiltered(abonents, minInternational, false);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Треба ввести число");
                        }
                    }
                    break;

                case "0":
                    return;
                default:
                    System.out.println("невірний вибір, спробуйте ще раз");
                    break;
            }
        }
    }

    static void printFiltered(Abonent[] abonents, double minTime, boolean isLocal) {
        boolean found = false;
        for (Abonent abonent : abonents) {
            double time = isLocal ? abonent.localTime : abonent.internationalTime;
            if (time > minTime) {
                abonent.print();
                found = true;
            }
        }
        if (!found) System.out.println("не знайдено");
    }
}