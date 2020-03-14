package Exercises;

import java.util.*;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _13_SrpskoUnleashed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String singer = "";
        String venue = "";
        long ticketPrice = 0;
        long ticketsCount = 0;
        long turnOver = 0;
        String regex = "(.+) @(.+) (\\d+) (\\d+)";


        Map<String, Map<String, Long>> venue__singer_turnover = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();

            if ("End".equals(input)) {
                break;
            }

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                singer = matcher.group(1);
                venue = matcher.group(2);
                ticketPrice = Long.parseLong(matcher.group(3));
                ticketsCount = Long.parseLong(matcher.group(4));
                turnOver = ticketPrice * ticketsCount;
            } else {
                continue;
            }

            if (!venue__singer_turnover.containsKey(venue)) {//няма такова venue

                LinkedHashMap<String, Long> singer_turnover = new LinkedHashMap<>();
                singer_turnover.put(singer, turnOver);

                venue__singer_turnover.put(venue, singer_turnover);
            } else {//има такова venue

                if (!venue__singer_turnover.get(venue).containsKey(singer)) {//няма такъв singer

                    venue__singer_turnover.get(venue).put(singer, turnOver);
                } else {// има такъв singer

                    venue__singer_turnover.get(venue).put(singer,
                            venue__singer_turnover.get(venue).get(singer) + turnOver);
                }
            }
        }
        venue__singer_turnover.entrySet()
                .forEach(outerKvp -> {
                    System.out.printf("%s\n", outerKvp.getKey());

                    outerKvp.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(innerKvp -> System.out.printf("#  %s -> %d\n", innerKvp.getKey(), innerKvp.getValue()));
                });
    }
}
