package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenCanParkCarAndParkingCarThenTrue() {
        Parking parking = new SimpleParking(1, 1);
        Car car = new Car("Toyota", "A110CC");
        assertTrue(parking.parkAutomobile(car));
    }

    @Test
    public void whenCanParkCarAndParkingTruckThenTrue() {
        Parking parking = new SimpleParking(3, 0);
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        assertTrue(parking.parkAutomobile(truck));
    }

    @Test
    public void whenCanParkTruckAndParkingCarThenFalse() {
        Parking parking = new SimpleParking(0, 3);
        Car car = new Car("Toyota", "A110CC");
        assertFalse(parking.parkAutomobile(car));
    }

    @Test
    public void whenCanParkAndParkingCarAndTruckThenTrue() {
        Parking parking = new SimpleParking(4, 1);
        Car car = new Car("Toyota", "A110CC");
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        Truck truck2 = new Truck("KAMAZ", "B121CC", 3);
        assertTrue(parking.parkAutomobile(car));
        assertTrue(parking.parkAutomobile(truck));
        assertTrue(parking.parkAutomobile(truck2));
    }

    @Test
    public void whenCanParkAutomobileAndParkingMoreTrackThenFalse() {
        Parking parking = new SimpleParking(1, 1);
        Car car = new Car("Toyota", "A110CC");
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        Truck truck2 = new Truck("KAMAZ", "B121CC", 3);
        assertTrue(parking.parkAutomobile(car));
        assertTrue(parking.parkAutomobile(truck));
        assertFalse(parking.parkAutomobile(truck2));
    }

    @Test
    public void whenParkingCarMoreThanAbleThenFalse() {
        Parking parking = new SimpleParking(1, 1);
        Car car = new Car("Toyota", "A110CC");
        Car car2 = new Car("Toyota", "A111CC");
        assertTrue(parking.parkAutomobile(car));
        assertFalse(parking.parkAutomobile(car2));
    }

    @Test
    public void whenParkingTrackMoreThanAbleThenFalse() {
        Parking parking = new SimpleParking(1, 1);
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        Truck truck2 = new Truck("KAMAZ", "B121CC", 3);
        assertTrue(parking.parkAutomobile(truck));
        assertFalse(parking.parkAutomobile(truck2));
    }

    @Test
    public void whenCanNotParkingThenFalse() {
        Parking parking = new SimpleParking(0, 0);
        Car car = new Car("Toyota", "A110CC");
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        assertFalse(parking.parkAutomobile(car));
        assertFalse(parking.parkAutomobile(truck));
    }

    @Test
    public void whenNotFindByNumberThenNull() {
        Parking parking = new SimpleParking(1, 1);
        Car car = new Car("Toyota", "A110CC");
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        parking.parkAutomobile(car);
        parking.parkAutomobile(truck);
        assertNull(parking.findByNumber("B122CC"));
    }

    @Test
    public void whenFindByNumberThenAutomobile() {
        Parking parking = new SimpleParking(1, 1);
        Car car = new Car("Toyota", "A110CC");
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        parking.parkAutomobile(car);
        parking.parkAutomobile(truck);
        assertThat(parking.findByNumber("B120CC"), is(truck));
        assertThat(parking.findByNumber("B120cC"), is(truck));
    }

    @Test
    public void whenCanDeleteCarThenTrue() {
        Parking parking = new SimpleParking(1, 1);
        Car car = new Car("Toyota", "A110CC");
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        parking.parkAutomobile(car);
        parking.parkAutomobile(truck);
        assertTrue(parking.delete("A110CC"));
    }

    @Test
    public void whenCanDeleteTruckThenTrue() {
        Parking parking = new SimpleParking(1, 1);
        Car car = new Car("Toyota", "A110CC");
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        parking.parkAutomobile(car);
        parking.parkAutomobile(truck);
        assertTrue(parking.delete("B120CC"));
    }

    @Test
    public void whenCanDeleteTruck2ThenTrue() {
        Parking parking = new SimpleParking(4, 1);
        Car car = new Car("Toyota", "A110CC");
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        Truck truck2 = new Truck("KAMAZ", "B121CC", 3);
        parking.parkAutomobile(car);
        parking.parkAutomobile(truck);
        parking.parkAutomobile(truck2);
        assertTrue(parking.delete("B121CC"));
    }

    @Test
    public void whenCanNotDeleteThenFalse() {
        Parking parking = new SimpleParking(1, 1);
        Car car = new Car("Toyota", "A110CC");
        Truck truck = new Truck("KAMAZ", "B120CC", 3);
        parking.parkAutomobile(car);
        parking.parkAutomobile(truck);
        assertFalse(parking.delete("A111CC"));
    }
}