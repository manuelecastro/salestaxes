package com.liferay;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Calculator {
    private static final DecimalFormat decimalFormat =
            new DecimalFormat("#0.0#", new DecimalFormatSymbols(Locale.US));
    public static double calculateBasicTax(double price, int amount) {
        double totalTax = 0.1 * price * amount;

        return roundTax(totalTax);
    }
    public static double calculateBasicTaxedPrice(double price, int amount) {
        return Double.parseDouble(formatPrice(calculateBasicTax(price, amount) + price * amount));
    }
    public static double calculateImportationTax(double price, int amount) {
        double totalTax = 0.05 * price * amount;

        return roundTax(totalTax);
    }
    public static double calculateImportationTaxedPrice(double price, int amount) {

        return calculateImportationTax(price, amount) + price * amount;
    }
    public static double calculateTotalPrice(double price, int amount) {
        return price * amount;
    }
    public static String formatPrice(double price) {
        return decimalFormat.format(price);
    }
    public static double roundTax(double tax){
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

        return Double.parseDouble(formatPrice(tax));
    }

}
