package Generics.JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> integerJar = new Jar<>();
        Jar<String> stringJar = new Jar<>();

        integerJar.add(10);
        stringJar.add("Koce");
    }
}
