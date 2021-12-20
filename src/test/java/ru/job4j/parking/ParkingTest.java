package ru.job4j.parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenCanParkingCarAndParkCarThenTrue() {
    }

    @Test
    public void whenCanParkingCarAndParkTruckThenTrue() {
    }

    @Test
    public void whenCanParkingTruckAndParkCarThenFalse() {
    }

    @Test
    public void whenCanParkingAndParkCarAndTruckThenTrue() {
    }

    @Test
    public void whenCanParkingAutomobileAndParkMoreTrackThenFalse() {
    }

    @Test
    public void whenParkingCarMoreThanAbleThenFalse() {
    }

    @Test
    public void whenParkingTrackMoreThanAbleThenFalse() {
    }

    @Test
    public void whenCanNotParkingThenFalse() {
    }

    @Test
    public void whenNotFindByNumberThenNull() {
    }

    @Test
    public void whenFindByNumberThenAutomobile() {
    }

    @Test
    public void whenCanDeleteThenTrue() {
    }

    @Test
    public void whenCanNotDeleteThenFalse() {
    }
}