package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _08_Wrong_measurements {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        List<List<Integer>> matrix = new LinkedList<>();
        int rows = Integer.parseInt(reader.readLine());

        readMatrix(matrix, rows);

        int[] elementToBeFixedPosition = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int wrongNumber = matrix.get(elementToBeFixedPosition[0]).get(elementToBeFixedPosition[1]);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) == wrongNumber){

                    int correctNumber = 0;
                    try {
                        if (matrix.get(i - 1).get(j) != wrongNumber) {
                            correctNumber += matrix.get(i - 1).get(j);
                        }
                    }catch (Exception e){}
                    try {
                        if (matrix.get(i).get(j + 1) != wrongNumber) {
                            correctNumber += matrix.get(i).get(j + 1);
                        }
                    }catch (Exception e){}
                    try {
                        if (matrix.get(i + 1).get(j) != wrongNumber) {
                            correctNumber += matrix.get(i + 1).get(j);
                        }
                    }catch (Exception e){}
                    try {
                        if (matrix.get(i).get(j - 1) != wrongNumber) {
                            correctNumber += matrix.get(i).get(j - 1);
                        }
                    }catch (Exception e){}

                    matrix.get(i).set(j, correctNumber);
                }
            }
        }

        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(matrix.get(i).stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }




    }

    private static void readMatrix(List<List<Integer>> matrix, int rows) throws IOException {
        for (int i = 0; i < rows; i++) {
            List<Integer> row = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(LinkedList::new));
            matrix.add(row);
        }
    }
}
