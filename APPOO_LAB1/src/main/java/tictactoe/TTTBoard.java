package tictactoe;

public class TTTBoard extends Board {
    private char[][] board;

    TTTBoard(int size) {
        this.size = size;
        board = new char[size][size];
        scoreBoard = new int[size][size];
        initialize(size);
    }
    void recordMove(char mark, int x, int y) {
        board[x][y] = mark;
        scoreBoard[x][y] = 1;
    }

    char getMark(int x, int y) {
        return board[x][y];
    }

    private void initialize(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
                scoreBoard[i][j] = 0;
            }
        }
    }
}
