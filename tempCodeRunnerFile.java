import java.util.Scanner;

public class Tris {

    static int moves = 0;
    static Scanner gameScanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };
        System.out.println("------------ Welcome to Tic Tac Toe! ------------");
        while (moves < 9 && !checkWinner(board)) {
            if (playerMove(board, 'X')) {
                printBoard(board);
                break;
            }
            if (moves == 9 && !checkWinner(board)) {
                System.out.println("It's a draw!");
                break;
            }
            if (playerMove(board, 'O')) {
                printBoard(board);
                break;
            }
        }

        gameScanner.close();
        return;

    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (i < 2) {
                    System.out.print("__");
                } else {
                    System.out.print("  ");
                }
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public static boolean playerMove(char[][] board, char player) {
        boolean validMove = false;
        System.out.print("Player " + player + ", enter your move (row and column)[0-2][0-2]: ");
        while (!validMove) {
            int playerMove_x = gameScanner.nextInt();
            int playerMove_y = gameScanner.nextInt();
            if (playerMove_x < 0 || playerMove_x > 2 || playerMove_y < 0 || playerMove_y > 2) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }
            if (board[playerMove_x][playerMove_y] == ' ') {
                if (player == 'X') {
                    board[playerMove_x][playerMove_y] = 'X';
                } else {
                    board[playerMove_x][playerMove_y] = 'O';
                }
            } else {
                System.out.println("Invalid move. Please try again.");
                continue;
            }
            moves++;
            if (checkWinner(board)) {
                System.out.println("Player " + player + " wins!");
                return true;
            }
            validMove = true;
        }
        printBoard(board);
        return false;
    }

    public static boolean checkWinner(char[][] board) {
        if (checkWinnerRow(board) || checkWinnerColumn(board) || checkWinnerDiagonal(board)) {
            return true;
        }
        return false;
    }

    public static boolean checkWinnerRow(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
        }
        return false;
    }

    public static boolean checkWinnerColumn(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }
        return false;
    }

    public static boolean checkWinnerDiagonal(char[][] board) {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }
        return false;
    }
}