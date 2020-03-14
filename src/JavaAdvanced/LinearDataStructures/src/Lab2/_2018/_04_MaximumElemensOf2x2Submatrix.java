package Lab2._2018;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximumElemensOf2x2Submatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];

        for (int i = 0; i < matrixSize[0]; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = row;
        }

        String[] bestSubmatrix = new String[4];
        long bestSum = Long.MIN_VALUE;

        for (int i = 0; i < matrixSize[0] - 1; i++) {
            for (int j = 0; j < matrixSize[1] - 1; j++) {

                long currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                String[] currentMatrix = {matrix[i][j] + "", matrix[i][j + 1] + "", matrix[i + 1][j] + "", matrix[i + 1][j + 1] + ""};

                if (isIndexValid(i, j, matrixSize) &&
                        currentSum > bestSum) {

                    bestSum = currentSum;
                    bestSubmatrix[0] = currentMatrix[0];
                    bestSubmatrix[1] = currentMatrix[1];
                    bestSubmatrix[2] = currentMatrix[2];
                    bestSubmatrix[3] = currentMatrix[3];
                }
            }
        }

        System.out.println(bestSubmatrix[0] + " " + bestSubmatrix[1]);
        System.out.println(bestSubmatrix[2] + " " + bestSubmatrix[3]);
        System.out.println(bestSum);
    }

    static boolean isIndexValid(int x, int y, int[] matrixSize) {


        if (x >= 0 && x < matrixSize[0]
                && y >= 0 && y < matrixSize[1]
        ) {
            return true;
        }
        return false;
    }
}
