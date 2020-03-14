package ExamPreparation._03Jan2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHARMAInitiative {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Station> stations = new LinkedList<>();

        Station Hydra = new Station();
        Hydra.stationTask = "Zoological Research.";
        Hydra.stationName = "Hydra";

        Station Arrow = new Station();
        Arrow.stationTask = "Development of defensive strategies, and Intelligence gathering.";
        Arrow.stationName = "Arrow";

        Station Flame = new Station();
        Flame.stationTask = "Communication.";
        Flame.stationName = "Flame";

        Station Pearl = new Station();
        Pearl.stationTask = "Psychological Research and/or Observation.";
        Pearl.stationName = "Pearl";

        Station Orchid = new Station();
        Orchid.stationTask = "Space-time manipulation research, disguised as a Botanical station.";
        Orchid.stationName = "Orchid";

        stations.add(Hydra);
        stations.add(Arrow);
        stations.add(Flame);
        stations.add(Pearl);
        stations.add(Orchid);

        String line;
        Pattern patternName = Pattern.compile("[A-Z][a-z]+(?: [A-Z][a-z]+)*");

        while (!"Recruit".equals((line = reader.readLine()))) {

            String[] tokens = line.split(":");
            String recrName = tokens[0];
            long recrNumber = Long.parseLong(tokens[1]);
            String appliesForStation = tokens[2];

            Matcher matcherName = patternName.matcher(recrName);

            if (matcherName.find() && stations.stream().anyMatch(station -> appliesForStation.equals(station.stationName))) {

                stations
                        .stream()
                        .filter(station -> appliesForStation.equals(station.stationName))
                        .findFirst()
                        .get()
                        .candidates
                        .put(recrNumber, recrName);
            }
        }
        String command = reader.readLine();

        if ("DHARMA Initiative".equals(command)) {

            stations
                    .stream()
                    .sorted((station1, station2) -> {

                        if (station2.getCandidates().size() != station1.getCandidates().size()) {
                            return station2.getCandidates().size() - station1.getCandidates().size();
                        } else {
                            return station1.stationName.compareTo(station2.stationName);
                        }
                    })
                    .forEach(station -> System.out.printf("The %s has %d DHARMA recruits in it.%n",
                            station.stationName,
                            station.candidates.size()));

        }
        else {

            Optional<Station> stationSearched = stations.stream().filter(station -> station.stationName.equals(command)).findFirst();
            if (stationSearched.isPresent()){
                System.out.printf("The %s station: %s%n",
                        stationSearched.get().stationName,
                        stationSearched.get().getStationTask());


                if (stationSearched.get().candidates.size() > 0 ) {
                    stationSearched.get().candidates.entrySet().stream()
                            .sorted((candidate1, candidate2) -> candidate2.getKey().compareTo(candidate1.getKey()))
                            .forEach(candidate ->

                                    System.out.printf("###%s - %d%n", candidate.getValue(), candidate.getKey())
                            );
                }
                else {
                    System.out.println("No recruits.");
                }
            }
            else{
                System.out.println("DHARMA Initiative does not have such a station!");
            }
        }
    }
}

class Station {

    String stationTask = "";
    String stationName = "";
    Map<Long, String> candidates = new LinkedHashMap<>();

    public String getStationTask() {
        return stationTask;
    }

    public String getStationName() {
        return stationName;
    }

    public Map<Long, String> getCandidates() {
        return candidates;
    }
}