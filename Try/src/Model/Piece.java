package Model;

public class Piece {
    private String name;//棋子的名字
    private int rank;//等级（从1到8）
    private Coordinate coordinate;//棋子的位置
    private final Player player;//玩家的类型

    public Piece(String name, int rank, Player player, Coordinate coordinate) {
        this.name = name;
        this.rank = rank;
        this.player = player;
        this.coordinate = coordinate;
    }

    //能移动的条件：1.移动距离为1；2.目的地没有被己方或更高级的敌方占领；3.目的地不能是河；4.如果在陷阱中，目的地只要有棋就不能移动
    public void move(Grid grid) {
        if (correctMovement(this.coordinate, grid.getCoordinate())) {
            this.setCoordinate(grid.getCoordinate());
            if (this.player.getColor().equals(Player.Color.BLUE)) {
                grid.setOccupy(-1);
            } else {
                grid.setOccupy(-2);
            }
        }
    }

    public boolean correctMovement(Grid start, Grid end, Field field) {
        if (Coordinate.distance(start.getCoordinate().getRow(), start.getCoordinate().getCol(), end.getCoordinate().getRow(), end.getCoordinate().getCol()) == 1
                && end.notOccupiedByPlayer(end)
                && !(end.getType().equals(Grid.Type.RIVER))) {
            if (start.getType().equals(Grid.Type.GROUND)) {
                return true;
            } else if (start.getType().equals(Grid.Type.DENS)) {
                if (end.getPiece() != null) {
                    return false;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean correctMovement(Coordinate start, Coordinate end) {
        return Coordinate.distance(start.getRow(), start.getCol(), end.getRow(), end.getCol()) == 1;
    }

    public void eat(Piece target, Grid grid, Player player) {
        if (Field.eatable(this, target)) {
            move(grid);
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

    public Player getPlayer() {
        return player;
    }
}
