package Exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        String currentInput = "";
        int longestWordLength = Integer.MIN_VALUE;

        String command = scanner.nextLine();

        while (true) {

            currentInput = scanner.nextLine();

            if ("END".equals(currentInput)) {
                break;
            }

            if (currentInput.length() > longestWordLength) {
                longestWordLength = currentInput.length();
            }
            list.add(currentInput);
        }

        list = appendFillings(list, longestWordLength);

        char[][] matrix = convertListToCharMatrix(list, list.size(), longestWordLength);

        int degreesToTurn = getDegrees(command) % 360;

        switch (degreesToTurn) {

            case 90:

                matrix = turnMatrix90degsOnceOrThrice(matrix, 90);
                break;

            case 180:

                matrix = turnMatrix90degsTwice(matrix);
                break;

            case 270:
                matrix = turnMatrix90degsOnceOrThrice(matrix, 270);
                break;
        }

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    static String createFilling(int length) {

        String filling = "";
        for (int i = 0; i < length; i++) {

            filling += " ";
        }
        return filling;
    }

    static ArrayList appendFillings(ArrayList<String> list, int longestWordLength) {

        String filling = "";

        for (int i = 0; i < list.size(); i++) {
            filling = createFilling(Math.abs(list.get(i).length() - longestWordLength));
            list.set(i, list.get(i) + filling);
        }

        return list;
    }

    static char[][] convertListToCharMatrix(ArrayList list, int rows, int cols) {

        char[][] newMatrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            newMatrix[i] = list.get(i).toString().toCharArray();
        }
        return newMatrix;

    }

    static int getDegrees(String string) {

        int indexOpeningBracket = 0;
        int indexClosingBracket = 0;

        for (int i = 0; i < string.length(); i++) {

            if ('(' == string.charAt(i)) {
                indexOpeningBracket = i;
            } else if (')' == string.charAt(i)) {
                indexClosingBracket = i;
            }
        }
        String newString = string.substring(indexOpeningBracket + 1, indexClosingBracket);

        return Integer.parseInt(newString);
    }

    static char[][] turnMatrix90degsTwice(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] newMatrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {

            newMatrix[rows - 1 - i] = reverseCharArray(matrix[i]);
        }

        return newMatrix;
    }

    static char[][] turnMatrix90degsOnceOrThrice(char[][] matrix, int degreesToTurn) {

        int matrixRows = matrix.length;

        int newMatrixRows = matrix[0].length;
        int newMatrixCols = matrix.length;
        char[][] newMatrix = new char[newMatrixRows][newMatrixCols];

        if (degreesToTurn == 90) {
            for (int i = 0; i < matrixRows; i++) {

                String currentString = charArrayToString(matrix[i]);

                assignStringToNewMatrixBackwards(newMatrix, newMatrixCols - 1 - i, currentString);

            }
        } else if (degreesToTurn == 270) {

            for (int i = 0; i < matrixRows; i++) {

                String currentString = charArrayToString(matrix[i]);

                assignStringToNewMatrixForwards(newMatrix, i, currentString);
            }
        }


        return newMatrix;
    }

    static char[][] assignStringToNewMatrixForwards(char[][] newMatrix, int i, String currentString) {

        for (int j = 0; j < newMatrix.length; j++) {

            char[] currentCharArray = currentString.toCharArray();
            char[] currentCharArrayReversed = reverseCharArray(currentCharArray);
            String currentStringReversed = charArrayToString(currentCharArrayReversed);
            newMatrix[j][i] = currentStringReversed.charAt(j);
        }

        return newMatrix;
    }

    static char[][] assignStringToNewMatrixBackwards(char[][] newMatrix, int i, String currentString) {

        for (int j = 0; j < newMatrix.length; j++) {

            newMatrix[j][i] = currentString.charAt(j);
        }

        return newMatrix;
    }

    static char[] reverseCharArray(char[] array) {


        String string = "";

        for (int i = 0; i < array.length; i++) {
            string += array[i];
        }
        char[] newArray = new char[string.length()];

        for (int i = 0; i < array.length; i++) {

            newArray[i] = string.charAt(array.length - 1 - i);
        }
        newArray[array.length - 1] = array[0];

        return newArray;
    }

    static String charArrayToString(char[] charArray) {

        String string = "";

        for (int i = 0; i < charArray.length; i++) {
            string += charArray[i];
        }

        return string;
    }
}
