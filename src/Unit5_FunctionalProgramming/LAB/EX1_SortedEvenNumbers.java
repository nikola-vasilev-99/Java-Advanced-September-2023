package Unit5_FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX1_SortedEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(", ")).map(Integer::parseInt)
                .filter(e -> e % 2 == 0).collect(Collectors.toList());

        String result1 = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(result1);

        List <Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        String result2 = sortedNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(result2);


    }
}
