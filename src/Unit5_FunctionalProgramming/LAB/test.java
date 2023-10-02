package Unit5_FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List <Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        String formattedOutput1 = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(formattedOutput1);

        List <Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        String formattedOutput2 = sortedNumbers.stream().map(String::valueOf).collect(Collectors.joining(", " ));
        System.out.println(formattedOutput2);
    }
}
