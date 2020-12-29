package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
    private int[][] config;
    private Turn lastTurn;
    private List<Turn> turns;
    private int stepsCount;
    private List<Node> madeSteps;

    public List<Node> getMadeSteps() {
        return madeSteps;
    }

    public void setMadeSteps(List<Node> madeSteps) {
        this.madeSteps = madeSteps;
    }

    private int manhattanDistance;

    public Node() {
        turns=new ArrayList<Turn>();
    }

    public Node(int[][] config) {
        this.config = config;
        lastTurn = null;
        turns=new ArrayList<Turn>();
        stepsCount=0;
        manhattanDistance=0;
        madeSteps=new ArrayList<Node>();
    }

    public Node(int[][] config, Turn turn, List<Turn> turns) {
        this.turns=turns;
        this.config = config;
        lastTurn = turn;
        stepsCount=turns.size();
        manhattanDistance=0;
        madeSteps=new ArrayList<Node>();
    }
    public int[][] getConfig() {
        return config;
    }

    public int getManhattanDistance() {
        return manhattanDistance;
    }

    public void setManhattanDistance(int manhattanDistance) {
        this.manhattanDistance = manhattanDistance;
    }


    public Turn getLastTurn() {
        return lastTurn;
    }


    public List<Turn> getTurns() {
        return turns;
    }

    void printMatrix(){
        String viewMatrix=new String() ;
        for (int i = 0; i <getConfig().length ; i++) {
            for (int j = 0; j < getConfig().length; j++) {
                viewMatrix+=getConfig()[i][j];
            
                viewMatrix+=" ";
            }
            viewMatrix+="\n";
        }
        System.out.println(viewMatrix);
    }

    public int getStepsCount() {
        return stepsCount;
    }

    @Override
    public int compareTo(Node o) {
        if(manhattanDistance + getStepsCount() < o.getManhattanDistance() + o.getStepsCount()){
            return -1;
        }
        else if(manhattanDistance + getStepsCount() > o.getManhattanDistance() + o.getStepsCount()){
            return 1;
        }
        return 0;
    }
}
