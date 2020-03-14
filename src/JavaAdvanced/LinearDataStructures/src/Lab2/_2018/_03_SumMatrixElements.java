package Lab2._2018;

import java.util.Arrays;
import java.util.Scanner;

public class _03_SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        long sum = 0;

        for (int i = 0; i < dimensions[0]; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < dimensions[1]; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(dimensions[0]);
        System.out.println(dimensions[1]);
        System.out.println(sum);

    }
}
