package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Arrays.stream(scanner.nextLine().split("\\s++"))
                .mapToInt(Integer::parseInt).min().orElseThrow();

        System.out.println(number);
    }
}