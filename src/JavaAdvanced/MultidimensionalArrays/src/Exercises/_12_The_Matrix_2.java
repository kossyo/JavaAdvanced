package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _12_The_Matrix_2 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] matrix = new char[dimensions[0]][dimensions[1]];

        fillMatrix(matrix);

        char replaceChar = reader.readLine().charAt(0);
        int[] target = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        traverse(matrix, target, replaceChar);
        printMatrix(matrix);
    }

    private static void traverse(char[][] matrix, int[] target, char replaceChar) {

        Deque<Integer[]> stack = new ArrayDeque<>();

        char originalChar = matrix[target[0]][target[1]];

        int[] currentIndex = {target[0], target[1]};
        while (true) {

            try {

                boolean hasUpper = false;
                boolean hasRight = false;

                if (matrix[currentIndex[0]][currentIndex[1]] == originalChar){
                    hasUpper = true;
                }

                if (matrix[currentIndex[0]][currentIndex[1] + 1] == originalChar){
                    hasRight = true;
                }


                if (hasUpper) {
                    Integer[] node = {currentIndex[0], currentIndex[1], 0};
                    stack.push(node);
                    currentIndex[0]--;
                }
                if(hasRight){
                    currentIndex[1]++;
                    Integer[] node = {currentIndex[0], currentIndex[1], 0};
                    stack.push(node);

                }
                else {
                    Integer[] node = stack.pop();
                    matrix[node[0]][node[1]] = replaceChar;
                }

                if (stack.isEmpty()){
                    break;
                }
            }
            catch (Exception e) {

                while (!stack.isEmpty()) {
                    Integer[] node = stack.pop();
                    matrix[node[0]][node[1]] = replaceChar;
                }
                break;
            }
        }
    }

    private static void fillMatrix(char[][] matrix) throws IOException {
        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = reader.readLine().replaceAll(" ", "").toCharArray();
        }
    }

    private static void printMatrix(char[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
