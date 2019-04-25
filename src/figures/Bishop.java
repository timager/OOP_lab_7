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

    private boolean checkPath(int x, int y) {

        if(x>this.x){
            if(y>this.y){
                for(x=x-1,y=y-1;x>this.x&&y>this.y;x--,y--){
                    if (this.chessBoard.get(x, y) != null) {
                        return false;
                    }
                }
            }
            else{
                for(x=x-1,y=y+1;x>this.x&&y<this.y;x--,y++){
                    if (this.chessBoard.get(x, y) != null) {
                        return false;
                    }
                }
            }
        }
        else {
            if(y>this.y){
                for(x=x+1,y=y-1;x<this.x&&y>this.y;x++,y--){
                    if (this.chessBoard.get(x, y) != null) {
                        return false;
                    }
                }
            }
            else{
                for(x=x+1,y=y+1;x<this.x&&y<this.y;x++,y++){
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
        return (Math.abs(this.x - x) == Math.abs(this.y - y)) && checkPath(x, y);
    }
}
