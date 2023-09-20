package Unit2_MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class EX4_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = getArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];
        int [][] matrix = new int [dimensions[0]][dimensions[1]];

        for (int i = 0; i < rows; i++) {
            int [] currentArr = getArray(scanner);
            matrix[i] = currentArr;
        }
        int sumOfAllElements = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumOfAllElements += matrix[i][j];
            }
        }
        int [] resultArray = {rows, cols, sumOfAllElements};
        for (int el: resultArray) {
            System.out.println(el);
        }

    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
