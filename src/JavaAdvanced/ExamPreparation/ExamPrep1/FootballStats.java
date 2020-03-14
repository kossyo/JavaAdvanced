package ExamPreparation.ExamPrep1;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FootballStats {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Game>> almanach = new LinkedHashMap<>();

        List<String> selectedTeams;
        String regex = "([A-Za-z]+(?: [A-Za-z]+)*) - ([A-Za-z]+(?: [A-Za-z]+)*) result (\\d)+:(\\d)+";
        Pattern pattern = Pattern.compile(regex);

        String line;
        while (!"Season End".equals((line = reader.readLine()))) {

            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String opponent1 = matcher.group(1);
                String opponent2 = matcher.group(2);
                int scoreOp1 = Integer.parseInt(matcher.group(3));
                int scoreOp2 = Integer.parseInt(matcher.group(4));

                Game gameStraight = new Game(new Pair<>(opponent1, scoreOp1), new Pair<>(opponent2, scoreOp2));
                Game gameReversed = new Game(new Pair<>(opponent2, scoreOp2), new Pair<>(opponent1, scoreOp1));

                if (almanach.get(opponent1) == null) {
                    almanach.put(opponent1, new ArrayList<>());
                }
                almanach.get(opponent1).add(gameStraight);

                if (almanach.get(opponent2) == null) {
                    almanach.put(opponent2, new ArrayList<>());

                }
                almanach.get(opponent2).add(gameReversed);
            }
        }

        selectedTeams = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());

        for (String selectedTeam : selectedTeams) {

            for (Map.Entry<String, List<Game>> team_listOfGames : almanach.entrySet()) {

                if (selectedTeam.equals(team_listOfGames.getKey())) {

                    team_listOfGames.getValue().stream()
                            .sorted(Comparator.comparing(game -> game.getTeam2_score().getKey()))
                            .forEach(game -> System.out.printf("%s - %s -> %d:%d%n",
                                    game.getTeam1_score().getKey(),
                                    game.getTeam2_score().getKey(),
                                    game.getTeam1_score().getValue(),
                                    game.getTeam2_score().getValue()));
                }
            }
        }
    }
}

class Game {

    Pair<String, Integer> team1_score;
    Pair<String, Integer> team2_score;

    public Game(Pair<String, Integer> team1_score, Pair<String, Integer> team2_score) {
        this.team1_score = team1_score;
        this.team2_score = team2_score;
    }

    public Pair<String, Integer> getTeam1_score() {
        return team1_score;
    }

    public Pair<String, Integer> getTeam2_score() {
        return team2_score;
    }
}