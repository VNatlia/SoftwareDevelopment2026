package org.softwareDevelopment;

public class Abonent {
    String surname;
    String address;
    double localTime;
    double internationalTime;

    public Abonent(String surname, String address, double localTime, double internationalTime) {
        this.surname = surname;
        this.address = address;
        this.localTime = localTime;
        this.internationalTime = internationalTime;
    }

    public void print() {
        System.out.printf("%-15s %-20s %-15.2f %-15.2f\n",
                surname, address, localTime, internationalTime);
    }
}