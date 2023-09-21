package Unit2_MultidimensionalArrays.EX;

import java.util.Arrays;
import java.util.Scanner;

public class EX2_MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] inf = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int rows = inf[0];
        int columns = inf[1];

        String [][] matrix = new String [rows][columns];

        createMatrix(matrix);
        printMatrix(matrix);

    }
    private static void createMatrix(String [][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                String firstLetter = String.valueOf((char)('a' + r));
                String middleLetter = String.valueOf((char)('a' + r + c));
                String finalElement = firstLetter + middleLetter + firstLetter;
                matrix[r][c] = finalElement;
            }
        }
    }
    private static void printMatrix (String [][] matrix) {
        for (String [] elementArray: matrix) {
            System.out.println(String.join(" ", elementArray));
        }
    }
}
