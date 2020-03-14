//when converted from c# to Java, two major problems occurred:
//1. It took me one hour to realize I forgot to change "==" to "equals" on row 28.
//2. ".remove" kept throwing exceptions, that's why I used and array forth and back instead.

package Exercises;

import java.util.*;

public class _08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> mapCards = new LinkedHashMap<>();
        Map<String, Integer> mapSummed = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(": ");

        String name = input[0];

        String inputCard = (input.length > 1) ? input[1] : "";
        String[] array = inputCard.split(", ");
        List<String> cards = new LinkedList<>(Arrays.asList(array));
        String currentCard = cards.get(0);

        int cardValue = 0;
        int cardColour = 0;

        while (!"JOKER".equals(name)) {
            int cardsCount = cards.size();
            for (int i = 0; i < cardsCount; i++) {

                cardValue = getCardValue(currentCard);
                cardColour = getCardColour(currentCard);

                if (!mapCards.containsKey(name)) {
                    mapCards.put(name, currentCard);
                    mapSummed.put(name, cardValue * cardColour);
                }

                if (!mapCards.get(name).contains(currentCard)) {
                    mapCards.put(name, mapCards.get(name) + (", " + currentCard));
                    mapSummed.put(name, mapSummed.get(name) + cardValue * cardColour);
                }

                if (!cards.isEmpty()) {

                    String[] arrayHelpToRemove = new String[cards.size() - 1];

                    for (int j = 1; j < cards.size(); j++) {
                        arrayHelpToRemove[j-1] = cards.get(j);
                    }
                    cards = Arrays.asList(arrayHelpToRemove);
                }

                if (!cards.isEmpty()) {
                    currentCard = cards.get(0);
                }
            }

            input = scanner.nextLine().split(": ");
            name = input[0];

            inputCard = (input.length > 1) ? input[1] : "";
            String[] cardsHelpArray = inputCard.split(", ");
            cards = Arrays.asList(cardsHelpArray);
            currentCard = cards.get(0);
        }

        for (Map.Entry<String, Integer> kvp : mapSummed.entrySet()) {
            System.out.printf("%s: %d\n", kvp.getKey(), kvp.getValue());
        }
    }

    static int getCardValue(String currentCard) {

        String currentValue = currentCard.substring(0, currentCard.length()-1);// bez minus 1?

        if (
                !"J".equals(currentValue) &&
                        !"Q".equals(currentValue) &&
                        !"K".equals(currentValue) &&
                        !"A".equals(currentValue)
        ) {
            return Integer.parseInt(currentValue);

        } else {
            switch (currentValue) {
                case "J":
                    return 11;
                case "Q":
                    return 12;
                case "K":
                    return 13;
                case "A":
                    return 14;
                default:
                    return 1000;
            }
        }
    }

    static int getCardColour(String currentCard) {
        char currentColour = currentCard.charAt(currentCard.length() - 1);

        switch (currentColour) {
            case 'S':
                return 4;
            case 'H':
                return 3;
            case 'D':
                return 2;
            case 'C':
                return 1;
            default:
                return 1000;
        }
    }
}
