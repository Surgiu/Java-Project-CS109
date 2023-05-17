package Model;

//这个类就是所谓的“格子”
public class Grid {
    private int areaType;//地盘。0表示红方，1表示蓝方
    private Type type;//类型
    private Piece piece;
    private Coordinate coordinate;
    private int occupy;//当前占领的棋子。0代表未占领，-1代表红方占领，-2代表蓝方占领

    enum Type {
        RIVER, DENS, TRAP, GROUND//棋格的类型
    }

//    public boolean notOccupiedByPlayer(Grid target) {//没被占返回true
//        if (target.occupy == 0 || (this.occupy != target.occupy)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getAreaType() {
        return areaType;
    }

    public void setAreaType(int areaType) {
        this.areaType = areaType;
    }

    public Piece getPiece() {
        return piece;
    }

    public void add(Piece piece) {
        this.piece = piece;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getOccupy() {
        return occupy;
    }

    public void setOccupy(int occupy) {
        this.occupy = occupy;
    }

}
