package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _07_Find_The_Real_Queen {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        char[][] matrix = new char[8][8];
        List<Integer[]> allQueens = new ArrayList<>();

        readMatrixAndNoteAllQueens(matrix, allQueens);
        if (findTheRealQueen(matrix, allQueens) != null) {
            System.out.println(Arrays.toString(findTheRealQueen(matrix, allQueens)).replaceAll("[\\[\\],]", "").trim());
        }
    }

    private static void readMatrixAndNoteAllQueens(char[][] matrix, List<Integer[]> allQueens) throws IOException {
        for (int i = 0; i < 8; i++) {

            String line = reader.readLine().replaceAll(" ", "");
            if (line.contains("q")) {
                Integer[] position = new Integer[2];
                position[0] = i;
                position[1] = line.indexOf("q");
                allQueens.add(position);
            }
            matrix[i] = line.toCharArray();
        }
    }

    private static int[] findTheRealQueen(char[][] matrix, List<Integer[]> allQueens) {

        int[] theRealQueenPosition = new int[2];
        for (int q = 0; q < allQueens.size(); q++) {
            Integer[] queenPosition = allQueens.get(q);
            Integer queenRow = queenPosition[0];
            Integer queenCol = queenPosition[1];
            boolean noQueensHorizontally = true;
            boolean noQueensVertically = true;
            boolean noQueensDiagonallyTopLeftBottomRight = true;
            boolean noQueensDiagonallyTopRightBottomLeft = true;

            //chech horizontal
            for (int j = 0; j < matrix[queenRow].length; j++) {

                if (matrix[queenRow][j] == 'q' && queenCol != j) {
                    noQueensHorizontally = false;
                }
            }

            //check vertical
            for (int i = 0; i < matrix.length; i++) {

                if (matrix[i][queenCol] == 'q' && queenRow != i) {
                    noQueensVertically = false;
                }
            }

            noQueensDiagonallyTopLeftBottomRight = checkDiagonalTopLeftBottomRight(matrix, allQueens.get(q));
            noQueensDiagonallyTopRightBottomLeft = checkDiagonalTopRightBottomLeft(matrix, allQueens.get(q));


            if (noQueensHorizontally && noQueensVertically && noQueensDiagonallyTopLeftBottomRight && noQueensDiagonallyTopRightBottomLeft) {
                theRealQueenPosition[0] = queenPosition[0];
                theRealQueenPosition[1] = queenPosition[1];
                return theRealQueenPosition;
            }
        }
        return null;
    }
    private static boolean checkDiagonalTopLeftBottomRight(char[][] matrix, Integer[] position){

        int row = position[0];
        int col = position[1];

        while (row != 0 && col != 0){
            row--;
            col--;
        }

        while (row <= 7 && col <= 7){

            if (matrix[row][col] == 'q' && row != position[0]){
                return false;
            }
            row++;
            col++;
        }
        return true;
    }

    private static boolean checkDiagonalTopRightBottomLeft(char[][] matrix, Integer[] position){

        int row = position[0];
        int col = position[1];

        while (row != 0 && col != 7){
            row--;
            col++;
        }

        while (row <= 7 && col >= 0){

            if (matrix[row][col] == 'q' && row != position[0]){
                return false;
            }

            row++;
            col--;
        }
        return true;

    }
}
