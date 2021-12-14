package ru.job4j.foodstorege.foods;

import java.time.LocalDate;

public class Food {
    private final String name;
    private final LocalDate createDate;
    private final LocalDate expiryDate;
    private double price;
    private final double discount;

    public Food(String name,
                LocalDate createDate,
                LocalDate expiryDate,
                double price,
                double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setPrice(double v) {
        this.price = v;
    }
}
