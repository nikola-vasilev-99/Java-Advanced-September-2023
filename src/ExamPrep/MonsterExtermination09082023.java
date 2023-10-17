package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MonsterExtermination09082023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque <Integer> monsterArmour = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).forEach(monsterArmour::offer);
        Deque <Integer> solderStrike = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).forEach(solderStrike::push);
        int monstersCountAtTheBeginning = monsterArmour.size();

        while (!isEmpty(monsterArmour) && !isEmpty(solderStrike)) {
            int currentMonsterArmour = monsterArmour.poll();
            int currentSolderStrike = solderStrike.pop();
            if (currentSolderStrike >= currentMonsterArmour) {
                currentSolderStrike -= currentMonsterArmour;
                if (currentSolderStrike > 0) {
                    solderStrike.push(currentSolderStrike);
                }
            } else {
                currentMonsterArmour -= currentSolderStrike;
                monsterArmour.offer(currentMonsterArmour);
            }
        }

        if (isEmpty(monsterArmour)) {
            System.out.println("All monsters have been killed!");
        }
        if (isEmpty(solderStrike)) {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d%n", monstersCountAtTheBeginning - monsterArmour.size());

    }
    public static boolean isEmpty (Deque <Integer> sequence) {
        if (sequence.isEmpty()) {
            return true;
        }
        return false;
    }
}
