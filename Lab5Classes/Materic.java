package org.softwareDevelopment;

public class Materic {

    private String name;
    private String history;

    public Materic(String name, String history) {
        this.name = name;
        this.history = history;
    }

    public void printInfo() {
        System.out.println("Материк: " + name);
        System.out.println("Історія змін: " + history);
    }

    public class TerritorialDivision implements ISearchable {

        private String[] countries;
        private String[] periods;

        public TerritorialDivision(String[] countries, String[] periods) {
            this.countries = countries;
            this.periods = periods;
        }

        public void printDivision() {
            System.out.println("\nТериторіальний поділ материка " + name + ":");

            for (int i = 0; i < countries.length; i++) {
                System.out.println(countries[i] + " — " + periods[i]);
            }
        }

        @Override
        public void searchCountry(String countryName) {
            boolean found = false;

            for (int i = 0; i < countries.length; i++) {
                if (countries[i].equalsIgnoreCase(countryName)) {
                    System.out.println("\nДержава знайдена:");
                    System.out.println("Назва держави: " + countries[i]);
                    System.out.println("Термін існування: " + periods[i]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("\nДержаву не знайдено.");
            }
        }
    }
}