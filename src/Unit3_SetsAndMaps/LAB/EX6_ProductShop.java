package Unit3_SetsAndMaps.LAB;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EX6_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap <String, LinkedHashMap<String, Double>> map = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String [] array = input.split(", ");
            String shop = array[0];
            String product = array[1];
            double price = Double.parseDouble(array[2]);
            if (!map.containsKey(shop)) { // = map.putIfAbsent()
                map.put(shop, new LinkedHashMap<>());
                map.get(shop).put(product, price);
            } else {
                map.get(shop).put(product, price);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (Map.Entry<String, Double> secondEntry : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", secondEntry.getKey(), secondEntry.getValue());
            }
        }

    }
}
