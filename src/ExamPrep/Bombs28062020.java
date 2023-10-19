package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class  Bombs28062020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //5, 25, 50, 115 -> queue -> bomb effect
        //5, 15, 25, 35 -> stack -> bomb casing
        Deque<Integer> bombEffect = new ArrayDeque<>();
        Deque<Integer> bombCasing = new ArrayDeque<>();
        Map<String, Integer> bombPouch = new TreeMap<>(Map.of("Datura Bombs", 0,
                                                             "Cherry Bombs", 0,
                                                             "Smoke Decoy Bombs", 0));

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(bombEffect::offer);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(bombCasing::push);


        while (!bombEffect.isEmpty() && !bombCasing.isEmpty() && !isBombPouchFull(bombPouch)) {
            int currentEffect = bombEffect.peek();
            int currentCasing = bombCasing.peek();

            int sum = currentCasing + currentEffect;
            if (sum == 40) {
                bombCasing.pop();
                bombEffect.poll();
                int updatedBombCount = bombPouch.get("Datura Bombs") + 1;
                bombPouch.put("Datura Bombs", updatedBombCount);
            } else if (sum == 60) {
                bombCasing.pop();
                bombEffect.poll();
                int updatedBombCount = bombPouch.get("Cherry Bombs") + 1;
                bombPouch.put("Cherry Bombs", updatedBombCount);
            } else if (sum == 120) {
                bombCasing.pop();
                bombEffect.poll();
                int updatedBombCount = bombPouch.get("Smoke Decoy Bombs") + 1;
                bombPouch.put("Smoke Decoy Bombs", updatedBombCount);
            } else {
                currentCasing -= 5;
                bombCasing.pop();
                bombCasing.push(currentCasing);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (isBombPouchFull(bombPouch)) {
            sb.append("Bene! You have successfully filled the bomb pouch!").append(System.lineSeparator());
        } else {
            sb.append("You don't have enough materials to fill the bomb pouch.").append(System.lineSeparator());
        }
        if (bombEffect.isEmpty()) {
            sb.append("Bomb Effects: empty").append(System.lineSeparator());
        } else {
            String bombEffectsAsString = bombEffect.stream().map(String::valueOf).collect(Collectors.joining(", "));
            sb.append("Bomb Effects: ").append(bombEffectsAsString).append(System.lineSeparator());
        }
        if (bombCasing.isEmpty()) {
            sb.append("Bomb Casings: empty");
        } else {
            String bombCasingAsString = bombCasing.stream().map(String::valueOf).collect(Collectors.joining(", "));
            sb.append("Bomb Casings: ").append(bombCasingAsString);
        }
        System.out.println(sb.toString());
        for (Map.Entry<String, Integer> entry : bombPouch.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
    public static boolean isBombPouchFull (Map <String, Integer> bombPouch) {
        if (bombPouch.get("Datura Bombs") >= 3) {
            if (bombPouch.get("Cherry Bombs") >= 3) {
                if (bombPouch.get("Smoke Decoy Bombs") >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
