package ru.job4j.foodstorege.storeges;

import ru.job4j.foodstorege.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private final List<Food> trash = new ArrayList<>();

    @Override
    public void doOperation(Food food) {
        if (this.accept(food)) {
            trash.add(food);
        }
    }

    @Override
    public boolean accept(Food food) {
        double percentOfFine = this.getExpirationPercent(food);
        return percentOfFine >= 1;
    }

    @Override
    public List<Food> cleanStorage() {
        List<Food> foodsFromTrashForResort = List.copyOf(trash);
        trash.clear();
        return foodsFromTrashForResort;
    }
}
