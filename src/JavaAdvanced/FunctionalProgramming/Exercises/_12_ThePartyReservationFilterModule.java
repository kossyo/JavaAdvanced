package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _12_ThePartyReservationFilterModule {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<Filter1> filters = new ArrayList<>();

        String commandInput;

        while (!"Print".equals((commandInput = scanner.nextLine()))) {

            String[] commandTokens = commandInput.split(";");
            String addOrRemove = commandTokens[0].startsWith("Add") ? "Add" : "Remove";
            String condition = commandTokens[1];
            String parameter = commandTokens[2];

            switch (addOrRemove) {
                case "Add":

                    filters.add(new Filter1(condition, parameter));
                    break;

                case "Remove":

                    filters.removeIf(x -> condition.equals(x.condition) && parameter.equals(x.parameter));
                    break;
            }
        }
        Predicate<String> myFilter = guest -> {

            boolean mustBeRemoved = false;

            for (Filter1 filter : filters) {
                if (filter.condition.equals("Starts with") && guest.startsWith(filter.parameter)) {
                    mustBeRemoved = true;
                }
                if (filter.condition.equals("Ends with") && guest.endsWith(filter.parameter)) {
                    mustBeRemoved = true;
                }
                if (filter.condition.equals("Length") && guest.length() == Integer.parseInt(filter.parameter)) {
                    mustBeRemoved = true;
                }
                if (filter.condition.equals("Contains") && guest.contains(filter.parameter)) {
                    mustBeRemoved = true;
                }
            }
            return !mustBeRemoved;
        };
        guests.stream().filter(myFilter).forEach(guest -> System.out.print(guest + " "));
    }
}

class Filter1 {

    String condition;
    String parameter;

    public Filter1(String condition, String parameter) {

        this.condition = condition;
        this.parameter = parameter;

    }

}
