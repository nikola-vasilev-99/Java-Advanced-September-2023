package Unit2_MultidimensionalArrays.LAB;

import java.util.Arrays;
import java.util.Scanner;

public class EX1_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] firstMatrix = readArray(scanner);
        int [][] secondMatrix = readArray(scanner);

        //първо проверяваме дали двете матрици са с еднакви дължини
        boolean areEqual = firstMatrix.length == secondMatrix.length;

        if (areEqual) {
            for (int r = 0; r < firstMatrix.length; r++) {
                int [] firstArray = firstMatrix[r];
                int [] secondArray = secondMatrix[r];

                //сега сравняваме дължините на вътрешните масиви на съответния индекс от матрицата
                areEqual = firstArray.length == secondArray.length;
                if (areEqual) {
                    // ако дължините са еднакви, започваме да проверяваме елемент по елемент
                    for (int el = 0; el < firstArray.length; el++) {
                        if (firstArray[el] != secondArray[el]) {
                            areEqual = false;
                        }
                    }
                }
            }
        }
        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

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
