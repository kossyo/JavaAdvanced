package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _03_Intersection_of_Two_Matrices {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());
        Character[][] matrix1 = new Character[rows][cols];
        Character[][] matrix2 = new Character[rows][cols];
        readMatrix(matrix1);
        readMatrix(matrix2);
        Character[][] resultMatrix = new Character[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix1[i][j] == matrix2[i][j]){
                    resultMatrix[i][j] = matrix1[i][j];
                }
                else{
                    resultMatrix[i][j] = '*';
                }
            }
        }

        printMatrix(resultMatrix);



    }

    private static void printMatrix(Character[][] resultMatrix) {

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                System.out.print(resultMatrix[i][j]);
                if (j != resultMatrix.length){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void readMatrix(Character[][] matrix) throws IOException {

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split("\\s+")).map(x -> x.charAt(0)).toArray(Character[]::new);
        }
    }
}
