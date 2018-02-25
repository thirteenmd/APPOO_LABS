package tictactoe;

import java.util.Scanner;

public class GameManager {
    private Scanner scanner = new Scanner(System.in);
    private Board board;
    private Game game;
    private Player playerOne;
    private Player playerTwo;
    private char currentMark = 'X';

    public GameManager(int size){
        initGame(size);
    }

    private void initPlayers(){
        playerOne = new Player();
        playerTwo = new Player();
        System.out.println("First player's name: ");
        playerOne.setName(scanner.nextLine());
        playerOne.setMark('X');
        System.out.println("Second player's name: ");
        playerTwo.setName(scanner.nextLine());
        playerTwo.setMark('O');
    }

    private void initGame(int size) {
        board = new Board(size);
        game = new Game();
        initPlayers();
        System.out.println("Welcome to TIC TAC TOE!");
        System.out.println("To start the game, press enter.");
        scanner.nextLine();
    }

    public void startGame(){
        board.printBoard();
        int x, y;
        do {
            System.out.println("Give coordinates for mark: ");
            x = scanner.nextInt();
            y = scanner.nextInt();
            while (!areCoordinatesValid(x, y)){
                System.out.println("Wrong move! Reenter coordinates:");
                x = scanner.nextInt();
                y = scanner.nextInt();
            }
            board.move(currentMark, x, y);
            if (currentMark == 'X'){
                currentMark = 'O';
            }else {
                currentMark = 'X';
            }
            board.printBoard();
            System.out.println();
        }while (!game.gameIsFinished(board));
    }

    private boolean areCoordinatesValid(int x, int y) {
        if (x > board.getSeize() || x < 0 || y > board.getSeize() || y < 0){
            return false;
        }
        if (board.isCellFull(x, y)){
            return false;
        }
        return true;
    }
}
