import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Tris {

    static int moves = 0;
    static Scanner gameScanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };

        Player playerX = new HumanPlayer("Luca", 'X', gameScanner);
        Player playerO = new BotPlayer("Bot", 'O');

        System.out.println("------------ Welcome to Tic Tac Toe! ------------");
        while (moves < 9) {
            if (playerX.nextMove(board)) {
                printBoard(board);
                break;
            }
            if (moves == 9 && !checkWinner(board)) {
                System.out.println("It's a draw!");
                break;
            }
            if (playerO.nextMove(board)) {
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

    public static List<int[]> freeMoves(char[][] board) {
        List<int[]> freeSpaces = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    freeSpaces.add(new int[] { i, j });
                }
            }
        }
        return freeSpaces;
    }

    public static void getFreeMoves(char[][] board) {
        List<int[]> freeSpaces = freeMoves(board);
        System.out.println();
        System.out.print("(Free moves: ");
        for (int[] freeSpace : freeSpaces) {
            System.out.print("[" + freeSpace[0] + " " + freeSpace[1] + "]");
        }
        System.out.println(")");
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

    public static int[] wouldWin(char[][] board, List<int[]> freeMoves, char symbol) {
        int[] winningCoord = new int[2];
        for (int[] freeMove : freeMoves) {
            int x = freeMove[0];
            int y = freeMove[1];
            board[x][y] = symbol;
            if (checkWinner(board)) {
                winningCoord = freeMove;
                board[x][y] = ' ';
                return winningCoord;
            }
            board[x][y] = ' ';
        }
        return null;
    }

    public static List<int[]> findFutureWinningMoves(char[][] board) {
        List<int[]> coordForWin = new ArrayList<>();
        List<int[]> freeSpaces = freeMoves(board);
        int[] winningCoord = new int[2];
        for (int[] freeSpace : freeSpaces) {
            int x = freeSpace[0];
            int y = freeSpace[1];
            board[x][y] = 'O';
            winningCoord = wouldWin(board, freeMoves(board), 'O');
            if (winningCoord != null) {
                coordForWin.add(winningCoord);
            }
            board[x][y] = ' ';
        }
        return coordForWin;
    }
}