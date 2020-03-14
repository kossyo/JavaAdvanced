package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_PredicateParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());


        String line;

        while (!"Party!".equals((line = scanner.nextLine()))) {

            String[] commandTokens = line.split(" ");

            String command = commandTokens[0];

            switch (command) {

                case "Double":

                    List<String> guestsNewList = new ArrayList<>();
                    for (String guest : guests) {

                        guestsNewList.add(guest);

                        if (getPredicate(commandTokens).test(guest)) {
                            guestsNewList.add(guest);
                        }

                    }
                    guests = guestsNewList;
                    break;

                case "Remove":

                        guests.removeIf(getPredicate(commandTokens));


                    break;
            }
        }

        if (guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }
        else {
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }

    private static Predicate<String> getPredicate(String[] commandTokens) {

        String predicateType = commandTokens[1];
        String parameter = commandTokens[2];

        switch (predicateType) {

            case "StartsWith":
                return x -> x.startsWith(parameter);

            case "EndsWith":
                return x -> x.endsWith(parameter);

            case "Length":
                return x -> x.length() == Integer.parseInt(parameter);
        }
        return null;
    }
}
