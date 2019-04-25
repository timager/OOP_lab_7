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

    private boolean checkPath(int x, int y) {
        if (this.x == x) {
            if (y < this.y) {
                for (y = y + 1; y < this.y; y++) {
                    if (this.chessBoard.get(x, y) != null) {
                        return false;
                    }
                }
            } else {
                for (y = y - 1; y > this.y; y--) {
                    if (this.chessBoard.get(x, y) != null) {
                        return false;
                    }
                }
            }
        } else {
            if (this.x > x) {
                for (x = x + 1; x < this.x; x++) {
                    if (this.chessBoard.get(x, y) != null) {
                        return false;
                    }
                }
            } else {
                for (x = x - 1; x > this.x; x--) {
                    if (this.chessBoard.get(x, y) != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    protected boolean check(int x, int y) {
        return (this.x == x || this.y == y) && checkPath(x, y);
    }
}
