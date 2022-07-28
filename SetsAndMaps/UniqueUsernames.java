package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> names = new LinkedHashSet<>();

        int linesOfInput = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < linesOfInput; i++) {
            String name = scanner.nextLine();
            names.add(name);
        }

        names.forEach(System.out::println);
    }
}