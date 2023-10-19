package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting15122021 {
    public static void main(String[] args) {
        //100 out of 100
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> males = new ArrayDeque<>();
        Deque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(males::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(females::offer);
        int matchesCount = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int maleValue = males.peek();
            int femaleValue = females.peek();

            if (maleValue <= 0) {
                males.pop();
                continue; // премини към следващ цикъл на while
            } else if (maleValue % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }

            if (femaleValue <= 0) {
                females.poll();
                continue;
            } else if(femaleValue % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }

            if (maleValue == femaleValue) {
                males.pop();
                females.poll();
                matchesCount++;
            } else {
                females.poll();
                maleValue = maleValue - 2;
                males.pop();
                males.push(maleValue);
            }
        }
        printOutput(matchesCount, males, females);
    }
    public static void printOutput (int matchesCount, Deque<Integer> males, Deque<Integer> females) {
        System.out.println("Matches: " + matchesCount);
        if (!males.isEmpty()) {
            String malesLeft = males.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Males left: %s%n", malesLeft);
        } else {
            System.out.println("Males left: none");
        }

        if (!females.isEmpty()) {
            String femalesLeft = females.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Females left: %s%n", femalesLeft);
        } else {
            System.out.println("Females left: none");
        }
    }
}
