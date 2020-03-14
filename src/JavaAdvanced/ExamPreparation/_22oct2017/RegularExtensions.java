package ExamPreparation._22oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        String line;
        while (!"Print".equals((line = reader.readLine()))) {

            line = line.replaceAll("%", "\\\\S*");
            //line = line.replaceAll("\\.", "\\\\.");

//            line = line.replaceAll("$", "\\$");
//            line = line.replaceAll("\\(", "\\\\(");
//            line = line.replaceAll("\\)", "\\\\)");
//            line = line.replaceAll("\\[", "\\\\[");
//            line = line.replaceAll("\\]", "\\\\]");
//            line = line.replaceAll("\\/", "\\\\/");


            //line = line.replaceAll("")

            Pattern pattern = Pattern.compile(line);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {

                StringBuilder replacement = new StringBuilder(matcher.group());
                replacement.reverse();
                text = text.replaceAll(matcher.group(), replacement.toString());
            }

            //     text.replaceAll(line, )
        }
        System.out.println(text);

    }
}
