package tictactoe;

public class Game {
    public static void main(String[] args){
        GameManager gameManager = new GameManager(3);
        gameManager.startGame();
    }

    public boolean gameIsFinished(Board board){
        if((board.getMark(0,0) == board.getMark(1,0)) && (board.getMark(0,0) == board.getMark(2,0)) && board.getMark(0,0) != '-' )
            return true;

        if((board.getMark(0,1) == board.getMark(1,1)) && (board.getMark(0,1) == board.getMark(2,1)) && board.getMark(0,1)!= '-')
            return true;

        if((board.getMark(0,2) == board.getMark(1,2)) && (board.getMark(0,2) == board.getMark(2,2)) && board.getMark(0,2)!= '-')
            return true;

        if (( board.getMark(0,0) == board.getMark(0,1)) && (board.getMark(0,0) == board.getMark(0,2)) && board.getMark(0,0) != '-')
            return true;

        if (( board.getMark(1,0) == board.getMark(1,1)) && (board.getMark(1,0) == board.getMark(1,2)) && board.getMark(1,0) != '-')
            return true;

        if (( board.getMark(2,0) == board.getMark(2,1)) && (board.getMark(2,0) == board.getMark(2,2)) && board.getMark(2,0) != '-')
            return true;

        if (( board.getMark(0,0) == board.getMark(1,1)) && (board.getMark(0,0) == board.getMark(2,2)) && board.getMark(0,0) != '-')
            return true;

        if (( board.getMark(0,2) == board.getMark(2,1)) && (board.getMark(0,2) == board.getMark(2,0)) && board.getMark(0,2) != '-')
            return true;

        return false;
    }
}
