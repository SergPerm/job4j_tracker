package ru.job4j.foodstorege.storeges;

import ru.job4j.foodstorege.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storege {

    private final List<Food> trash = new ArrayList<>();

    @Override
    public boolean doOperation(Food food) {
        if (this.accept(food)) {
            trash.add(food);
            return true;
        }
        return false;
    }

    @Override
    public boolean accept(Food food) {
        double percentOfFine = this.getExpirationPercent(food);
        return percentOfFine >= 1;
    }
}
