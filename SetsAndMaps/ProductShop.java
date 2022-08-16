package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> shops = new TreeMap<>();

        // fill shops
        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shopName = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            Map<String, Double> productPrice;
            if (shops.containsKey(shopName)) {
                productPrice = shops.get(shopName);
            } else {
                productPrice = new LinkedHashMap<>();
            }
            productPrice.put(product, price);
            shops.put(shopName, productPrice);

            input = scanner.nextLine();
        }

        for (String s : shops.keySet()) {
            System.out.println(s + "->");
            shops.get(s).forEach((key, value) -> System.out.printf("Product: %s, Price: %.1f\n", key, value));
        }
    }
}