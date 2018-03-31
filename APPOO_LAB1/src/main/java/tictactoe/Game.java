package tictactoe;


interface Game {

    void initGame(int size);

    void startGame();

    boolean gameIsFinished(Board board);

}
