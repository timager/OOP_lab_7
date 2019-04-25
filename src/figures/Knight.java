package figures;

import classes.ChessBoard;
import classes.Figure;

public class Knight extends Figure {
    @Override
    public String getImageName() {
        return "knight.png";
    }

    public Knight(int x, int y, COLORS color, ChessBoard chessBoard) {
        super(x, y, color, chessBoard);
    }

    @Override
    protected boolean check(int x, int y) {
        int difX = Math.abs(this.x - x);
        int difY = Math.abs(this.y - y);
        return (difX == 2 && difY == 1) || (difX == 1 && difY == 2);
    }
}
