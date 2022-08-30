package Generics.ListUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> integers = List.of(13, 2, 10);
        List<String> strings = List.of("Koce", "Boce");

        System.out.println(ListUtils.getMax(integers));
        System.out.println(ListUtils.getMax(strings));
        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMin(strings));


    }
}
