package ru.job4j.stream;

public class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{"
                + "name='" + name + '\''
                + '}';
    }
}
