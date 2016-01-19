import java.util.ArrayList;
import java.util.Random;

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

    public static char[][] returnRandomFigure() {

        ArrayList<Figure> listOfFigs = new ArrayList<Figure>();
        listOfFigs.add(new Ifig());
        listOfFigs.add(new Lfig());
        listOfFigs.add(new Ofig());
        listOfFigs.add(new Sfig());
        listOfFigs.add(new Tfig());

        Random rand = new Random();

        int randNum = rand.nextInt(5);

        switch (randNum) {
            case 0:
                return listOfFigs.get(0).getFig();
            case 1:
                return listOfFigs.get(1).getFig();
            case 2:
                return listOfFigs.get(2).getFig();
            case 3:
                return listOfFigs.get(3).getFig();
            case 4:
                return listOfFigs.get(4).getFig();
            default:
                break;
        }

        return null;
    }

    public static void main(String... strings) {

        Figure l = new Figure();
        l.setFig(returnRandomFigure());
        Board b = new Board();

        l.setY(7);
        int x = 0;
        // l.setX(13);
        // b.canMoveDown(l);
        // b.printField(b.printFigToField(l));
        // b.printField(b.getGameField());
        // b.printField(b.getGameField());

        for (;;) {

            b.printField(b.getGameField());
            b.printField(b.printFigToField(l));
            if (!b.canMoveDown(l)) {
                b.printField(b.printFigToField(l));
                l.setFig(returnRandomFigure());
                break;
            }
            l.setX(x++);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }

    }

}
