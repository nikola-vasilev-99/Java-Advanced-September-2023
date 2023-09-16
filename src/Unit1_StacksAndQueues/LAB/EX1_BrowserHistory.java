package Unit1_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class EX1_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque <String> urlStack = new ArrayDeque<>();
        String currentUrl = "";
        while (!input.equals("Home")) {
            if (!input.equals("back")) {
                urlStack.push(input);
                currentUrl = input;
                System.out.println(currentUrl);
            } else {
                if (urlStack.size() > 1) {
                    urlStack.pop();
                    currentUrl = urlStack.peek();
                    System.out.println(currentUrl);
                } else {
                    System.out.println("no previous URLs");
                }
            }
            input = scanner.nextLine();
        }
    }
}
