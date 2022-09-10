package IteratorsAndComparators.Library;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String name, int year, String... authors) {
        this.setTitle(name);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.stream(authors).collect(Collectors.toList());
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book other) {
        int result = this.getTitle().compareTo(other.getTitle());

        if (result == 0) {
            result = Integer.compare(this.year, other.getYear());
        }

        return result;
    }
}
