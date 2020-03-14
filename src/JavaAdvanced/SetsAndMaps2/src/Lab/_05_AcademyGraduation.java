package Lab;

import javafx.beans.binding.DoubleExpression;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _05_AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000000");
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> scores = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();

            double[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();

            double avg = 0;
            double sumOfGrades = 0;

            for (double v : input) {
                sumOfGrades += v;
            }
            avg = sumOfGrades / input.length;

            scores.put(name, avg);
        }

        for (Map.Entry<String, Double> stringDoubleEntry : scores.entrySet()) {

            System.out.printf("%s is graduated with %s\n", stringDoubleEntry.getKey(), stringDoubleEntry.getValue().toString());
        }
    }
}
