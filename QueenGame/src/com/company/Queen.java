package com.company;

public class Queen implements Comparable<Queen>{

    private int row;
    private int col;
    int numOfConflicts;


    public Queen(int row, int col) {
        this.row = row;
        this.col = col;
        numOfConflicts=0;
    }

    public int getNumOfConflicts() {
        return numOfConflicts;
    }

    public void setNumOfConflicts(int numOfConflicts) {
        this.numOfConflicts = numOfConflicts;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public int compareTo(Queen o) {
        if(this.getNumOfConflicts()>o.getNumOfConflicts()){
            return -1;
        }
        else if(this.getNumOfConflicts()<o.getNumOfConflicts()){
            return 1;
        }
        return 0;
    }
}
