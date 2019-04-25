package figures;

import classes.ChessBoard;
import classes.Figure;

public class Rook extends Figure {
    @Override
    public String getImageName() {
        return "rook.png";
    }

    public Rook(int x, int y, COLORS color, ChessBoard chessBoard) {
        super(x, y, color, chessBoard);
    }

    @Override
    protected boolean check(int x, int y) {
        return this.x == x || this.y == y;
    }
}
