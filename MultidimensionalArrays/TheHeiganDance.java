package MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get battle details
        double dmgDoneEveryRound = Double.parseDouble(scanner.nextLine());
        double heiganHP = 3000000;
        double playerHP = 18500;

        // player coordinates
        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";

        while (heiganHP >= 0 && playerHP >= 0) {
            heiganHP -= dmgDoneEveryRound;
            // apply last round
            if (lastSpell.equals("Cloud")) {
                playerHP -= 3500;
                lastSpell = "Plague Cloud";
            }
            if (playerHP <= 0) {
                break;
            }
            if (heiganHP <= 0) {
                break;
            }

            // attack info
            String[] tokens = scanner.nextLine().split(" ");
            String attackType = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            // check if player is in range
            if (checkRange(row, col, playerRow, playerCol)) {
                // try to dodge
                if (!checkRange(row, col, playerRow - 1, playerCol) && checkEscape(playerRow - 1)) {
                    playerRow--;
                } else if (!checkRange(row, col, playerRow, playerCol + 1) && checkEscape(playerCol + 1)) {
                    playerCol++;
                } else if (!checkRange(row, col, playerRow + 1, playerCol) && checkEscape(playerRow + 1)) {
                    playerRow++;
                } else if (!checkRange(row, col, playerRow, playerCol - 1) && checkEscape(playerCol - 1)) {
                    playerCol--;
                } else {
                    // take damage
                    switch (attackType) {
                        case "Cloud" -> playerHP -= 3500;
                        case "Eruption" -> playerHP -= 6000;
                    }
                    lastSpell = attackType;
                }
            }
        }

        if (lastSpell.equals("Cloud")) {
            lastSpell = "Plague Cloud";
        }

        if (heiganHP > 0) {
            System.out.printf("Heigan: %.2f\n", heiganHP);
        } else {
            System.out.println("Heigan: Defeated!");
        }

        if (playerHP > 0) {
            System.out.printf("Player: %.0f\n", playerHP);
        } else {
            System.out.printf("Player: Killed by %s\n", lastSpell);
        }
        System.out.printf("Final position: %d, %d", playerRow, playerCol);


    }

    private static boolean checkEscape(int i) {
        return i >= 0 && i < 15;
    }


    private static boolean checkRange(int row, int col, int playerRow, int playerCol) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (playerRow == i && playerCol == j) {
                    return true;
                }
            }
        }
        return false;
    }


}
