package com.appoo.chess.pieces;

import com.appoo.chess.Cell;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(String id, String path, int Color) {
        setId(id);
        setPath(path);
        setColor(Color);
    }

    public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
        possiblemoves.clear();
        if (getColor() == 0) {
            if (x == 0)
                return possiblemoves;
            if (pos[x - 1][y].getpiece() == null) {
                possiblemoves.add(pos[x - 1][y]);
                if (x == 6) {
                    if (pos[4][y].getpiece() == null)
                        possiblemoves.add(pos[4][y]);
                }
            }
            if ((y > 0) && (pos[x - 1][y - 1].getpiece() != null) && (pos[x - 1][y - 1].getpiece().getColor() != this.getColor()))
                possiblemoves.add(pos[x - 1][y - 1]);
            if ((y < 7) && (pos[x - 1][y + 1].getpiece() != null) && (pos[x - 1][y + 1].getpiece().getColor() != this.getColor()))
                possiblemoves.add(pos[x - 1][y + 1]);
        } else {
            if (x == 8)
                return possiblemoves;
            if (pos[x + 1][y].getpiece() == null) {
                possiblemoves.add(pos[x + 1][y]);
                if (x == 1) {
                    if (pos[3][y].getpiece() == null)
                        possiblemoves.add(pos[3][y]);
                }
            }
            if ((y > 0) && (pos[x + 1][y - 1].getpiece() != null) && (pos[x + 1][y - 1].getpiece().getColor() != this.getColor()))
                possiblemoves.add(pos[x + 1][y - 1]);
            if ((y < 7) && (pos[x + 1][y + 1].getpiece() != null) && (pos[x + 1][y + 1].getpiece().getColor() != this.getColor()))
                possiblemoves.add(pos[x + 1][y + 1]);
        }
        return possiblemoves;
    }
}
