package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle air = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = new Vehicle[]{air, train, bus};
        for (Vehicle vhcl : vehicles) {
            vhcl.move();
        }
    }
}
