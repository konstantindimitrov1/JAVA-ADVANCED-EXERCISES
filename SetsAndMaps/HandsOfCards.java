package SetsAndMaps;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create map
        Map<String, Set<String>> playerCards = new LinkedHashMap<>();
        // take input
        String input = scanner.nextLine();
        // create loop
        while (!input.equals("JOKER")) {
            // get data
            String[] tokens = input.split(": ");
            String playerName = tokens[0];
            String[] cards = tokens[1].split(", ");
            //fill data
            playerCards.putIfAbsent(playerName, new LinkedHashSet<>());
            Set<String> fill = playerCards.get(playerName);
            fill.addAll(List.of(cards));
            playerCards.put(playerName, fill);
            input = scanner.nextLine();
        }

        // print
        playerCards.forEach((key, value) -> {
            int result = calculatePoints(value);
            System.out.printf("%s: %d\n", key, result);
        });
    }


    private static int calculatePoints(Set<String> cards) {
        int result = 0;
        for (String card : cards) {
            String firstChar = card.substring(0, card.length() - 1);
            char secondChar = card.charAt(card.length() - 1);
            int value;
            int power = 0;
            value = switch (firstChar) {
                case "J" -> 11;
                case "Q" -> 12;
                case "K" -> 13;
                case "A" -> 14;
                default -> Integer.parseInt(firstChar);
            };

            switch (secondChar) {
                case 'S' -> power = 4;
                case 'H' -> power = 3;
                case 'D' -> power = 2;
                case 'C' -> power = 1;
            }
            result += power * value;
        }


        return result;
    }
}
