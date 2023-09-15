package Unit1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EX2_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\s+");
        ArrayDeque <String> stack = new ArrayDeque<>();

        for (int i = array.length - 1; i >= 0; i--) {
            stack.push(array[i]);
        }

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+":
                    stack.push(String.valueOf(firstNum + secondNum));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNum - secondNum));
                    break;
            }
        }
        System.out.println(stack.peek());
    }
}
