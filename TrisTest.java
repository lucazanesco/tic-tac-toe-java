import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TrisTest {

    char[][] board;

    // Doing before each test
    @BeforeEach

    void setUp() {
        board = new char[][] {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };
    }

    @Test
    void checkWinnerRow_true() {
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';
        assertTrue(Tris.checkWinnerRow(board));
    }

    @Test
    void checkWinnerRow_false() {
        board[0][0] = 'X';
        board[0][1] = 'O';
        board[0][2] = 'X';
        assertFalse(Tris.checkWinnerRow(board));
    }

    @Test
    void checkWinnerRow_second_true() {
        board[1][0] = 'X';
        board[1][1] = 'X';
        board[1][2] = 'X';
        assertTrue(Tris.checkWinnerRow(board));
    }

    @Test
    void checkWinnerRow_second_false() {
        board[1][0] = 'X';
        board[1][1] = 'O';
        board[1][2] = 'X';
        assertFalse(Tris.checkWinnerRow(board));
    }

    @Test
    void checkWinnerRow_secondMiss_false() {
        board[1][0] = 'X';
        board[1][1] = 'X';
        board[1][2] = ' ';
        assertFalse(Tris.checkWinnerRow(board));
    }

    @Test
    void checkWinnerRow_third_true() {
        board[2][0] = 'X';
        board[2][1] = 'X';
        board[2][2] = 'X';
        assertTrue(Tris.checkWinnerRow(board));
    }

    @Test
    void checkWinnerRow_third_false() {
        board[2][0] = 'X';
        board[2][1] = 'O';
        board[2][2] = 'X';
        assertFalse(Tris.checkWinnerRow(board));
    }

    @Test
    void checkWinnerRow_thirdMiss_false() {
        board[2][0] = 'X';
        board[2][1] = 'X';
        board[2][2] = ' ';
        assertFalse(Tris.checkWinnerRow(board));
    }

    @Test
    void checkWinnerColumn_first_true() {
        board[0][0] = 'X';
        board[1][0] = 'X';
        board[2][0] = 'X';
        assertTrue(Tris.checkWinnerColumn(board));
    }

    @Test
    void checkWinnerColumn_first_false() {
        board[0][0] = 'X';
        board[1][0] = 'O';
        board[2][0] = 'X';
        assertFalse(Tris.checkWinnerColumn(board));
    }

    @Test
    void checkWinnerColumn_firstMiss_false() {
        board[0][0] = 'X';
        board[1][0] = 'X';
        board[2][0] = ' ';
        assertFalse(Tris.checkWinnerColumn(board));
    }

    @Test
    void checkWinnerColumn_second_true() {
        board[0][1] = 'X';
        board[1][1] = 'X';
        board[2][1] = 'X';
        assertTrue(Tris.checkWinnerColumn(board));
    }

    @Test
    void checkWinnerColumn_second_false() {
        board[0][1] = 'X';
        board[1][1] = 'O';
        board[2][1] = 'X';
        assertFalse(Tris.checkWinnerColumn(board));
    }

    @Test
    void checkWinnerColumn_secondMiss_false() {
        board[0][1] = 'X';
        board[1][1] = 'O';
        board[2][1] = ' ';
        assertFalse(Tris.checkWinnerColumn(board));
    }

    @Test
    void checkWinnerColumn_third_true() {
        board[0][2] = 'X';
        board[1][2] = 'X';
        board[2][2] = 'X';
        assertTrue(Tris.checkWinnerColumn(board));
    }

    @Test
    void checkWinnerColumn_third_false() {
        board[0][2] = 'X';
        board[1][2] = 'O';
        board[2][2] = 'X';
        assertFalse(Tris.checkWinnerColumn(board));
    }

    @Test
    void checkWinnerColumn_thirdMiss_false() {
        board[0][2] = 'X';
        board[1][2] = 'X';
        board[2][2] = ' ';
        assertFalse(Tris.checkWinnerColumn(board));
    }

    @Test
    void checkWinnerDiagonal_right_true() {
        board[0][0] = 'X';
        board[1][1] = 'X';
        board[2][2] = 'X';
        assertTrue(Tris.checkWinnerDiagonal(board));
    }

    @Test
    void checkWinnerDiagonal_right_false() {
        board[0][0] = 'X';
        board[1][1] = 'O';
        board[2][2] = 'X';
        assertFalse(Tris.checkWinnerDiagonal(board));
    }

    @Test
    void checkWinnerDiagonal_rightMiss_false() {
        board[0][0] = 'X';
        board[1][1] = 'X';
        board[2][2] = ' ';
        assertFalse(Tris.checkWinnerDiagonal(board));
    }

    @Test
    void checkWinnerDiagonal_left_true() {
        board[0][2] = 'X';
        board[1][1] = 'X';
        board[2][0] = 'X';
        assertTrue(Tris.checkWinnerDiagonal(board));
    }

    @Test
    void checkWinnerDiagonal_left_false() {
        board[0][2] = 'X';
        board[1][1] = 'X';
        board[2][0] = 'X';
        assertFalse(Tris.checkWinnerDiagonal(board));
    }

    @Test
    void checkWinnerDiagonal_leftMiss_false() {
        board[0][2] = 'X';
        board[1][1] = 'X';
        board[2][0] = ' ';
        assertFalse(Tris.checkWinnerDiagonal(board));
    }

    @Test
    void checkWinner_emptyBoard_noWinner() {
        assertFalse(Tris.checkWinner(board));
    }

    @Test
    void checkWinner_casualBoard_yesWinner() {
        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'O';
        board[1][0] = 'X';
        board[1][1] = 'O';
        board[1][2] = 'O';
        board[2][0] = 'O';
        board[2][1] = 'X';
        board[1][2] = ' ';
        assertTrue(Tris.checkWinner(board));
    }
    

}
