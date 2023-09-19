package Unit2_MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class EX1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] firstMatrix = readArray(scanner);
        int [][] secondMatrix = readArray(scanner);

        System.out.println();




    }
    private static int [][] readArray(Scanner scanner) {
        int [] definition = getArray(scanner);
        int rows = definition[0];
        int cols = definition[1];

        int [][] matrix = new int [rows][cols];
        for (int i = 0; i < rows; i++) {
            int [] array = getArray(scanner);
            matrix[i] = array;
        }
        return matrix;
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
