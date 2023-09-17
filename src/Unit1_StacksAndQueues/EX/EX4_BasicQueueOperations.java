package Unit1_StacksAndQueues.EX;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EX4_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] commandArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int addElement = commandArray[0];
        int removeElement = commandArray[1];
        int checkIfPresent = commandArray[2];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int [] elementsArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < addElement; i++) {
            queue.offer(elementsArray[i]);
        }

        for (int i = 1; i <= removeElement; i++) {
            queue.poll();
        }

        if (queue.contains(checkIfPresent)) {
            System.out.println("true");
        } else if(queue.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
