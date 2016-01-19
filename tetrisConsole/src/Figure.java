import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JRootPane;

public class Figure {

    private int x;

    private int y;

    protected char[][] fig;

    private boolean isMoving = true;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char[][] getFig() {
        return fig;
    }

    public void setFig(char[][] figure) {
        this.fig = figure;
    }

    public boolean getIsMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public Figure() {

        x = 1;
        y = 0;

    }

    // check if it should return fig.length
    public int getHeight() {

        return fig.length;

    }

    public int getWidth() {

        return fig[0].length;
    }

    public void rotateCounterClockWise() {

        int w = fig.length;
        int h = fig[0].length;

        char[][] newFig = new char[h][w];

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {

                newFig[i][j] = fig[j][h - i - 1];
            }
        }
        fig = newFig;

    }

    public void rotateClockWise() {

        int w = fig.length;
        int h = fig[0].length;

        char[][] newFig = new char[h][w];

        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {

                newFig[i][j] = fig[w - j - 1][i];
            }
        }

        fig = newFig;

    }

    public void printFig(char[][] figToBePrinted) {

        for (int i = 0; i < figToBePrinted.length; i++) {
            for (int j = 0; j < figToBePrinted[i].length; j++) {

                System.out.print(figToBePrinted[i][j]);

            }
            System.out.println();
        }

    }

    private static List<Class<? extends Figure>> listOfFigs = new ArrayList<>();

    static {
        listOfFigs.add(Ifig.class);
        listOfFigs.add(Lfig.class);
        listOfFigs.add(Ofig.class);
        listOfFigs.add(Sfig.class);
        listOfFigs.add(Tfig.class);
    }

    private static Random rand = new Random();

    public static Figure returnRandomFigure() {

        int randNum = rand.nextInt(listOfFigs.size());

        try {
            return listOfFigs.get(randNum).newInstance();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static void getCh() { // TODO : check how it works
        final JFrame frame = new JFrame();
        synchronized (frame) {
            frame.setUndecorated(true);
            frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    synchronized (frame) {
                        frame.setVisible(false);
                        frame.dispose();
                        frame.notify();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }
            });
            frame.setVisible(true);
            try {
                frame.wait();
            } catch (InterruptedException e1) {
            }
        }
    }

    public static void main(String... strings) {

        Figure l = returnRandomFigure();

        Board b = new Board();
        // l.setY(7);
        // l.setX(13);
        // b.canMoveDown(l);
        // b.printField(b.printFigToField(l));
        // b.printField(b.getGameField());
        // b.printField(b.getGameField());

        while (true) {

            // b.printField(b.getGameField());
            b.printField(b.printFigToField(l));
            if (!b.canMoveDown(l)) {
                b.printField(b.printFigToField(l));
                l = returnRandomFigure();
                if (!b.canMoveDown(l)) {
                    System.out.println("End of game");
                    break;
                }

            }
            l.setX(l.getX() + 1);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }

    }

}
