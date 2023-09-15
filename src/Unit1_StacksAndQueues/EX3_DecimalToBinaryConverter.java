package Unit1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EX3_DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque <Integer> stack = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(0);
            return;
        }
        while (number >= 1) {
            stack.push(number % 2);
            number /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

        System.out.println(Integer.toBinaryString(number));

    }
}
