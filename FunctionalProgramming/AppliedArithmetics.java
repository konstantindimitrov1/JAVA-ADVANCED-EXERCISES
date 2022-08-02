package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s++"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();


        while (!input.equals("end")) {
            if (input.equals("print")) {
                System.out.println(numbers.toString().replaceAll("[,\\[\\]]", ""));
            } else {
                numbers = numbers.stream().map(doTheMath(input)).collect(Collectors.toList());
            }
            input = scanner.nextLine();
        }

    }

    private static Function<Integer, Integer> doTheMath(String input) {
        if (input.equals("add")) {
            return x -> x += 1;
        } else if (input.equals("subtract")) {
            return x -> x -= 1;
        }
        return x -> x *= 2;
    }
}