package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initialize the decks
        Set<Integer> playerOneCards = new LinkedHashSet<>();
        Set<Integer> playerTwoCards = new LinkedHashSet<>();
        int[] cards = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int card : cards) {
            playerOneCards.add(card);
        }
        cards = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int card : cards) {
            playerTwoCards.add(card);
        }

        // start the game
        for (int i = 0; i < 50; i++) {
            if (playerOneCards.isEmpty() || playerTwoCards.isEmpty()) {
                break;
            }
            int firstNumber = playerOneCards.iterator().next();
            playerOneCards.remove(firstNumber);
            int secondNumber = playerTwoCards.iterator().next();
            playerTwoCards.remove(secondNumber);
            if (firstNumber > secondNumber) {
                playerOneCards.add(firstNumber);
                playerOneCards.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                playerTwoCards.add(firstNumber);
                playerTwoCards.add(secondNumber);
            }
        }


        String output;
        if (playerOneCards.size() > playerTwoCards.size()) {
            output = "First player win!";
        } else if (playerTwoCards.size() > playerOneCards.size()) {
            output = "Second player win!";
        } else {
            output = "Draw!";
        }

        System.out.println(output);
    }


}
