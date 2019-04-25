package figures;

import classes.ChessBoard;
import classes.Figure;

public class Bishop extends Figure {
    @Override
    public String getImageName() {
        return "bishop.png";
    }

    public Bishop(int x, int y, COLORS color, ChessBoard chessBoard) {
        super(x, y, color, chessBoard);
    }

    @Override
    protected boolean check(int x, int y) {
        return Math.abs(this.x - x) == Math.abs(this.y - y);
    }
}
