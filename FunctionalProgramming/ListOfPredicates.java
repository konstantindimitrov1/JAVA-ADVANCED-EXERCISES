package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Set<Integer> numbersToDivide = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toSet());

        Predicate<Integer> checkDivision = e -> {
            for (Integer numberToDivide : numbersToDivide) {
                if (e % numberToDivide != 0) {
                    return false;
                }
            }
            return true;
        };

        IntStream.rangeClosed(1, number).filter(checkDivision::test).forEach(e -> System.out.print(e + " "));
    }
}