package IteratorsAndComparators.ListIterator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split(" ")).skip(1)
                .collect(Collectors.toList());

        ListIterator listIterator = new ListIterator(data);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            switch (input) {
                case "HasNext" -> System.out.println(listIterator.hasNext());
                case "Move" -> System.out.println(listIterator.next());
                case "Print" -> listIterator.print();
            }

            input = scanner.nextLine();
        }
    }
}
