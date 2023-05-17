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
        init();
    }

    public void init() {
        //上面都是蓝的
        grids[6][0].add(new LionOrTiger("tiger", 6, blue, new Coordinate(6, 0)));
        grids[6][2].add(new Piece("elephant", 7, blue, new Coordinate(6, 2)));
        grids[5][1].add(new Piece("cat", 2, blue, new Coordinate(5, 1)));
        grids[4][2].add(new Piece("wolf", 4, blue, new Coordinate(4, 2)));
        grids[2][2].add(new Piece("leopard", 5, blue, new Coordinate(2, 2)));
        grids[1][1].add(new Piece("dog", 3, blue, new Coordinate(1, 1)));
        grids[0][0].add(new LionOrTiger("lion", 7, blue, new Coordinate(0, 0)));
        grids[0][3].add(new Rat("rat", 1, blue, new Coordinate(0, 3)));
        //下面都是红的
        grids[0][8].add(new LionOrTiger("tiger", 6, red, new Coordinate(0, 8)));
        grids[0][6].add(new Piece("elephant", 7, red, new Coordinate(0, 6)));
        grids[1][7].add(new Piece("cat", 2, red, new Coordinate(1, 7)));
        grids[2][6].add(new Piece("wolf", 4, red, new Coordinate(2, 6)));
        grids[4][6].add(new Piece("leopard", 5, red, new Coordinate(4, 6)));
        grids[5][7].add(new Piece("dog", 3, red, new Coordinate(5, 7)));
        grids[6][8].add(new LionOrTiger("lion", 7, red, new Coordinate(6, 8)));
        grids[6][6].add(new Rat("rat", 1, red, new Coordinate(6, 8)));
        for (Grid[] grid : grids) {
            for (Grid value : grid) {
                if (value.getPiece().getPlayer().getColor().equals(Player.Color.BLUE)) {
                    value.setOccupy(-2);//设置占领信息
                }
            }
        }
        for (Grid[] grid : grids) {
            for (Grid value : grid) {
                if (value.getPiece().getPlayer().getColor().equals(Player.Color.RED)) {
                    value.setOccupy(-1);//设置占领信息
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 2; j < 5; j++) {
                grids[i][j].setAreaType(1);//设置地盘信息
            }
        }
        for (int i = 7; i < 9; i++) {
            for (int j = 2; j < 5; j++) {
                grids[i][j].setAreaType(0);//设置地盘信息
            }
        }
        //设置地图
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
        return !(coordinate.getCol() > 6 || coordinate.getRow() > 8 || coordinate.getCol() < 0 || coordinate.getRow() < 0);
    }

    public static boolean boundaryCheck(int row, int col) {
        return row > 6 || col > 8 || row < 0 || col < 0;
    }

    public static boolean eatable(Piece p1, Piece p2) {
        if (p1.correctMovement(p1.getCoordinate(), p2.getCoordinate())) {
            if (p1.getName().equals("rat")
                    && (p2.getName().equals("elephant") || p2.getName().equals("rat"))) {
                return true;
            } else {
                return p1.getRank() >= p2.getRank();
            }
        }
        return false;
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
