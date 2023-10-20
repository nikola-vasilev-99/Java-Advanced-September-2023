package ExamPrep;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //e a u o -> vowels -> queue (first take the first element)
        //p r l x f -> consonants -> stack (first take the last element)
        //100 out of 100
        List<String> pearList = new ArrayList<>(Arrays.asList("p", "e", "a", "r"));
        List<String> flourList = new ArrayList<>(Arrays.asList("f", "l", "o", "u", "r"));
        List<String> porkList = new ArrayList<>(Arrays.asList("p", "o", "r", "k"));
        List<String> oliveList = new ArrayList<>(Arrays.asList("o", "l", "i", "v", "e"));

        Deque<String> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(vowels::offer);
        Deque<String> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consonants::push);

        while (!consonants.isEmpty()) {
            String currVowel = vowels.poll(); // винаги преместваме накрая на колекцията
            vowels.offer(currVowel);
            String currConsonant = consonants.pop(); //винаги трием от колекцията

            pearList.remove(currVowel);
            pearList.remove(currConsonant);
            flourList.remove(currVowel);
            flourList.remove(currConsonant);
            porkList.remove(currVowel);
            porkList.remove(currConsonant);
            oliveList.remove(currVowel);
            oliveList.remove(currConsonant);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Words found: ");
        List <String> foundWords = getFoundWords(pearList, flourList, porkList, oliveList);
        sb.append(foundWords.size()).append(System.lineSeparator());
        foundWords.stream().forEach(e -> sb.append(e).append(System.lineSeparator()));
        System.out.println(sb.toString().trim());

    }
    public static List <String> getFoundWords (List <String> pearList,
                                       List <String> flourList,
                                       List <String> porkList,
                                       List <String> oliveList){
        List <String> words = new ArrayList<>();
        if(pearList.isEmpty()) {
            words.add("pear");
        }

        if (flourList.isEmpty()) {
            words.add("flour");
        }
        if (porkList.isEmpty()) {
            words.add("pork");
        }
        if (oliveList.isEmpty()) {
            words.add("olive");
        }
        return words;
    }
}
