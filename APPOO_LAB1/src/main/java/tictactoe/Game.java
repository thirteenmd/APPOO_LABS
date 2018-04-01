package tictactoe;


interface Game {

    void initGame(int size);

    void startGame();

    boolean gameIsFinished(Board board);

    boolean areCoordinatesValid(int x, int y);

}
