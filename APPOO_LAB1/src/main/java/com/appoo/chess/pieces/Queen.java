package com.appoo.chess.pieces;

import com.appoo.chess.Cell;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(String id, String path, int Color) {
        setId(id);
        setPath(path);
        setColor(Color);
    }

    public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
        possiblemoves.clear();

        //Checking possible moves in vertical direction
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


        //Checking possible moves in horizontal Direction
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

        //Checking for possible moves in diagonal direction
        tempx = x + 1;
        tempy = y - 1;
        while (tempx < 8 && tempy >= 0) {
            if (pos[tempx][tempy].getpiece() == null)
                possiblemoves.add(pos[tempx][tempy]);
            else if (pos[tempx][tempy].getpiece().getColor() == this.getColor())
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
