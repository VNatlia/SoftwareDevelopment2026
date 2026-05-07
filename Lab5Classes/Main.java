package org.softwareDevelopment;

import org.softwareDevelopment.Materic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Materic materic = new Materic(
                "Європа",
                "Територіальний поділ Європи змінювався через війни, об'єднання держав та розпад імперій."
        );

        String[] countries = {
                "Україна",
                "Польща",
                "Німеччина",
                "Франція",
                "Італія"
        };

        String[] periods = {
                "1991 — наш час",
                "1918 — наш час",
                "1871 — наш час",
                "843 — наш час",
                "1861 — наш час"
        };

        Materic.TerritorialDivision division =
                materic.new TerritorialDivision(countries, periods);

        Scanner scanner = new Scanner(System.in);

        materic.printInfo();
        division.printDivision();

        System.out.print("\nВведіть назву держави для пошуку: ");
        String countryName = scanner.nextLine();

        division.searchCountry(countryName);
    }
}