package StreamAPI.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _08_WeakStudents {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();
        String input;

        while (!"END".equals(input = reader.readLine())) {

            String[] tokens = input.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            List<Integer> marks = new ArrayList<>();

            for (int i = 2; i < tokens.length; i++) {
                marks.add(Integer.parseInt(tokens[i]));
            }

            Student student = new Student();
            student.firstName = firstName;
            student.lastName = lastName;
            student.marks = marks;
            students.add(student);

        }
        students.stream()
                .filter(student -> (int) student.marks.stream()
                        .filter(mark -> mark <= 3)
                        .count() >= 2)
                .forEach(student -> System.out.println(student.firstName + " " + student.lastName));
    }
}

