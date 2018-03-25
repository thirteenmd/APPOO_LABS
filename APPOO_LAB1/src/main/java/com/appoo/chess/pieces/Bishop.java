package com.appoo.chess.pieces;

import com.appoo.chess.Cell;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(String id, String path, int Color) {
        setId(id);
        setPath(path);
        setColor(Color);
    }

    public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
        possiblemoves.clear();
        int tempx = x + 1, tempy = y - 1;
        while (tempx < 8 && tempy >= 0) {
            if (pos[tempx][tempy].getpiece() == null) {
                possiblemoves.add(pos[tempx][tempy]);
            } else if (pos[tempx][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                possiblemoves.add(pos[tempx][tempy]);
                break;
            }
            tempx++;
            tempy--;
        }
        tempx = x - 1;
        tempy = y + 1;
        while (tempx >= 0 && tempy < 8) {
            if (pos[tempx][tempy].getpiece() == null)
                possiblemoves.add(pos[tempx][tempy]);
            else if (pos[tempx][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                possiblemoves.add(pos[tempx][tempy]);
                break;
            }
            tempx--;
            tempy++;
        }
        tempx = x - 1;
        tempy = y - 1;
        while (tempx >= 0 && tempy >= 0) {
            if (pos[tempx][tempy].getpiece() == null)
                possiblemoves.add(pos[tempx][tempy]);
            else if (pos[tempx][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                possiblemoves.add(pos[tempx][tempy]);
                break;
            }
            tempx--;
            tempy--;
        }
        tempx = x + 1;
        tempy = y + 1;
        while (tempx < 8 && tempy < 8) {
            if (pos[tempx][tempy].getpiece() == null)
                possiblemoves.add(pos[tempx][tempy]);
            else if (pos[tempx][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                possiblemoves.add(pos[tempx][tempy]);
                break;
            }
            tempx++;
            tempy++;
        }
        return possiblemoves;
    }
}
