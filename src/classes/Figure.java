package classes;

public abstract class Figure {
    public enum COLORS {
        BLACk,
        WHITE
    }

    public abstract String getImageName();

    public int x, y;

    public COLORS color;

    private ChessBoard chessBoard;

    public Figure(int y, int x, COLORS color, ChessBoard chessBoard) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.chessBoard = chessBoard;
    }

    private boolean baseCheck(int x, int y) {
        if (!chessBoard.existCell(x, y)) {
            return false;
        }
        Figure figureOnBoard = chessBoard.get(x, y);
        if (figureOnBoard == null) {
            return true;
        } else {
            return figureOnBoard.color != this.color;
        }
    }

    protected abstract boolean check(int x, int y);

    private boolean fullCheck(int x, int y) {
        return baseCheck(x, y) && check(x, y);
    }

    public void move(int x, int y) {
        if (fullCheck(x, y)) {
            chessBoard.set(this, x, y);
        }
        else {
            System.out.println("Так ходить нельзя");
        }
    }
}
