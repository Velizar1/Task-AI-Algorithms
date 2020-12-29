package com.company;

public class City {

    private int cordinateX;
    private int cordinateY;
    private int cityNumber;

    public City(int cordinateX, int cordinateY,int number) {
        this.cordinateX = cordinateX;
        this.cordinateY = cordinateY;
        cityNumber=number;
    }

    public int getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(int cityNumber) {
        this.cityNumber = cityNumber;
    }

    public int getCordinateX() {
        return cordinateX;
    }


    public int getCordinateY() {
        return cordinateY;
    }

    @Override
    public String toString(){
       return String.format("City : %d\nCoordinate of X : %d  Coordinate of Y : %d"
                ,getCityNumber(),getCordinateX(),getCordinateY());
    }
}
