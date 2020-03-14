package StringProcessing.Exercises;

import java.util.Scanner;

public class _08_MelrahShake {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String pattern = scanner.nextLine();

        while (pattern.length() != 0 && input.length() >= pattern.length()) {
            if (input.contains(pattern) && input.lastIndexOf(pattern) != -1
                    && input.indexOf(pattern) != input.lastIndexOf(pattern)) {

                StringBuilder sb = new StringBuilder(input);
                int firstOccurrence = sb.indexOf(pattern);
                for (int i = 0; i < pattern.length(); i++) {

                    sb.deleteCharAt(firstOccurrence);
                }
                input = sb.toString();
                int lastOccurrence = sb.lastIndexOf(pattern);

                for (int i = 0; i < pattern.length(); i++) {

                    sb.deleteCharAt(lastOccurrence);
                }
                input = sb.toString();

                System.out.println("Shaked it.");
                StringBuilder patternSb = new StringBuilder(pattern);
                patternSb.deleteCharAt(pattern.length() / 2);
                pattern = patternSb.toString();
            } else {
                break;
            }
        }
        System.out.printf("No shake.%n%s",input);
    }
}
