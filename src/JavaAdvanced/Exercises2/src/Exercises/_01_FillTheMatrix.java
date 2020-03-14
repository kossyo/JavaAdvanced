package Exercises;
import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        int[][] matrix = new int[size][size];
        String pattern = input[1];

        if("A".equals(pattern)){

            matrix = fillMatrixA(size);
        }
        else{
           matrix = fillMatrixB(size);
        }
        printMatrix(matrix, size);
    }

    static int[][] fillMatrixA(int size){

        int[][] matrix = new int[size][size];

        int filling = 1;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                matrix[j][i] = filling;
                filling++;
            }

        }
        return matrix;
    }
    static int[][] fillMatrixB(int size){

        int[][] matrix = new int[size][size];
        int filling = 1;

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if(i % 2 ==0 ) {
                    matrix[j][i] = filling;
                    filling++;
                }
                else{
                    matrix[matrix.length - 1 - j][i] = filling;
                    filling++;
                }
            }
        }
        return matrix;
    }
    static void printMatrix(int[][] matrix, int size){

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
