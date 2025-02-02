package ru.job4j.parking;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return size == truck.size && name.equals(truck.name) && number.equals(truck.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, size);
    }
}
