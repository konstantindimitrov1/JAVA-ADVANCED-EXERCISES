import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] plants = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> plantsStackComparison = new ArrayDeque<>();
        ArrayDeque<Integer> plantsStack = new ArrayDeque<>();

        for (int plant : plants) {
            plantsStackComparison.push(plant);
        }

        int daysCount = 0;
        int lastDay = 0;

        while (lastDay != plantsStackComparison.size()) {
            lastDay = plantsStackComparison.size();
            for (int i = 0; i < lastDay; i++) {
                int currentNum = plantsStackComparison.pop();
                plantsStack.push(currentNum);
                if (!plantsStackComparison.isEmpty()) {
                    if (plantsStackComparison.peek() < currentNum) {
                        plantsStack.pop();
                    }
                }
            }

            int x = plantsStack.size();

            for (int i = 0; i < x; i++) {
                plantsStackComparison.push(plantsStack.pop());
            }

            daysCount++;
        }


        System.out.println(daysCount -1);
    }
}
