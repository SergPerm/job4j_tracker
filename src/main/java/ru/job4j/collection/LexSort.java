package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftSplit = left.split("\\.");
        String[] rightSplit = right.split("\\.");
//        int size = Math.min(rightSplit.length, leftSplit.length);
//        int result = 0;
//        for (int i = 0; i < size; i++) {
//            if (!leftSplit[i].startsWith(" ") && !rightSplit[i].startsWith(" ")) {
//                result = Integer.compare(
//                        Integer.parseInt(leftSplit[i]),
//                        Integer.parseInt(rightSplit[i]));
//                if (result != 0) {
//                    return result;
//                }
//            }
//        }
//        return result;
        return Integer.compare(
                Integer.parseInt(leftSplit[0]),
                Integer.parseInt(rightSplit[0]));
    }
}