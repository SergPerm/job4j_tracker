package ru.job4j.foodstorege;

import ru.job4j.foodstorege.foods.Food;
import ru.job4j.foodstorege.storeges.*;

import java.time.LocalDate;
import java.util.List;

public class ControllQuality {

    private final List<Storege> storeges;

    public ControllQuality(List<Storege> storeges) {
        this.storeges = storeges;
    }

    public void control(Food food) {
        for (Storege storege : storeges) {
            storege.doOperation(food);
        }
    }

    public static void main(String[] args) {
        List<Storege> storeges = List.of(new Warehouse(),
                new Shop(),
                new Trash());
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
        ControllQuality cq = new ControllQuality(storeges);
        for (Food food : foodList) {
            cq.control(food);
        }
    }
}
