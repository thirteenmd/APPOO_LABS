package tictactoe;

class BoardPrinter {
   private TTTBoard board;

   BoardPrinter(TTTBoard board){
       this.board = board;
   }

    void printBoard() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                System.out.print(board.getCell(i, j) + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
