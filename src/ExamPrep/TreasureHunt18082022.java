package ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt18082022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        String [][] map = new String [rows][columns];
        for (int r = 0; r < rows; r++) {
            map[r] = scanner.nextLine().split("\\s+");
        }

        List<String> correctDirections = new ArrayList<>();

        String direction = scanner.nextLine();
        while (!direction.equals("Finish")) {
            int currentRow = getYPosition(map)[0];
            int currentCol = getYPosition(map)[1];
            // next step is outside the field -> do not add the command to the list of commands -> do not move
            // next step is on a tree (letter T) -> do not add the command to the list of commands -> do not move
            switch(direction){
                case "up":
                    int nextRow = currentRow - 1;
                    if (nextRow >= 0 && nextRow < map.length) {
                        if (!map[nextRow][currentCol].equals("T")) {
                        correctDirections.add(direction);
                        map[currentRow][currentCol] = "-";
                        currentRow = nextRow;
                        if (map[currentRow][currentCol].equals("X")) {
                            map[currentRow][currentCol] = "X/Y";
                        } else {
                            map[currentRow][currentCol] = "Y";
                        }
                        }
                    }
                    break;
                case "down":
                    nextRow = currentRow + 1;
                    if (nextRow >= 0 && nextRow < map.length) {
                        if (!map[nextRow][currentCol].equals("T")) {
                            correctDirections.add(direction);
                            map[currentRow][currentCol] = "-";
                            currentRow = nextRow;
                            if (map[currentRow][currentCol].equals("X")) {
                                map[currentRow][currentCol] = "X/Y";
                            } else {
                                map[currentRow][currentCol] = "Y";
                            }
                        }
                    }
                    break;
                case "right":
                    int nextCol = currentCol + 1;
                    if (nextCol >= 0 && nextCol < map[currentRow].length) {
                        if (!map[currentRow][nextCol].equals("T")) {
                            correctDirections.add(direction);
                            map[currentRow][currentCol] = "-";
                            currentCol = nextCol;
                            if (map[currentRow][currentCol].equals("X")) {
                                map[currentRow][currentCol] = "X/Y";
                            } else {
                                map[currentRow][currentCol] = "Y";
                            }
                        }
                    }
                    break;
                case "left":
                    nextCol = currentCol - 1;
                    if (nextCol >= 0 && nextCol < map[currentRow].length) {
                        if (!map[currentRow][nextCol].equals("T")) {
                            correctDirections.add(direction);
                            map[currentRow][currentCol] = "-";
                            currentCol = nextCol;
                            if (map[currentRow][currentCol].equals("X")) {
                                map[currentRow][currentCol] = "X/Y";
                            } else {
                                map[currentRow][currentCol] = "Y";
                            }
                        }
                    }
                    break;
            }
            direction = scanner.nextLine();
        }

        if (foundTreasure(map)) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.println(String.join(", ", correctDirections));
        } else {
            System.out.println("The map is fake!");
        }
    }
    public static boolean foundTreasure (String [][] map) {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if (map[r][c].equals("X/Y")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int [] getYPosition (String [][] map) {
        int [] position = new int[2];
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if (map[r][c].equals("Y")) {
                    position[0] = r;
                    position[1] = c;
                }
            }
        }
        return position;
    }
}
