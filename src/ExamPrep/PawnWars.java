package ExamPrep;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [][] board = fillMatrix(scanner);
        int [] wPosition = getPosition (board, "w");
        int wCurrRow = wPosition[0];
        int wCurrCol = wPosition[1];
        int [] bPosition = getPosition(board, "b");
        int bCurrRow = bPosition[0];
        int bCurrCol = bPosition[1];
        boolean isGameOver = false;

        while (!isGameOver) {
            //white
            if ((bCurrCol == wCurrCol - 1 || bCurrCol == wCurrCol + 1) && (bCurrRow == wCurrRow + 1 || bCurrRow == wCurrRow - 1)) {
                board[wCurrRow][wCurrCol] = "-";
                wCurrRow = bCurrRow;
                wCurrCol = bCurrCol;
                board[wCurrRow][wCurrCol] = "w";
                char colLetter = (char)('a' + wCurrCol);
                System.out.printf("Game over! White capture on %c%d.%n", colLetter, wCurrRow + 1);
                isGameOver = true;
                continue;
            }

            int wNextRow = wCurrRow + 1;
            if (board[wNextRow][wCurrCol].equals("-")) {
                board[wCurrRow][wCurrCol] = "-";
                wCurrRow = wNextRow;
                board[wCurrRow][wCurrCol] = "w";
                if (wCurrRow == 7) {
                    char colLetter = (char)('a' + wCurrCol);
                    System.out.printf("Game over! White pawn is promoted to a queen at %c%s.%n", colLetter, wCurrRow + 1);
                    isGameOver = true;
                    continue;
                }
            }

            // black
            if ((bCurrCol == wCurrCol - 1 || bCurrCol == wCurrCol + 1) && (bCurrRow == wCurrRow + 1 || bCurrRow == wCurrRow - 1)) {
                board[bCurrRow][bCurrCol] = "-";
                bCurrRow = wCurrRow;
                bCurrCol = wCurrCol;
                board[bCurrRow][bCurrCol] = "b";
                char colLetter = (char)('a' + bCurrCol);
                System.out.printf("Game over! Black capture on %c%d.%n", colLetter, bCurrRow + 1);
                isGameOver = true;
                continue;
            }

            int bNextRow = bCurrRow - 1;
            if (board[bNextRow][bCurrCol].equals("-")) {
                board[bCurrRow][bCurrCol] = "-";
                bCurrRow = bNextRow;
                board[bCurrRow][bCurrCol] = "b";
                if (bCurrRow == 0) {
                    char colLetter = (char)('a' + bCurrCol);
                    System.out.printf("Game over! Black pawn is promoted to a queen at %c%s.%n", colLetter, bCurrRow + 1);
                    isGameOver = true;
                }
            }
        }
    }
    public static int [] getPosition(String [][] board, String pawn) {
        int [] position = {-1, -1};
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c].equals(pawn)) {
                    position[0] = r;
                    position[1] = c;
                    return position;
                }
            }
        }
        return position;
    }

    public static String [][] fillMatrix(Scanner scanner) {
        String [][] board = new String [8][8];
        for (int i = 7; i >= 0 ; i--) {
            board[i] = scanner.nextLine().split("");
        }
        return board;
    }
}
