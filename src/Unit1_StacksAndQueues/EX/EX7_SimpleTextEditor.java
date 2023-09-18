package Unit1_StacksAndQueues.EX;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EX7_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque <String> stackOfChanges = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String [] commandArray = scanner.nextLine().split("\\s+");
            int commandNumber = Integer.parseInt(commandArray[0]);

            switch (commandNumber) {
                case 1:
                    String textToAdd = commandArray[1];
                    text.append(textToAdd);
                    stackOfChanges.push(text.toString());
                    break;
                case 2:
                    int elementsToRemove = Integer.parseInt(commandArray[1]);
                    int startIndex = text.length() - elementsToRemove;
                    int endIndex = text.length();
                    text.delete(startIndex, endIndex);
                    stackOfChanges.push(text.toString());
                    break;
                case 3:
                    int index = Integer.parseInt(commandArray[1]) - 1;
                    char symbol = text.charAt(index);
                    System.out.println(symbol);
                    break;
                case 4:
                    if (stackOfChanges.size() > 1) {
                        stackOfChanges.pop();
                        text.delete(0, text.length()).append(stackOfChanges.peek());
                    }
                    break;
            }
        }
    }
}
