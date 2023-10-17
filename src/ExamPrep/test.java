package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArrayDeque<Integer> tools = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(tools::offer);

        System.out.println(tools.toString().replaceAll("[\\[\\]]", ""));
    }
}
