package Unit5_FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EX1_SortedEvenNumber_withFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(", ")).map(Integer::parseInt)
                .filter(e -> e % 2 == 0).collect(Collectors.toList());

        Function <List<Integer>, String> format = l -> l.stream()
                .map(String::valueOf).collect(Collectors.joining(", "));
        String result = format.apply(numbers);
        System.out.println(format.apply(numbers));

        List <Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());

        System.out.println(format.apply(sortedNumbers));
    }
}
