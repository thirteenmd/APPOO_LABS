package tictactoe;


interface Game {

    void initGame(int size);

    void startGame();

    boolean gameIsFinished(TTTBoard board);

    boolean areCoordinatesValid(int x, int y);

}
