package Model;

import java.lang.annotation.Target;

public class LionOrTiger extends Piece{
    public LionOrTiger(String name, int rank, Player ofplayer) {
        super(name, rank, ofplayer);
    }
    @Override
    public void move(Coordinate coordinate) {
        if(canJump(coordinate)) {

        }
    }
    private boolean canJump(Coordinate coordinate) {

    }
}
