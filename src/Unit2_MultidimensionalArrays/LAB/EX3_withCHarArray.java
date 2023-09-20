package Unit2_MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class EX3_withCHarArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char [][] matrixA = createMatrix(scanner, rows, cols);
        char [][] matrixB = createMatrix(scanner, rows, cols);
        char [][] matrixC = new char [rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrixA[i][j] == (matrixB[i][j])) {
                    matrixC[i][j] = matrixA[i][j];
                } else {
                    matrixC[i][j] = '*';
                }
            }
            System.out.println(Arrays.toString(matrixC[i]).replaceAll("[\\[\\],]", ""));
        }
    }

    private static char [][] createMatrix(Scanner scanner, int rows, int cols) {
        char [][] matrix = new char [rows][cols];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        return matrix;
    }
}
