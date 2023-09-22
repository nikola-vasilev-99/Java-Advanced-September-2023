package Unit2_MultidimensionalArrays.EX;

import java.util.Arrays;
import java.util.Scanner;

public class EX5_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String [][] matrix = createMatrix(scanner, rows, cols);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            boolean isValidInput = false;
            String [] coordinatesArr = input.split(" ");
            if (coordinatesArr[0].equals("swap") && coordinatesArr.length == 5) {
                int row1 = Integer.parseInt(coordinatesArr[1]);
                int col1 = Integer.parseInt(coordinatesArr[2]);
                int row2 = Integer.parseInt(coordinatesArr[3]);
                int col2 = Integer.parseInt(coordinatesArr[4]);

                if (areValidCoordinates(matrix, row1, col1)) {
                    if (areValidCoordinates(matrix, row2, col2)) {
                    String firstElement = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = firstElement;
                    isValidInput = true;
                    }
                }
            }

            if (isValidInput) {
                for (String [] elementArr: matrix) {
                    for (String element: elementArr) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }
    private static String [][] createMatrix (Scanner scanner, int rows, int cols)  {
        String [][] matrix = new String [rows][cols];
        for (int i = 0; i < rows; i++) {
            String [] array = scanner.nextLine().split(" ");
            matrix[i] = array;
        }
        return matrix;
    }
    private static boolean areValidCoordinates (String [][] matrix, int row, int col) {
        if (row >= 0 && row < matrix.length) {
            if (col >= 0 && col < matrix[row].length) {
                return true;
            }
        }
        return false;

    }
}
