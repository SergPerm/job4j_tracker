package ru.job4j.parking;

public class Truck implements Automobile {

    private final String name;
    private final String number;
    private final int size;

    public Truck(String name, String number, int size) {
        this.name = name;
        this.number = number;
        this.size = size;
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
