package com.company;


import java.util.*;

public class GenericAlgorithm {

    private List<City> cities;
    private int numOfCityes;
    private List<Road> roads;
    private final double mutationProcent=0.1;
    private final double selectionProcent=0.5;
    private final Random random=new Random();


    public GenericAlgorithm(int n) {
        cities=new ArrayList<City>();
        roads=new ArrayList<Road>();
        numOfCityes=n;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    /**
     * Testing method
     */
    //TODO
    //testing functions
    public void createGeneration(){

        generateCityes();
        generateNRoads();
        double minDistance=0.0;
        int randomFirst;
        int randomSecond;
        int size;
        int populations=0;
        do{
            minDistance=findMinDistance();
            roads=selection(roads);
            size=roads.size();
            for (int i = 0; i <(numOfCityes)/2 ; i++) {
                randomFirst=random.nextInt(size);
                randomSecond=random.nextInt(size);
                if(randomFirst!=randomSecond){
                    crossOver(roads.get(randomFirst),roads.get(randomSecond));
                }else i--;
            }
            mutationFunc(roads);
            roads=roads.subList(0,numOfCityes);
            populations++;
            System.out.println("Population "+populations);
            System.out.println("Distance:" +minDistance);
        }while (populations<100); //&& minDistance>findMinDistance());


    }
    /**
     * selecting the best n parents for crossover by they'r distance
     * @param population
     * @return
     */
    private List<Road> selection(List<Road> population){
        Collections.sort(roads);
        int bestN=(int)Math.round(roads.size()*selectionProcent);
        return new ArrayList<Road>(population.subList(0,bestN));
    }
    /**
     * Creating to list to help us save the data we need for making the mutation
     * We have 3 random indexes of the road and the two cities we want to swap
     * Each time we create a new list of the cities so we can generate random numbers of two cities for
     * each road. Then we generate index of a road to mutate. After mutating and adding the new road to the
     * helperRoads list, we remove it from the curr list(to prevent mutating same road twice).
     * After we finish with the mutation we add the mutated roads to the curr list of roads.
     * @param population
     */
    private void mutationFunc(List<Road> population){

        List<Road> helperRoads=new ArrayList<Road>();
        List<City> helperCityes;
        int numberForMutating= (int)Math.round(population.size()*mutationProcent);

        int indexOfRandomRoad;
        int indexOfFirstCityToSwap;
        int indexOfSecondCityToSwap;
        //System.out.println("Mutating : "+numberForMutating);
        for (int i = 0; i <numberForMutating; i++) {
            helperCityes=new ArrayList<City>(cities);

            indexOfRandomRoad=random.nextInt(population.size());

            indexOfFirstCityToSwap=random.nextInt(helperCityes.size());
            indexOfFirstCityToSwap=helperCityes.get(indexOfFirstCityToSwap).getCityNumber();
            helperCityes.remove(indexOfFirstCityToSwap);
            indexOfSecondCityToSwap=random.nextInt(helperCityes.size());
            indexOfSecondCityToSwap=helperCityes.get(indexOfSecondCityToSwap).getCityNumber();

            helperRoads.add(swapCitiesOfRoad(indexOfFirstCityToSwap,indexOfSecondCityToSwap,indexOfRandomRoad));
            population.remove(indexOfRandomRoad);
        }
        // Adding the removed mutated roads to the list of all rounds
        for (int i = 0; i <helperRoads.size() ; i++) {
            population.add(helperRoads.get(i));
        }
        Collections.sort(roads);

    }
    /**
     * swapping places of two cities from a current road
     * @param indexOfFirstCityToSwap
     * @param indexOfSecondCityToSwap
     * @param indexOfRandomRoad
     * @return
     */
    private Road swapCitiesOfRoad(int indexOfFirstCityToSwap, int indexOfSecondCityToSwap, int indexOfRandomRoad) {

       City first = roads.get(indexOfRandomRoad).getRoad().get(indexOfFirstCityToSwap);
       City second = roads.get(indexOfRandomRoad).getRoad().get(indexOfSecondCityToSwap);

        /*System.out.println("------------------------------------------------------");
        System.out.println("Indexes: "+indexOfFirstCityToSwap+" "+
                indexOfSecondCityToSwap+"\n"+roads.get(indexOfRandomRoad).toString());*/
       roads.get(indexOfRandomRoad).deleteCityFromRoadByIndex(indexOfFirstCityToSwap);
       roads.get(indexOfRandomRoad).addCityToRoadByIndex(indexOfFirstCityToSwap,second);

       roads.get(indexOfRandomRoad).deleteCityFromRoadByIndex(indexOfSecondCityToSwap);
       roads.get(indexOfRandomRoad).addCityToRoadByIndex(indexOfSecondCityToSwap,first);

      /*  System.out.println("Affter slap:"+roads.get(indexOfRandomRoad));
        System.out.println("------------------------------------------");*/
       return roads.get(indexOfRandomRoad);
    }
    private double findMinDistance(){
        double min=roads.get(0).getDistance();
        for (Road road:roads) {
            if(min>road.getDistance()){
                min=road.getDistance();
            }
        }
        return min;
    }
    /**
     * @param firstParent
     * @param secondParent
     *
     * Getting random number for sub road.
     * Checking witch cities of the cross parents are missing from the children's
     * Adding missing cities in the order in witch they are in the parents
     * Adding the created roads to the list of roads
     */
    private void crossOver(Road firstParent,Road secondParent){
        //roads.clear();

        int index=random.nextInt(numOfCityes);
        index=(index==0?index+1:index);
        index=(index==numOfCityes-1?index-1:index);
        //System.out.println("Index for cutting the parents: "+index);
        Road childOne=new Road(firstParent.getRoad().subList(0,index));
        Road childTwo=new Road(secondParent.getRoad().subList(0,index));
        int size=numOfCityes;
        int i = index;
        for ( ;i < size; i++) {
            boolean contains1 = false;
            boolean contains2 = false;
            for (int j = 0; j < childOne.getRoad().size()  ; j++) {
                if(childOne.getRoad().get(j).getCityNumber()==secondParent.getRoad().get(i).getCityNumber()){
                    contains1=true;
                    break;
                }
            }
            for (int j = 0; j < childTwo.getRoad().size(); j++) {
                if(childTwo.getRoad().get(j).getCityNumber()==firstParent.getRoad().get(i).getCityNumber()){
                    contains2=true;
                    break;
                }
            }
            if(!contains1) childOne.addCityToRoad(secondParent.getRoad().get(i));
            if(!contains2) childTwo.addCityToRoad(firstParent.getRoad().get(i));
            if(i+1==numOfCityes){
                i=-1;
                size=index;
            }
        }
        //System.out.println("Adding child 1:" +childOne.toString());
        // System.out.println("Adding child 2:" +childTwo.toString());
        roads.add(childOne);
        roads.add(childTwo);
    }
    /**
     * Getting random number from 1 - number of cities
     * Getting this city from the list and adding it to the road
     * Deleting this city from the list, so we prevent getting the same city twice
     * After creating the road we are adding it to the list of roads.
     */
    private void generateNRoads(){
        int index;

        for (int i = 0; i < numOfCityes; i++) {
            Road help=new Road(cities);
            Road help2=new Road();
            for (int j = 0; j <numOfCityes ; j++) {
                index=random.nextInt(numOfCityes-j);
                help2.addCityToRoad(help.getRoad().get(index));
                help.getRoad().remove(index);
            }
            roads.add(help2);
        }
    }
    /**
     * Generating two numbers from 1 to number of cities
     * Checking if we didnt already added a city on this position
     * Creating city with this coordinates and add it to the list of cities
     * Repeat the last step if we have a city on this position
     */
    private void generateCityes(){

        int cordinateX;
        int cordinateY;
        for (int i = 0; i < numOfCityes; i++) {
            cordinateX=random.nextInt(100)+1;
            cordinateY=random.nextInt(100)+1;
            if(!usedCordinates(cordinateX,cordinateY)){
                City city=new City(cordinateX,cordinateY,i);
                cities.add(city);
            }else i--;
        }
    }
    /**
     * Checking from the list of cities if we dont already have a city with this coordinates
     *
     * @param cordinateX
     * @param cordinateY
     * @return
     */
    private boolean usedCordinates(int cordinateX, int cordinateY) {
        int length=cities.size()%2==0?0:1;
        int size=cities.size()-1;

        for (int i = 0; i <cities.size()/2 +length; i++) {
            if(cities.get(i).getCordinateX()==cordinateX && cities.get(i).getCordinateY()==cordinateX
            || cities.get(size-i).getCordinateX()==cordinateX && cities.get(size-i).getCordinateY()==cordinateY){
                return true;
            }
        }
        return false;
    }
}