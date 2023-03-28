package com.liferay;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Calculator {
    private static final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
    private static final DecimalFormat df = new DecimalFormat("#.0#", symbols);

    public static double basicTax(double price, int amount) {
        double totalTax = 0.1 * price * amount;

        return round(totalTax);
    }
    public static double basicTaxPrice(double price, int amount) {
        return Double.parseDouble(format(basicTax(price, amount) + price * amount));
    }
    public static double importationTax(double price, int amount) {
        double totalTax = 0.05 * price * amount;

        return round(totalTax);
    }
    public static double importationTaxPrice(double price, int amount) {

        return importationTax(price, amount) + price * amount;
    }
    public static double noTaxes(double price, int amount) {
        return price * amount;
    }

    public static double round(double tax){
        double taxIntMultiplied = ((int)(tax * 100));
        double restToRound = taxIntMultiplied % 10;
        tax = taxIntMultiplied/100;
        if (restToRound != 0) {
            if (restToRound <= 5){
                tax += (5 - restToRound) / 100;
            } else{
                tax += (10 - restToRound) / 100;
            }
        }
        return Double.parseDouble(format(tax));
    }

    public static String format(double price) {
        return df.format(price);
    }

}
