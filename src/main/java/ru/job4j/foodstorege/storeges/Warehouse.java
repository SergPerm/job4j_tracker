package ru.job4j.foodstorege.storeges;

import ru.job4j.foodstorege.foods.Food;

public class Warehouse implements Storege {

    @Override
    public void doOperation(Food food) {
        if (this.accept(food)) {
            System.out.println(" Add " + food.getName() + " to WareHouse ");
        }
    }

    @Override
    public boolean accept(Food food) {
        double percentOfFine = this.getExpirationPercent(food);
        return percentOfFine >= 0 && percentOfFine < 0.25;
    }
}
