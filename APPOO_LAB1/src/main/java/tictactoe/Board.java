package tictactoe;

class Board {
    int size;
    int[][] scoreBoard;

    int getSize() {
        return size;
    }

    public int getCell(int x, int y) {
        return scoreBoard[x][y];
    }

    boolean isCellFull(int x, int y) {
        return getCell(x, y) != 0;
    }

}
