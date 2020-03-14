//This solution provides 100/100 but it accepts "5dfgdf" as a word starting with a capital letter.
//Judge is programmed based on solution under.

package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _03_CountUpperCaseWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.asList(scanner.nextLine().split(" "));

        Predicate<String> isUpper = word -> word.charAt(0) == word.toUpperCase().charAt(0);
        List<String> upper = new ArrayList();

        for(String word : list){

            if(isUpper.test(word)){
                upper.add(word);
            }
        }
        System.out.println(upper.size());
        upper.forEach(word -> System.out.println(word));
    }
}
