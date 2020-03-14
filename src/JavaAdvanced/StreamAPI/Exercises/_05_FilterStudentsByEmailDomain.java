package StreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _05_FilterStudentsByEmailDomain {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();
        String input;

        while (!"END".equals(input = reader.readLine())) {

            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            String email = tokens[2];

            Student student = new Student();
            student.firstName = firstName;
            student.lastName = lastName;
            student.email = email;
            students.add(student);
        }

        students.stream().filter(student -> student.email.endsWith("@gmail.com"))
                .forEach(x -> System.out.println(x.firstName + " " + x.lastName));

    }
}
