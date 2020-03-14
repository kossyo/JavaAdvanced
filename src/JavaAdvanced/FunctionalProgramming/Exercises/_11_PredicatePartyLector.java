package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_PredicatePartyLector {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String line;

        while (!"Party!".equals(line = scanner.nextLine())) {

            String[] commandTokens = line.split(" ");
            String command = commandTokens[0];
            String predicateType = commandTokens[1];
            String parameter = commandTokens[2];

            switch (command) {
                case "Double":

                    List<String> additionalGuests = new ArrayList<>();
                    for (String guest : guests) {
                        if (getPredicate(predicateType, parameter).test(guest)) {
                            additionalGuests.add(guest);
                        }
                        additionalGuests.add(guest);
                    }
                    guests = additionalGuests;


                    break;

                case "Remove":
                    guests.removeIf(getPredicate(predicateType, parameter));
                    break;
            }
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else
            System.out.println(String.join(", ", guests) + " are going to the party!");
    }

    private static Predicate<String> getPredicate(String predicateType, String parameter) {

        switch (predicateType) {
            case "StartsWith":
                return (guest) -> guest.startsWith(parameter);
            case "EndsWith":
                return (guest) -> guest.endsWith(parameter);
            default:
                return (guest) -> guest.length() == Integer.parseInt(parameter);
        }

    }
}

