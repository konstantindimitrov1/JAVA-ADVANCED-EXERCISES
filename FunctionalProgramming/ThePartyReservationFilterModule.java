package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        List<String> commands = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Print")) {
            String actionType = input.split(";")[0];
            if (actionType.equals("Add filter")) {
                commands.add(input);
            } else {
                String[] tokens = input.split(";");
                commands.removeIf(e -> e.equals(String.format("Add filter;%s;%s", tokens[1], tokens[2])));
            }

            input = scanner.nextLine();
        }

        for (String command : commands) {
            String[] tokens = command.split(";");
            String condition = tokens[1];
            String parameters = tokens[2];

            guests.removeIf(getPredicate(condition, parameters));
        }

        System.out.println(guests.toString().replaceAll("[,\\[\\]]", ""));
    }

    private static Predicate<String> getPredicate(String condition, String parameters) {
        return switch (condition) {
            case "Starts with" -> text -> text.startsWith(parameters);
            case "Ends with" -> text -> text.endsWith(parameters);
            case "Contains" -> text -> text.contains(parameters);
            default -> text -> text.length() == Integer.parseInt(parameters);
        };
    }
}