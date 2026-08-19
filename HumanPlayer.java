import java.util.Scanner;

public class HumanPlayer implements Player {

    private String name;
    private char symbol;
    private Scanner scanner;

    public HumanPlayer(String name, char symbol, Scanner scanner) {
        this.name = name;
        this.symbol = symbol;
        this.scanner = scanner;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public boolean nextMove(char[][] board) {
        boolean validMove = false;
        int playerMove_x = -1;
        int playerMove_y = -1;
        System.out.print("Player " + symbol + ", enter your move (row and column)[0-2][0-2]: ");
        Tris.getFreeMoves(board);
        System.out.println();
        while (!validMove) {
            try {
                playerMove_x = scanner.nextInt();
                playerMove_y = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please reenter a new move! LOOK AT THE FREE MOVES!.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }
            if (playerMove_x < 0 || playerMove_x > 2 || playerMove_y < 0 || playerMove_y > 2) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }
            if (board[playerMove_x][playerMove_y] == ' ') {
                if (symbol == 'X') {
                    board[playerMove_x][playerMove_y] = 'X';
                } else {
                    board[playerMove_x][playerMove_y] = 'O';
                }
            } else {
                System.out.println("Invalid move. Please try again.");
                continue;
            }
            if (Tris.checkWinner(board)) {
                System.out.println("Player " + symbol + " wins!");
                Tris.moves++;
                return true;
            }
            validMove = true;
        }
        Tris.printBoard(board);
        Tris.moves++;
        return false;
    }

}

