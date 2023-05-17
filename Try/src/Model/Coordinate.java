package Model;

public class Coordinate {
    private int row;//横坐标
    private int col;//纵坐标

    public Coordinate(int col, int row) {
        this.row = row;
        this.col = col;
    }
    public Coordinate() {

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public static int distance(int rFrom, int cFrom, int rTo, int cTo) {
        return Math.abs(rFrom - rTo) + Math.abs(cFrom - cTo);
    }
}
