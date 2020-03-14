package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new LinkedList<>();

        numbers = Arrays.stream("123 10 11 3".split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(numbers);
     //   System.out.println(numbers.indexOf());


    }
}
