package StreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _04_SortStudents {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();
        String input;

        while (!"END".equals(input = reader.readLine())) {

            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            //int age = Integer.parseInt(tokens[2]);

            Student student = new Student();
            student.firstName = firstName;
            student.lastName = lastName;
            //student.age = age;
            students.add(student);
        }

        students.stream().sorted((student1, student2) -> {

            if (student1.lastName.compareTo(student2.lastName) != 0)
                return student1.lastName.compareTo(student2.lastName);
            else {
                return student2.firstName.compareTo(student1.firstName);
            }
        }).forEach(x -> System.out.printf("%s %s%n", x.firstName, x.lastName));
    }
}
