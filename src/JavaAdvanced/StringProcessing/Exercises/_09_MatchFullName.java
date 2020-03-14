package StringProcessing.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _09_MatchFullName {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String patternStr = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        Pattern pattern = Pattern.compile(patternStr);
        String line = "";

        while (!(line = scanner.nextLine()).equals("end")) {

            Matcher matcher = pattern.matcher(line);
            if (matcher.find())
                System.out.println(matcher.group(0));
        }
    }
}
