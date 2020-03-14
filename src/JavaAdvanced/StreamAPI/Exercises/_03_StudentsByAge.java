package StreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _03_StudentsByAge {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();
        String input;

        while (!"END".equals(input = reader.readLine())){

            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Student student = new Student();
            student.firstName = firstName;
            student.lastName = lastName;
            student.age = age;
            students.add(student);
        }

        students.stream().filter(student -> student.age >= 18 && student.age <= 24)
                .forEach(x -> System.out.println(String.format("%s %s %d", x.firstName, x.lastName, x.age)));
    }
}
