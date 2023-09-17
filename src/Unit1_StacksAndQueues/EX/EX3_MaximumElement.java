package Unit1_StacksAndQueues.EX;

import java.util.*;

public class EX3_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int [] commandArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int commandNumber = commandArr[0];
            switch (commandNumber) {
                case 1:
                    int elementToPush = commandArr[1];
                    stack.push(elementToPush);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int maxElement = Collections.max(stack);
                    System.out.println(maxElement);
                    break;
            }
        }
    }
}
