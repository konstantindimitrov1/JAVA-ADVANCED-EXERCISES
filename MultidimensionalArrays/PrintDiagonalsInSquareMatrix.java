package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsInSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < rowsAndCols; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        int col = 0;
        for (int i = rowsAndCols - 1; i >= 0; i--) {
            System.out.print(matrix[i][col] + " ");
            col++;
        }
    }
}