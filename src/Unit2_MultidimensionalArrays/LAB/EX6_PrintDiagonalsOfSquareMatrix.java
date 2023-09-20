package Unit2_MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class EX6_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            int [] array = Arrays.stream(scanner.nextLine().split("\\s+")).
                    mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = array;
        }
        int [] firstDiagonalArr = new int[size];
        int [] secondDiagonalArr = new int[size];

        // first diagonal 0-0 1-1 2-2 3-3 4-4 5-5 ...
        for (int i = 0; i < matrix.length; i++) {
            int currentNum = matrix[i][i];
            firstDiagonalArr[i] = currentNum;
        }

        // second diagonal 3-0 2-1 1-2 0-3

        for (int i = matrix.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < matrix.length; j++) {
                int currentNum = matrix[i][j];
                secondDiagonalArr[j] = currentNum;
                i = i - 1;
            }
        }
        System.out.println(Arrays.toString(firstDiagonalArr).replaceAll("[\\[\\],]", ""));
        System.out.println(Arrays.toString(secondDiagonalArr).replaceAll("[\\[\\],]", ""));
    }
}
