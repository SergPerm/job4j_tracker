package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    private static final int LIMIT_OF_SPLITING = 2;

    @Override
    public int compare(String o1, String o2) {
        int result = o2.split("/", LIMIT_OF_SPLITING)[0]
                .compareTo(o1.split("/", LIMIT_OF_SPLITING)[0]);
        if (result != 0) {
            return result;
        } else if (o1.split("/", LIMIT_OF_SPLITING).length > 1
                && o2.split("/", LIMIT_OF_SPLITING).length > 1) {
            return o1.split("/", LIMIT_OF_SPLITING)[1]
                    .compareTo(o2.split("/", LIMIT_OF_SPLITING)[1]);
            } else {
            return o1.split("/", LIMIT_OF_SPLITING).length
                    > o2.split("/", LIMIT_OF_SPLITING).length
                    ? 1 : -1;
        }
    }
}
