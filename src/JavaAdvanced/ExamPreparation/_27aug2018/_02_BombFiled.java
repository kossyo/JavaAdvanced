package ExamPreparation._27aug2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_BombFiled {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(",");
        String[][] field = new String[size][size];
        fillMatrix(reader, size, field);


        int[] startPosition = findStartingPosition(field);
        int[] endPosition = findEndPosition(field);
        int[] currentPosition = startPosition;
        int bombsCount = findBombsCount(field);

        for (int i = 0; i < commands.length; i++) {

            if(bombsCount == 0){
                break;
            }
            String currentCommand = commands[i];
            currentPosition = movePlayer(field, currentPosition, currentCommand);

            if ("e".equals(field[currentPosition[0]][currentPosition[1]])){
                System.out.printf("END! %d bombs left on the field", bombsCount);
                return;
            }
            else if("B".equals(field[currentPosition[0]][currentPosition[1]])){
                System.out.println("You found a bomb!");
                field[currentPosition[0]][currentPosition[1]] = "+";
                bombsCount--;
            }
        }

        if(bombsCount == 0){
            System.out.print("Congratulations! You found all bombs!");
        }
        else{
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsCount, currentPosition[0], currentPosition[1]);
        }
    }

    private static int findBombsCount(String[][] field) {

        int bombsCount = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {

                if ("B".equals(field[i][j])){
                    bombsCount++;
                }
            }
        }
        return bombsCount;
    }

    private static int[] movePlayer(String[][] field, int[] currentPosition, String currentCommand) {

        int[] newPosition = new int[2];
        int currentPosition0 = currentPosition[0];
        int currentPosition1 = currentPosition[1];
        int[] currentPositionUnchanged = new int[2];
        currentPositionUnchanged[0] = currentPosition0;
        currentPositionUnchanged[1] = currentPosition1;

        switch (currentCommand){
            case "right":

                newPosition[0] = currentPosition[0];
                newPosition[1] = ++currentPosition[1];
                break;

            case "down":
                newPosition[0] = ++currentPosition[0];
                newPosition[1] = currentPosition[1];
                break;
            case "left":

                newPosition[0] = currentPosition[0];
                newPosition[1] = --currentPosition[1];
                break;
            case "up":

                newPosition[0] = --currentPosition[0];
                newPosition[1] = currentPosition[1];
                break;
        }


        try {
            String optionalCoordinates = (field[newPosition[0]][newPosition[1]]);
            newPosition[0] = newPosition[0];
            newPosition[1] = newPosition[1];
            return newPosition;
        }
        catch (IndexOutOfBoundsException iobe){
            return currentPositionUnchanged;
        }
    }

    private static int[] findEndPosition(String[][] field) {

        int [] endPosition = new int[2];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {

                if ("e".equals(field[i][j])){
                    endPosition[0] = i;
                    endPosition[1] = j;
                    break;
                }
            }
        }
        return endPosition;
    }

    private static int[] findStartingPosition(String[][] field) {

        int [] startingPosition = new int[2];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {

                if ("s".equals(field[i][j])){
                    startingPosition[0] = i;
                    startingPosition[1] = j;
                    break;
                }
            }
        }
        return startingPosition;
    }

    private static void fillMatrix(BufferedReader reader, int size, String[][] field) throws IOException {
        for (int i = 0; i < size; i++) {
            String[] line = reader.readLine().split(" ");
            field[i] = line;
        }
    }

}

