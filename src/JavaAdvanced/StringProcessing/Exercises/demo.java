package StringProcessing.Exercises;

//import java.util.Arrays;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new LinkedList<>();

        list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<String> listStr = new LinkedList<>();

        list.stream().forEach(x -> listStr.add(x.toString()));


    }
}
