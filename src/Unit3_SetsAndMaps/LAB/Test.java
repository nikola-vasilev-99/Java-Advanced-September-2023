package Unit3_SetsAndMaps.LAB;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> nums = List.of(12, 4, 3, 8, 6);

        nums = nums.stream().sorted((f, s) -> Integer.compare(s, f)).collect(Collectors.toList());
        System.out.println();
    }
}
