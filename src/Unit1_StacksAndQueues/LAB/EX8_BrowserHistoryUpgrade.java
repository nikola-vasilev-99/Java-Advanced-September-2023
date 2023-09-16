package Unit1_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EX8_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> urlStack = new ArrayDeque<>();
        ArrayDeque<String> forwardUrl = new ArrayDeque<>();
        String currentUrl = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (urlStack.size() > 1) {
                    forwardUrl.addFirst(urlStack.pop());
                    currentUrl = urlStack.peek();
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (input.equals("forward")) {
                if (forwardUrl.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    urlStack.push(forwardUrl.poll());
                    System.out.println(urlStack.peek());
                }
            } else {
                urlStack.push(input);
                currentUrl = input;
                forwardUrl.clear();
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }
    }
}
