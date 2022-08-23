package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create ds
        Map<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            if (isInputValid(input)) {
                // get data
                String[] tokensForName = input.split(" @");
                String name = tokensForName[0];
                String[] tokens = tokensForName[1].split(" ");
                int ticketsCount = Integer.parseInt(tokens[tokens.length - 1]);
                int ticketsPrice = Integer.parseInt(tokens[tokens.length - 2]);
                int sum = ticketsCount * ticketsPrice;
                String venueName = getVenueName(tokens);

                // fill data
                venues.putIfAbsent(venueName, new LinkedHashMap<>());
                LinkedHashMap<String, Integer> singers = venues.get(venueName);
                singers.putIfAbsent(name, 0);
                singers.put(name, singers.get(name) + sum);
                venues.put(venueName, singers);
            }

            // get new input
            input = scanner.nextLine();
        }

        // print
        venues.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(singer -> System.out.printf("#  %s -> %d\n", singer.getKey(), singer.getValue()));
        });

    }

    private static String getVenueName(String[] tokens) {
        StringBuilder venueName = new StringBuilder();
        for (int i = 0; i < tokens.length - 2; i++) {
            venueName.append(tokens[i]).append(" ");
        }
        return venueName.toString().trim();
    }

    // check valid input
    private static boolean isInputValid(String input) {
        String[] checkName = input.split(" @");
        if (checkName.length == 1) {
            return false;
        }
        String[] checkOtherData = checkName[1].split(" ");
        if (checkOtherData.length < 3) {
            return false;
        }
        for (int i = checkOtherData.length - 1; i > checkOtherData.length - 3; i--) {
            for (int j = 0; j < checkOtherData[i].length(); j++) {
                if (!Character.isDigit(checkOtherData[i].charAt(j))) {
                    return false;
                }
            }

        }
        return true;
    }
}
