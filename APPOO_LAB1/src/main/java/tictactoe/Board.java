package tictactoe;

class Board {
    private int seize;
    private char[][] board;
    private int[][] secondBoard;

    //CONSTRUCTOR
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

    //GETTER
    int getSeize() {
        return seize;
    }

    //PRINTS THE BOARD
    void printBoard() {
        for (int i = 0; i < seize; i++) {
            for (int j = 0; j < seize; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //GETTER
    private int getCell(int x, int y) {
        return secondBoard[x][y];
    }

    //VERIFIES IF THE CELL IS FULL
    boolean isCellFull(int x, int y) {
        return getCell(x, y) != 0;
    }

    //RECORDS THE MOVE
    public void recordMove(char mark, int x, int y) {
        board[x][y] = mark;
        secondBoard[x][y] = 1;
    }

    //RETURNS THE MARK
    char getMark(int x, int y) {
        return board[x][y];
    }

    //SHOULD MAKE ANOTHER CLASS CELL

}
