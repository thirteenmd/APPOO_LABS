package tictactoe;

import java.util.Scanner;

public class TicTacToe implements Game {
    private Scanner scanner = new Scanner(System.in);
    private TTTBoard board;
    private BoardPrinter boardPrinter;
    private char currentMark = 'X';

    TicTacToe(int size) {
        initGame(size);
    }

    public void initGame(int size) {
        board = new TTTBoard(size);
        boardPrinter = new BoardPrinter(board);
        System.out.println("Welcome to TIC TAC TOE!");
        System.out.println("To start the game, press enter.");
        scanner.nextLine();
    }

    public void startGame() {
        boardPrinter.printBoard();
        int x, y;
        do {
            System.out.println("Give coordinates for mark: ");
            x = scanner.nextInt();
            y = scanner.nextInt();
            while (!areCoordinatesValid(x, y)) {
                System.out.println("Wrong move! Reenter coordinates:");
                x = scanner.nextInt();
                y = scanner.nextInt();
            }
            board.recordMove(currentMark, x, y);
            if (currentMark == 'X') {
                currentMark = 'O';
            } else {
                currentMark = 'X';
            }
            boardPrinter.printBoard();
            System.out.println();
        } while (!gameIsFinished(board));
        if (gameIsFinished(board)){
            System.out.println("Game Over!");
            System.out.println(currentMark + " WON!!!");
        }
    }

    public boolean areCoordinatesValid(int x, int y) {
        if (x > board.getSize() || x < 0 || y > board.getSize() || y < 0) {
            return false;
        }
        if (board.isCellFull(x, y)) {
            return false;
        }
        return true;
    }

    public boolean gameIsFinished(TTTBoard board) {
        if ((board.getMark(0, 0) == board.getMark(1, 0)) && (board.getMark(0, 0) == board.getMark(2, 0)) && board.getMark(0, 0) != '-')
            return true;

        if ((board.getMark(0, 1) == board.getMark(1, 1)) && (board.getMark(0, 1) == board.getMark(2, 1)) && board.getMark(0, 1) != '-')
            return true;

        if ((board.getMark(0, 2) == board.getMark(1, 2)) && (board.getMark(0, 2) == board.getMark(2, 2)) && board.getMark(0, 2) != '-')
            return true;

        if ((board.getMark(0, 0) == board.getMark(0, 1)) && (board.getMark(0, 0) == board.getMark(0, 2)) && board.getMark(0, 0) != '-')
            return true;

        if ((board.getMark(1, 0) == board.getMark(1, 1)) && (board.getMark(1, 0) == board.getMark(1, 2)) && board.getMark(1, 0) != '-')
            return true;

        if ((board.getMark(2, 0) == board.getMark(2, 1)) && (board.getMark(2, 0) == board.getMark(2, 2)) && board.getMark(2, 0) != '-')
            return true;

        if ((board.getMark(0, 0) == board.getMark(1, 1)) && (board.getMark(0, 0) == board.getMark(2, 2)) && board.getMark(0, 0) != '-')
            return true;

        if ((board.getMark(0, 2) == board.getMark(2, 1)) && (board.getMark(0, 2) == board.getMark(2, 0)) && board.getMark(0, 2) != '-')
            return true;

        return false;
    }
}
