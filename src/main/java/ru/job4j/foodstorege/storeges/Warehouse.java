package ru.job4j.foodstorege.storeges;

import ru.job4j.foodstorege.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storege {

    private final List<Food> warehouse = new ArrayList<>();

    @Override
    public void doOperation(Food food) {
        if (this.accept(food)) {
            warehouse.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        double percentOfFine = this.getExpirationPercent(food);
        return percentOfFine >= 0 && percentOfFine < 0.25;
    }
}
