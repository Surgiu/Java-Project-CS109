package Model;

public class Rat extends Piece {

    public Rat(String name, int rank, Player ofplayer, Coordinate coordinate) {
        super(name, rank, ofplayer, coordinate);
    }

    @Override
    public void move(Coordinate target, Grid grid, Player player) {
        if (correctMovement(this.getCoordinate(), target)
                && grid.notOccupiedByPlayer(target.getRow(), target.getCol(), player)) {
            this.setCoordinate(target);
        }
    }

    @Override
    public void eat(Piece target, Grid grid, Player player) {
        if (target.getName().equals("elephant")) {
            move(target.getCoordinate(), grid, player);
            //还没有移除被吃者
        }
    }
}
