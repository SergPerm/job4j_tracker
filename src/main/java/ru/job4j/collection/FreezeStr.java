package ru.job4j.collection;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        char[] characters1 = left.toCharArray();
        char[] characters2 = right.toCharArray();
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
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.replace(ch, map1.get(ch) - 1);
                }
            }
        }
        return map1.isEmpty();
    }
}
