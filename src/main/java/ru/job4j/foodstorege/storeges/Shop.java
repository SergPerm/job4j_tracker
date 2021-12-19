package ru.job4j.foodstorege.storeges;

import ru.job4j.foodstorege.foods.Food;

public class Shop implements Storege {

    @Override
    public void doOperation(Food food) {
        if (this.accept(food)) {
            double percentOfFine = this.getExpirationPercent(food);
            if (percentOfFine >= 0.25 && percentOfFine < 0.75) {
                System.out.println(" Add " + food.getName() + " to Shop ");
            }
            if (percentOfFine >= 0.75 && percentOfFine < 1) {
                System.out.println(" Add " + food.getName()
                        + " to Shop with discount " + food.getDiscount());
            }
        }
    }

    @Override
    public boolean accept(Food food) {
        double percentOfFine = this.getExpirationPercent(food);
        return percentOfFine >= 0.25 && percentOfFine < 1;
    }
}
