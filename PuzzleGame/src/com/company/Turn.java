package com.company;

public enum Turn {
    Left(1),Right(2),Up(3),Down(4);
    private int numVal;

    Turn(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
