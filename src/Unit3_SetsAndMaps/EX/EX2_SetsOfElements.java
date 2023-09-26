package Unit3_SetsAndMaps.EX;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class EX2_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arrayWithLengths = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int nLength = arrayWithLengths[0];
        int mLength = arrayWithLengths[1];

        Set <Integer> firstSet = new LinkedHashSet<>();
        Set <Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < nLength; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < mLength; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }
        Set <Integer> newSet = new LinkedHashSet<>();
        for (int number: firstSet) {
            if (secondSet.contains(number)) {
                newSet.add(number);
            }
        }

        newSet.forEach(e -> System.out.print(e + " "));

    }
}
