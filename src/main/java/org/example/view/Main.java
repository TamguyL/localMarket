package org.example.view;

import org.example.controller.MarketController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MarketController mc = new MarketController();
//        mc.displayProducts();
//        mc.displayProduct(1);
//        mc.newProduct(3, "Avocado", 52, 2.36);
//        mc.updateProduct(3,2,"choux-fleur", 40 , 1.12);
//        mc.deleteProduct(5);

            mc.addConsumer();
    }
}