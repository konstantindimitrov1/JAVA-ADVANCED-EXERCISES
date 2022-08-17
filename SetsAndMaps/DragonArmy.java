package SetsAndMaps;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create ds
        Map<String, TreeMap<String, ArrayList<Integer>>> dragonsType = new LinkedHashMap<>();

        int dragonsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < dragonsCount; i++) {
            // get data
            String[] tokens = scanner.nextLine().split(" ");
            String type = tokens[0];
            String name = tokens[1];
            int damage = checkNull(tokens[2], "damage");
            int health = checkNull(tokens[3], "health");
            int armor = checkNull(tokens[4], "armor");

            // fill data
            dragonsType.putIfAbsent(type, new TreeMap<>());
            TreeMap<String, ArrayList<Integer>> dragonName = dragonsType.get(type);
            dragonName.putIfAbsent(name, new ArrayList<>());
            ArrayList<Integer> stats = dragonName.get(name);
            if (!stats.isEmpty()) {
                stats.clear();
            }
            stats.add(damage);
            stats.add(health);
            stats.add(armor);
            dragonName.put(name, stats);
            dragonsType.put(type, dragonName);
        }

        // print
        dragonsType.forEach((key, val) -> {
            double averageDmg = 0;
            double averageHP = 0;
            double averageArmor = 0;
            for (ArrayList<Integer> value : val.values()) {
                averageDmg += value.get(0);
                averageHP += value.get(1);
                averageArmor += value.get(2);
            }
            averageDmg /= val.size();
            averageHP /= val.size();
            averageArmor /= val.size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", key, averageDmg, averageHP, averageArmor);
            val.forEach((key1, value) -> {
                System.out.printf("-%s -> ", key1);
                int damage = value.get(0);
                int health = value.get(1);
                int armor = value.get(2);
                System.out.printf("damage: %d, health: %d, armor: %d\n", damage, health, armor);
            });
        });


    }

    private static int checkNull(String token, String stat) {
        if (token.equals("null")) {
            switch (stat) {
                case "damage":
                    return 45;
                case "health":
                    return 250;
                case "armor":
                    return 10;
            }
        }
        return Integer.parseInt(token);
    }
}