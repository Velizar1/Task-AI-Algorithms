import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Board board=new Board();
        MinMaxAlg minMaxAlg=new MinMaxAlg();
        Scanner scanner=new Scanner(System.in);

        //board.setPlayer(0,0,2);
        //board.setPlayer(2,0,1);

        board.print();
        for (int i = 0; i <4 ; i++) {

            System.out.println( "Enter coordinates for X :");
            board.setPlayer(scanner.nextInt(),scanner.nextInt(),1);
            int[] newPoint=minMaxAlg.alphaBeta(board,9-i,-100,100,2);
            System.out.println(newPoint[0]);
            board.setPlayer(newPoint[1],newPoint[2],2);
            board.print();

            if(minMaxAlg.hasMinWon(board)){
                System.out.println("O has won");
                break;
            }

            if(minMaxAlg.hasMaxWon(board)){
                System.out.println("X has won");
                break;
            }
        }
    }
}
