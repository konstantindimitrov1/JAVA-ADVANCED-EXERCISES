package SetsAndMaps;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        Map<String, Integer> junk = new TreeMap<>();

        while (true) {
            String[] tokens = scanner.nextLine().split(" ");

            for (int i = 0; i < tokens.length; i += 2) {
                String material = tokens[i + 1].toLowerCase();
                int quantity = Integer.parseInt(tokens[i]);

                switch (material) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        keyMaterials.put(material, keyMaterials.get(material) + quantity);


                        if (keyMaterials.get(material) >= 250) {
                            keyMaterials.put(material, keyMaterials.get(material) - 250);

                            String obtainedItem = switch (material) {
                                case "shards" -> "Shadowmourne";
                                case "fragments" -> "Valanyr";
                                case "motes" -> "Dragonwrath";
                                default -> "";
                            };

                            System.out.println(obtainedItem + " obtained!");

                            keyMaterials.entrySet().stream()
                                    .sorted((e1, e2) -> {
                                        int res = e2.getValue().compareTo(e1.getValue());
                                        if (res == 0)
                                            res = e1.getKey().compareTo(e2.getKey());
                                        return res; })
                                    .forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));


                            for (Map.Entry<String, Integer> entry2 : junk.entrySet()) {
                                System.out.printf("%s: %d\n", entry2.getKey(), entry2.getValue());
                            }

                            return;
                        }
                        break;
                    default:
                        if (junk.containsKey(material)) {
                            junk.put(material, junk.get(material) + quantity);
                        } else {
                            junk.putIfAbsent(material, quantity);
                        }
                        break;
                }
            }
        }
    }
}