package Unit2_MultidimensionalArrays.LAB;

import java.util.Scanner;

public class EX3_IntersectionOfMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String [][] matrixA = createMatrix(scanner, rows, cols);
        String [][] matrixB = createMatrix(scanner, rows, cols);
        String [][] matrixC = new String [rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrixA[i][j].equals(matrixB[i][j])) {
                    matrixC[i][j] = matrixA[i][j];
                } else {
                    matrixC[i][j] = "*";
                }
            }
            System.out.println(String.join(" ", matrixC[i]));
        }
    }

    private static String [][] createMatrix(Scanner scanner, int rows, int cols) {
        String [][] matrix = new String [rows][cols];
        for (int i = 0; i < rows; i++) {
            String [] array = scanner.nextLine().split("\\s+");
            matrix[i] = array;
        }
        return matrix;
    }
}
