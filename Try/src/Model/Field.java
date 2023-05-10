package Model;


public class Field implements PieceMethods{
    private final int rowMax= 7;
    //棋盘的列数
    private final int colMax =9;
    //棋盘的行数
    private Grid[][] grids = new Grid[rowMax][colMax];
    //棋盘
    public boolean eatable(Piece p1,Piece p2) {
        return p1.getRank()>= p2.getRank();
    }
    public void eat(Piece p1, Piece p2) {

    }
    public void init(){

    }

}
