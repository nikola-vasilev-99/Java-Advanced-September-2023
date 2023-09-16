package Unit1_StacksAndQueues.EX;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EX2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();
        int [] infArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int elementsToPop = infArray[1];
        int findElement = infArray[2];
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(stack::push);

        for (int i = 1; i <= elementsToPop; i++) {
            stack.pop();
        }

        int minNum = Integer.MAX_VALUE;
        if (stack.isEmpty()) {
            System.out.println("0");
            return;
        } else {
            if (stack.contains(findElement)) {
                System.out.println("true");
                return;
            } else {
                while(!stack.isEmpty()) {
                    int currentNum = stack.pop();
                    if (currentNum < minNum) {
                        minNum = currentNum;
                    }
                }
            }
        }
        System.out.println(minNum);
    }
}
