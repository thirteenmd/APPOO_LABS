package tictactoe;

public class Board {
    private int seize;
    private char[][] board;
    private int[][] secondBoard; //for memorising the moves

    public Board(int seize) {
        this.seize = seize;
        board = new char[seize][seize];
        for (int i = 0; i < seize; i++){
            for (int j = 0; j < seize; j++){
                board[i][j] = '-'; //the board is empty
            }
        }
    }

    public int getSeize(){
        return seize;
    }

    //prints the board to the console
    public void printBoard(){
        for (int i = 0; i < seize; i++){
            System.out.println();
            for (int j = 0; j < seize; j++){
                if (j == 0)
                    System.out.println("| ");
                System.out.println(board[i][j] + " | ");
            }
        }
    }

    private int getCell(int x, int y){
        return secondBoard[x][y];
    }

    public boolean isCellFull(int x, int y){
        return getCell(x, y) != 0;
    }

    public  void moove(char mark, int x, int y){
        board[x][y] = mark;
        secondBoard[x][y] = 1;
    }

    public char getMark(int x, int y){
        return board[x][y];
    }

}
