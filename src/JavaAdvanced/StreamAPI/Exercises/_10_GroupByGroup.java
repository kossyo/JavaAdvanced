package StreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class _10_GroupByGroup {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> listOfPersons = new LinkedList<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {

            String[] tokens = input.split(" ");
            String name1 = tokens[0];
            String name2 = tokens[1];
            int group = Integer.parseInt(tokens[2]);
            String name = name1 + " " + name2;

            Person person = new Person(name, group);
            listOfPersons.add(person);
        }
        listOfPersons.stream()
                .collect(Collectors.groupingBy(Person::getGroup))
                .forEach((group, currentListOfPersonsNames) -> System.out.printf("%d - %s%n", group,

                        String.join(" ",
                                currentListOfPersonsNames.stream()
                                        .map(Person::getName).collect(Collectors.toList())

                        )));

    }
}

class Person {
    String name;
    int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }
}
