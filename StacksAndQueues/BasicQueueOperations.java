import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int numberOfElements = numbers[0];
        int nElementsToRemove = numbers[1];
        int elementToFind = numbers[2];

        Deque<Integer> queue = new ArrayDeque();

        String input = scanner.nextLine();

        for (int i = 0; i < numberOfElements; i++) {
            queue.offer(Integer.parseInt(input.split("\\s+")[i]));
        }

        for (int i = 0; i < nElementsToRemove; i++) {
            queue.poll();
        }

        if (queue.contains(elementToFind)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            queue.stream().sorted().limit(1).forEach(System.out::println);
        }
    }
}