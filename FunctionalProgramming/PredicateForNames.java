package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int allowedLength = Integer.parseInt(scanner.nextLine());

        Arrays.stream(scanner.nextLine().split("\\s++"))
                .filter(e -> e.length() <= allowedLength)
                .forEach(System.out::println);
    }
}
