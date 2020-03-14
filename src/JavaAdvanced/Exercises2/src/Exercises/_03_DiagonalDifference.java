package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for(int i = 0; i < size; i++){

            int[] current = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = current;

        }


        int diagonal1 = 0;
        int diagonal2 = 0;

        for(int i = 0; i < size; i++){

            diagonal1 += matrix[i][i];
            diagonal2 += matrix[i][size - 1 - i];


        }
        System.out.print(Math.abs(diagonal1 - diagonal2));
    }
}
