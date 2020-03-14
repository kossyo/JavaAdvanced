package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _12_The_Matrix_3 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] matrix = new char[dimensions[0]][dimensions[1]];

        fillMatrix(matrix);

        char replaceChar = reader.readLine().charAt(0);
        int[] target = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //traverse(matrix, target, replaceChar);
        printMatrix(matrix);
    }

    private static void fillMatrix(char[][] matrix) throws IOException {
        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = reader.readLine().replaceAll(" ", "").toCharArray();
        }
    }

    private static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
