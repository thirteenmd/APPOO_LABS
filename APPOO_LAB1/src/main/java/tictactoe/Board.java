package tictactoe;

class Board {
    private int seize;
    private char[][] board;
    private int[][] secondBoard;

    Board(int seize) {
        this.seize = seize;
        board = new char[seize][seize];
        secondBoard = new int[seize][seize];
        for (int i = 0; i < seize; i++) {
            for (int j = 0; j < seize; j++) {
                board[i][j] = '-';
                secondBoard[i][j] = 0;
            }
        }
    }

    int getSeize() {
        return seize;
    }

    void printBoard() {
        for (int i = 0; i < seize; i++) {
            for (int j = 0; j < seize; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int getCell(int x, int y) {
        return secondBoard[x][y];
    }

    boolean isCellFull(int x, int y) {
        return getCell(x, y) != 0;
    }

    void recordMove(char mark, int x, int y) {
        board[x][y] = mark;
        secondBoard[x][y] = 1;
    }

    char getMark(int x, int y) {
        return board[x][y];
    }
}
