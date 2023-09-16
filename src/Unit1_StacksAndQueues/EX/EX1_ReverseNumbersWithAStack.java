package Unit1_StacksAndQueues.EX;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class EX1_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();

        //int [] array = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        //        for(int element: array) {
        //            stack.push(element);
        //        }
        // еднакво с това отдолу
        Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).forEach(stack::push);

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
