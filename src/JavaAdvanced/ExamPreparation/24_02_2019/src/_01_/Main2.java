package _01_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(reader.readLine());

        Deque<String> input = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Hall> halls = new ArrayDeque<>();
        Hall currentHall = null;
        int overflow = 0;

        while (!input.isEmpty()) {

            String currentChunk = input.pollLast();

            if (Character.isLetter(currentChunk.charAt(0))) { // is hall
                halls.addLast(new Hall(Objects.requireNonNull(currentChunk).charAt(0), capacity));
            }

            //if (overflow != 0 && !currentChunkIsLetter) { //is group

            int groupTryingToEnter = 0;

            if (currentHall == null) {
                currentHall = halls.pollLast();
            }
            if (overflow != 0) {

                groupTryingToEnter = overflow;
                overflow = 0;
            } else {

                if (!input.isEmpty() && !Character.isLetter(currentChunk.charAt(0))) {
                    groupTryingToEnter = Integer.parseInt(currentChunk);
                }
            }

            if (currentHall != null) {

                if (currentHall.roomLeft - groupTryingToEnter > 0) {    // ще се съберат
                    currentHall.roomLeft -= groupTryingToEnter;
                    currentHall.groups.add(groupTryingToEnter);
                } else {     // няма да се съберат
                    overflow = groupTryingToEnter;
                    System.out.println(currentHall);
                    //currentHall = halls.pollLast();
                    currentHall = null;
                }
            }
            // }
        }


    }

//    public static class Hall {
//
//        public char name;
//        public int roomLeft;
//        public List<Integer> groups;
//
//        public Hall(char name, int capacity) {
//            this.name = name;
//            this.roomLeft = capacity;
//            this.groups = new LinkedList<>();
//        }
//
//        @Override
//        public String toString() {
//
//            return String.format("%c -> %s",
//                    this.name,
//                    this.groups.stream().map(String::valueOf).collect(Collectors.joining(", ")));
//        }
//    }


}
