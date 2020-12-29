package com.company;

import java.util.*;

public class Table {

    private List<Queen> queens;
    private int[][] conflicts;
    private int size;
    private HashMap<Integer,Integer> placesWithConflicts;

    public Table(int size) {
        queens=new ArrayList<Queen>();
        this.size=size;
        conflicts=new int[size][size];
        placesWithConflicts= new HashMap<Integer, Integer>();

    }
    public void createTable(){
        int steps=0;
        genrateTable();
        int i=0;
        int lastRow=-1;
        int lastCol=-1;
        int restarts=0;
        while (true) {
            while (steps < 150) {
                Collections.sort(queens);
                Queen queen ;
                int maxConflicts=queens.get(0).getNumOfConflicts();
                    if (maxConflicts == queens.get(1).getNumOfConflicts()) {
                        int count = 0;
                        Random random = new Random();
                        for (Queen q : queens) {
                            if (q.getNumOfConflicts() == maxConflicts) {
                                count++;
                            } else {
                                break;
                            }
                        }
                        queen = queens.get(random.nextInt(count));
                    } else {
                        queen = queens.get(0);
                    }
                if (queen.getNumOfConflicts() == 0) {
                    System.out.println();
                   // printTable();
                    System.out.println("Steps :"+steps);
                    System.out.println("Restarts :"+restarts);
                    System.out.println();
                    return;
                }
                steps++;
                findBetterPosition(queen,lastCol,lastRow);
            }
            steps=0;
            reset();
            genrateTable();
            restarts++;
        }

    }

    private void genrateTable(){
        for (int i = 0; i < size; i++) {
            int randomNum = randomPlace(i);
            Queen queen=new Queen(i,randomNum);
            increaseConflictMatrix(i, randomNum);
            queens.add(queen);
        }
        setQueensConflicts();
    }
    private boolean findBetterPosition(Queen queen,int lastCol,int lastRow) {

        int colPossition=otherRandomPlace(queen.getRow(),queen.getCol(), lastCol,lastRow);
        if(colPossition!=-1){
            decreaseConflictMatrix(queen.getRow(),queen.getCol());
            queen.setCol(colPossition);
            increaseConflictMatrix(queen.getRow(),queen.getCol());
            setQueensConflicts();
            Collections.sort(queens);
            return true;
        }
        return false;
    }

    private void setQueensConflicts(){
        int row;
        int col;
        for (int i = 0; i < size ; i++){
            row=queens.get(i).getRow();
            col=queens.get(i).getCol();
            queens.get(i).setNumOfConflicts(conflicts[row][col]);
        }
    }
    private void reset(){
        queens=new ArrayList<Queen>();
        conflicts=new int[size][size];
        placesWithConflicts= new HashMap<Integer, Integer>();
    }
    private void decreaseConflictMatrix(int row,int col){
        int helpRow=row;
        int helpColMainDiagonal=col;
        int helpColSecondDiagonal=col;
        //for col
        int length = conflicts.length % 2 == 0 ? conflicts.length / 2 : (conflicts.length / 2) + 1;
        for (int i = 0; i < length; i++) {
            //col
            if (i != row) {
                conflicts[i][col]--;
            }
            if (conflicts.length - i- 1 > i && conflicts.length-i-1!=row) {
                conflicts[conflicts.length - i- 1][col]--;
            }
        }
        for (int i = 0; i <conflicts.length; i++) {
            if (helpRow + 1 < size) {
                helpRow++;
                if (helpColSecondDiagonal - 1 >= 0) {
                    helpColSecondDiagonal--;
                    conflicts[helpRow][helpColSecondDiagonal]--;
                }
                if (helpColMainDiagonal + 1 < size) {
                    helpColMainDiagonal++;
                    conflicts[helpRow][helpColMainDiagonal]--;
                }
            }
            else break;
        }
        helpRow = row;
        helpColMainDiagonal = col;
        helpColSecondDiagonal = col;
        for (int i = 0; i < conflicts.length; i++) {
            if (helpRow - 1 >= 0) {
                helpRow--;
                if (helpColSecondDiagonal + 1 < size) {
                    helpColSecondDiagonal++;
                    conflicts[helpRow][helpColSecondDiagonal]--;
                }
                if (helpColMainDiagonal - 1 >= 0) {
                    helpColMainDiagonal--;
                    conflicts[helpRow][helpColMainDiagonal]--;
                }
            }
            else break;
        }
    }

