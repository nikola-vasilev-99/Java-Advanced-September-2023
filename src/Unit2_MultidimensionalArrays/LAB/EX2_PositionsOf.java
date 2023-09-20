package Unit2_MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class EX2_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int [] definition = getArray(scanner);
        int [][] matrix = new int[definition[0]][definition[1]];

        for (int r = 0; r < definition[0]; r++) {
            int [] array = getArray(scanner);
            matrix[r] = array;
        }

        int numToFind = Integer.parseInt(scanner.nextLine());
        boolean numFoundInMatrix = false;
        for (int i = 0; i < matrix.length; i++) {
            int [] currentArr = matrix[i];
            for (int j = 0; j < currentArr.length; j++) {
                if (currentArr[j] == numToFind) {
                    System.out.printf("%d %d%n", i, j);
                    numFoundInMatrix = true;
                }
            }
        }
        if (!numFoundInMatrix) {
            System.out.println("not found");
        }
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
