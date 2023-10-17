package ExamPrep;

import java.util.Scanner;

public class MouseInTheKitchen17062023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] dimensions = scanner.nextLine().split(",");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        String [][] matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            matrix [i] = scanner.nextLine().split("");
        }
        String command = scanner.nextLine();
        int [] mouseStartingPosition = getMousePosition(matrix);

        while (!command.equals("danger")) {
            boolean endProgram = false;
            switch (command) {
                case "up":
                    int resultRow = mouseStartingPosition[0] - 1;
                    int resultCol = mouseStartingPosition[1];

                    if (resultRow < 0 || resultRow >= rows) {
                        System.out.println("No more cheese for tonight!");
                        endProgram = true;
                        break;
                    } else {
                        String nextPosition = matrix[resultRow][resultCol];
                        if (!nextPosition.equals("@")) {
                            moveMouse(matrix, mouseStartingPosition, resultRow, resultCol);
                        }
                        if (nextPosition.equals("C")) {
                            if (!isThereMoreCheese(matrix)) {
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                endProgram = true;
                                break;
                            }
                        } else if (nextPosition.equals("T")) {
                            System.out.println("Mouse is trapped!");
                            endProgram = true;
                            break;
                        }
                    }
                    break;
                case "down":
                    resultRow = mouseStartingPosition[0] + 1;
                    resultCol = mouseStartingPosition[1];

                    if (resultRow < 0 || resultRow >= rows) {
                        //mouse step outside the matrix -> end program
                        System.out.println("No more cheese for tonight!");
                        endProgram = true;
                        break;
                    } else {
                        String nextPosition = matrix[resultRow][resultCol];
                        if (!nextPosition.equals("@")) {
                            moveMouse(matrix, mouseStartingPosition, resultRow, resultCol);
                        }
                        if (nextPosition.equals("C")) {
                            if (!isThereMoreCheese(matrix)) {
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                endProgram = true;
                                break;
                            }
                        } else if (nextPosition.equals("T")) {
                            System.out.println("Mouse is trapped!");
                            endProgram = true;
                            break;
                        }
                    }
                    break;
                case "right":
                    resultRow = mouseStartingPosition[0];
                    resultCol = mouseStartingPosition[1] + 1;

                    if (resultCol < 0 || resultCol >= columns) {
                        //mouse step outside the matrix -> end program
                        System.out.println("No more cheese for tonight!");
                        endProgram = true;
                        break;
                    } else {
                        String nextPosition = matrix[resultRow][resultCol];
                        if (!nextPosition.equals("@")) {
                            moveMouse(matrix, mouseStartingPosition, resultRow, resultCol);
                        }
                        if (nextPosition.equals("C")) {
                            if (!isThereMoreCheese(matrix)) {
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                endProgram = true;
                                break;
                            }
                        } else if (nextPosition.equals("T")) {
                            System.out.println("Mouse is trapped!");
                            endProgram = true;
                            break;
                        }
                    }
                    break;
                case "left":
                    resultRow = mouseStartingPosition[0];
                    resultCol = mouseStartingPosition[1] - 1;

                    if (resultCol < 0 || resultCol >= columns) {
                        System.out.println("No more cheese for tonight!");
                        endProgram = true;
                        break;
                    } else {
                        String nextPosition = matrix[resultRow][resultCol];
                        if (!nextPosition.equals("@")) {
                            moveMouse(matrix, mouseStartingPosition, resultRow, resultCol);
                        }
                        if (nextPosition.equals("C")) {
                            if (!isThereMoreCheese(matrix)) {
                                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                                endProgram = true;
                                break;
                            }
                        } else if (nextPosition.equals("T")) {
                            System.out.println("Mouse is trapped!");
                            endProgram = true;
                            break;
                        }
                    }
                    break;
            }
            if (endProgram) {
                break;
            }
            command = scanner.nextLine();
        }

        if (command.equals("danger") && isThereMoreCheese(matrix)) {
            System.out.println("Mouse will come back later!");
        }

        for (String [] arr: matrix) {
            System.out.println(String.join("", arr));
        }

    }

    public static void moveMouse(String[][] matrix, int[] mouseStartingPosition, int resultRow, int resultCol) {
        matrix[mouseStartingPosition[0]][mouseStartingPosition[1]] = "*";
        matrix[resultRow][resultCol] = "M";
        mouseStartingPosition[0] = resultRow;
        mouseStartingPosition[1] = resultCol;
    }

    public static int [] getMousePosition (String [][] matrix) {
        int [] array = new int [2];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("M")) {
                    array[0] = r;
                    array[1] = c;
                    break;
                }
            }
        }
        return array;
    }
    public static boolean isThereMoreCheese (String [][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("C")) {
                    return true;
                }
            }
        }
        return false;
    }
}
