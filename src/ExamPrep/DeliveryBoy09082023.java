package ExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy09082023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];

        String [][] neighbourhood = createMatrix(scanner, rows, columns);
        int [] boysInitialPosition = getPosition(neighbourhood);
        int [] boysCurrentPosition = getPosition(neighbourhood);
        boolean outOfNeighbourhood = false;
        boolean pizzaIsDelivered = false;

        while (!pizzaIsDelivered) {
            String direction = scanner.nextLine();
            //current boy's location
            int currentRow = boysCurrentPosition[0];
            int currentCol = boysCurrentPosition[1];

            switch (direction) {
                case "up":
                    int newRow = currentRow - 1;
                    if (isValidRow(newRow, neighbourhood)) {
                        // доставчикът остава в квартала
                        String nextAddress = neighbourhood [newRow][currentCol];

                        if (nextAddress.equals("-") || nextAddress.equals(".")) {
                            neighbourhood [newRow][currentCol] = "B";
                            if (!neighbourhood [currentRow][currentCol].equals("R")) {
                                neighbourhood[currentRow][currentCol] = ".";
                            }
                        } else if (nextAddress.equals("P")) {
                            // pizza restaurant
                            neighbourhood[newRow][currentCol] = "R";
                            neighbourhood [currentRow][currentCol] = ".";
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (nextAddress.equals("A")) {
                            neighbourhood [newRow][currentCol] = "P";
                            neighbourhood [currentRow][currentCol] = ".";
                            System.out.println("Pizza is delivered on time! Next order...");
                            pizzaIsDelivered = true;
                        }
                        if (!nextAddress.equals("*")) {
                            boysCurrentPosition[0] = newRow;
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        outOfNeighbourhood = true;
                    }
                    break;
                case "down":
                    newRow = currentRow + 1;
                    if (isValidRow(newRow, neighbourhood)) {
                        // доставчикът остава в квартала
                        String nextAddress = neighbourhood [newRow][currentCol];
                        if (nextAddress.equals("-") || nextAddress.equals(".")) {
                            neighbourhood [newRow][currentCol] = "B";
                            if (!neighbourhood [currentRow][currentCol].equals("R")) {
                                neighbourhood[currentRow][currentCol] = ".";
                            }
                        } else if (nextAddress.equals("P")) {
                            // pizza restaurant
                            neighbourhood[newRow][currentCol] = "R";
                            neighbourhood [currentRow][currentCol] = ".";
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (nextAddress.equals("A")) {
                            neighbourhood [newRow][currentCol] = "P";
                            neighbourhood [currentRow][currentCol] = ".";
                            System.out.println("Pizza is delivered on time! Next order...");
                            pizzaIsDelivered = true;
                        }
                        if (!nextAddress.equals("*")) {
                            boysCurrentPosition[0] = newRow;
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        outOfNeighbourhood = true;
                    }
                    break;
                case "left":
                    int newCol = currentCol - 1;
                    if (isValidColumn(newCol, neighbourhood)) {
                        // доставчикът остава в квартала
                        String nextAddress = neighbourhood [currentRow][newCol];
                        if (nextAddress.equals("-") || nextAddress.equals(".")) {
                            neighbourhood [currentRow][newCol] = "B";
                            if (!neighbourhood [currentRow][currentCol].equals("R")) {
                                neighbourhood[currentRow][currentCol] = ".";
                            }
                        } else if (nextAddress.equals("P")) {
                            // pizza restaurant
                            neighbourhood[currentRow][newCol] = "R";
                            neighbourhood [currentRow][currentCol] = ".";
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (nextAddress.equals("A")) {
                            neighbourhood [currentRow][newCol] = "P";
                            neighbourhood [currentRow][currentCol] = ".";
                            System.out.println("Pizza is delivered on time! Next order...");
                            pizzaIsDelivered = true;
                        }
                        if (!nextAddress.equals("*")) {
                            boysCurrentPosition[1] = newCol;
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        outOfNeighbourhood = true;
                    }
                case "right":
                    newCol = currentCol + 1;
                    if (isValidColumn(newCol, neighbourhood)) {
                        // доставчикът остава в квартала
                        String nextAddress = neighbourhood [currentRow][newCol];
                        if (nextAddress.equals("-") || nextAddress.equals(".")) {
                            neighbourhood [currentRow][newCol] = "B";
                            if (!neighbourhood [currentRow][currentCol].equals("R")) {
                                neighbourhood[currentRow][currentCol] = ".";
                            }
                        } else if (nextAddress.equals("P")) {
                            // pizza restaurant
                            neighbourhood[currentRow][newCol] = "R";
                            neighbourhood [currentRow][currentCol] = ".";
                            System.out.println("Pizza is collected. 10 minutes for delivery.");
                        } else if (nextAddress.equals("A")) {
                            neighbourhood [currentRow][newCol] = "P";
                            neighbourhood [currentRow][currentCol] = ".";
                            System.out.println("Pizza is delivered on time! Next order...");
                            pizzaIsDelivered = true;
                        }
                        if (!nextAddress.equals("*")) {
                            boysCurrentPosition[1] = newCol;
                        }
                    } else {
                        System.out.println("The delivery is late. Order is canceled.");
                        outOfNeighbourhood = true;
                    }
                    break;
            }
            if (outOfNeighbourhood) {
                break;
            }
        }
        if (outOfNeighbourhood) {
            neighbourhood[boysInitialPosition[0]][boysInitialPosition[1]] = " ";
        } else if (pizzaIsDelivered) {
            neighbourhood[boysInitialPosition[0]][boysInitialPosition[1]] = "B";
        }

        StringBuilder sb = new StringBuilder();
        for (String[] arr: neighbourhood) {
            for (String el: arr) {
                sb.append(el);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
    public static boolean isValidRow(int row, String [][] neighbourhood) {
        //checks if the next position is inside the neighbourhood
        if (row >= 0 && row < neighbourhood.length) {
            return true;
        }
        return false;
    }
    public static boolean isValidColumn(int column, String [][] neighbourhood) {
        //checks if the next position is inside the neighbourhood
        if (column >= 0 && column < neighbourhood[1].length) {
            return true;
        }
        return false;
    }

    public static String [][] createMatrix (Scanner scanner, int rows, int columns) {
        String [][] matrix = new String [rows][columns];
        for (int r = 0; r < matrix.length; r++) {
            String [] currentRow = scanner.nextLine().split("");
            matrix[r] = currentRow;
        }
        return matrix;
    }
    public static int [] getPosition (String [][] neighbourhood) {
        int [] arrWithPosition = new int [2];
        for (int r = 0; r < neighbourhood.length; r++) {
            for (int c = 0; c < neighbourhood[r].length; c++) {
                if (neighbourhood[r][c].equals("B")) {
                    arrWithPosition[0] = r;
                    arrWithPosition[1] = c;
                    break;
                }
            }
        }
        return arrWithPosition;
    }
}
