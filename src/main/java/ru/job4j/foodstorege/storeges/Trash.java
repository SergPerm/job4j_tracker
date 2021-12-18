package ru.job4j.foodstorege.storeges;

import ru.job4j.foodstorege.foods.Food;

public class Trash implements Storege {

    @Override
    public void doOperation(Food food) {
        System.out.println(" Add " + food.getName() + " to Trash ");
    }

    @Override
    public boolean accept(Food food) {
        double percentOfFine = this.getExpirationPercent(food);
        return percentOfFine >= 1;
    }
}
