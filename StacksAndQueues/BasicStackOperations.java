import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] vars = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int poppedElements = vars[1];
        int numToFind = vars[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int number : numbers) {
            stack.push(number);
        }

        for (int i = 0; i < poppedElements; i++) {
            stack.pop();
        }

        if (stack.contains(numToFind)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            printLowestValue(stack);
        }
    }

    private static void printLowestValue(ArrayDeque<Integer> stack) {
        int lowestValue = Integer.MAX_VALUE;
        for (int i = 0; i < stack.size(); i++) {
            int number = stack.pop();
            if (number < lowestValue) {
                lowestValue = number;
            }
        }
        System.out.println(lowestValue);
    }
}
