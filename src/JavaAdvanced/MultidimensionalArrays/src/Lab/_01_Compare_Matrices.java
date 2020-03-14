package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _01_Compare_Matrices {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix1 = new int[dimensions[0]][dimensions[1]];
        readMatrix(matrix1);

        dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix2 = new int[dimensions[0]][dimensions[1]];

        readMatrix(matrix2);
        System.out.println(areEqual(matrix1, matrix2) ? "equal" : "not equal");

    }

    private static void readMatrix(int[][] matrix) throws IOException {

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
    }
    private static boolean areEqual(int[][] matrix1, int[][] matrix2){

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length){
            return false;
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]){
                    return false;
                }
            }
        }
        return true;

    }
}
