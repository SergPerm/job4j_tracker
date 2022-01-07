package ru.job4j.foodstorege;

import ru.job4j.foodstorege.foods.Food;
import ru.job4j.foodstorege.storeges.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private final List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void control(Food food) {
        for (Storage storage : storages) {
            storage.doOperation(food);
        }
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        for (Storage storage : storages) {
            foodList.addAll(storage.cleanStorage());
        }
        for (Food food : foodList) {
            control(food);
        }
    }

    public static void main(String[] args) {
        List<Storage> storages = List.of(new Warehouse(),
                new Shop(),
                new Trash());
        List<Food> foodList = List.of(
                new Food("apple",
                        LocalDate.now().minusDays(20),
                        LocalDate.now().plusDays(20),
                        100.0,
                        0.7),
                new Food("grape",
                        LocalDate.now(),
                        LocalDate.now().plusDays(20),
                        100.0,
                        0.7),
                new Food("paper",
                        LocalDate.now().minusMonths(11),
                        LocalDate.now().plusDays(20),
                        100.0,
                        0.7),
                new Food("orange",
                        LocalDate.now().minusMonths(11),
                        LocalDate.now().minusDays(12),
                        100.0,
                        0.7)
        );
        ControllQuality cq = new ControllQuality(storages);
        for (Food food : foodList) {
            cq.control(food);
        }
        cq.resort();
    }
}
