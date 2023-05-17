package Model;

//这个类就是所谓的“格子”
public class Grid {
    private int areaType;//地盘。0表示红方，1表示蓝方
    private Type type;//类型
    private Piece piece;
    Coordinate coordinate;

    enum Type {
        RIVER, DENS, TRAP, GROUND//棋格的类型
    }

    public boolean notOccupiedByPlayer(int row, int col, Player player) {
        for (int i = 0; i < player.getPieceList().size(); i++) {
            boolean r = row == player.getPieceList().get(i).getCoordinate().getRow();
            boolean c = col == player.getPieceList().get(i).getCoordinate().getCol();
            if (r && c) {
                return false;
            }
        }
        return true;
    }

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
}
