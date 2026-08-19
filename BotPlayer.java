import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BotPlayer implements Player {

    private String name;
    private char symbol;

    public BotPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public boolean nextMove(char[][] board) {
        List<int[]> freeSpaces = new ArrayList<>();
        List<int[]> xPlayerMoves = new ArrayList<>();
        List<int[]> listNextMove = new ArrayList<>();
        Random random = new Random();
        int[] winCoordinate = new int[2];
        int x = 0;
        int y = 0;
        int numberOfX = 0;
        freeSpaces = Tris.freeMoves(board);
        Tris.getFreeMoves(board);
        System.out.println();
        if (freeSpaces.isEmpty()) {
            System.out.println("No more free spaces available. It's a draw!");
            return true; // Game over, no more moves possible
        } else {
            xPlayerMoves = findXPlayerMoves(board);
            numberOfX = xPlayerMoves.size();
            // First move of O
            if (numberOfX == 1) {
                // If the middle position is free mark it there
                if (board[1][1] == ' ') {
                    board[1][1] = 'O';
                } else {
                    // If the middle position is not free then pick a random cell
                    int randomPickIndex = random.nextInt(freeSpaces.size());
                    x = listNextMove.get(randomPickIndex)[0];
                    y = listNextMove.get(randomPickIndex)[1];
                    board[x][y] = 'O';
                }
            } else {
                // Check if O can win
                winCoordinate = Tris.wouldWin(board, freeSpaces, 'O');
                if (winCoordinate != null) {
                    x = winCoordinate[0];
                    y = winCoordinate[1];
                    board[x][y] = 'O';
                    System.out.println("PlayerO Win!!!");
                    Tris.moves++;
                    return true; // O win
                } else {
                    // Check if X can win
                    winCoordinate = Tris.wouldWin(board, freeSpaces, 'X');
                    if (winCoordinate != null) {
                        x = winCoordinate[0];
                        y = winCoordinate[1];
                        board[x][y] = 'O'; // O block X winning
                    } else {
                        // What to do if O can't win and X can't win on the next move
                        listNextMove = Tris.findFutureWinningMoves(board);
                        int randomPickIndex = random.nextInt(listNextMove.size());
                        x = listNextMove.get(randomPickIndex)[0];
                        y = listNextMove.get(randomPickIndex)[1];
                        board[x][y] = 'O';
                    }
                }
            }
        }
        Tris.printBoard(board);
        Tris.moves++;
        return false;
    }

    public static List<int[]> findXPlayerMoves(char[][] board) {
        List<int[]> xPlayerMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    xPlayerMoves.add(new int[] { i, j });
                }
            }
        }
        return xPlayerMoves;
    }

}
