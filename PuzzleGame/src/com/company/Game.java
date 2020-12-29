package com.company;

import java.util.List;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
	// write your code here


        System.out.print("Enter size: ");
        Scanner scanner=new Scanner(System.in);

        int size=scanner.nextInt();
        if(Math.sqrt(size+1)%1==0){
            int [][]matrix=new int[(int)Math.sqrt(size+1)][(int)Math.sqrt(size+1)];
            int [][]matrix2=new int[(int)Math.sqrt(size+1)][(int)Math.sqrt(size+1)];

            System.out.print("Enter position of zero: ");
            int positionOfZero=scanner.nextInt();

            System.out.println("Enter your matrix: ");
            for (int i = 0; i < (int)Math.sqrt(size+1); i++) {
                for (int j = 0; j < (int)Math.sqrt(size+1); j++) {
                    matrix[i][j]=scanner.nextInt();
                }
            }
            int count=1;
            if(positionOfZero==-1) {
                for (int i = 0; i < Math.sqrt(size + 1); i++) {
                    for (int j = 0; j < Math.sqrt(size + 1); j++) {
                        if(count<size+1) {
                            matrix2[i][j] = count;
                        }
                        else {
                            matrix2[i][j]=0;
                        }
                        count++;
                    }
                }
            }
            else{
                count=1;
                for (int i = 0; i < Math.sqrt(size + 1); i++) {
                    for (int j = 0; j < Math.sqrt(size + 1); j++) {
                        if(positionOfZero!=count) {
                            matrix2[i][j] = count;
                        }
                        else {
                            matrix2[i][j]=0;
                            count--;
                            positionOfZero=-1;
                        }
                        count++;
                    }
                }
            }
            Node start=new Node(matrix);
            Node end= new Node(matrix2);
            IDAStar idaStar=new IDAStar(start,end);

            idaStar.findPath();
        }
        else{
            System.err.println("Enter valid size!");
        }





    }
}
