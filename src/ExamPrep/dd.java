package ExamPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class dd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        List<Character> pearList = new ArrayList<>(Arrays.asList('p', 'e', 'a', 'r'));

        char letter = 'r';
        int indexOfExisting = pearList.indexOf(letter);
        int indexOfNotExisting = pearList.indexOf('z');
        System.out.println();


    }
}
