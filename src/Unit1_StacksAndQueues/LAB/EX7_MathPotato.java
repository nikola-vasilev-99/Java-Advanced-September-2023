package Unit1_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EX7_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] kids = scanner.nextLine().split(" ");
        int toss = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        for (String element: kids) {
            kidsQueue.offer(element);
        }

        int cycle = 1;
        while (kidsQueue.size() > 1) {
            for (int i = 1; i < toss; i++) {
                kidsQueue.offer(kidsQueue.poll());
                if (isPrime(cycle)) {
                    System.out.println("Prime " + kidsQueue.peek());
                } else {
                    System.out.println("Removed " + kidsQueue.poll());
                }
                cycle++;
            }
        }
        System.out.println("Last is " + kidsQueue.poll());

    }
    public static boolean isPrime(int cycle) {
        if (cycle <= 1) {
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}
