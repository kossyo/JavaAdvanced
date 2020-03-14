package ExamPreparation.ExamPrep2;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (isValidIndex(matrix,i,j)){
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
    private static boolean isValidIndex(int[][] matrix, int row, int col) {

        try {
            matrix[row][col] = 1000;
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
