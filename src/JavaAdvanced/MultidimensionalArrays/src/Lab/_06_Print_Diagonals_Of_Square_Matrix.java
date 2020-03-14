package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _06_Print_Diagonals_Of_Square_Matrix {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[size][size];

        readMatrix(matrix);
        printDiagonals(matrix);


    }

    private static void readMatrix(int[][] matrix) throws IOException {

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }

    private static void printDiagonals(int[][] matrix) {

        int[] diagonal1 = new int[matrix.length];
        int[] diagonal2 = new int[matrix.length];

        for (int i = 0; i < matrix.length ; i++) {

            for (int j = 0, p = matrix.length - 1; j < matrix.length && p >= 0; j++, p--) {

                if (i == j) {
                    diagonal1[i] = matrix[i][j];
                }
                if (p == i) {
                    diagonal2[matrix.length -1 - i] = matrix[i][j];
                }
            }
        }

        System.out.println(Arrays.toString(diagonal1).replaceAll("[\\[\\],]", ""));
        System.out.println(Arrays.toString(diagonal2).replaceAll("[\\[\\],]", ""));


    }
}
