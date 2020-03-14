package Exercises;

import java.util.*;

public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        while (true)
        {
            String name = scanner.nextLine();

            if ("stop".equals(name))
            {
                break;
            }

            String email = scanner.nextLine().trim();

            phonebook.put(name  , email);
        }

        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            if (
                    !entry.getValue().toUpperCase().endsWith("US") &&
                    !entry.getValue().toUpperCase().endsWith("UK") &&
                    !entry.getValue().toUpperCase().endsWith("COM")
            ){

                System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
            }
        }
    }
}
