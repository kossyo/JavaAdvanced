package ExamPreparation._03may2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class HandScore {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] hand = reader.readLine().split(" ");
        long sum = 0;
        char lastSuit = hand[0].charAt(hand[0].length() - 1);
        List<List<String>> sequences = new LinkedList<>();

        List<String> sequence = new LinkedList<>();

        for (int i = 0; i < hand.length; i++) {

            String card = hand[i];
            char suit = card.charAt(card.length() - 1);

            if (suit == lastSuit) {

                sequence.add(card);
            } else {

                sequences.add(sequence);
                sequence = new LinkedList<>();
                sequence.add(card);
                lastSuit = suit;
            }
            if (i == hand.length - 1) {
                sequences.add(sequence);
            }
        }

        for (List<String> seq : sequences) {

            long value = 0;
            long currentSum = 0;

            for (String currentCard : seq) {

                try {

                    value = Integer.parseInt(currentCard.substring(0, currentCard.length() - 1));
                } catch (Exception e) {

                    value =
                            "J".equals(currentCard.substring(0, currentCard.length() - 1)) ? 12 :
                                    "Q".equals(currentCard.substring(0, currentCard.length() - 1)) ? 13 :
                                            "K".equals(currentCard.substring(0, currentCard.length() - 1)) ? 14 :
                                                    "A".equals(currentCard.substring(0, currentCard.length() - 1)) ? 15 : 0;
                }
                currentSum += value;
            }
            sum += currentSum * seq.size();
        }
        System.out.println(sum);
    }
}
