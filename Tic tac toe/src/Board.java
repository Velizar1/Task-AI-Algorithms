public class Board {

    private int [][] table;
    /*private final int  XPlayer=2;
    private final int  YPlayer=1;*/
    private int lastI;
    private int lastJ;

    public int getLastI() {
        return lastI;
    }

    public int getLastJ() {
        return lastJ;
    }

    public Board() {
        table=new int[3][3];
    }

    public  Board(Board board){
       makeCopy(board.getTable());
    }
    public Board(int[][] table) {
        this.table = table;
    }

    private int[][] makeCopy(int[][] array){
        table=new int[array.length][];

        for(int row=0; row< 3; ++row){
            table[row]=new int[array[row].length];
            for(int col=0; col< 3; ++col){
                table[row][col]=array[row][col];
            }
        }
        return table;
    }
    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }

    public void setPlayer(int i,int j,int player){
        if(table[i][j]==0) {
            lastI = i;
            lastJ = j;
            table[i][j] = player;
        }
    }
    public void  print(){
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                if(table[i][j]==1){
                    System.out.print("| X ");
                }
                else if(table[i][j]==2){
                    System.out.print("| O ");
                }
                else System.out.print("|   ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }
}
