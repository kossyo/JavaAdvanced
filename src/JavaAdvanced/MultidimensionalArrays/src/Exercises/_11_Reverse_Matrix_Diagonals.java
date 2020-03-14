package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _11_Reverse_Matrix_Diagonals {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] size = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> matrix = new LinkedList<>();
        readAndFillMatrix(matrix, size[0]);

        int lastIndexRow = size[0] - 1;
        int lastIndexCol = size[1] - 1;
        int startCol = lastIndexCol;


        int col = lastIndexCol;

        while (startCol >= 0) {

            int row = lastIndexRow;

            for (; row >= 0 && col <= lastIndexCol; col++, row--) {

                System.out.print(matrix.get(row).get(col) + " ");
            }
            col = --startCol;
            System.out.println();
        }

        while (lastIndexRow > 0){

            col = 0;
            lastIndexRow--;
            int row = lastIndexRow;

            for (; row >= 0 && col <= lastIndexCol; col++, row--) {

                System.out.print(matrix.get(row).get(col) + " ");
            }

            System.out.println();


        }

    }


    private static void readAndFillMatrix(List<List<Integer>> matrix, int size) throws IOException {

        for (int i = 0; i < size; i++) {

            List<Integer> list = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
            matrix.add(list);
        }
    }
}
