package IntroToJava.Exercizes;

import java.util.Arrays;
import java.util.Scanner;

public class _04_CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double a = input[0];
        double b = input[1];
        double c = input[2];

        double result1 = Math.pow((a*a + b*b) / (a*a - b*b),(a+b+c) / Math.sqrt(c));
        double result2 = Math.pow(a*a + b*b - c*c*c,a-b);

        double avgBtwExpr = (result1 + result2) / 2;
        double avgBtwNrs = (a+b+c) / 3;

        double result3 = Math.abs(avgBtwExpr - avgBtwNrs);
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",result1, result2, result3);

    }
}
