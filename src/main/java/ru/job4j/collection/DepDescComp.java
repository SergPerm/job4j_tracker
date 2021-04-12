package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] catalog1 = o1.split("/", 2);
        String[] catalog2 = o2.split("/", 2);

//        int result = catalog2[0].compareTo(catalog1[0]);
//        if (result != 0) {
//            return result;
//        } else  {
//            return catalog1[1].compareTo(catalog2[1]);
//        }

        int result = catalog2[0].compareTo(catalog1[0]);
        if (result != 0) {
            return result;
        } else if (catalog1.length > 1 && catalog2.length > 1) {
            return catalog1[1].compareTo(catalog2[1]);
            } else {
            return catalog1.length > catalog2.length ? 1 : -1;
        }
    }
}
