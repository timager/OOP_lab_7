package classes;

public class ChessBoard {
    public int length;
    private Figure[][] positions;

    public ChessBoard(int length) {
        this.length = length;
        this.positions = new Figure[length][length];
    }

    public Figure get(int x, int y) {
        return positions[x][y];
    }

    boolean existCell(int x, int y) {
        return (length > x && length > y);
    }

    public void set(Figure figure, int x, int y) {
        positions[figure.x][figure.y] = null;
        positions[x][y] = figure;
        figure.x = x;
        figure.y = y;
    }

    public void init(Figure figure){
        positions[figure.x][figure.y] = figure;
    }
}

