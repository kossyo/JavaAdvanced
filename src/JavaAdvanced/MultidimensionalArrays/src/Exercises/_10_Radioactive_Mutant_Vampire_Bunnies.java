package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10_Radioactive_Mutant_Vampire_Bunnies {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        char[][] field = new char[dimensions[0]][dimensions[1]];
        int[] playerLocation = new int[2];
        readMatrix(field);
        localizePlayer(field, playerLocation);
        char[] commands = reader.readLine().toCharArray();
        boolean playerWon = false;
        boolean playerDead = false;


        for (int i = 0; i < commands.length; i++) {

            char command = commands[i];

            int[] newLoc = new int[2];

            //if is inside field
            if (isDestLocInsideField(dimensions, command, playerLocation, newLoc)) {

                //if new destination has a Bunny on it
                if (field[newLoc[0]][newLoc[1]] == 'B') {

                    playerDead = true;
                } else {

                    field[newLoc[0]][newLoc[1]] = 'P';
                }
                field[playerLocation[0]][playerLocation[1]] = '.';
                playerLocation = newLoc;
            } else {

                field[playerLocation[0]][playerLocation[1]] = '.';
                playerWon = true;

            }
            spread(field);

            // if got hit by a Bunny
            if (field[playerLocation[0]][playerLocation[1]] == 'B' && !playerWon) {

                playerDead = true;
            }

            if (playerDead || playerWon) {

                break;
            }
//            printField(field);
//            System.out.println();
        }

        printField(field);
        if (playerWon && !playerDead) {
            System.out.print("won: ");
        }
        else{
            System.out.print("dead: ");
        }
        System.out.print(playerLocation[0] + " " + playerLocation[1]);

    }

    private static void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    private static void spread(char[][] field) {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {

                if (field[i][j] == 'B') {


                    try {
                        if (field[i - 1][j] == '.' ||field[i - 1][j] == 'P') {
                            field[i - 1][j] = 'b';
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                        ;
                    }
                    try {
                        if (field[i][j + 1] == '.' || field[i][j + 1] == 'P') {
                            field[i][j + 1] = 'b';
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                        ;
                    }
                    try {
                        if (field[i + 1][j] == '.' || field[i + 1][j] == 'P') {
                            field[i + 1][j] = 'b';
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                        ;
                    }
                    try {
                        if (field[i][j - 1] == '.' || field[i][j - 1] == 'P') {
                            field[i][j - 1] = 'b';
                        }
                    } catch (IndexOutOfBoundsException ignored) {
                        ;
                    }
                }
            }
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {

                if (field[i][j] == 'b') {
                    field[i][j] = 'B';
                }
            }
        }
    }

    private static boolean isDestLocInsideField(int[] dimensions, char command, int[] playerLocation, int[] newLoc) {

        switch (command) {
            case 'U':
                if (playerLocation[0] - 1 >= 0) {
                    newLoc[0] = playerLocation[0] - 1;
                    newLoc[1] = playerLocation[1];
                    return true;
                }
                return false;
            case 'R':
                if (playerLocation[1] + 1 < dimensions[1]) {
                    newLoc[0] = playerLocation[0];
                    newLoc[1] = playerLocation[1] + 1;
                    return true;
                }
                return false;
            case 'D':
                if (playerLocation[0] + 1 < dimensions[0]) {
                    newLoc[0] = playerLocation[0] + 1;
                    newLoc[1] = playerLocation[1];
                    return true;
                }
                return false;
            case 'L':
                if (playerLocation[1] - 1 >= 0) {
                    newLoc[0] = playerLocation[0];
                    newLoc[1] = playerLocation[1] - 1;
                    return true;
                }
                return false;
        }
        return false;
    }

    private static void readMatrix(char[][] field) throws IOException {

        for (int i = 0; i < field.length; i++) {
            field[i] = reader.readLine().toCharArray();
        }
    }

    private static void localizePlayer(char[][] field, int[] location) {

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 'P') {
                    location[0] = i;
                    location[1] = j;
                    break;
                }
            }
        }
    }
}
