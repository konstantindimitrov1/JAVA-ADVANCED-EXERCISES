package Generics.ArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] integers = ArrayCreator.create(3, 3);

        String[] strings = ArrayCreator.create(String.class, 3, "Java");

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
