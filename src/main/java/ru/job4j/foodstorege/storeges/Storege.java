package ru.job4j.foodstorege.storeges;

import ru.job4j.foodstorege.foods.Food;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface Storege {
    void doOperation(Food food);

    boolean accept(Food food);

    default double getExpirationPercent(Food food) {
        LocalDate currentDate = LocalDate.of(2021, 12, 13);
        long periodCreateToCurrentDate =
                ChronoUnit.DAYS.between(food.getCreateDate(), currentDate);
        long periodCreateToExpiry =
                ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        return (double) periodCreateToCurrentDate / periodCreateToExpiry;
    }
}
