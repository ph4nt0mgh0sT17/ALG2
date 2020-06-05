package cz.osu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ExchangeRateDatabase rateDatabase = new ExchangeRateDatabase();

        rateDatabase.enlistRates();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadej pocet penez: ");

        double value = scanner.nextDouble();

        System.out.print("Zadej puvodni menu: ");

        String defaultRate = scanner.next();

        System.out.print("Zadej novou menu: ");

        String newRate = scanner.next();

        System.out.println(rateDatabase.convert(value, defaultRate, newRate));
    }
}
