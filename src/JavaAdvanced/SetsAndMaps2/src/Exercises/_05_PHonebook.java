package Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_PHonebook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();
        while (true) {
            String[] input = scanner.nextLine().split("-");

            if ("search".equals(input[0])) {
                break;
            }

            String name = input[0];
            String number = input[1];

            phonebook.put(name, number);

            //input = scanner.nextLine().split("-");
        }

        while (true) {
            String input = scanner.nextLine();
            if ("stop".equals(input)) {
                break;
            }

            if (phonebook.containsKey(input)) {

                System.out.printf("%s -> %s\n", input, phonebook.get(input));

            } else {
                System.out.printf("Contact %s does not exist.\n", input);
            }
        }
    }
}
