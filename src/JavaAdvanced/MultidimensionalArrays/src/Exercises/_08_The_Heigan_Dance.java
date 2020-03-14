
package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _08_The_Heigan_Dance {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] matrix = new char[15][15];
        matrix[7][7] = 'p';

        int playerHealth = 18500;
        double heiganHealth = 3000000;
        double damage = Double.parseDouble(reader.readLine());

        boolean isPlayerAlive = true;
        boolean isHeiganAlive = true;

        int playerPositionRow = 7;
        int playerPositionCol = 7;

        String previousCommand = "";
        int prevCommandRow = 0;
        int prevCommandCol = 0;

        while (isPlayerAlive && isHeiganAlive) {

            heiganHealth -= damage;
            isHeiganAlive = heiganHealth > 0;


            String[] cmdArgs = reader.readLine().split("\\s");
            String command = cmdArgs[0];
            int targetRow = Integer.parseInt(cmdArgs[1]);
            int targetCol = Integer.parseInt(cmdArgs[2]);

            if ("Cloud".equals(previousCommand) && isPlayerInRange(playerPositionRow, playerPositionCol, prevCommandRow, prevCommandCol)) {
                playerHealth -= 3500;
                isPlayerAlive = playerHealth > 0;
            }

            if (!isHeiganAlive || !isPlayerAlive){
                break;
            }

            if (isPlayerInRange(playerPositionRow, playerPositionCol, targetRow, targetCol)) {

                if (!isPlayerInRange(playerPositionRow - 1, playerPositionCol, targetRow, targetCol) && playerPositionRow - 1 >= 0
                ) {
                    playerPositionRow--;

                } else if (!isPlayerInRange(playerPositionRow, playerPositionCol + 1, targetRow, targetCol) && playerPositionCol + 1 <= 14
                ) {
                    playerPositionCol++;


                } else if (!isPlayerInRange(playerPositionRow + 1, playerPositionCol, targetRow, targetCol) && playerPositionRow + 1 <= 14
                ) {
                    playerPositionRow++;


                } else if (!isPlayerInRange(playerPositionRow, playerPositionCol - 1, targetRow, targetCol) && playerPositionCol - 1 >= 0
                ) {
                    playerPositionCol--;
                }

                if (isPlayerInRange(playerPositionRow, playerPositionCol, targetRow, targetCol)) {

                    playerHealth -= "Cloud".equals(command) ? 3500 : 6000;
                    isPlayerAlive = playerHealth > 0;
                }
            }

            prevCommandRow = targetRow;
            prevCommandCol = targetCol;
            previousCommand = command;

        }

         previousCommand = "Cloud".equals(previousCommand) ? "Plague Cloud" : previousCommand;

        if (!isPlayerAlive && isHeiganAlive) {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
            System.out.printf("Player: Killed by %s%n", previousCommand);
        } else if (!isHeiganAlive && isPlayerAlive) {
            System.out.printf("Heigan: Defeated!%n");
            System.out.printf("Player: %d%n", playerHealth);
        }
        else{
            System.out.printf("Heigan: Defeated!%n");
            System.out.printf("Player: Killed by %s%n", previousCommand);
        }
        System.out.printf("Final position: %d, %d", playerPositionRow, playerPositionCol);
    }

    private static boolean isPlayerInRange(int playerPositionRow, int playerPositionCol, int targetRow, int targetCol) {

        return Math.abs(playerPositionRow - targetRow) <= 1 && Math.abs(playerPositionCol - targetCol) <= 1;
    }
}
