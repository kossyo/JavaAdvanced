package StreamAPI.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {

        Map<String, Student> map = new LinkedHashMap<>();

        Student student = new Student();
        student.lastName = "koev";
        student.age = 32;
        map.put("Bulgaria", student);




    }
}
