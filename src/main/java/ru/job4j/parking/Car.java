package ru.job4j.parking;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name) && number.equals(car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, size);
    }
}
