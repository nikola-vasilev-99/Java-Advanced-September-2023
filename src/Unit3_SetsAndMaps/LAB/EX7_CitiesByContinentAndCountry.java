package Unit3_SetsAndMaps.LAB;

import java.util.*;

public class EX7_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap <String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split(" ");
            String continent = data[0];
            String country = data[1];
            String city = data[2];
            //key1 -> Continent
            //key2 -> Country
            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);

        }
        for (Map.Entry<String, LinkedHashMap<String, List<String>>> entry1 : map.entrySet()) {
            System.out.println(entry1.getKey() + ":");
            for (Map.Entry<String, List<String>> entry2 : entry1.getValue().entrySet()) {
                System.out.print("  " + entry2.getKey() + " -> ");
                System.out.println(String.join(", ", entry2.getValue()));
            }
        }

    }
}
