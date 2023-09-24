package Unit3_SetsAndMaps.LAB;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX3_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerSet = Arrays.stream(scanner.nextLine().
                  split(" ")).map(Integer::parseInt)
                  .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayerSet = Arrays.stream(scanner.nextLine().
                        split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;
        while (rounds -- > 0) {
            int firstPlayerNum = firstPlayerSet.iterator().next();
            firstPlayerSet.remove(firstPlayerNum);
            int secondPlayerNum = secondPlayerSet.iterator().next();
            secondPlayerSet.remove(secondPlayerNum);
            if (firstPlayerNum > secondPlayerNum) {
                firstPlayerSet.add(firstPlayerNum);
                firstPlayerSet.add(secondPlayerNum);
            } else if (firstPlayerNum < secondPlayerNum) {
                secondPlayerSet.add(firstPlayerNum);
                secondPlayerSet.add(secondPlayerNum);
            }

            if (firstPlayerSet.isEmpty() || secondPlayerSet.isEmpty()) {
                break;
            }
        }
        String output;
        if (firstPlayerSet.size() > secondPlayerSet.size()) {
            output = "First player win!";
        } else if (firstPlayerSet.size() < secondPlayerSet.size()) {
            output = "Second player win!";
        } else {
            output = "Draw!";
        }
        System.out.println(output);
    }
}
