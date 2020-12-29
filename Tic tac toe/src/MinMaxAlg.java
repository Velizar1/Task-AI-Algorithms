import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.List;

public class MinMaxAlg {

    private List<Board> boards;
    private Board board;


    public MinMaxAlg(){
        board=new Board();
    }
    public Board getBoard(){
        return board;
    }
    public boolean hasMaxWon(Board board){

        if ((board.getTable()[0][0] == board.getTable()[1][1] && board.getTable()[0][0] == board.getTable()[2][2]
                && board.getTable()[0][0] == 1) || (board.getTable()[0][2] == board.getTable()[1][1]
                && board.getTable()[0][2] == board.getTable()[2][0] && board.getTable()[0][2] == 1)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board.getTable()[i][0] == board.getTable()[i][1]
                    && board.getTable()[i][0] == board.getTable()[i][2] && board.getTable()[i][0] == 1)
                    || (board.getTable()[0][i] == board.getTable()[1][i]
                    && board.getTable()[0][i] == board.getTable()[2][i] && board.getTable()[0][i] == 1))) {
                return true;
            }
        }
        return false;
    }

    private List<Board> generatePositionsForPlayer(int player,Board board){
        List<Board> generatedTables=new ArrayList<>();

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                if(board.getTable()[i][j]==0){
                    Board help=new Board(board);
                    help.setPlayer(i,j,player);
                    generatedTables.add(help);
                }
            }
        }
        return generatedTables;
    }

    public boolean hasMinWon(Board board){

        if ((board.getTable()[0][0] == board.getTable()[1][1]
                && board.getTable()[0][0] == board.getTable()[2][2] && board.getTable()[0][0] == 2)
                || (board.getTable()[0][2] == board.getTable()[1][1]
                && board.getTable()[0][2] == board.getTable()[2][0] && board.getTable()[0][2] == 2)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board.getTable()[i][0] == board.getTable()[i][1]
                    && board.getTable()[i][0] == board.getTable()[i][2] && board.getTable()[i][0] == 2)
                    || (board.getTable()[0][i] == board.getTable()[1][i]
                    && board.getTable()[0][i] == board.getTable()[2][i] && board.getTable()[0][i] == 2))) {
                return true;
            }
        }
        return false;
    }

    public int []alphaBeta(Board board,int depth,int alpha,int beta,int player){

        int bestRow = -1;
        int bestCol = -1;
        int value;
        List<Board> posiblePossitions=generatePositionsForPlayer(player,board);
        if (hasMaxWon(board)) return new int[]{10-depth,board.getLastI() ,board.getLastJ()};
        else if (hasMinWon(board)) return new int[]{-10-depth,board.getLastI() ,board.getLastJ()};
        if(depth==0||posiblePossitions.isEmpty()){
            return new int[]{0,bestRow,bestCol};
        }
        if(player==1){
            value=-100;
            for(Board point:posiblePossitions) {
                int[]help=alphaBeta(point,depth-1,alpha,beta,2);
                value=Math.max(value,help[0]);
               // System.out.println(value  + " "+alpha);
                if(value>alpha){
                    alpha=value;
                    bestRow=point.getLastI();
                    bestCol=point.getLastJ();
                }
                if(alpha>=beta)break;
            }
            return new int[]{alpha,bestRow,bestCol};
        }
        else {
            value=100;
            for (Board point:posiblePossitions){
                int[]help=alphaBeta(point,depth-1,alpha,beta,1);
                value=Math.min(value,help[0]);

                if(value<beta){
                    beta=value;
                    bestRow=point.getLastI();
                    bestCol=point.getLastJ();
                }
                if(alpha>=beta)break;
            }
            return new int[]{beta,bestRow,bestCol};
        }

    }

}
