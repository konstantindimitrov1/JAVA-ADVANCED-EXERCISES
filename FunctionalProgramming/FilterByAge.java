package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nLines = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < nLines; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> tester = createTester(condition, age);

        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        printFilteredStudent(people, tester, printer);


    }

    private static void printFilteredStudent(Map<String, Integer> people, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (tester.test(entry.getValue())) {
                printer.accept(entry);
            }
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = switch (format) {
            case "name age" -> n -> System.out.printf("%s - %d\n", n.getKey(), n.getValue());
            case "name" -> n -> System.out.println(n.getKey());
            case "age" -> n -> System.out.println(n.getValue());
            default -> null;
        };
        return printer;
    }


    private static Predicate<Integer> createTester(String condition, int age) {
        Predicate<Integer> tester;
        if (condition.equals("younger")) {
            tester = x -> x <= age;
        } else {
            tester = x -> x >= age;
        }
        return tester;
    }
}
