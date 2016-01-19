/**
 * 
 * @author radoslav.tashev
 *
 */
public class Board {
    public static final int GAMEFIELD_COLS = 20;

    public static final int GAMEFIELD_ROWS = 15;

    private char[][] gameField;

    public char[][] getGameField() {
        return gameField;
    }

    // public void setGameField(char[][] value) { TODO : check if some1 can set field
    // gameField = value;
    // }

    public Board() {

        gameField = new char[GAMEFIELD_ROWS][GAMEFIELD_COLS];
        // fillField();
    }

    // private void fillField() {
    //
    // for (int i = 0; i < GAMEFIELD_ROWS; i++) {
    // for (int j = 0; j < GAMEFIELD_COLS; j++) {
    //
    // gameField[i][j] = ' ';
    // }
    // }
    //
    // }

    public void printField(char[][] fieldToBePrinted) {

        for (int i = 0; i < GAMEFIELD_ROWS; i++) {
            for (int j = 0; j < GAMEFIELD_COLS; j++) {

                System.out.print(fieldToBePrinted[i][j]);

            }

            System.out.println();
        }
    }

    public char[][] printFigToField(Figure fig) {

        // fillField();

        char[][] fieldToBePrinted = new char[GAMEFIELD_ROWS][GAMEFIELD_COLS]; // array that gets printed

        for (int i = 0; i < GAMEFIELD_ROWS; i++) {
            for (int j = 0; j < GAMEFIELD_COLS; j++) {

                fieldToBePrinted[i][j] = gameField[i][j]; // copying gamefield so all non-moving figures are printed
            }
        }

        for (int i = 0; i < fig.getHeight(); i++) { // changed from fig.getFig().length
            for (int j = 0; j < fig.getWidth(); j++) { // changed from fig.getFig()[i].length

                if (fieldToBePrinted[i + fig.getX()][j + fig.getY()] == '#') { // Added so blank spaces don't overwrite
                                                                               // already fallen figures
                    continue;
                }

                fieldToBePrinted[i + fig.getX()][j + fig.getY()] = fig.getFig()[i][j];

                if (!canMoveDown(fig)) { // copies the current figure (when it stops moving) to the gamefield

                    copyFigToField(fig);
                    break;
                }

            }
        }

        return fieldToBePrinted;
    }

    public boolean checkIfFigIsInBounds(Figure fig) { // TODO : has to be checked if correct

        int maxXValue = GAMEFIELD_ROWS - fig.getHeight();
        int maxYValue = GAMEFIELD_COLS - fig.getWidth();
        int minXandYValue = 0;

        return ((fig.getX() >= minXandYValue && fig.getX() < maxXValue)
                && (fig.getY() >= minXandYValue && fig.getY() <= maxYValue));

    }

    public void copyFigToField(Figure f) {

        if (!f.getIsMoving()) { // TODO : ask how you should checkIfFigIsInBounds

            for (int i = 0; i < f.getFig().length; i++) { // GAMEFIELD_ROWS
                for (int j = 0; j < f.getFig()[i].length; j++) { // GAMEFIELD_COLS
                    gameField[i + f.getX()][j + f.getY()] = f.getFig()[i][j];
                }
            }
        }

    }

    public boolean canMoveDown(Figure f) {

        if (!checkIfFigIsInBounds(f)) {
            f.setIsMoving(false);
            return false;
        }

        boolean[] figBottom = new boolean[f.getWidth()];

        for (int i = f.getHeight() - 1; i < f.getHeight(); i++) {
            for (int j = 0; j < f.getWidth(); j++) {
                if (gameField[i + f.getX() + 1][j + f.getY()] == '#' && f.getFig()[i][j] == '#') {
                    figBottom[j] = false;
                } else {
                    figBottom[j] = true;
                }
            }
        }

        for (boolean element : figBottom) {

            if (element == false) {
                f.setIsMoving(false);
                return false;
            }
        }

        return true;
    }
}
