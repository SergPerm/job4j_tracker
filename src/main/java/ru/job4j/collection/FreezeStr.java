package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        char[] characters1 = left.toCharArray();
        char[] characters2 = right.toCharArray();
        if (characters1.length != characters2.length) {
            return false;
        }
        int count = 1;
        for (char ch : characters1) {
            if ((!map1.containsKey(ch))) {
                map1.put(ch, count);
            } else {
                map1.replace(ch, map1.get(ch) + 1);
            }
        }
        for (char ch : characters2) {
            if ((!map1.containsKey(ch))) {
                return false;
            } else {
                map1.replace(ch, map1.get(ch) - 1);
            }
        }
        for (Integer i : map1.values()) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
