package _02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<List<String>> matrix = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            matrix.add(Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList()));
        }

        List<String> commandAndParameters = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String command = commandAndParameters.get(0);
        List<String> parameters = commandAndParameters.stream().skip(1).collect(Collectors.toList());
        int whichColumnToWatch = matrix.get(0).indexOf(parameters.get(0));

        switch (command) {

            case "hide":

                for (List<String> outer : matrix) {
                    outer.remove(whichColumnToWatch);
                }
                break;

            case "filter":

                List<String> headers = matrix.get(0);

                matrix = matrix.stream().filter(record -> record.get(whichColumnToWatch).equals(parameters.get(1))).collect(Collectors.toList());
                matrix.add(0, headers);

                break;

            case "sort":
                headers = matrix.get(0);

                matrix = matrix
                        .stream()
                        .skip(1)
                        .sorted(Comparator.comparing(record -> record.get(whichColumnToWatch)))
                        .collect(Collectors.toList());

                matrix.add(0, headers);
                break;
        }


        printMatrix(matrix);
    }

    private static void printMatrix(List<List<String>> matrix) {
        for (List<String> outer : matrix) {

            System.out.println(String.join(" | ", outer));
        }
    }
}
