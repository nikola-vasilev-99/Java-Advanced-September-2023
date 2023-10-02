package Unit5_FunctionalProgramming.LAB;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class EX2_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Function<int [], String> countElements = arr -> "Count = " + arr.length;
        Function<int [], String> sumElements = arr -> "Sum = " + Arrays.stream(arr).sum();

        System.out.println(countElements.apply(numbers));
        System.out.println(sumElements.apply(numbers));
    }
}
