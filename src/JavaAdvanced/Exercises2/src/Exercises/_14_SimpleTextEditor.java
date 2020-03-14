//77/100

package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _14_SimpleTextEditor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String text = "";
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (input[0]) {

                case "1":
                    String append = input[1];
                    text += append;
                    stack.push(text);
                    break;

                case "2":
                    int charsToErase = Integer.parseInt(input[1]);
                    String newText = text.substring(0, text.length() - charsToErase);
                    text = newText;
                    stack.push(text);
                    break;

                case "3":
                    System.out.println(text.charAt(Integer.parseInt(input[1]) - 1));
                    break;

                case "4":
                    stack.pop();
                    text = stack.peek();
                    break;
            }
        }
    }
}
