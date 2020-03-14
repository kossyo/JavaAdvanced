package ExamPreparation._03may2017;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterExpression {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        List<String> matches = new LinkedList<>();

        String myRegex = "-?\\d+(?:\\.\\d+)*";
        String otherRegex = "([-]?[0-9]+)";
        Pattern pattern = Pattern.compile(myRegex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            matches.add(matcher.group());
        }
        double result = Double.parseDouble(matches.get(0));

        for (int i = 0; i < matches.size() - 1; i++) {

            if ((input.indexOf(matches.get(i+1))
                    - input.indexOf(matches.get(i))/
                    - matches.get(i).length())
                    % 2 == 0){
                //result = result.add(new BigDecimal(Double.parseDouble(matches.get(i+1))));
                result += Double.parseDouble(matches.get(i+1));
            }
            else{
                result -= Double.parseDouble(matches.get(i+1));
            }
        }
        DecimalFormat df = new DecimalFormat("##.#######");
        System.out.println(df.format(result));
    }
}
