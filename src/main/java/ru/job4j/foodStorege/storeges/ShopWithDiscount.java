package ru.job4j.foodStorege.storeges;

import ru.job4j.foodStorege.foods.Food;

public class ShopWithDiscount extends Shop {

    @Override
    public void doOperation(Food food) {
        System.out.print(" With discount " + food.getDiscount() + " ");
        food.setPrice(food.getPrice() * food.getDiscount());
        super.doOperation(food);
    }
}
