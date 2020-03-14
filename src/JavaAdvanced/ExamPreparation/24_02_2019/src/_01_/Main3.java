package _01_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());
        Deque<String> input = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Hall> halls = new ArrayDeque<>();
        Hall currentHall = null;

        while (!input.isEmpty()) {

            String currentChunk = input.pollLast();
            //IS LETTER
            if (Character.isLetter(currentChunk.charAt(0))) {

                halls.addLast(new Hall(Objects.requireNonNull(currentChunk).charAt(0), capacity));
            }
            //IS NUMBER
            else {

                int group = Integer.parseInt(currentChunk);

                if (currentHall == null) {

                    if (!halls.isEmpty()) {  //ima hall

                        currentHall = halls.pollLast();

                    }
                    else{
                        continue;
                    }

                }

                if (currentHall.roomLeft - group >= 0) { // they fit
                    currentHall.roomLeft -= group;
                    currentHall.groups.add(group);

                } else {//  they dont fit

                    System.out.println(currentHall);
                    currentHall = null;

                    if (!halls.isEmpty()) {

                        currentHall = halls.poll();


                        if (currentHall != null && currentHall.roomLeft - group > 0) {
                            currentHall.roomLeft -= group;
                            currentHall.groups.add(group);
                        }
                    }
                }
            }
        }
    }
}


class Hall {

    public char name;
    public int roomLeft;
    public List<Integer> groups;

    public Hall(char name, int capacity) {
        this.name = name;
        this.roomLeft = capacity;
        this.groups = new LinkedList<>();
    }

    @Override
    public String toString() {

        return String.format("%c -> %s",
                this.name,
                this.groups.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}