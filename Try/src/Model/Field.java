package Model;


import java.util.ArrayList;

public class Field {
    private final int rowMax = 7;//棋盘的列数

    private final int colMax = 9;//棋盘的行数

    private Grid[][] grids = new Grid[rowMax][colMax];//棋盘

    private Player blue;
    private Player red ;

    public Field(Player blue, Player red) {
        this.blue = new Player(Player.Color.BLUE);
        this.red = new Player(Player.Color.RED);
    }

    public void init() {

    }
    public static boolean eatable(Piece p1, Piece p2) {
        return p1.getRank() >= p2.getRank();
    }

    public boolean checkWin() {

    }

    public Grid[][] getGrids() {
        return grids;
    }

    public void setGrids(Grid[][] grids) {
        this.grids = grids;
    }

}
