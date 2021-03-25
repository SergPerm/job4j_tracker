package ru.job4j.poly;

public class Bus implements Transport {

    private float costOfFuel = 45.6f;

    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("мы везём " + passengers + " пассажиров");
    }

    @Override
    public float fuelling(float amountOfFuel) {

        return costOfFuel * amountOfFuel;
    }
}
