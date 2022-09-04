import java.util.*;

public class NQueens {
    static boolean[][] board;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the rows present in chess board");
        int n = s.nextInt();
        board = new boolean[n][n];
        System.out.println("The solutions are ");
        nqs( 0, 0);


    }


    static void nqs(int k, int n) {

        if (n == board.length) {
            printPositions(board);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (place(board, i, n)) {
                board[n][i] = true;
                nqs( k, n + 1);
                board[n][i] = false;
            }
        }
    }

    static void printPositions(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j])
                    System.out.print("(" + i + "," + j + ") ");
            }
        }
        System.out.println();
    }

    static boolean place(boolean[][] board, int col, int row) {
        for (int i = 0; i < row - 1; i++) {
            if (board[i][col])
                return false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }


}
