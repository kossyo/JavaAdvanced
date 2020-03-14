//90/100

package ExamPreparation._27aug2018;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _04_Agents {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> listOfAgents = new LinkedList<>();
        Map<String, Double> listOfMissions = new LinkedHashMap<>();

        Map<String, Map<String, Double>> chart = new LinkedHashMap<>();

        String line;
        while (!"registration".equals((line = reader.readLine()))) {

            if (line.startsWith("#")) {

                String[] tokens = line.split(":");
                String missionName = tokens[0];
                double missionRating = Double.parseDouble(tokens[1]);

                listOfMissions.put(missionName, missionRating);///// put if absent???
            } else if (line.charAt(line.length() - 3) == '0') {
                listOfAgents.add(line);
            }
        }
        while (!"operate".equals((line = reader.readLine()))) {

            String[] tokens = line.split("->");
            String action = tokens[0];
            if ("assign".equals(action)) {

                String agentName = tokens[1];
                String[] missionDetails = tokens[2].split(":");
                String missionName = missionDetails[0];
                chart = assign(agentName, missionName, chart, listOfMissions);
            } else if ("abort".equals(action)) {
                String missionName = tokens[1];
                abort(missionName, chart, listOfMissions);

            } else if ("change".equals(action)) {

                String agent1 = tokens[1];
                String agent2 = tokens[2];

                change(chart, agent1, agent2);

            }
        }
        System.out.println();
        printResults(chart);
    }

    private static void change(Map<String, Map<String, Double>> chart, String agent1, String agent2) {


        Map<String, Double> temporaryMap = new LinkedHashMap<>();
        temporaryMap = chart.get(agent1);
        chart.put(agent1, chart.get(agent2));
        chart.put(agent2, temporaryMap);
    }

    private static void abort(String missionName,
                              Map<String, Map<String, Double>> chart,
                              Map<String, Double> listOfMissions) {

        for (Map.Entry<String, Map<String, Double>> kvp : chart.entrySet()) {
            if (kvp.getValue().containsKey(missionName)){
                chart.get(kvp.getKey()).remove(missionName);
            }
        }
    }

    private static void printResults(Map<String, Map<String, Double>> chart) {

        chart.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().values().stream().reduce(0.0, Double::sum)
                        .compareTo(a.getValue().values().stream().reduce(0.0, Double::sum))
                )
                .filter(agent__mission_rating -> !agent__mission_rating.getValue().isEmpty()
                        ||agent__mission_rating.getValue() == null)
                .forEach(agent__mission_rating -> {

                            System.out.printf("Agent: %s - Total Rating: %.2f%n",
                                    agent__mission_rating.getKey(),
                                    agent__mission_rating.getValue()
                                            .values()
                                            .stream()
                                            .reduce(0.0, Double::sum)
                            );
                            agent__mission_rating.getValue().entrySet().stream().forEach(mission_rating -> {

                                System.out.printf(" - %s -> %.2f%n", mission_rating.getKey(), mission_rating.getValue());
                            });
                        }
                );
    }

    private static Map<String, Map<String, Double>> assign(String agentName, String missionName,
                                                           Map<String, Map<String, Double>> chart,
                                                           Map<String, Double> listOfMissions) {


        chart.putIfAbsent(agentName, new LinkedHashMap<>());
        if (listOfMissions.containsKey(missionName)) {
            chart.get(agentName).put(missionName, listOfMissions.get(missionName));
        }
        return chart;
    }
}
