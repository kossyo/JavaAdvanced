//50/100


package StringProcessing.Lab;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^[\\w-]{3,16}$");
        String input;
        List<String> list = new LinkedList<>();

        while (!(input = scanner.nextLine()).equals("END")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                list.add("valid");
            } else {
                list.add("invalid");
            }
        }
        if (list.contains("valid"))
            list.stream().forEach(x -> System.out.println(x));
    }
}
