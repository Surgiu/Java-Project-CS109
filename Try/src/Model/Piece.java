package Model;

public class Piece{
    private String name;//棋子的名字
    private int rank;//等级（从1到8）
    private Player Ofplayer;//棋子的主人
    private Coordinate coordinate;//棋子的位置

    public Piece(String name, int rank, Player ofplayer) {
        this.name = name;
        this.rank = rank;
        Ofplayer = ofplayer;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void move(Coordinate target) {
        if(correctMovement(this.coordinate,target)) {
            this.setCoordinate(target);
        }
    }
    private boolean correctMovement(Coordinate start, Coordinate end) {

    }
    public void eat(Piece target) {
        if(Field.eatable(this,target)) {

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

    public Player getOfplayer() {
        return Ofplayer;
    }

    public void setOfplayer(Player ofplayer) {
        Ofplayer = ofplayer;
    }
}
