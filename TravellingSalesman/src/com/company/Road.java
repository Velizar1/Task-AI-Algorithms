package com.company;

import java.util.ArrayList;
import java.util.List;

public class Road implements Comparable<Road>{

    private List<City> road;
    private double distance;

    public Road() {
        road=new ArrayList<City>();
        distance=0;
    }

    public Road(List<City> roads) {
        this.road = new ArrayList<City>(roads);
        calculateDistance();
    }

    /**
     * Calculating distance of the current road
     */
    private void calculateDistance() {
        double sum=0.0;
        for (int i = 0; i <road.size()-1 ; i++) {
            sum+=distanceBetweenCityes( road.get(i),road.get(i+1));
        }
        distance=(Double.valueOf(String.format("%.2f",sum).replace(",",".")));
    }

    /**
     * Calculating distance between 2 cities by Pitagor formula
     * @param first
     * @param second
     * @return
     */
    private double distanceBetweenCityes(City first,City second){
        return  Math.sqrt(Math.pow(first.getCordinateX()-second.getCordinateX(),2)+
                Math.pow(first.getCordinateY()-second.getCordinateY(),2));
    }

    public List<City> getRoad() {
        return road;
    }

    /**
     * After adding a city to the road we calculate the new distance
     * @param city
     */
    public void addCityToRoad(City city){
        road.add(city);
        calculateDistance();
    }
    public void addCityToRoadByIndex(int index,City city){
        road.add(index,city);
        calculateDistance();
    }
    public void deleteCityFromRoadByIndex(int index){
        road.remove(index);
        calculateDistance();
    }

    public double getDistance() {
        return distance;
    }

    public void setRoads(List<City> roads) {
        this.road = roads;
        calculateDistance();
    }

    @Override
    public String toString(){
        String info="";
        for (int i = 0; i < road.size(); i++) {
            info+=road.get(i).toString()+"\n";
        }
        info+="Distance : "+distance+"\n";
        return info;
    }

    @Override
    public int compareTo(Road o) {
        if(o.getDistance()-distance>0){
            return -1;
        }else if(o.getDistance()-distance<0){
            return 1;
        }
        return 0;
    }
}
