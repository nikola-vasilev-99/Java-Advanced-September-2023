package Unit3_SetsAndMaps.EX;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EX3_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elementsSet = new TreeSet<>();

        while (n-- > 0) {
            String [] chemEl = scanner.nextLine().split(" ");

            for (String el: chemEl) {
                elementsSet.add(el);
            }
        }

        elementsSet.forEach(e -> System.out.print(e + " "));
    }
}
