package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class demo {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>(Arrays.asList("a4ko", "bobo", "vladi", "mitko", "ivanka"));

        List<String> newList = new LinkedList<>();

        BiFunction<String, Integer, Boolean> biPredicate = (str, integer) -> str.length() + integer == 6;


        for (int j = 0; j < list.size(); j++) {


            if (biPredicate.apply("kur", j)) {
                newList.add(list.get(j));
            }

        }


        newList.forEach(System.out::println);

    }
}
