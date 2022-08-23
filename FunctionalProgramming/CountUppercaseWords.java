package FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s++");

        Predicate<String> checkUppercaseStart = e -> Character.isUpperCase(e.charAt(0));
        Consumer<List<String>> printSizeAndContent = e -> {
            System.out.println(e.size());
            e.forEach(System.out::println);
        };

        List<String> words = new ArrayList<>();

        for (String s : input) {
            if (checkUppercaseStart.test(s)) {
                words.add(s);
            }
        }

        printSizeAndContent.accept(words);
    }
}