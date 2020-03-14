package StreamAPI.Exercises;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _11_StudentJoinedToSpecialties {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpecialty> specialties = new ArrayList<>();
        List<Student1> students = new ArrayList<>();
        String line;

        while (!"Students:".equals(line = reader.readLine())) {

            String[] tokens = line.split(" ");
            String fac1 = tokens[0];
            String fac2 = tokens[1];
            String facNum = tokens[2];

            StudentSpecialty studentSpecialty = new StudentSpecialty(facNum, fac1 + " " + fac2);

            specialties.add(studentSpecialty);

        }

        while (!"END".equals(line = reader.readLine())) {

            String[] tokens = line.split("\\s+");
            String facNum = tokens[0];
            String name1 = tokens[1];
            String name2 = tokens[2];
            Student1 student1 = new Student1(name1 + " " + name2, facNum);

            students.add(student1);
        }
        System.out.println();
        students.stream()
                .sorted(Comparator.comparing(Student1::getStudentName))
                .forEach(student1 -> specialties
                        .forEach(spec -> {
                            if (student1.getFacNum().equals(spec.getFacNum())) {
                                System.out.printf("%s %s %s%n", student1.getStudentName(), student1.getFacNum(), spec.getSpecialtyName());
                            }
                        }));
        System.out.println();
    }
}

class StudentSpecialty {

    String facNum;
    String specialtyName;

    public StudentSpecialty(String facNum, String specialtyName) {
        this.specialtyName = specialtyName;
        this.facNum = facNum;
    }

    public String getFacNum() {
        return facNum;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }
}

class Student1 {

    String studentName;
    String facNum;

    public Student1(String studentName, String facNum) {
        this.studentName = studentName;
        this.facNum = facNum;
    }

    public String getFacNum() {
        return facNum;
    }

    public String getStudentName() {
        return studentName;
    }
}