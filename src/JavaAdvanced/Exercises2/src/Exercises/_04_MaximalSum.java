package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];


        for (int i = 0; i < matrixSize[0]; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = row;
        }

        int[][] bestSubmatrix = new int[3][3];
        long bestSum = Long.MIN_VALUE;

        for (int i = 0; i < matrixSize[0] - 2; i++) {
            for (int j = 0; j < matrixSize[1] - 2; j++) {

                long currentSum = getCurrentSum(matrix, i, j);
                int[][] current3x3 = fillCurrent3x3(matrix, i, j);

                if (currentSum > bestSum) {

                    bestSum = currentSum;
                    bestSubmatrix = fillBestSumMatrixWithCurrent3x3(bestSubmatrix, current3x3);
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        printBestSumMatrix(bestSubmatrix);
    }

    static int[][] fillCurrent3x3(int[][] matrix, int i, int j) {

        int[][] current3x3 = new int[3][3];

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {

                current3x3[k][l] = matrix[i + k][j + l];
            }
        }

        return current3x3;
    }

    static long getCurrentSum(int[][] matrix, int i, int j) {

        long currentSum = 0;

        for (int k = i; k <= i + 2; k++) {
            for (int l = j; l <= j + 2; l++) {

                currentSum += matrix[k][l];
            }
        }

        return currentSum;
    }

    static int[][] fillBestSumMatrixWithCurrent3x3(int[][] bestSubmatrix, int[][] current3x3) {

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {

                bestSubmatrix[k][l] = current3x3[k][l];
            }
        }
        return bestSubmatrix;

    }

    static void printBestSumMatrix(int[][] bestSubmatrix) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(bestSubmatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
