package Unit2_MultidimensionalArrays.LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EX8_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int [][] matrix = new int [n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = getArray(scanner);
        }
        int [] mistakenValueArray = getArray(scanner);
        int mistakenValue = matrix[mistakenValueArray[0]][mistakenValueArray[1]];

        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == mistakenValue) {
                    int sum = 0;
                    //left
                    if (isInBounds(matrix, r, c -1) && matrix[r][c - 1] != mistakenValue) {
                        sum += matrix[r][c - 1];
                    }
                    // right
                    if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != mistakenValue) {
                        sum += matrix[r][c + 1];
                    }
                    //top
                    if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != mistakenValue) {
                        sum += matrix[r - 1][c];
                    }
                    //down
                    if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != mistakenValue) {
                        sum += matrix[r + 1][c];
                    }

                    int [] parameters = new int [3];
                    parameters[0] = r;
                    parameters[1] = c;
                    parameters[2] = sum;
                    list.add(parameters);
                }
            }
            for (int [] el: list) {
                matrix[el[0]][el[1]] = el[2];
            }


        }
        for (int[] array: matrix) {
            System.out.println(Arrays.toString(array).replaceAll("[\\[\\],]", ""));
        }

    }
    private static boolean isInBounds (int [][] matrix, int r, int c) {
        if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length) {
            return true;
        }
        return false;
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
