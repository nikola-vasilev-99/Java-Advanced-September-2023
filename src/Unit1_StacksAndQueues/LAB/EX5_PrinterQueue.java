package Unit1_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EX5_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque <String> printerQueue = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("print")) {
            if (!input.equals("cancel")) {
                printerQueue.offer(input);
            } else {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String firstFile = printerQueue.poll();
                    System.out.println("Canceled " + firstFile);
                }
            }
            input = scanner.nextLine();
        }
        while (printerQueue.size() != 0) {
            String nextFile = printerQueue.poll();
            System.out.println(nextFile);
        }
    }
}
