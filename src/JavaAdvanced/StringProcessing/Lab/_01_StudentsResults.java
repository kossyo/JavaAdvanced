package StringProcessing.Lab;

import java.util.Scanner;

public class _01_StudentsResults {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] array = input.split("( - )|(, )");
        double avg = (Double.parseDouble(array[1]) + Double.parseDouble(array[2]) + Double.parseDouble(array[3])) / 3;

        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|%n", array[0],
                Double.parseDouble(array[1]), Double.parseDouble(array[2]), Double.parseDouble(array[3]), avg);

    }
}
