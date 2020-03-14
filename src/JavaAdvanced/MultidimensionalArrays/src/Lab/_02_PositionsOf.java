package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _02_PositionsOf {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        readMatrix(matrix);
        int numberToSearch = Integer.parseInt(reader.readLine());

        boolean foundAtLeastOneNumber = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == numberToSearch){
                    System.out.println(i + " " + j);
                    foundAtLeastOneNumber = true;
                }
            }
        }

        if (!foundAtLeastOneNumber){
            System.out.println("not found");
        }
    }

    private static void readMatrix(int[][] matrix) throws IOException {

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }

}
