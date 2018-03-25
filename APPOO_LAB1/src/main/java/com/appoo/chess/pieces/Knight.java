package com.appoo.chess.pieces;

import com.appoo.chess.Cell;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(String id, String path, int color) {
        setId(id);
        setPath(path);
        setColor(color);
    }

    public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
        possiblemoves.clear();
        int posx[] = {x + 1, x + 1, x + 2, x + 2, x - 1, x - 1, x - 2, x - 2};
        int posy[] = {y - 2, y + 2, y - 1, y + 1, y - 2, y + 2, y - 1, y + 1};
        for (int i = 0; i < 8; i++)
            if ((posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8))
                if ((pos[posx[i]][posy[i]].getpiece() == null || pos[posx[i]][posy[i]].getpiece().getColor() != this.getColor())) {
                    possiblemoves.add(pos[posx[i]][posy[i]]);
                }
        return possiblemoves;
    }
}
