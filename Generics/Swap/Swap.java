package Generics.Swap;

import java.util.ArrayList;
import java.util.List;

public class Swap <T> {
    private List<T> data;

    public Swap() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public void swap(int firstElement, int secondElement) {
        T firstElementToSwap = this.data.get(firstElement);
        this.data.set(firstElement, this.data.get(secondElement));
        this.data.set(secondElement, firstElementToSwap);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : data) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
