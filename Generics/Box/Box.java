package Generics.Box;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private final List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(String.format("%s: %s", t.getClass().getName(), t));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
