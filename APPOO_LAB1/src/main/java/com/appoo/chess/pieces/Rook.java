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
        possiblemoves.clear();
        int tempx = x - 1;
        while (tempx >= 0) {
            if (pos[tempx][y].getpiece() == null)
                possiblemoves.add(pos[tempx][y]);
            else if (pos[tempx][y].getpiece().getColor() == this.getColor())
                break;
            else {
                possiblemoves.add(pos[tempx][y]);
                break;
            }
            tempx--;
        }
        tempx = x + 1;
        while (tempx < 8) {
            if (pos[tempx][y].getpiece() == null)
                possiblemoves.add(pos[tempx][y]);
            else if (pos[tempx][y].getpiece().getColor() == this.getColor())
                break;
            else {
                possiblemoves.add(pos[tempx][y]);
                break;
            }
            tempx++;
        }
        int tempy = y - 1;
        while (tempy >= 0) {
            if (pos[x][tempy].getpiece() == null)
                possiblemoves.add(pos[x][tempy]);
            else if (pos[x][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                possiblemoves.add(pos[x][tempy]);
                break;
            }
            tempy--;
        }
        tempy = y + 1;
        while (tempy < 8) {
            if (pos[x][tempy].getpiece() == null)
                possiblemoves.add(pos[x][tempy]);
            else if (pos[x][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                possiblemoves.add(pos[x][tempy]);
                break;
            }
            tempy++;
        }
        return possiblemoves;
    }
}
