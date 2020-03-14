package FunctionalProgramming.Lab;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _05_FilterByAge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        while (count-- > 0) {

            String[] entry = scanner.nextLine().split(", ");
            String name = entry[0];
            int age = Integer.parseInt(entry[1]);

            people.putIfAbsent(name, age);
        }

        String ageCondition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String outputFormat = scanner.nextLine();

//        BiConsumer<Map.Entry<String, Integer>, String> print = (kvp, format) -> {
//
//            String output = "";
//
//            switch (format) {
//                case "age":
//                    output = String.format("%d", kvp.getValue());
//                    break;
//
//                case "name":
//                    output = String.format("%s", kvp.getKey());
//                    break;
//
//                default:
//                    output = String.format("%s - %d", kvp.getKey(), kvp.getValue());
//                    break;
//            }
//            System.out.println(output);
//        };
//
//        switch (ageCondition) {
//            case "older":
//                people.entrySet().stream().filter(x -> x.getValue() >= ageLimit)
//                        .forEach(y -> print.accept(y, outputFormat));
//                break;
//            default:
//                people.entrySet().stream().filter(x -> x.getValue() < ageLimit)
//                        .forEach(y -> print.accept(y, outputFormat));
//
//                break;
//        }
        Predicate<Integer> tester = createTester(ageCondition, ageLimit);//предикат се взима от метода, зависи от ageCondition

        Consumer<Map.Entry<String, Integer>> print =
                // това е void функция, която извиква метод, който връща Consumer<Map.Entry<String, Integer>>, а той от своя страна
                // се запаметява в променлива. Той зависи от формата, в който трябва да бъде изходът.
                //от
                printer(outputFormat);

        printFilteredStudent(people, tester, print);
        // void метод, който принтира output на базата на:
        // 1. мап, който съдържа данните
        // 2. предикат, който се взима от метод, който зависи от ageCondition и age.
        // 3. void функция, която извиква метод, който връща Consumer<Map.Entry<String, Integer>>, който зависи от outputFormat.


    }

    private static Consumer<Map.Entry<String, Integer>> printer(String format) {
        switch (format) {
            case "name":
                return person -> System.out.printf("%s%n", person.getKey());

            case "age":
                return person -> System.out.printf("%d%n", person.getValue());

            default:
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());

        }
    }

    private static Predicate<Integer> createTester(String condition, Integer age) {
        switch (condition) {
            case "younger":
                return x -> x < age;

            default:
                return x -> x >= age;
        }
    }

    private static void printFilteredStudent(
            LinkedHashMap<String, Integer> people,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (tester.test(people.get(person.getKey()))) {
                printer.accept(person);
            }
        }
    }


}
