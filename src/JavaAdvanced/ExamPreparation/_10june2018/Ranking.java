package ExamPreparation._10june2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ranking {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contests = new LinkedHashMap<>();
        Map<String, Map<String, Long>> ranking = new LinkedHashMap<>();

        String line;
        while (!"end of contests".equals((line = reader.readLine()))) {

            String[] nameAndPsswd = line.split(":");

            if (nameAndPsswd.length != 2) {
                continue;
            }

            String name = nameAndPsswd[0];
            String psswd = nameAndPsswd[1];

            contests.put(name, psswd);
        }

        Pattern pattern = Pattern.compile("(.+)=>(.+)=>(.+)=>(\\d+)");
        while (!"end of submissions".equals((line = reader.readLine()))) {

            Matcher matcher = pattern.matcher(line);

            fillRanking(contests, ranking, matcher);
        }

        String winner =
                ranking
                        .entrySet()
                        .stream()
                        .sorted((kkvEntry1, kkvEntry2) ->
                                kkvEntry2
                                        .getValue()
                                        .values()
                                        .stream()
                                        .reduce(0L, Long::sum)
                                        .compareTo(kkvEntry1
                                                .getValue()
                                                .values()
                                                .stream()
                                                .reduce(0L, Long::sum)))
                        .findFirst()
                        .get()
                        .getKey();


///////////////////////////////////////////////OR///////////////////////////////////////////////////////////
        // String winner =
//                ranking
//                        .entrySet()
//                        .stream()
//                        .filter(kkv ->
//                                kkv.getValue()//inner map
//                                        .values()
//                                        .stream()
//                                        .reduce(0L, Long::sum)
//                                        ==
//                                        ranking
//                                                .entrySet()
//                                                .stream()
//                                                .mapToLong(x ->
//                                                        x.getValue()
//                                                                .values()
//                                                                .stream()
//                                                                .reduce(0l, Long::sum))
//                                                .max()
//                                                .getAsLong())
//                        .findFirst()
//                        .get()
//                        .getKey();

        long winnersPoints =

                ranking
                        .get(winner)
                        .values()
                        .stream()
                        .reduce(0L, Long::sum);


/////////////////////////////////////////////////////OR/////////////////////////////////////////////////////////////

        // long winnersPoints =
//                ranking
//                        .entrySet()
//                        .stream()
//                        .mapToLong(x ->
//                                x.getValue()
//                                        .values()
//                                        .stream()
//                                        .reduce(0l, Long::sum))
//                        .max()
//                        .getAsLong();

        System.out.printf("Best candidate is %s with total %d points.%n", winner, winnersPoints);
        System.out.println("Ranking:");

        ranking
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(kkvEntry -> {
                    System.out.println(kkvEntry.getKey());

                    kkvEntry
                            .getValue()
                            .entrySet()
                            .stream()
                            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                            .forEach(kvEntry -> {
                                System.out.printf("#  %s -> %d%n",
                                        kvEntry.getKey(), kvEntry.getValue());

                            });
                });
    }

    private static void fillRanking(Map<String, String> contests, Map<String, Map<String, Long>> ranking, Matcher matcher) {
        if (matcher.find()) {

            String contest = matcher.group(1);
            String psswd = matcher.group(2);
            String username = matcher.group(3);
            long points = Long.parseLong(matcher.group(4));

            if (contests.containsKey(contest)) {
                if (psswd.equals(contests.get(contest))) {
                    if (!ranking.containsKey(username)) {

                        ranking.put(username, new LinkedHashMap<>());
                        ranking.get(username).put(contest, points);
                    } else {

                        if (!ranking.get(username).containsKey(contest)) {

                            ranking.get(username).put(contest, points);
                        } else {

                            if (points > ranking.get(username).get(contest))
                                ranking.get(username).put(contest, points);
                        }
                    }
                }
            }
        }
    }
}
