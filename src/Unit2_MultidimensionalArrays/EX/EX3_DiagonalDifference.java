package Unit2_MultidimensionalArrays.EX;

import java.util.Arrays;
import java.util.Scanner;

public class EX3_DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = fillMatrix(scanner, n);
        int sumFirstDiagonal = getSumFirst(matrix);
        int sumSecondDiagonal = getSumSecond(matrix);
        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));

    }
    private static int [][] fillMatrix (Scanner scanner, int dimensions) {
        int [][] matrix = new int [dimensions][dimensions];
        for (int row = 0; row < matrix.length; row++) {
            int [] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = array;
        }
        return matrix;
    }
    private static int getSumFirst (int [][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    private static int getSumSecond (int [][] matrix) {
        int sum = 0;
        int row = 0;
        for (int col = matrix.length - 1; col >= 0; col--) {
            sum += matrix[row][col];
            row++;
        }
        return sum;
    }
}
