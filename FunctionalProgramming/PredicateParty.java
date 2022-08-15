package FunctionalProgramming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] tokens = input.split(" ");
            String action = tokens[0];
            String criteria = tokens[1];
            String condition = tokens[2];

            switch (action) {
                case "Double":
                    for (int i = 0; i < names.size(); i++) {
                        String name = names.get(i);
                        if (getPredicate(criteria, condition).test(name)) {
                            names.add(i++, name);
                        }
                    }
                    break;
                case "Remove":
                    names.removeIf(getPredicate(criteria, condition));
                    break;
            }

            input = scanner.nextLine();
        }

        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            names = names.stream().sorted().collect(Collectors.toList());
            System.out.printf("%s are going to the party!", names.toString().replaceAll("[\\[\\]]", ""));
        }


    }

    private static Predicate<String> getPredicate(String criteria, String condition) {
        return switch (criteria) {
            case "StartsWith" -> text -> text.startsWith(condition);
            case "EndsWith" -> text -> text.endsWith(condition);
            case "Length" -> text -> text.length() == Integer.parseInt(condition);
            default -> text -> false;
        };

    }
}
