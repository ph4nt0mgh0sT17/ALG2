package cz.osu;

import java.util.ArrayList;

public class ExchangeRateDatabase {

    private ArrayList<ExchangeRateModel> exchangeRates;

    public ExchangeRateDatabase() {
        exchangeRates = new ArrayList<>();
        loadDatabase();
    }

    private void loadDatabase() {
        ArrayList<String> lines = FileManager.getFileContent("exchange_rate.txt");

        // Each line is 1 exchange rate

        assert lines != null;
        lines.forEach((line) -> {
            String[] parsedLine = line.split(";");

            exchangeRates.add(new ExchangeRateModel(parsedLine[0], parsedLine[2], Double.parseDouble(parsedLine[4]), Double.parseDouble(parsedLine[5])));
        });
    }

    public double convert(double value, String from, String to) {
        if (from.equals("CZK")) {
            return convertTo(value,to);
        }

        else if (to.equals("CZK")) {
            return convertFrom(value, from);
        }

        else {
            System.out.println("You have to choose CZK.");
            return 0;
        }
    }

    private double convertTo(double value, String to) {
        // test for czk
        ExchangeRateModel toModel = searchRate(to);

        if(toModel == null) {
            return 0;
        }

        return value / toModel.getSellPrice();

    }

    private double convertFrom(double value, String from) {
        ExchangeRateModel toModel = searchRate(from);

        if(toModel == null) {
            return 0;
        }

        return value * toModel.getBuyPrice();
    }

    public ExchangeRateModel searchRate(String abbreviation) {
        return exchangeRates.stream()
                .filter((exchangeRateModel -> exchangeRateModel.getAbbreviation().equals(abbreviation)))
                .findAny()
                .orElse(null);
    }

    public void enlistRates() {
        System.out.print("Available rates: ");
        exchangeRates.forEach((model) -> {
            System.out.print(model.getAbbreviation() +"; ");
        });

        System.out.println();
    }
}
