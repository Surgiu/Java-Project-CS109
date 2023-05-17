package Model;

public class Rat extends Piece {

    public Rat(String name, int rank, Player ofplayer, Coordinate coordinate) {
        super(name, rank, ofplayer, coordinate);
    }

    @Override
    public void move(Grid grid) {
        if (correctMovement(this.getCoordinate(), grid.getCoordinate())
                && grid.notOccupiedByPlayer(grid)){
            this.setCoordinate(grid.getCoordinate());
        }
    }

    @Override
    public void eat(Piece target, Grid grid, Player player) {
        if (target.getName().equals("elephant")) {
            move(grid);
            //还没有移除被吃者
        }
    }
}
