package Unit1_StacksAndQueues.EX;

import java.util.*;
import java.util.stream.Collectors;

public class EX5_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <String> input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        String result = isBalanced(input) ? "YES" : "NO";
        System.out.println(result);
    }

    private static boolean isBalanced(List<String> input) {
        Deque <String> openedBracketsStack = new ArrayDeque<>();
        for (int i = 0; i < input.size(); i++) {
            String currentBracket = input.get(i);
            if (currentBracket.equals("}")) {
                if (openedBracketsStack.isEmpty()) {
                    return false;
                }
                String lastAddedBracket = openedBracketsStack.pop();
                if (!lastAddedBracket.equals("{")) {
                    return false;
                }
            } else if (currentBracket.equals("]")) {
                if (openedBracketsStack.isEmpty()) {
                    return false;
                }
                String lastAddedBracket = openedBracketsStack.pop();
                if (!lastAddedBracket.equals("[")) {
                    return false;
                }
            } else if (currentBracket.equals(")")) {
                if (openedBracketsStack.isEmpty()) {
                    return false;
                }
                String lastAddedBracket = openedBracketsStack.pop();
                if (!lastAddedBracket.equals("(")) {
                    return false;
                }
            } else {
                openedBracketsStack.push(currentBracket);
            }
        }
        return true;
    }
}

