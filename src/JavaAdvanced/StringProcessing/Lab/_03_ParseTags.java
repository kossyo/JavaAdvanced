package StringProcessing.Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_ParseTags {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regexPattern = "<upcase>(.+?)<\\/upcase>";
        Pattern pattern = Pattern.compile(regexPattern);
        String text = scanner.nextLine();
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String stringToReplace = matcher.group(1);
            String replacement = stringToReplace.toUpperCase();
            text = text.replace("<upcase>" + stringToReplace + "</upcase>", replacement);

        }

        System.out.println(text);
    }
}
