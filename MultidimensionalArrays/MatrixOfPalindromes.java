package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];


        for (int row = 0; row < rows; row++) {
            StringBuilder string = new StringBuilder();
            for (int col = 0; col < cols; col++) {
                string.append(palindrome(row, col));

            }
            System.out.println(string);
        }
    }

    private static String palindrome(int row, int col) {
        char startChar = 'a';
        int currentDimensionsSum = row + col;
        char startEndChar = (char) (startChar + row);
        return String.valueOf(startEndChar) +
                (char) (startChar + currentDimensionsSum) +
                startEndChar +
                " ";
    }
}