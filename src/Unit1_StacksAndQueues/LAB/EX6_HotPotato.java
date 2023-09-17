package Unit1_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class EX6_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] kids = scanner.nextLine().split(" ");
        int toss = Integer.parseInt(scanner.nextLine());
        ArrayDeque <String> kidsQueue = new ArrayDeque<>();

        for (String element: kids) {
            kidsQueue.offer(element);
        }

        while (kidsQueue.size() > 1) {
            int counter = 1;
            while (counter < toss) {
                String currentKid = kidsQueue.poll();
                kidsQueue.offer(currentKid);
                counter++;
            }
            String removedKid = kidsQueue.poll();
            System.out.println("Removed " + removedKid);
        }
        String lastKid = kidsQueue.peek();
        System.out.println("Last is " + lastKid);
    }
}
