package cz.osu;

public class ExchangeRateModel {

    private String country;
    private String abbreviation;
    private double buyPrice;
    private double sellPrice;

    public ExchangeRateModel(String country, String abbreviation, double buyPrice, double sellPrice) {
        this.country = country;
        this.abbreviation = abbreviation;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public String getCountry() {
        return country;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    @Override
    public String toString() {
        return "ExchangeRateModel{" +
                "country='" + country + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                '}';
    }
}
