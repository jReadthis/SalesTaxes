package com.nano1.salestaxes.intelij;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by nano1 on 4/7/2016.
 */
public class Main {

    public static void  main(String args[]){

        Scanner input = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();
        char c;
        boolean origin = false;

       do {
           System.out.println("Enter the Product name:");
           input.nextLine();
           String name = input.nextLine();
           System.out.println("Enter Product price:");
           String price = input.next();
           System.out.println("Is this product Imported(T/F) ?");
           while (!input.hasNext("true")){
               System.out.println("Invalid Input");
               input.next();
           }
           origin = input.nextBoolean();
           System.out.println("Is this product a Book, Food, or Medical(T/F) ?");
           boolean type = input.nextBoolean();
           System.out.println("Enter Quantity");
           int quantity = input.nextInt();
           shoppingCart.add(addProductToCart(new Product(name, price), quantity, origin, type));
           System.out.println("Add another Product(Y/N)");
           c = input.next().charAt(0);
       } while (c == 'Y'||c =='y');

        System.out.println(shoppingCart.toString());
    }

    public static ShoppingCartItem addProductToCart(Product product, int quantity,boolean origin,boolean type){
        if(origin && !type){
        return new ItemBuilder(quantity,product)
                .addImportTaxCalc()
                .addSalesTaxCalc().build();
        }else if (origin){
            return new ItemBuilder(quantity,product)
                    .addImportTaxCalc()
                    .build();
        }else if (!type){
            return new ItemBuilder(quantity,product)
                    .addSalesTaxCalc()
                    .build();
        }else{
            return new ItemBuilder(quantity,product)
                    .build();
        }
    }

    public static void input1(){
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.add(new ItemBuilder(1, new Product("book",new BigDecimal("12.49"))).build());
        shoppingCart.add(new ItemBuilder(1, new Product("book", new BigDecimal("12.49"))).build());
        shoppingCart.add(new ItemBuilder(1, new Product("music CD", new BigDecimal("14.99"))).addSalesTaxCalc().build());
        shoppingCart.add(new ItemBuilder(1, new Product("chocolate bar", new BigDecimal("0.85"))).build());

        System.out.println(shoppingCart.toString());
    }

    public static void input2(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new ItemBuilder(1, new Product("imported box of chocolates",new BigDecimal("10.00")))
                .addImportTaxCalc()
                .build());
        shoppingCart.add(new ItemBuilder(1, new Product("imported bottle of perfume",new BigDecimal("47.50")))
                .addImportTaxCalc()
                .addSalesTaxCalc().build());

        System.out.println(shoppingCart.toString());
    }

    public static void input3(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new ItemBuilder(1, new Product("imported bottle of perfume",new BigDecimal("27.99")))
                .addImportTaxCalc()
                .addSalesTaxCalc()
                .build());
        shoppingCart.add(new ItemBuilder(1, new Product("bottle of perfume",new BigDecimal("18.99")))
                .addSalesTaxCalc().build());
        shoppingCart.add(new ItemBuilder(1, new Product("packet of headache pills",new BigDecimal("9.75")))
                .build());
        shoppingCart.add(new ItemBuilder(1, new Product("box of imported chocolates",new BigDecimal("11.25")))
                .addImportTaxCalc()
                .build());
        shoppingCart.add(new ItemBuilder(1, new Product("box of imported chocolates",new BigDecimal("11.25")))
                .addImportTaxCalc()
                .build());

        System.out.println(shoppingCart.toString());
    }
}
