package Model;


public class LionOrTiger extends Piece {
    public LionOrTiger(String name, int rank, Player ofplayer, Coordinate coordinate) {
        super(name, rank, ofplayer, coordinate);
    }

    /*能移动的条件
    如果在陆地且不临河：与父类完全相同
    如果临河：1.只能走直线；2.起点和终点之间都是河；3.不能走斜线；4.如果路线上有棋子则不能通过；5.如果对面有己方棋子或更高级的敌方则不能通过
     */
    @Override
    public boolean correctMovement(Grid start, Grid end, Field field) {
        if (end.getType().equals(Grid.Type.RIVER)) {
            return false;
        }
        int count=0;
        for (int i = start.getCoordinate().getRow() - 1; i <= start.getCoordinate().getRow() + 1; i++) {
            for (int j = start.getCoordinate().getCol() - 1; j <= start.getCoordinate().getCol() + 1; j++) {
                if (Field.boundaryCheck(i, j)) {
                    if (field.getGrids()[i][j].getType().equals(Grid.Type.GROUND)) {
                        return direct(start.getCoordinate(), end.getCoordinate()) == 1;
                    }
                }
            }
        }
        if()
    }

    private int direct(Coordinate start, Coordinate end) {
        return Math.abs(start.getRow() - end.getRow()) + Math.abs(start.getCol() - end.getCol());
    }
}
