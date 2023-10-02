package Unit5_FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EX3_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String [] words =  text.split("\\s+");

        Predicate <String> isUppercase = s -> Character.isUpperCase(s.charAt(0));
        Function <String [], List<String>> getUppercase = arr -> Arrays.stream(arr)
                .filter(isUppercase)
                .collect(Collectors.toList());

        List <String> uppercase = getUppercase.apply(words);
        System.out.println(uppercase.size());

        uppercase.forEach(System.out::println);

    }
}
