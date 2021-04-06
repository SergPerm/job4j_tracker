package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size = Math.min(right.length(), left.length());
        int result = 0;
            for (int i = 0; i < size; i++) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                if (result != 0) {
                    return result;
                }
            }
            result = left.length() - right.length();
        return result;
    }
}