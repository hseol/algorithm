package week3;

import java.util.Scanner;

public class Baekjoon2239 {

    static int[][] board;
    static boolean first;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[9][9];
        first = true;

        for (int i = 0; i < 9; i++) {
            String s = sc.nextLine();

            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        recursive(0, 0);
    }

    public static void recursive(int row, int col) {

        if (row == 9) {
            if (first) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }
                first = false;
            }
            return ;
        }

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (checkNumber(i, row, col)) {
                    board[row][col] = i;

                    if (col == 8) recursive(row + 1, 0);
                    else recursive(row, col + 1);
                    if (!first) return;
                    board[row][col] = 0;
                }
            }
        }
        else {
            if (col == 8) recursive(row + 1, 0);
            else recursive(row, col + 1);
            if (!first) return;
        }
    }

    public static boolean checkNumber(int num, int row, int col) {

        for (int i = 0; i < 9; i++) if (num == board[row][i]) return false;
        for (int i = 0; i < 9; i++) if (num == board[i][col]) return false;

        int squareRow = (row / 3) * 3;

        int squareCol = (col / 3) * 3;

        for (int i = squareRow; i < squareRow + 3; i++) {
            for (int j = squareCol; j < squareCol + 3; j++)
                if (num == board[i][j]) return false;
        }

        return true;
    }
}
