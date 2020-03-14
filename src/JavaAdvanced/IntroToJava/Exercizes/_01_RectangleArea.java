package IntroToJava.Exercizes;

import java.util.Arrays;
import java.util.Scanner;

public class _01_RectangleArea {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String dimensionsStr = scanner.nextLine();

        double[] dimensions = Arrays.stream(dimensionsStr.split(" ")).mapToDouble(Double::parseDouble).toArray();

        System.out.printf("%.2f",dimensions[0] * dimensions[1]);
    }
}
