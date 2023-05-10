package Model;

public class Piece {
    private String name;//棋子的名字
    private int rank;//等级（从1到8）
    private Player Ofplayer;//棋子的主人

    public Piece(String name, int rank, Player ofplayer) {
        this.name = name;
        this.rank = rank;
        Ofplayer = ofplayer;
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
