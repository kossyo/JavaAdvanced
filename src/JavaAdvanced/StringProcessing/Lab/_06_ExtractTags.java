package StringProcessing.Lab;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_ExtractTags {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("<.+?>");
        List<String> list = new LinkedList<>();
        String input;
        while (!(input = scanner.nextLine()).equals("END")) {

            Matcher matcher = pattern.matcher(input);

            while(matcher.find()){
                list.add(matcher.group(0));
            }
        }

        list.stream().forEach(x -> System.out.println(x));
    }
}
