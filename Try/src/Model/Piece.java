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

    //能移动的条件：1.移动距离为1；2.目的地没有被己方或更高级的敌方占领；3.目标不能是河；4.如果在陷阱中，目的地只要有棋就不能移动
    public void move(Coordinate target, Grid grid, Player player) {
        if (correctMovement(this.coordinate, target)
                && grid.notOccupiedByPlayer(target.getRow(), target.getCol(), player)
                && grid.getType().equals(Grid.Type.GROUND)) {
            this.setCoordinate(target);
        }
    }

    public boolean correctMovement(Grid start, Grid end,Field field) {
        return Coordinate.distance(start.getCoordinate().getRow(), start.getCoordinate().getCol(), end.getCoordinate().getRow(), end.getCoordinate().getCol()) == 1;
    }
    public boolean correctMovement(Coordinate start, Coordinate end) {
        return Coordinate.distance(start.getRow(), start.getCol(), end.getRow(), end.getCol()) == 1;
    }

    public void eat(Piece target, Grid grid, Player player) {
        if (Field.eatable(this, target)) {
            move(target.getCoordinate(), grid, player);
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
