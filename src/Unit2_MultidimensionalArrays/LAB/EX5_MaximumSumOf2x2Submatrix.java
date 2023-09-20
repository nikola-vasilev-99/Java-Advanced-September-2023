package Unit2_MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class EX5_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = getArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];
        int [][] matrix = new int [rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = getArray(scanner);
        }
        int [][] resultMatrix = new int [2][2];
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentElement = matrix [row][col];
                int rightElement = matrix[row][col + 1];
                int underElement = matrix[row + 1][col];
                int underRightElement = matrix [row + 1][col + 1];
                int currentSum = currentElement + rightElement + underElement + underRightElement;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    int [] firstArr = {currentElement, rightElement};
                    int [] secondArr = {underElement, underRightElement};
                    resultMatrix[0] = firstArr;
                    resultMatrix[1] = secondArr;
                }
            }
        }
        for (int [] element: resultMatrix) {
            System.out.println(Arrays.toString(element).replaceAll("[\\[\\],]", ""));
        }
        System.out.println(maxSum);
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
