package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> rst = new HashSet<>(Arrays.asList(origin.split("[^A-Za-zА-Яа-я]+")));
        return rst.containsAll(Arrays.asList(line.split("[^A-Za-zА-Яа-я]+")));
    }
}