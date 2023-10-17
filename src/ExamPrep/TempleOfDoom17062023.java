package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom17062023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque <Integer> tools = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(tools::offer);
        ArrayDeque <Integer> substances = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(substances::push);
        List <Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (!challenges.isEmpty()) {
            if (!tools.isEmpty() && !substances.isEmpty()) {
                // ако и двете поредици са пълни
                int currentTool = tools.poll();
                int currentSubstance = substances.pop();
                int result = currentTool * currentSubstance;
                if (challenges.contains(result)) {
                    // има такъв challenge
                    challenges.remove((Integer) result);
                } else {
                    // няма такъв challenge
                    tools.offer(currentTool += 1);
                    currentSubstance -= 1;
                    if (currentSubstance != 0) {
                        // добавяме го обратно в поредицата, ако е различно от 0
                        substances.push(currentSubstance);
                    }
                }
            } else {
                // ако някоя от поредиците е празна
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");
                printTools(tools);
                printSubstances(substances);
                printChallenges(challenges);
                return;
            }
        }

        System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        printTools(tools);
        printSubstances(substances);

    }
    public static void printChallenges (List <Integer> sequence) {
        if (!sequence.isEmpty()) {
            System.out.print("Challenges: ");
            System.out.println(sequence.toString().replaceAll("[\\[\\]]", ""));
        }
    }
    public static void printSubstances (ArrayDeque <Integer> sequence) {
        if (!sequence.isEmpty()) {
            System.out.print("Substances: ");
            System.out.println(sequence.toString().replaceAll("[\\[\\]]", ""));
        }
    }
    public static void printTools (ArrayDeque <Integer> sequence) {
        if (!sequence.isEmpty()) {
            System.out.print("Tools: ");
            System.out.println(sequence.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
