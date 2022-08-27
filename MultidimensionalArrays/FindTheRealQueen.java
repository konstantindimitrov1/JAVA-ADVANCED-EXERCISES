package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = input[j].charAt(0);
            }
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col] == 'q') {
                    if (checkRealQueen(matrix, row, col)) {
                        System.out.printf("%d %d", row, col);
                        return;
                    }

                }
            }
        }

    }

    private static boolean checkRealQueen(char[][] matrix, int row, int col) {
        //check horizontal
        int occurrences = 0;
        for (int i = 0; i < 8; i++) {
            if (matrix[row][i] == 'q') {
                occurrences++;
            }
        }

        if (occurrences > 1) {
            return false;
        }

        //check vertical
        occurrences = 0;
        for (int i = 0; i < 8; i++) {
            if (matrix[i][col] == 'q') {
                occurrences++;
            }
        }

        if (occurrences > 1) {
            return false;
        }

        //check right downwards
        int checkCol = col + 1;
        int checkRow = row + 1;
        while (checkCol < 8 && checkRow < 8) {
            if (matrix[checkRow][checkCol] == 'q') {
                return false;
            }
            checkCol++;
            checkRow++;
        }

        //check left downwards
        checkCol = col - 1;
        checkRow = row + 1;
        while (checkRow < 8 && checkCol >= 0) {
            if (matrix[checkRow][checkCol] == 'q') {
                return false;
            }
            checkCol--;
            checkRow++;
        }

        //check right upwards
        checkCol = col + 1;
        checkRow = row - 1;
        while (checkRow >= 0 && checkCol < 8) {
            if (matrix[checkRow][checkCol] == 'q') {
                return false;
            }
            checkCol++;
            checkRow--;
        }

        //check left upwards
        checkCol = col - 1;
        checkRow = row - 1;
        while (checkRow >= 0 && checkCol >= 0) {
            if (matrix[checkRow][checkCol] == 'q') {
                return false;
            }
            checkCol--;
            checkRow--;
        }

        return true;
    }
}
