//80/100

package ExamPreparation.ExamPrep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> dictionary = new LinkedHashMap<>();

        String line;

        while (!"Ascend".equals((line = reader.readLine()))) {

            Pattern pattern = Pattern.compile("(,|_)([A-Za-z]+)(\\d)");
            Matcher matcher = pattern.matcher(line);

            String match = "";
            String replacement = "";

            while (matcher.find()) {

                match = matcher.group(0);
                replacement = getDecryptedFragment(matcher);

                for (String currentWord : dictionary.keySet()) {

                    if (line.contains(currentWord)) {
                        line = line.replaceAll(match, replacement);
                        break;

                    }
                }
                matcher = pattern.matcher(line);
                if (!"".equals(match)) {
                    dictionary.put(match, replacement);
                }
            }

            System.out.println(line);
        }
    }

    private static String getDecryptedFragment(Matcher matcher) {

        int coefficient = Integer.parseInt(matcher.group(3));

        StringBuilder decrypted = new StringBuilder();

        switch (matcher.group(1)) {

            case ",":

                for (int i = 0; i < matcher.group(2).length(); i++) {

                    decrypted.append((char) (matcher.group(2).charAt(i) + coefficient));
                }

                break;

            case "_":

                for (int i = 0; i < matcher.group(2).length(); i++) {

                    decrypted.append((char) (matcher.group(2).charAt(i) - coefficient));
                }

                break;
        }

        return decrypted.toString();
    }
}
