package ru.job4j.foodstorege;

import ru.job4j.foodstorege.foods.Food;
import ru.job4j.foodstorege.storeges.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ControllQuality {

    private final Storege storege;
    private static LocalDate currentDate = LocalDate.of(2021, 12, 13);

    public ControllQuality(Storege storege) {
        this.storege = storege;
    }

    public void executeStorege(Food food) {
        storege.doOperation(food);
    }

    public static void control(Food food) {
        long periodCreateToCurrentDate =
                ChronoUnit.DAYS.between(food.getCreateDate(), currentDate);
        long periodCreateToExpiry =
                ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        double percentOfFine = (double) periodCreateToCurrentDate / periodCreateToExpiry;
        ControllQuality cc = new ControllQuality(new Warehouse());
        if (percentOfFine >= 0.25 && percentOfFine < 0.75) {
            cc = new ControllQuality(new Shop());
        }
        if (percentOfFine >= 0.75 && percentOfFine < 1.0) {
            cc = new ControllQuality(new ShopWithDiscount());
        }
        if (percentOfFine >= 1.0) {
            cc = new ControllQuality(new Trash());
        }
        cc.executeStorege(food);
    }

    public static void main(String[] args) {
        List<Food> foodList = List.of(
                new Food("apple",
                        LocalDate.of(2021, 12, 1),
                        LocalDate.of(2021, 12, 31),
                        100.0,
                        0.7),
                new Food("grape",
                        LocalDate.of(2021, 12, 13),
                        LocalDate.of(2021, 12, 31),
                        100.0,
                        0.7),
                new Food("paper",
                        LocalDate.of(2021, 1, 13),
                        LocalDate.of(2021, 12, 31),
                        100.0,
                        0.7),
                new Food("orange",
                        LocalDate.of(2021, 1, 13),
                        LocalDate.of(2021, 12, 12),
                        100.0,
                        0.7)
        );
        for (Food food : foodList) {
            ControllQuality.control(food);
        }
    }
}
