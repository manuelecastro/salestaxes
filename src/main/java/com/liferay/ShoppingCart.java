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
    public static void menu(){
        System.out.println("\tShopping Basket");
        System.out.println("0. Exit");
        System.out.println("1. Add Product");
        System.out.println("2. Finish Shopping");
    }

    public static void addProduct(){
        int productAmount;

        System.out.println("Type the name of the product:");
        _product.setName(input.next());
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

        shoppingList.add(resume(_product, productAmount));
    }

    public static void finishShopping(){
        System.out.println("---------- RECEIPT ----------");
        shoppingList.forEach((item) -> System.out.println(item));
        System.out.println("Sales Taxes: " + format(totalTax));
        System.out.println("Total: " + format(totalPrice));
    }

    public static String resume(Product product, int amount) {
        double price;
        if (!_product.isExempt() && _product.isImported()) {
            price =  _product.getPrice() + basicTax(_product.getPrice(), amount) + importationTax(_product.getPrice(), amount);
            totalTax = totalTax + basicTax(_product.getPrice(), amount);
        }else if (!_product.isExempt()) {
            price = basicTaxPrice(_product.getPrice(), amount);
            totalTax = totalTax + basicTax(_product.getPrice(), amount);
        } else if (_product.isImported()) {
            price = importationTaxPrice(_product.getPrice(), amount);
            totalTax = totalTax + importationTax(_product.getPrice(), amount);
        } else {
            price = noTaxes(_product.getPrice(), amount);
        }
        totalPrice = totalPrice + price;
        String formattedPrice = format(price);

        return String.valueOf(amount) + " " + _product.getName() + " : " + formattedPrice;
    }

    public static void main(String[] args) {
        int option;

        do{
            menu();
            option = input.nextInt();

            switch(option){
                case 1:
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
}
