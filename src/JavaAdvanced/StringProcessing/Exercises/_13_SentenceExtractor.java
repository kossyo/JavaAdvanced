
package StringProcessing.Exercises;

    import java.util.Scanner;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class _13_SentenceExtractor {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            String keyword = scanner.nextLine();
            String input = scanner.nextLine();

            String regexPattern = String.format("(?<= |^)(?:[\\w ;:,\"\'\\(\\)-]+ )*%s(?: [\\w ;:,\"\'\\(\\)-]+)*[\\.!?]", keyword);

            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(input);

            while(matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }
