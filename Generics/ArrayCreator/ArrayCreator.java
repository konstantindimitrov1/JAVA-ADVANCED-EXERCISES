package Generics.ArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    public static <T> T[] create(int length, T def) {
        T[] array = (T[]) Array.newInstance(def.getClass(), length);
        Arrays.fill(array, def);
        return array;
    }

    public static <T> T[] create(Class<T> clazz, int length, T def) {
        T[] array = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(array, def);
        return array;
    }
}
