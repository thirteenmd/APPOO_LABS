package com.appoo.chess.pieces;

import com.appoo.chess.Cell;

import java.util.ArrayList;

public class King extends Piece {
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public King(String i, String p, int c, int x, int y) {
        setX(x);
        setY(y);
        setId(i);
        setPath(p);
        setColor(c);
    }

    public ArrayList<Cell> move(Cell[][] pos, int x, int y) {
        possiblemoves.clear();
        int posx[] = {x, x, x + 1, x + 1, x + 1, x - 1, x - 1, x - 1};
        int posy[] = {y - 1, y + 1, y - 1, y, y + 1, y - 1, y, y + 1};
        for (int i = 0; i < 8; i++)
            if ((posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8))
                if ((pos[posx[i]][posy[i]].getpiece() == null || pos[posx[i]][posy[i]].getpiece().getColor() != this.getX()))
                    possiblemoves.add(pos[posx[i]][posy[i]]);
        return possiblemoves;
    }

    public boolean isInDanger(Cell state[][]) {

        //Checking for attack from left,right,up and down
        for (int i = x + 1; i < 8; i++) {
            if (state[i][y].getpiece() == null)
                continue;
            else if (state[i][y].getpiece().getColor() == this.getColor())
                break;
            else {
                if ((state[i][y].getpiece() instanceof Rook) || (state[i][y].getpiece() instanceof Queen))
                    return true;
                else
                    break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (state[i][y].getpiece() == null)
                continue;
            else if (state[i][y].getpiece().getColor() == this.getColor())
                break;
            else {
                if ((state[i][y].getpiece() instanceof Rook) || (state[i][y].getpiece() instanceof Queen))
                    return true;
                else
                    break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if (state[x][i].getpiece() == null)
                continue;
            else if (state[x][i].getpiece().getColor() == this.getColor())
                break;
            else {
                if ((state[x][i].getpiece() instanceof Rook) || (state[x][i].getpiece() instanceof Queen))
                    return true;
                else
                    break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (state[x][i].getpiece() == null)
                continue;
            else if (state[x][i].getpiece().getColor() == this.getColor())
                break;
            else {
                if ((state[x][i].getpiece() instanceof Rook) || (state[x][i].getpiece() instanceof Queen))
                    return true;
                else
                    break;
            }
        }

        //checking for attack from diagonal direction
        int tempx = x + 1, tempy = y - 1;
        while (tempx < 8 && tempy >= 0) {
            if (state[tempx][tempy].getpiece() == null) {
                tempx++;
                tempy--;
            } else if (state[tempx][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                if (state[tempx][tempy].getpiece() instanceof Bishop || state[tempx][tempy].getpiece() instanceof Queen)
                    return true;
                else
                    break;
            }
        }
        tempx = x - 1;
        tempy = y + 1;
        while (tempx >= 0 && tempy < 8) {
            if (state[tempx][tempy].getpiece() == null) {
                tempx--;
                tempy++;
            } else if (state[tempx][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                if (state[tempx][tempy].getpiece() instanceof Bishop || state[tempx][tempy].getpiece() instanceof Queen)
                    return true;
                else
                    break;
            }
        }
        tempx = x - 1;
        tempy = y - 1;
        while (tempx >= 0 && tempy >= 0) {
            if (state[tempx][tempy].getpiece() == null) {
                tempx--;
                tempy--;
            } else if (state[tempx][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                if (state[tempx][tempy].getpiece() instanceof Bishop || state[tempx][tempy].getpiece() instanceof Queen)
                    return true;
                else
                    break;
            }
        }
        tempx = x + 1;
        tempy = y + 1;
        while (tempx < 8 && tempy < 8) {
            if (state[tempx][tempy].getpiece() == null) {
                tempx++;
                tempy++;
            } else if (state[tempx][tempy].getpiece().getColor() == this.getColor())
                break;
            else {
                if (state[tempx][tempy].getpiece() instanceof Bishop || state[tempx][tempy].getpiece() instanceof Queen)
                    return true;
                else
                    break;
            }
        }

        //Checking for attack from the Knight of opposite color
        int posx[] = {x + 1, x + 1, x + 2, x + 2, x - 1, x - 1, x - 2, x - 2};
        int posy[] = {y - 2, y + 2, y - 1, y + 1, y - 2, y + 2, y - 1, y + 1};
        for (int i = 0; i < 8; i++)
            if ((posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8))
                if (state[posx[i]][posy[i]].getpiece() != null && state[posx[i]][posy[i]].getpiece().getColor() != this.getColor() && (state[posx[i]][posy[i]].getpiece() instanceof Knight)) {
                    return true;
                }


        //Checking for attack from the Pawn of opposite color
        int pox[] = {x + 1, x + 1, x + 1, x, x, x - 1, x - 1, x - 1};
        int poy[] = {y - 1, y + 1, y, y + 1, y - 1, y + 1, y - 1, y};
        {
            for (int i = 0; i < 8; i++)
                if ((pox[i] >= 0 && pox[i] < 8 && poy[i] >= 0 && poy[i] < 8))
                    if (state[pox[i]][poy[i]].getpiece() != null && state[pox[i]][poy[i]].getpiece().getColor() != this.getColor() && (state[pox[i]][poy[i]].getpiece() instanceof King)) {
                        return true;
                    }
        }
        if (getColor() == 0) {
            if (x > 0 && y > 0 && state[x - 1][y - 1].getpiece() != null && state[x - 1][y - 1].getpiece().getColor() == 1 && (state[x - 1][y - 1].getpiece() instanceof Pawn))
                return true;
            if (x > 0 && y < 7 && state[x - 1][y + 1].getpiece() != null && state[x - 1][y + 1].getpiece().getColor() == 1 && (state[x - 1][y + 1].getpiece() instanceof Pawn))
                return true;
        } else {
            if (x < 7 && y > 0 && state[x + 1][y - 1].getpiece() != null && state[x + 1][y - 1].getpiece().getColor() == 0 && (state[x + 1][y - 1].getpiece() instanceof Pawn))
                return true;
            if (x < 7 && y < 7 && state[x + 1][y + 1].getpiece() != null && state[x + 1][y + 1].getpiece().getColor() == 0 && (state[x + 1][y + 1].getpiece() instanceof Pawn))
                return true;
        }
        return false;
    }
}
