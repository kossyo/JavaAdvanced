package StringProcessing.Exercises;

import java.util.Scanner;

public class _04_UnicodeCharacters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length(); i++ ){

            char str = input.charAt(i);
            String codeAsString = String.format("%04x", (int)str );
            sb.append("\\u");
            sb.append(codeAsString);

        }
        System.out.println(sb.toString());
    }
}
