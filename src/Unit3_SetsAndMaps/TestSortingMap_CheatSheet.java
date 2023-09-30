package Unit3_SetsAndMaps;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.Entry.comparingByValue;

public class TestSortingMap_CheatSheet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> peopleMap = new LinkedHashMap<>();
        peopleMap.put("nik", 45);
        peopleMap.put("lea", 4);
        peopleMap.put("zozo", 23);
        peopleMap.put("dodo", 56);
        peopleMap.put("mimi", 12);

        //ascending order by value
        System.out.println("ascending order by value");
        peopleMap.entrySet().stream().sorted(comparingByValue())
                .forEach(e -> System.out.println(e.getKey() + " is " + e.getValue()));

        //descending order by value
        System.out.println("descending order by value");
        peopleMap.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue()))
                .forEach(e -> System.out.println(e.getKey() + " is " + e.getValue()));

    }
}
