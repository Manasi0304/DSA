/*
 * Implement N queens problem usingBacktracking. Compare the time required for 4,5,6,7, and
 8 Queens.
 */

import java.util.*;

// 
public class Que6 {
    public static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // lower left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    public static boolean solveNQueens(int[][] board, int col, int n) {
        // base case
        if (col == n)
            return true;

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;

                if (solveNQueens(board, col + 1, n)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("*** N-Queen Problem ***");
        System.out.println("------------------------------------");

        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        int[][] board = new int[n][n];

        if (!solveNQueens(board, 0, n)) {
            System.out.println("Solution does not exist");
        } else {
            printBoard(board, n);
        }

        System.out.println("------------------------------------");
        System.out.println("!! Thank You !! \n Have a nice day");
        System.out.println("------------------------------------");

    }
}
