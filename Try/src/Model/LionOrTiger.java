package Model;


public class LionOrTiger extends Piece {
    public LionOrTiger(String name, int rank, Player ofplayer, Coordinate coordinate) {
        super(name, rank, ofplayer, coordinate);
    }

    @Override
    public void move(Coordinate target, Grid grid, Player player) {
        if (correctMovement(this.getCoordinate(), target)) {

        }
    }

    @Override
    public boolean correctMovement(Grid start, Grid end, Field field) {
        if (end.getType().equals(Grid.Type.RIVER)) {
            return false;
        }
        for (int i = start.getCoordinate().getRow() - 1; i <= start.getCoordinate().getRow() + 1; i++) {
            for (int j = start.getCoordinate().getCol() - 1; j <= start.getCoordinate().getCol() + 1; j++) {
                if (Field.boundaryCheck(i, j)) {
                    if (field.getGrids()[i][j].getType().equals(Grid.Type.GROUND)) {
                        return direct(start.getCoordinate(), end.getCoordinate()) == 1;
                    }
                }
            }
        }

    }

    private int direct(Coordinate start, Coordinate end) {
        return Math.abs(start.getRow() - end.getRow()) + Math.abs(start.getCol() - end.getCol());
    }
}
