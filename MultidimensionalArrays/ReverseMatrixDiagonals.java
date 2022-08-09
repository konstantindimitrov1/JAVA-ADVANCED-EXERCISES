package MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get dimensions
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        // fill the matrix
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // stack to print bottom
        ArrayDeque<String> stackBottom = new ArrayDeque<>();

        // prepare bottom
        for (int i = 0; i < cols; i++) {
            StringBuilder outputToStack = new StringBuilder();
            int col = i;
            for (int j = rows - 1; j >= 0; j--) {
                if (isInRange(matrix, j, col)) {
                    outputToStack.append(String.format("%d ", matrix[j][col++]));
                } else {
                    break;
                }
            }
            stackBottom.push(outputToStack.toString().trim());
        }

        // stack to print top
        ArrayDeque<String> stackTop = new ArrayDeque<>();

        // prepare top
        for (int i = 0; i < matrix.length - 1; i++) {
            StringBuilder outputToQueue = new StringBuilder();
            int row = i;
            for (int j = 0; j < cols; j++) {
                if (isInRange(matrix, row, j)) {
                    outputToQueue.append(String.format("%d ", matrix[row--][j]));
                } else {
                    break;
                }
            }
            stackTop.push(outputToQueue.toString().trim());
        }

        // print
        while (!stackBottom.isEmpty()) {
            System.out.println(stackBottom.pop());
        }
        while (!stackTop.isEmpty()) {
            System.out.println(stackTop.pop());
        }

    }

    private static boolean isInRange(int[][] matrix, int row, int col) {
        return row >= 0 && col < matrix[0].length;
    }
}
