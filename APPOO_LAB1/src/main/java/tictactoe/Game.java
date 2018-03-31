package tictactoe;

import static tictactoe.Player.initialize;

abstract class Game {
    private Player playerOne;
    private Player playerTwo;


    void initPlayers() {
        playerOne = initialize();
        playerTwo = initialize();
    }

    public abstract void initGame(int size);

    public abstract void startGame();

    public abstract boolean gameIsFinished(Board board);

}
