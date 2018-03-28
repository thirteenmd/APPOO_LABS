package tictactoe;

public class Board {
    private int seize;
    private char[][] board;
    private int[][] secondBoard; //for memorising the moves

    Board(int seize) {
        this.seize = seize;
        board = new char[seize][seize];
        secondBoard = new int[seize][seize];
        for (int i = 0; i < seize; i++) {
            for (int j = 0; j < seize; j++) {
                board[i][j] = '-'; //the board is empty
                secondBoard[i][j] = 0; //initialize the second board
            }
        }
    }

    public int getSeize() {
        return seize;
    }

    //prints the board to the console
    public void printBoard() {
        for (int i = 0; i < seize; i++) {
            for (int j = 0; j < seize; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        for (int i = 0; i < seize; i++) {
            for (int j = 0; j < seize; j++) {
                System.out.print(secondBoard[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private int getCell(int x, int y) {
        return secondBoard[x][y];
    }

    public boolean isCellFull(int x, int y) {
        return getCell(x, y) != 0;
    }

    public void move(char mark, int x, int y) {
        board[x][y] = mark;
        secondBoard[x][y] = 1;
    }

    public char getMark(int x, int y) {
        return board[x][y];
    }

}
