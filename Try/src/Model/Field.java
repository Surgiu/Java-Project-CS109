package Model;


public class Field {
    private final int rowMax = 7;//棋盘的列数

    private final int colMax = 9;//棋盘的行数

    private Grid[][] grids = new Grid[rowMax][colMax];//棋盘

    private final Player blue;
    private final Player red;

    public Field(Player blue, Player red) {
        this.blue = new Player(Player.Color.BLUE);
        this.red = new Player(Player.Color.RED);
    }

    public void init() {
        //上面都是蓝的
        blue.getPieceList().add(new LionOrTiger("tiger", 6, blue, new Coordinate(6, 0)));
        blue.getPieceList().add(new Elephant("elephant", 7, blue, new Coordinate(6, 2)));
        blue.getPieceList().add(new Piece("cat", 2, blue, new Coordinate(5, 1)));
        blue.getPieceList().add(new Piece("wolf", 4, blue, new Coordinate(4, 2)));
        blue.getPieceList().add(new Piece("leopard", 5, blue, new Coordinate(2, 2)));
        blue.getPieceList().add(new Piece("dog", 3, blue, new Coordinate(1, 1)));
        blue.getPieceList().add(new LionOrTiger("lion", 7, blue, new Coordinate(0, 0)));
        blue.getPieceList().add(new Rat("rat", 1, blue, new Coordinate(0, 3)));
        //下面都是红的
        red.getPieceList().add(new LionOrTiger("tiger", 6, red, new Coordinate(0, 8)));
        red.getPieceList().add(new Elephant("elephant", 7, red, new Coordinate(0, 6)));
        red.getPieceList().add(new Piece("cat", 2, red, new Coordinate(1, 7)));
        red.getPieceList().add(new Piece("wolf", 4, red, new Coordinate(2, 6)));
        red.getPieceList().add(new Piece("leopard", 5, red, new Coordinate(4, 6)));
        red.getPieceList().add(new Piece("dog", 3, red, new Coordinate(5, 7)));
        red.getPieceList().add(new LionOrTiger("lion", 7, red, new Coordinate(6, 8)));
        red.getPieceList().add(new Rat("rat", 1, red, new Coordinate(6, 8)));
        for (int i = 0; i < 2; i++) {
            for (int j = 2; j < 5; j++) {
                grids[i][j].setAreaType(1);
            }
        }
        for (int i = 7; i < 9; i++) {
            for (int j = 2; j < 5; j++) {
                grids[i][j].setAreaType(0);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 1; j < 3; j++) {
                grids[i][j].setType(Grid.Type.RIVER);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 4; j < 6; j++) {
                grids[i][j].setType(Grid.Type.RIVER);
            }
        }
        grids[0][4].setType(Grid.Type.DENS);
        grids[8][4].setType(Grid.Type.DENS);
        grids[0][2].setType(Grid.Type.TRAP);
        grids[0][4].setType(Grid.Type.TRAP);
        grids[1][3].setType(Grid.Type.TRAP);
        grids[8][4].setType(Grid.Type.TRAP);
        grids[7][3].setType(Grid.Type.TRAP);
        grids[8][4].setType(Grid.Type.TRAP);
        for (int i = 0; i < rowMax; i++) {
            for (int j = 0; j < colMax; j++) {
                if (!(grids[i][j].getType().equals(Grid.Type.DENS)
                        || grids[i][j].getType().equals(Grid.Type.RIVER)
                        || grids[i][j].getType().equals(Grid.Type.TRAP))) {
                    grids[i][j].setType(Grid.Type.GROUND);
                }
            }
        }
    }


    public static boolean boundaryCheck(Coordinate coordinate) {
        return !(coordinate.getCol() > 6 || coordinate.getRow() > 8);
    }

    public static boolean eatable(Piece p1, Piece p2) {
        return p1.getRank() >= p2.getRank();
    }

    public boolean checkWin(Player player) {
        if (player.getColor().equals(Player.Color.BLUE)) {
            return grids[0][3].notOccupiedByPlayer(0, 3, player);
        }
        return false;
    }

    public Grid[][] getGrids() {
        return grids;
    }

    public void setGrids(Grid[][] grids) {
        this.grids = grids;
    }
}
