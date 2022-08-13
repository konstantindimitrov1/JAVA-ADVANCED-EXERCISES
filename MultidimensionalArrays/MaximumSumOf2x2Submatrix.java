package MultidimensionalArrays;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = tokens[0];
        int cols = tokens[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        int bestSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > bestSum) {
                    bestSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }
        System.out.printf("%d %d\n%d %d\n%d", matrix[resultRow][resultCol], matrix[resultRow][resultCol + 1]
                , matrix[resultRow + 1][resultCol], matrix[resultRow + 1][resultCol + 1], bestSum);
    }
}