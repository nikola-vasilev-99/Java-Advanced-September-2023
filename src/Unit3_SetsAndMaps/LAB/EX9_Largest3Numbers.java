package Unit3_SetsAndMaps.LAB;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EX9_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        numList = numList.stream().sorted((f, s) -> Integer.compare(s, f)).collect(Collectors.toList());

        if (numList.size() < 3) {
            System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(numList.get(i) + " ");
            }
        }

    }
}
