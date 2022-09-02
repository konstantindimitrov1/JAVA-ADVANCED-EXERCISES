package Generics.GenericScale;

public class Scale<T extends Comparable<T>>{
    public final T first;
    public final T second;

    public Scale (T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getHeavier() {
        int result = this.first.compareTo(this.second);

        if (result > 0) {
            return first;
        } else if (result < 0) {
            return second;
        }

        return null;
    }
}
