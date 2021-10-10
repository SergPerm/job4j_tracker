package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] catalog1 = o1.split("/", 2);
        String[] catalog2 = o2.split("/", 2);

        int result = catalog2[0].compareTo(catalog1[0]);
        return result != 0 ? result : o1.compareTo(o2);
    }
}
