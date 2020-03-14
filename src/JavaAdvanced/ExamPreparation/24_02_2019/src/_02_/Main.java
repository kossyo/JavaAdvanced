package _02_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        char[][] matrix = new char[n][n];

        int[] firstPlayerPos = new int[2];
        int[] secondPlayerPos = new int[2];


        readMatrixAndPlayerPositions(reader, n, matrix, firstPlayerPos, secondPlayerPos);


        while (matrix[firstPlayerPos[0]][firstPlayerPos[1]] != 'x'
                && matrix[secondPlayerPos[0]][secondPlayerPos[1]] != 'x') {

            String[] commands = reader.readLine().split("\\s+");

            switch (commands[0]){

                case "up":
                    firstPlayerPos = moveUp(matrix, n, firstPlayerPos, 'f');
                    break;
                case "down":
                    firstPlayerPos = moveDown(matrix,n ,firstPlayerPos, 'f');
                    break;
                case "left":
                    firstPlayerPos = moveLeft(matrix,n ,firstPlayerPos, 'f');
                    break;
                case "right":
                    firstPlayerPos = moveRight(matrix,n ,firstPlayerPos, 'f');
                    break;
            }

            if (!someonedied(matrix, n)) {

                switch (commands[1]) {
                    case "up":
                        secondPlayerPos = moveUp(matrix, n, secondPlayerPos, 's');
                        break;
                    case "down":
                        secondPlayerPos = moveDown(matrix, n, secondPlayerPos, 's');
                        break;
                    case "left":
                        secondPlayerPos = moveLeft(matrix, n, secondPlayerPos, 's');
                        break;
                    case "right":
                        secondPlayerPos = moveRight(matrix, n, secondPlayerPos, 's');
                        break;
                }
            }
        //    printMatrix(matrix,n);
        //    System.out.println();


        }
        printMatrix(matrix, n);


    }

    private static boolean someonedied(char[][] matrix, int n ){

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 'x'){
                    return true;
                }
            }

        }
        return false;
    }

    private static int[] moveUp(char[][] matrix, int n, int[] playerPos, char playerChar) {

        int[] nextPos = {playerPos[0] - 1, playerPos[1]};
        if (nextPos[0] == -1) {
            nextPos[0] = n - 1;
        }
        playerPos = nextPos;

        switch (playerChar) {

            case 'f':

                if (matrix[playerPos[0]][playerPos[1]] == 's') {
                    matrix[playerPos[0]][playerPos[1]] = 'x';

                }
                else{
                    matrix[playerPos[0]][playerPos[1]] = 'f';
                }
                break;


            case 's':

                if (matrix[playerPos[0]][playerPos[1]] == 'f') {
                    matrix[playerPos[0]][playerPos[1]] = 'x';
                }
                else{
                    matrix[playerPos[0]][playerPos[1]] = 's';
                }
                break;

        }

        return playerPos;


    }

    private static int[] moveRight(char[][] matrix, int n, int[] playerPos, char playerChar) {

        int[] nextPos = {playerPos[0], playerPos[1] + 1 };
        if (nextPos[1] == n) {
            nextPos[1] = 0;
        }
        playerPos = nextPos;

        switch (playerChar) {

            case 'f':

                if (matrix[playerPos[0]][playerPos[1]] == 's') {
                    matrix[playerPos[0]][playerPos[1]] = 'x';
                }
                else{
                    matrix[playerPos[0]][playerPos[1]] = 'f';
                }
                break;


            case 's':

                if (matrix[playerPos[0]][playerPos[1]] == 'f') {
                    matrix[playerPos[0]][playerPos[1]] = 'x';
                }
                else{
                    matrix[playerPos[0]][playerPos[1]] = 's';
                }
                break;

        }

        return playerPos;


    }

    private static int[] moveDown(char[][] matrix, int n, int[] playerPos, char playerChar) {

        int[] nextPos = {playerPos[0] + 1, playerPos[1]};
        if (nextPos[0] == n) {
            nextPos[0] = 0;
        }
        playerPos = nextPos;

        switch (playerChar) {

            case 'f':

                if (matrix[playerPos[0]][playerPos[1]] == 's') {
                    matrix[playerPos[0]][playerPos[1]] = 'x';
                }
                else{
                    matrix[playerPos[0]][playerPos[1]] = 'f';
                }
                break;


            case 's':

                if (matrix[playerPos[0]][playerPos[1]] == 'f') {
                    matrix[playerPos[0]][playerPos[1]] = 'x';
                }
                else{
                    matrix[playerPos[0]][playerPos[1]] = 's';
                }
                break;


        }

        return playerPos;


    }

    private static int[] moveLeft(char[][] matrix, int n, int[] playerPos, char playerChar) {

        int[] nextPos = {playerPos[0], playerPos[1] - 1};
        if (nextPos[1] == -1) {
            nextPos[1] = n - 1;
        }
        playerPos = nextPos;

        switch (playerChar) {

            case 'f':

                if (matrix[playerPos[0]][playerPos[1]] == 's') {
                    matrix[playerPos[0]][playerPos[1]] = 'x';
                }
                else{
                    matrix[playerPos[0]][playerPos[1]] = 'f';
                }
                break;

            case 's':

                if (matrix[playerPos[0]][playerPos[1]] == 'f') {
                    matrix[playerPos[0]][playerPos[1]] = 'x';
                }
                else{
                    matrix[playerPos[0]][playerPos[1]] = 's';
                }
                break;

        }

        return playerPos;


    }

    private static void readMatrixAndPlayerPositions(BufferedReader reader, int n, char[][] matrix, int[] firstPlayerPos, int[] secondPlayerPos) throws IOException {
        for (int i = 0; i < n; i++) {
            char[] currentRow = reader.readLine().toCharArray();

            for (int j = 0; j < n; j++) {
                if (currentRow[j] == 'f') {
                    firstPlayerPos[0] = i;
                    firstPlayerPos[1] = j;
                } else if (currentRow[j] == 's') {
                    secondPlayerPos[0] = i;
                    secondPlayerPos[1] = j;
                }
            }
            matrix[i] = currentRow;

        }
    }

    private static void printMatrix(char[][] matrix, int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }

    }
}
