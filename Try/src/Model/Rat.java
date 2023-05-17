package Model;

public class Rat extends Piece {

    public Rat(String name, int rank, Player ofplayer, Coordinate coordinate) {
        super(name, rank, ofplayer, coordinate);
    }

    @Override
    public boolean correctMovement(Grid start, Grid end,Field field) {
        if (Coordinate.distance(start.getCoordinate().getRow(), start.getCoordinate().getCol(), end.getCoordinate().getRow(), end.getCoordinate().getCol()) == 1
                && !(end.getType().equals(Grid.Type.RIVER))) {
            if (end.getOccupy() == 0) {
                if (start.getType().equals(Grid.Type.GROUND)) {
                    return true;
                } else if (start.getType().equals(Grid.Type.TRAP)) {
                    if (end.getPiece() != null) {
                        return false;
                    } else {
                        return true;
                    }
                }
            } else if (end.getOccupy() == start.getOccupy()) {
                return false;
            } else {
                return Field.eatable(this, end.getPiece());
            }
        }
        return false;
    }
}
