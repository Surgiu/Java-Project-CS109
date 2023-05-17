package Model;

public class Piece {
    private String name;//棋子的名字
    private int rank;//等级（从1到8）
    private Coordinate coordinate;//棋子的位置
    private Player player;//玩家的类型

    public Piece(String name, int rank, Player player, Coordinate coordinate) {
        this.name = name;
        this.rank = rank;
        this.player = player;
        this.coordinate = coordinate;
    }

    public void move(Coordinate target, Grid grid, Player player) {
        if (correctMovement(this.coordinate, target)
                && grid.notOccupiedByPlayer(target.getRow(), target.getCol(), player)
                && grid.getType().equals(Grid.Type.GROUND)) {
            this.setCoordinate(target);
        }
    }

    public boolean correctMovement(Coordinate start, Coordinate end) {
        return Coordinate.distance(start.getRow(), start.getCol(), end.getRow(), end.getCol()) == 1
                && Field.boundaryCheck(end);
    }

    public void eat(Piece target, Grid grid, Player player) {
        if (Field.eatable(this, target)) {
            move(target.getCoordinate(), grid, player);
            target = null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
