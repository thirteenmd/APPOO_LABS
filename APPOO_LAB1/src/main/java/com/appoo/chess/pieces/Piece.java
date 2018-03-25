package com.appoo.chess.pieces;

import com.appoo.chess.Cell;

import java.util.ArrayList;

public abstract class Piece implements Cloneable {
    private int color;
    private String id = null;
    private String path;
    protected ArrayList<Cell> possiblemoves = new ArrayList<Cell>();

    public abstract ArrayList<Cell> move(Cell pos[][], int x, int y);

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<Cell> getPossiblemoves() {
        return possiblemoves;
    }

    public void setPossiblemoves(ArrayList<Cell> possiblemoves) {
        this.possiblemoves = possiblemoves;
    }

    public Piece getcopy() throws CloneNotSupportedException {
        return (Piece) this.clone();
    }
}
