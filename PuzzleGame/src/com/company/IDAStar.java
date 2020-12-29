package com.company;

import java.util.*;

public class IDAStar {
    private Node root;
    private Node finalState;

    private List<Node> nodesSoFar;

    private PriorityQueue<Node> priorityQueue;

    public IDAStar() {
        root=null;
        finalState=null;
        priorityQueue=null;
    }

    public IDAStar(Node root, Node finalState) {
        this.root = root;
        this.finalState = finalState;
        nodesSoFar=new ArrayList<Node>();
        priorityQueue=new PriorityQueue<Node>();
    }

    public int ManhattanDistance(Node cur, Node goal ) {

        int[][] start=cur.getConfig();
        int[][] end=goal.getConfig();
        int path=0;
        int size=start.length;
        if(!areSame(start,end)) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    for (int k = 0; k < size; k++) {
                        for (int l = 0; l < size; l++) {
                            if (start[i][j] == end[k][l]) {
                                path += Math.abs(i - k) + Math.abs(j - l);
                            }
                        }
                    }

                }
            }
        }

        return path;
    }

    public boolean areSame(int A[][], int B[][])
    {
        int i, j;
        for (i = 0; i < A.length; i++)
            for (j = 0; j <A.length; j++)
                if (A[i][j] != B[i][j])
                    return false;
        return true;
    }

    static int[][] clone(int[][] a) {
        int[][] b = new int[a.length][];
        for (int i = 0; i < a.length; i++) {
            b[i]= new int[a[i].length];
            for (int j = 0; j < a[i].length; j++)
                b[i][j] = a[i][j];
        }
        return b;
    }

    public Node createNode(int [][]matrix, Turn turn,List<Turn> turns){
        Node node1=new Node(matrix,turn,turns);
        node1.setManhattanDistance(ManhattanDistance(node1,finalState));
        return node1;
    }

     public List<Node> getChildrens(Node node){

        nodesSoFar=new ArrayList<Node>(node.getMadeSteps());
        nodesSoFar.add(node);
        List<Turn> turns=new ArrayList<Turn>(node.getTurns());

        if(!areSame(node.getConfig(), finalState.getConfig())){

            List<Node> nodes=new ArrayList<Node>();
            int[][] matrix=clone(node.getConfig().clone());

            for (int i = 0; i <matrix.length ; i++) {
                for (int j = 0; j <matrix.length ; j++) {
                    if(matrix[i][j]==0){
                        if(i-1>=0){
                            if(node.getLastTurn()!=Turn.Down){
                            matrix[i][j]=matrix[i-1][j];
                            matrix[i-1][j]=0;
                            turns.add(Turn.Up);
                            Node node1=createNode(matrix, Turn.Up, new ArrayList<Turn>(turns) );
                            node1.setMadeSteps(nodesSoFar);
                            nodes.add(node1);

                            turns.remove(turns.size()-1);
                            matrix=clone(node.getConfig());
                        }
                        }
                        if(i+1<matrix.length){
                            if(node.getLastTurn()!=Turn.Up) {
                                matrix[i][j] = matrix[i + 1][j];
                                matrix[i + 1][j] = 0;
                                turns.add(Turn.Down);
                                Node node1 = createNode(matrix, Turn.Down, new ArrayList<Turn>(turns));
                                node1.setMadeSteps(nodesSoFar);
                                nodes.add(node1);

                                turns.remove(turns.size() - 1);
                                matrix = clone(node.getConfig());
                            }
                        }
                        if(j-1>=0){
                            if(node.getLastTurn()!=Turn.Right) {
                                matrix[i][j] = matrix[i][j - 1];
                                matrix[i][j - 1] = 0;
                                turns.add(Turn.Left);
                                Node node1 = createNode(matrix, Turn.Left, new ArrayList<Turn>(turns));
                                node1.setMadeSteps(nodesSoFar);
                                nodes.add(node1);

                                turns.remove(turns.size() - 1);
                                matrix = clone(node.getConfig());
                            }
                        }
                        if(j+1<matrix.length){
                            if(node.getLastTurn()!=Turn.Left) {
                                matrix[i][j] = matrix[i][j + 1];
                                matrix[i][j + 1] = 0;
                                turns.add(Turn.Right);
                                Node node1 = createNode(matrix, Turn.Right, new ArrayList<Turn>(turns));
                                node1.setMadeSteps(nodesSoFar);
                                nodes.add(node1);

                                turns.remove(turns.size() - 1);
                                matrix = clone(node.getConfig());
                            }
                        }
                    }
                }
            }
            return nodes;
        }
        return null;
     }
//TODO
     public void findPath(){

        this.root.setManhattanDistance(ManhattanDistance(this.root,this.finalState));
        Node current;
        SortedSet<Integer> notPassed=new TreeSet();
        notPassed.add(root.getManhattanDistance()+root.getStepsCount());
        int treshhold;

        while(true){
            priorityQueue.add(root);
            treshhold=notPassed.first();
            notPassed.remove(notPassed.first());

            while (!priorityQueue.isEmpty()) {
                current = priorityQueue.poll();

                if (current.getManhattanDistance() == 0) {


                    for (Node node : current.getMadeSteps()) {
                        System.out.println(node.getLastTurn());
                        node.printMatrix();

                    }

                    System.out.println(current.getLastTurn());
                    current.printMatrix();
                    System.out.println(current.getStepsCount());
                    return;
                }

                List<Node> nodeList=getChildrens(current);

                    for (Node child :nodeList) {
                        //TODO
                        if (child.getManhattanDistance()+child.getStepsCount() <= treshhold) {
                            priorityQueue.add(child);
                        }
                        else{
                            notPassed.add(child.getManhattanDistance()+child.getStepsCount());
                        }
                    }
            }
        }
     }
}
