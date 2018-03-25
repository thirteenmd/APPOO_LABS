package com.appoo.chess.pieces;

import com.appoo.chess.Cell;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(String i, String p, int c) {
        setId(i);
        setPath(p);
        setColor(c);
    }

    public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
        return null;
    }
}
