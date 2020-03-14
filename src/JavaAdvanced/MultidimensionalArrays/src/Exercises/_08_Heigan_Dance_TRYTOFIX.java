//90/100

package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _08_Heigan_Dance_TRYTOFIX {

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

        while (true) {

            if (playerHealth >= 0) {
                heiganHealth -= damage;
            }
            if (previousCommand.equals("Cloud")) {
                playerHealth -= 3500;
            }
            if (heiganHealth <= 0 || playerHealth <= 0) {
                break;
            }

            //тия трите ифа горе не са мои
            //тия трите ифа горе не са мои
            //тия трите ифа горе не са мои

            String[] cmdArgs = reader.readLine().split("\\s");
            String command = cmdArgs[0];
            int targetRow = Integer.parseInt(cmdArgs[1]);
            int targetCol = Integer.parseInt(cmdArgs[2]);

            if (isPlayerInRange(playerPositionRow, playerPositionCol, prevCommandRow, prevCommandCol)) {
                playerHealth -= 3500;
            }


            if (isPlayerInRange(playerPositionRow, playerPositionCol, targetRow, targetCol)) {

                if (!isPlayerInRange(playerPositionRow - 1, playerPositionCol, targetRow, targetCol) && !isWall(playerPositionRow - 1) //method isWall instead
                ) {
                    playerPositionRow--;
                    previousCommand = "";

                } else if (!isPlayerInRange(playerPositionRow, playerPositionCol + 1, targetRow, targetCol) && !isWall(playerPositionCol + 1)
                ) {
                    playerPositionCol++;
                    previousCommand = "";


                } else if (!isPlayerInRange(playerPositionRow + 1, playerPositionCol, targetRow, targetCol) && !isWall(playerPositionRow + 1)
                ) {
                    playerPositionRow++;
                    previousCommand = "";


                } else if (!isPlayerInRange(playerPositionRow, playerPositionCol - 1, targetRow, targetCol) && !isWall(playerPositionCol - 1)
                ) {
                    playerPositionCol--;
                    previousCommand = "";

                }

                else {//тоя елс не е мой
                    if (command.equals("Cloud")) {
                        playerHealth -= 3500;
                        previousCommand = "Cloud";
                    } else if (command.equals("Eruption")) {
                        playerHealth -= 6000;
                        previousCommand = "Eruption";
                    }
                }


//                  тука това си беше незакоментирано
//                  тука това си беше незакоментирано
//                  тука това си беше незакоментирано

//                if (isPlayerInRange(playerPositionRow, playerPositionCol, targetRow, targetCol)) {
//
//                    playerHealth -= "Cloud".equals(command) ? 3500 : 6000;
//                    isPlayerAlive = playerHealth > 0;
//                }
            }

//            prevCommandRow = targetRow;
//            prevCommandCol = targetCol;
        //    previousCommand = command;

        }
        previousCommand = previousCommand.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String heiganState = heiganHealth <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", heiganHealth);
        String playerState = playerHealth <= 0 ? String.format("Player: Killed by %s", previousCommand) :
                String.format("Player: %d", playerHealth);
        String playerEndCoordinates = String.format("Final position: %d, %d", playerPositionRow, playerPositionCol);

        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);

        //целият край е друг
        //целият край е друг
        //целият край е друг
        //целият край е друг
    }


    private static boolean isPlayerInRange(int playerPositionRow, int playerPositionCol, int targetRow, int targetCol) {

        return Math.abs(playerPositionRow - targetRow) <= 1 && Math.abs(playerPositionCol - targetCol) <= 1;
//        return ((targetRow - 1 <= playerPositionRow && playerPositionRow <= targetRow + 1)
//                && (targetCol - 1 <= playerPositionCol && playerPositionCol <= targetCol + 1));
    }

    private static boolean isWall(int moveCell) {
        return moveCell < 0 || moveCell >= 15;
    }
}
