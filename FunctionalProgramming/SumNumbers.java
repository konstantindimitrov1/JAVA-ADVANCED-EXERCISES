package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, List<Integer>> splitIntegers = line -> Arrays.stream(line.split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> numbers = splitIntegers.apply(scanner.nextLine());

        System.out.printf("Count = %d\n", numbers.size());

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        System.out.printf("Sum = %d", sum);
    }
}