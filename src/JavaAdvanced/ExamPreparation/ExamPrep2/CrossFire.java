//80/100 time limit

package ExamPreparation.ExamPrep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CrossFire {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> matrix = new ArrayList<>();

        int counter = 1;
        for (int i = 0; i < dimensions[0]; i++) {
            matrix.add(new LinkedList<>());
            for (int j = 0; j < dimensions[1]; j++) {

                matrix.get(i).add(counter);
                counter++;

                if (counter>2500){
                    return;
                }
            }
        }

        String command;
        while (!"Nuke it from orbit".equals((command = reader.readLine()))) {

            String[] tokensString = command.split(" ");
            int[] tokens = new int[3];
            tokens[0] = Integer.parseInt(tokensString[0]);
            tokens[1] = Integer.parseInt(tokensString[1]);
            tokens[2] = Integer.parseInt(tokensString[2]);
            //Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();



            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

            matrix = setImpactedToZero(matrix, row, col, radius);
            matrix = getShrunk(matrix);// SHOULD I SHRINK EVERY TIME??
        }
        printResult(matrix);

    }
    private static List<List<Integer>> getShrunk(List<List<Integer>> matrix) {


//        if (matrix.isEmpty()){
//            System.out.println(5/0);
//            return matrix;
//        }

        List<List<Integer>> newMatrix = matrix;

        for (int i = 0; i < newMatrix.size(); i++) {

            newMatrix.set(i, newMatrix.get(i).stream().filter(x -> x != 0).collect(Collectors.toList()));
        }

        for(int i = 0; i < matrix.size(); i++){

            for(int j = 0; j < matrix.get(i).size(); j++){
                if (newMatrix.get(i).get(j) != 0) {
                    newMatrix.get(i).set(j, matrix.get(i).get(j));
                }
            }

        }

        if (!newMatrix.isEmpty()) {
            for (int i = 0; i < newMatrix.size(); i++) {

                if (newMatrix.get(i).stream().allMatch(x -> x == 0)) {
                    newMatrix.remove(i);
                }
            }
        }

        matrix = newMatrix;
        return matrix;
    }

    private static List<List<Integer>> setImpactedToZero(List<List<Integer>> matrix, int row, int col, int radius) {



        List<List<Integer>> newMatrix = matrix;

        //right
        for (int i = col + 1; i <= radius + col; i++) {

            if (isValidIndex(matrix, row, i)) {//?
                newMatrix.get(row).set(i, 0);
            }
        }

        //left
        for (int i = col - 1; i >= col - radius; i--) {

            if (isValidIndex(matrix, row, i)) {//?
                newMatrix.get(row).set(i, 0);
            }
        }

        //down
        for (int i = row + 1; i <= radius + row; i++) {

            if (isValidIndex(matrix, i, col)) {
                newMatrix.get(i).set(col, 0);
            }
        }

        //up
        for (int i = row - 1; i >= row - radius; i--) {

            if (isValidIndex(matrix, i, col)) {
                newMatrix.get(i).set(col, 0);
            }
        }

        //center
        if (isValidIndex(newMatrix, row, col)){
            newMatrix.get(row).set(col, 0);
        }


        matrix = newMatrix;
        return matrix;
    }

    private static boolean isValidIndex(List<List<Integer>> matrix, int row, int col) {

        try {
            matrix.get(row).get(col);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void printResult(List<List<Integer>> matrix) {

        matrix.forEach(innerList -> {
            System.out.println(innerList.toString().replaceAll("[\\[\\],]", ""));
        });
    }
}
