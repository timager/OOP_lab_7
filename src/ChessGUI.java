import classes.ChessBoard;
import classes.Figure;
import figures.Bishop;
import figures.Knight;
import figures.Rook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessGUI extends JFrame {
    private int length;
    private JPanel[][] cells;
    private ChessBoard chessBoard;

    private void drawChessBoard() {
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(0, length));
        cells = new JPanel[length][length];
        JPanelListener listener = new JPanelListener();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                JPanel panel = new JPanel();
                if ((i % 2 == 0) == (j % 2 == 0)) {
                    panel.setBackground(Color.LIGHT_GRAY);
                } else {
                    panel.setBackground(Color.DARK_GRAY);
                }
                cells[i][j] = panel;
                container.add(cells[i][j]);
            }
        }
        container.addMouseListener(listener);
    }

    public class JPanelListener implements MouseListener {
        private Figure checkedFigure;


        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            for(int i=0;i<length;i++){
                for(int j=0;j<length;j++){
                    if(cells[i][j]==e.getComponent().getComponentAt(e.getX(), e.getY())){
                        checkedFigure = chessBoard.get(i,j);
                        System.out.println("Нажал "+i+","+j);
                    }
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for(int i=0;i<length;i++){
                for(int j=0;j<length;j++){
                    if(cells[i][j]==e.getComponent().getComponentAt(e.getX(), e.getY()) && checkedFigure != null){
                        checkedFigure.move(i,j);
                        System.out.println("Отпустил "+i+","+j);
                        redraw();
                    }
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private ChessGUI(int length) {
        super("Шахматы");
        this.length = length;
        this.setBounds(0, 0, length * 60, length * 60);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawChessBoard();

    }

    private void setFigures() {
        chessBoard.init(new Rook(0, 0, Figure.COLORS.WHITE, chessBoard));
        chessBoard.init(new Knight(1, 0, Figure.COLORS.WHITE, chessBoard));
        chessBoard.init(new Bishop(2, 0, Figure.COLORS.WHITE, chessBoard));
        chessBoard.init(new Rook(7, 0, Figure.COLORS.WHITE, chessBoard));
        chessBoard.init(new Knight(6, 0, Figure.COLORS.WHITE, chessBoard));
        chessBoard.init(new Bishop(5, 0, Figure.COLORS.WHITE, chessBoard));

        chessBoard.init(new Rook(0, 7, Figure.COLORS.BLACk, chessBoard));
        chessBoard.init(new Knight(1, 7, Figure.COLORS.BLACk, chessBoard));
        chessBoard.init(new Bishop(2, 7, Figure.COLORS.BLACk, chessBoard));
        chessBoard.init(new Rook(7, 7, Figure.COLORS.BLACk, chessBoard));
        chessBoard.init(new Knight(6, 7, Figure.COLORS.BLACk, chessBoard));
        chessBoard.init(new Bishop(5, 7, Figure.COLORS.BLACk, chessBoard));
    }

    private void drawFigures() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Figure figure = chessBoard.get(i, j);
                cells[i][j].removeAll();
                if (figure != null) {
                    drawFigure(figure);
                }
            }
        }
    }

    private void redraw() {
        Container container = this.getContentPane();
        drawFigures();
        container.validate();
        container.repaint();
    }

    private void drawFigure(Figure figure) {
        String color;
        if (figure.color == Figure.COLORS.WHITE) {
            color = "white";
        } else {
            color = "black";
        }
        String filename = "images/" + color + "/" + figure.getImageName();
        JLabel jLabel = new JLabel();
        jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(filename)));
        this.cells[figure.x][figure.y].add(jLabel);
    }

    public static void main(String[] args) {
        int length = 8;
        ChessGUI chess = new ChessGUI(length);
        chess.chessBoard = new ChessBoard(length);
        chess.setFigures();
        chess.redraw();
        chess.setVisible(true);
    }
}
