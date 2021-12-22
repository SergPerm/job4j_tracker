package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class SimpleParking implements Parking {

    private final int carPlace;
    private final int truckPlace;
    private final List<Automobile> automobileList = new ArrayList<>();
    private int countCars = 0;
    private int countTrucks = 0;

    public SimpleParking(int carPlace, int truckPlace) {
        this.carPlace = carPlace;
        this.truckPlace = truckPlace;

    }

    @Override
    public boolean parkAutomobile(Automobile automobile) {
        boolean result = false;
        if (automobile.getSize() == 1 && countCars < carPlace) {
            automobileList.add(automobile);
            countCars++;
            result = true;
        }
        if (automobile.getSize() > 1) {
            if (countTrucks < truckPlace) {
                automobileList.add(automobile);
                countTrucks++;
                result = true;
            } else if (countCars + automobile.getSize() <= carPlace) {
                automobileList.add(automobile);
                countCars += automobile.getSize();
                countTrucks++;
                result = true;
            }
        }
        return result;
    }

    @Override
    public Automobile findByNumber(String number) {
        Automobile tmp = null;
        for (Automobile a : automobileList) {
            if (a.getNumber().equalsIgnoreCase(number)) {
                tmp = a;
            }
        }
        return tmp;
    }

    @Override
    public boolean delete(String number) {
        boolean result = false;
        Automobile automobile = this.findByNumber(number);
        if (automobile != null) {
            if (automobile.getSize() == 1) {
                automobileList.remove(automobile);
                countCars--;
                result = true;
            } else {
                if (countTrucks > truckPlace) {
                    automobileList.remove(automobile);
                    countCars = countCars - automobile.getSize();
                    countTrucks--;
                    result = true;
                } else {
                    automobileList.remove(automobile);
                    countTrucks--;
                    result = true;
                }
            }
        }
        return result;
    }
}
