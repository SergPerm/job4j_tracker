package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int indexOfNull;
        for (int i = 0; i < products.length; i++) {
            Product pr = products[i];
            if (pr == null) {
                indexOfNull = i;
                return indexOfNull;
            }
        }
        return -1;
    }
}
