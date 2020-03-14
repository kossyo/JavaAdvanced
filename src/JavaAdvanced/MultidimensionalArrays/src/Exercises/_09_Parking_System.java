package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _09_Parking_System {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] parking = new int[size[0]][size[1]];
        String input;
        while (!"stop".equals(input = reader.readLine())) {

            int distance = 1;
            int[] cmdArgs = Arrays.stream(input.split("\\s")).mapToInt(Integer::parseInt).toArray();

            int enteringRow = cmdArgs[0];
            int targetRow = cmdArgs[1];
            int targetCol = cmdArgs[2];

            boolean rowFull = false;

            if (parking[targetRow][targetCol] == 1) {

                int freeCol = 0;

                int radius = 1;

                boolean hitLeftEnd = false;
                boolean hitRightEnd = false;

                while (true) {

                    if (targetCol - radius < 1) {
                        hitLeftEnd = true;
                    }

                    if (targetCol + radius >= size[1]) {
                        hitRightEnd = true;
                    }

                    if (!hitLeftEnd && parking[targetRow][targetCol - radius] == 0) {
                        freeCol = targetCol - radius;
                        break;
                    }

                    if (!hitRightEnd && parking[targetRow][targetCol + radius] == 0) {
                        freeCol = targetCol + radius;
                        break;
                    }

                    if (hitLeftEnd && hitRightEnd) {
                        rowFull = true;
                        break;
                    }
                    radius++;
                }

                targetCol = freeCol;
            }
            if (rowFull) {
                System.out.printf("Row %d full%n", targetRow);
            } else {
                parking[targetRow][targetCol] = 1;
                distance += (Math.abs(enteringRow - targetRow) + targetCol);
                System.out.println(distance);
            }
        }
    }
}