    private void increaseConflictMatrix(int row, int col) {
        //for col
        int helpRow = row;
        int helpColMainDiagonal = col;
        int helpColSecondDiagonal = col;
        int length = conflicts.length % 2 == 0 ? conflicts.length / 2 : (conflicts.length / 2)+1;
        for (int i = 0; i < length; i++) {
            //col
            if (i != row) {
                conflicts[i][col]++;
            }
            if (conflicts.length - i- 1 > i && conflicts.length-i-1!=row) {
                conflicts[conflicts.length - i- 1][col]++;
            }
        }
        //for col
        for (int i = 0; i < conflicts.length; i++) {

            if (helpRow + 1 < size) {
                helpRow++;
                if (helpColSecondDiagonal - 1 >= 0) {
                    helpColSecondDiagonal--;
                    conflicts[helpRow][helpColSecondDiagonal]++;
                }
                if (helpColMainDiagonal + 1 < size) {
                    helpColMainDiagonal++;
                    conflicts[helpRow][helpColMainDiagonal]++;
                }
            }
            else break;
        }
        helpRow = row;
        helpColMainDiagonal = col;
        helpColSecondDiagonal = col;
        for (int i = 0; i < conflicts.length; i++) {
            if (helpRow - 1 >= 0) {
                helpRow--;
                if (helpColSecondDiagonal + 1 < size) {
                    helpColSecondDiagonal++;
                    conflicts[helpRow][helpColSecondDiagonal]++;
                }
                if (helpColMainDiagonal - 1 >= 0) {
                    helpColMainDiagonal--;
                    conflicts[helpRow][helpColMainDiagonal]++;
                }
            } else break;
        }
    }
    private int otherRandomPlace(int row,int col,int lastCol,int lastRow){
        Random random=new Random();
        List<Integer> numConflicts=new ArrayList<Integer>();
        int min=conflicts[row][col];

        for (int j = 0; j < size; j++) {
            if(conflicts[row][j]<min && j!=col ){
                if(row==lastRow&&lastCol!=j) {
                    min = conflicts[row][j];
                    numConflicts.clear();
                    numConflicts.add(j);
                }
                else if(row!=lastRow){
                    min = conflicts[row][j];
                    numConflicts.clear();
                    numConflicts.add(j);
                }
            }
            else if(conflicts[row][j]==min && j!=col ){
                if(row==lastRow&&lastCol!=j){
                    numConflicts.add(j);
                }
                else if(lastRow!=row){
                    numConflicts.add(j);
                }

            }
        }
        if(numConflicts.size()>0) {
            int randomPlace = random.nextInt(numConflicts.size());
            return numConflicts.get(randomPlace);
        }
        return -1;
    }
    private int randomPlace(int row){
        Random random=new Random();
        List<Integer> numConflicts=new ArrayList<Integer>();
        int min=conflicts[row][0];
        numConflicts.add(0);

        for (int j = 1; j < size; j++) {
            if(conflicts[row][j]<min){
                min=conflicts[row][j];
                numConflicts.clear();
                numConflicts.add(j);
            }
            else if(conflicts[row][j]==min){
                numConflicts.add(j);
            }
        }
        int randomPlace=random.nextInt(numConflicts.size());
        if(min!=0){
            placesWithConflicts.put(row,randomPlace);
        }
        return numConflicts.get(randomPlace);
    }

    private void printTable(){
        int i=0;
        int count=0;
        while(i<size) {

            if (i == queens.get(count).getRow()) {
                for (int k = 0; k < size; k++) {
                    if (k != queens.get(count).getCol()) {
                        System.out.printf("%3s", "0");
                    } else {
                        System.out.printf("%3s", "1");
                    }
                }
                i++;
                count = 0;
                System.out.println();
            } else {
                count++;
            }
        }
        System.out.println();
    }
}
