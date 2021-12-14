package ru.job4j.foodStorege.storeges;

import ru.job4j.foodStorege.foods.Food;

public class Warehouse implements Storege {

    @Override
    public void doOperation(Food food) {
        System.out.println(" Add " + food.getName() + " to WareHouse ");
    }
}
