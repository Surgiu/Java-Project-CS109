package Model;

import java.util.ArrayList;

public class Player {
    public Player(Color color) {
    }
    private Color color;

    enum Color {
        RED, BLUE
    }

    private ArrayList<Piece> pieceList = new ArrayList<>();

    public ArrayList<Piece> getPieceList() {
        return pieceList;
    }

    public Color getColor() {
        return color;
    }
}
