package tictactoe;


import java.util.Scanner;

class Player {
    private String name;
    private char mark;

    private Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    static Player initialize(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give player's name: ");
        return new Player(scanner.nextLine(), 'X');
    }
}
