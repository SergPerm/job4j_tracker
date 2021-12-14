package ru.job4j.foodstorege.storeges;

import ru.job4j.foodstorege.foods.Food;

public class Warehouse implements Storege {

    @Override
    public void doOperation(Food food) {
        System.out.println(" Add " + food.getName() + " to WareHouse ");
    }
}
