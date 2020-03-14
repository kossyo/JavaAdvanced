package ExamPreparation._22oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class V_logger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        List<VLogger> data = new LinkedList<>();

        while (!"Statistics".equals((line = reader.readLine()))) {

            String[] tokens = line.split(" ", 3);

            String name = tokens[0];

            if (tokens.length > 1) {
                String action = tokens[1];

                if ("joined".equals(action)) {

                    VLogger vlogger = new VLogger();
                    vlogger.name = name;
                    vlogger.following = new HashSet<>();
                    vlogger.followedBy = new HashSet<>();

                    if (data.stream().noneMatch(vlogger1 -> vlogger1.getName().equals(name))) {
                        data.add(vlogger);
                    }

                } else if ("followed".equals(action)) {

                    String name2 = tokens[2];
                    if (data.stream().anyMatch(vLogger -> vLogger.getName().equals(name)
                            && data.stream().anyMatch(vLogger1 -> vLogger1.getName().equals(name2)))
                            && !name.equals(name2)) {

                        data.stream()
                                .filter(vLogger -> vLogger.getName().equals(name2))
                                .findFirst().get().getFollowedBy().add(name);//add pen4o na mene

                        data.stream()
                                .filter(vLogger -> vLogger.getName().equals(name))
                                .findFirst().get().getFollowing().add(name2);
                    }
                }
            }
        }
        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", data.size());

        Optional<VLogger> winner = data
                .stream()
                .sorted((v1, v2) -> {

                    if (v2.getFollowedBy().size() != v1.getFollowedBy().size()) {
                        return v2.getFollowedBy().size() - v1.getFollowedBy().size();
                    } else {
                        return v1.getFollowing().size() - v2.getFollowing().size();
                    }
                })
                .findFirst();

        System.out.printf("1. %s : %d followers, %d following%n",

                winner.get().getName(),
                winner.get().getFollowedBy().size(),
                winner.get().getFollowing().size()
        );
        if (!winner.get().getFollowedBy().isEmpty()) {
            winner.get().getFollowedBy().stream()
                    .sorted()
                    .forEach(follower -> System.out.printf("*  %s%n", follower));
            data.removeIf(vLogger -> vLogger.getName().equals(winner.get().name));

            int[] counter = {2};
            data.stream().sorted((v1, v2) -> {

                if (v2.getFollowedBy().size() != v1.getFollowedBy().size()) {
                    return v2.getFollowedBy().size() - v1.getFollowedBy().size();
                } else {
                    return v1.getFollowing().size() - v2.getFollowing().size();
                }
            }).forEach(vLogger -> {

                        System.out.printf("%d. %s : %d followers, %d following%n",
                                counter[0],
                                vLogger.getName(),
                                vLogger.getFollowedBy().size(),
                                vLogger.getFollowing().size()
                        );
                        counter[0]++;
                    }
            );
        }
    }
}

class VLogger {

    String name;
    Set<String> following;
    Set<String> followedBy;

    public String getName() {
        return name;
    }


    public Set<String> getFollowing() {
        return following;
    }


    public Set<String> getFollowedBy() {
        return followedBy;
    }
}