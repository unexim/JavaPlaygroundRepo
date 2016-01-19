import java.awt.AWTException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public char[][] field = new char[20][15]; // 20-rows 15-cols

    public char[][] scene = new char[20][15];

    public int x = 0;

    public int y = 6;

    public char[][] Lfig = new char[][] {{' ', '#', ' ', ' '}, {' ', '#', ' ', ' '}, {' ', '#', ' ', ' '},
            {' ', '#', '#', ' '}};

    public char[][] rotatedLfig = new char[][] {{' ', ' ', ' ', '#'}, {'#', '#', '#', '#'}, {' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' '}};

    public char[][] Ifig = new char[][] {{' ', '#', ' ', ' '}, {' ', '#', ' ', ' '}, {' ', '#', ' ', ' '},
            {' ', '#', ' ', ' '}};

    public char[][] rotatedIfig = new char[][] {{' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' '}, {'#', '#', '#', '#'},
            {' ', ' ', ' ', ' '}};

    public char[][] Ofig = new char[][] {{' ', ' ', ' ', ' '}, {' ', '#', '#', ' '}, {' ', '#', '#', ' '},
            {' ', ' ', ' ', ' '}};

    public char[][] Sfig = new char[][] {{' ', ' ', '#', ' '}, {' ', '#', '#', ' '}, {' ', '#', ' ', ' '},
            {' ', ' ', ' ', ' '}};

    public char[][] rotatedSfig = new char[][] {{' ', ' ', ' ', ' '}, {' ', '#', '#', ' '}, {' ', ' ', '#', '#'},
            {' ', ' ', ' ', ' '}};

    public char[][] randomFigSelect() {

        ArrayList<char[][]> listOfFigs = new ArrayList<char[][]>();
        listOfFigs.add(Lfig);
        listOfFigs.add(rotatedLfig);
        listOfFigs.add(Ifig);
        listOfFigs.add(rotatedIfig);
        listOfFigs.add(Ofig);
        listOfFigs.add(Sfig);
        listOfFigs.add(rotatedSfig);

        Random rand = new Random();

        int randNum = rand.nextInt(7);

        switch (randNum) {
            case 0:
                return listOfFigs.get(0);
            case 1:
                return listOfFigs.get(1);
            case 2:
                return listOfFigs.get(2);
            case 3:
                return listOfFigs.get(3);
            case 4:
                return listOfFigs.get(4);
            case 5:
                return listOfFigs.get(5);
            case 6:
                return listOfFigs.get(6);
            default:
                break;
        }

        return listOfFigs.get(1);
    }

    public void FigureMovement(char input) {

        if (input == 'a' || input == 'A') {

            y--;

        } else if (input == 'd' || input == 'D') {

            y++;

        } else if (input == '\n') {

            x++;
        } else {

            x++;
        }

    }

    public void printField() {

        char[][] figToBeUsed = randomFigSelect();
        clearField();

        System.out.println();

        copyFigToField(figToBeUsed);

        for (int i = 0; i < field.length; ++i) {
            for (int j = 0; j < field[i].length; ++j) {

                System.out.print(field[i][j]);
            }

            System.out.println();
        }

        // fillField();
        x++;

    }

    public void copyFigToField(char[][] fig) {

        for (int i = 0; i < fig.length; ++i) {
            for (int j = 0; j < fig[i].length; ++j) {

                field[i + x][j + y] = fig[i][j];

            }
        }
    }

    public void clearField() {

        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 15; ++j) {

                field[i][j] = ' ';
            }
        }
    }

    public void copyFieldToScene() {

        for (int i = 0; i < 20; ++i) {
            for (int j = 0; j < 15; ++j) {

                field[i][j] = scene[i][j];
            }

        }

    }

    public static void main(String[] args) throws AWTException {

        Scanner scr = new Scanner(System.in);
        // Robot r = new Robot();
        Main m = new Main();
        m.printField();

        for (int i = 0; i < 10; i++) {
            m.FigureMovement(scr.next().charAt(0));
            // r.keyPress(KeyEvent.VK_ENTER);
            // r.keyRelease(KeyEvent.VK_ENTER);
            m.printField();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

    }

}
