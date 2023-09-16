package Unit1_StacksAndQueues.EX;

import java.util.*;

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

        if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            if (stack.contains(findElement)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
