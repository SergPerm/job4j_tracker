package ru.job4j.parking;

public class Car implements Automobile {

    private String name;
    private String number;
    private final int size = 1;

    public Car(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }
}
