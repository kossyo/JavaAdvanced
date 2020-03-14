package ExamPreparation.ExamPrep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shockwave {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        String input;
        while (!"Here We Go".equals((input = reader.readLine()))) {

            int[] tokens = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int x1 = tokens[0];
            int y1 = tokens[1];
            int x2 = tokens[2];
            int y2 = tokens[3];


            for (int i = x1; i <= x2; i++) {

                for (int j = y1; j <= y2; j++) {

                    matrix[i][j]++;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
