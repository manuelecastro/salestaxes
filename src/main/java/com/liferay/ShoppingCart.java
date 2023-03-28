package com.liferay;
import java.util.ArrayList;
import java.util.Scanner;

import static com.liferay.Calculator.*;

public class ShoppingCart  {
    static ArrayList<String> shoppingList = new ArrayList<String>();
    static double totalTax;
    static double totalPrice;
    private static final Product _product = new Product();
    static Scanner input = new Scanner(System.in);

    public static void addProduct(){
        int productAmount;

        System.out.println("Type the name of the product:");
        _product.setName(input.nextLine());
        System.out.println("Type the price of the product:");
        _product.setPrice(input.nextDouble());
        System.out.println("Type the amount of the product:");
        productAmount = input.nextInt();
        System.out.println("Is the product exempt of taxes?");
        System.out.println("1. Yes");
        System.out.println("0. no");
        _product.setExempt(input.nextInt() == 1);
        System.out.println("Is the product imported?");
        System.out.println("1. Yes");
        System.out.println("0. no");
        _product.setImported(input.nextInt() == 1);

        shoppingList.add(sumUpProduct(_product, productAmount));
    }
    public static void finishShopping(){
        System.out.println("---------- RECEIPT ----------");
        shoppingList.forEach(System.out::println);
        System.out.println();
        System.out.println("Sales Taxes: " + formatPrice(totalTax));
        System.out.println("Total: " + formatPrice(totalPrice));
        System.out.println("-----------------------------");
    }
    public static void main(String[] args) {
        int option;

        do{
            menu();
            option = input.nextInt();

            switch(option){
                case 1:
                    input.nextLine();
                    addProduct();
                    break;

                case 2:
                    finishShopping();
                    option = 0;
                    break;

                default:
                    System.out.println("Invalid Option.");
            }
        } while(option != 0);
    }
    public static void menu(){
        System.out.println("\tShopping Basket");
        System.out.println("0. Exit");
        System.out.println("1. Add Product");
        System.out.println("2. Finish Shopping");
    }
    public static String sumUpProduct(Product product, int amount) {
        double price;

        if (!_product.isExempt() && _product.isImported()) {

            price =  _product.getPrice() + calculateBasicTax(_product.getPrice(), amount) +
                    calculateImportationTax(_product.getPrice(), amount);
            totalTax = totalTax + calculateBasicTax(_product.getPrice(), amount);

        } else if (!_product.isExempt()) {

            price = calculateBasicTaxedPrice(_product.getPrice(), amount);
            totalTax = totalTax + calculateBasicTax(_product.getPrice(), amount);

        } else if (_product.isImported()) {

            price = calculateImportationTaxedPrice(_product.getPrice(), amount);
            totalTax = totalTax + calculateImportationTax(_product.getPrice(), amount);

        } else {

            price = calculateTotalPrice(_product.getPrice(), amount);

        }

        totalPrice = totalPrice + price;

        return String.valueOf(amount) + " " + _product.getName() + " : " + formatPrice(price);
    }
}
