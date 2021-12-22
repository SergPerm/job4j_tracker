package ru.job4j.foodstorege.storeges;

import ru.job4j.foodstorege.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storege {

    private final List<Food> shop = new ArrayList<>();

    @Override
    public boolean doOperation(Food food) {
        if (this.accept(food)) {
            double percentOfFine = this.getExpirationPercent(food);
            if (percentOfFine >= 0.25 && percentOfFine < 0.75) {
                shop.add(food);
            }
            if (percentOfFine >= 0.75 && percentOfFine < 1) {
                food.setPrice(food.getPrice() * (1 - food.getDiscount()));
                shop.add(food);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean accept(Food food) {
        double percentOfFine = this.getExpirationPercent(food);
        return percentOfFine >= 0.25 && percentOfFine < 1;
    }
}
